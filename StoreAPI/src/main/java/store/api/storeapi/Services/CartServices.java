package store.api.storeapi.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import store.api.storeapi.Extra.DTOs.CartAdd;
import store.api.storeapi.Extra.DTOs.CartDTO;
import store.api.storeapi.Extra.Exception.ClientException;
import store.api.storeapi.Extra.Mapper.Mapper;
import store.api.storeapi.Model.*;
import store.api.storeapi.Repos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class CartServices extends AbstractService
{
    public CartServices(UserAccountDAO userAccountDAO,
                        CartDAO cartDAO,
                        CommentsDAO commentsDAO,
                        WalletDAO walletDAO,
                        TransactionDAO transactionDAO,
                        ProductDAO productDAO,
                        Mapper mapper,
                        HistoryDAO historyDAO) {
        super(userAccountDAO, cartDAO, commentsDAO, walletDAO, transactionDAO, productDAO, mapper, historyDAO);
    }

    @Async
    public boolean checkOut(Long userOid)
    {
        UserAccount user=userAccountDAO().getReferenceById(userOid);
        if(user==null)throw new ClientException("This user does not exist");

        Wallet wallet=walletDAO().findWalletByOwner(userOid);

        if(wallet==null)throw new ClientException("Wallet not available for user id :"+userOid);

        List<Cart> userCart=cartDAO().findCartByOwner_id(userOid);

        if(getCartTotal(userOid)<=wallet.getBalance()){
            userCart.forEach(cart -> {


                if(productDAO.getReferenceById(cart.getProduct().getId()).getQuantity()>=cart.getNumberOfProduct())
                {
                    History history=historyDAO().findByOwner_id(userOid).orElse(new History());
                    history.getBoughtProduct().add(cart.getProduct());

                    historyDAO().save(history);
                    cartDAO().delete(cart);
                }


            });
        }

        return true;
    }

    public CartDTO addToCart(CartAdd cartAdd)
    {
     UserAccount user=userAccountDAO().getReferenceById(cartAdd.userOid);

     if(user==null)throw new ClientException("No such user");
     Product product=productDAO.getReferenceById(cartAdd.productOid);

     if(product==null)throw new ClientException("No such product with this id");

     List<Cart> cartList=cartDAO().findCartByOwner_id(cartAdd.userOid);
       Cart exist= cartList.stream().filter(cart ->
            cart.getProduct().getId()==product.getId()
        ).findFirst().get();

       if(exist!=null){
           exist.setNumberOfProduct(cartAdd.numberOfProduct);
       }else{
           exist=new Cart();
           exist.setOwner_id(user.getId());
           exist.setProduct(product);
           exist.setNumberOfProduct(cartAdd.numberOfProduct);
       }

     return mapper().toCartDTO(cartDAO().save(exist));
    }
    public List<CartDTO> addToCart(List<CartAdd> cartAddList)
    {
        List<CartDTO> cartDTOList=new ArrayList<>();
     cartAddList.forEach(cartAdd -> {
         cartDTOList.add(addToCart(cartAdd));
     });
     return cartDTOList;
    }

    public List<CartDTO> viewCart(long userOid)
    {
        UserAccount user=userAccountDAO().getReferenceById(userOid);
        if(user==null)throw new ClientException("User not found");

        List<Cart> userCart=cartDAO().findCartByOwner_id(userOid);
        log.info("Cart DB size :"+userCart.size());
        List<CartDTO> showCart=new ArrayList<>();
        if(userCart.size()!=0){
            userCart.forEach(cart -> {
                log.info("HERE");
                showCart.add(mapper().toCartDTO(cart));
            });
        }

        log.info("sending :"+showCart.size());
        return showCart;
    }
    public double getCartTotal(long userOid){
log.info("User ID:"+userOid);
        List<Cart> userCart=cartDAO().findCartByOwner_id(userOid);
        AtomicReference<Double> total= new AtomicReference<>((double) 0);
        log.info(userCart.size()+" Size");
        if(userCart.size()==0||userCart==null) {
            return 0;
        }
            else{

            userCart.forEach(cart -> {
                total.set(total.get() + cart.getProduct().getAmount() * cart.getNumberOfProduct());;
            });

        }

        return total.get();
    }
    public void removeFromCart(long userOid,long productOid)
    {
//        Cart cart=cartDAO().findCartByOwner_idAndProduct(userOid,productOid);
//        if(cart==null)throw new ClientException("No such item in Cart");
//        cartDAO().delete(cart);

    }
}
