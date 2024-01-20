package store.api.storeapi.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import store.api.storeapi.Extra.DTOs.ProductDTO;
import store.api.storeapi.Extra.Exception.ClientException;
import store.api.storeapi.Extra.ImageUtils;
import store.api.storeapi.Extra.Mapper.Mapper;
import store.api.storeapi.Model.Product;
import store.api.storeapi.Model.UserAccount;
import store.api.storeapi.Repos.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductService extends AbstractService
{
    public ProductService(UserAccountDAO userAccountDAO,
                          CartDAO cartDAO,
                          CommentsDAO commentsDAO,
                          WalletDAO walletDAO,
                          TransactionDAO transactionDAO,
                          ProductDAO productDAO,
                          Mapper mapper,
                          HistoryDAO historyDAO) {
        super(userAccountDAO, cartDAO, commentsDAO, walletDAO, transactionDAO, productDAO, mapper, historyDAO);
    }

    public ProductDTO createProduct(ProductDTO productDTO){
        UserAccount user=userAccountDAO().findById(productDTO.owner_id).get();
        if(user==null)throw new RuntimeException("User was not found");

        Product product=mapper().toProduct(productDTO);
        product.setComments(new ArrayList<>());

        return mapper().toProductDTO(productDAO().save(product));
    }
    public void setImage(MultipartFile file, String oid){
        try {
//            Product product=ProductDAO.findById(new ObjectId(oid)).get();
//            product.setPicture(ImageUtils.compressImage(file.getBytes()));
//            productRepository.save(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public byte[] getImage(String oid){
//        Product product=productRepository.findById(new ObjectId(oid)).get();
//        return  ImageUtils.decompressImage(product.getPicture());
        return null;
    }

    public List<ProductDTO> getProductFoeUser(Long oid) {
        List<ProductDTO> userList=new ArrayList<>();
        productDAO.findProductByOwner_id(oid).forEach(product -> {
            userList.add(mapper().toProductDTO(product));
        });
        return userList;
    }

    public List<ProductDTO> getAllProducts()
    {
        List<ProductDTO> productDTOS=new ArrayList<>();
        productDAO.findAll().forEach(product -> {
            productDTOS.add(mapper().toProductDTO(product));
        });
        return productDTOS;
    }

    public ProductDTO getProductWithId(long id)
    {
        Product product=productDAO.findProductById(id).orElseThrow(() -> new ClientException("No Product with ID :"+id));
        return mapper().toProductDTO(product);
    }
}
