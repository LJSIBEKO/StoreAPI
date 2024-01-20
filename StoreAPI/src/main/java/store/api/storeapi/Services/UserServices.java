package store.api.storeapi.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import store.api.storeapi.Extra.DTOs.CreateUserDTO;
import store.api.storeapi.Extra.DTOs.UserAccountDTO;
import store.api.storeapi.Extra.Exception.ClientException;
import store.api.storeapi.Extra.Mapper.Mapper;
import store.api.storeapi.Model.Cart;
import store.api.storeapi.Model.Enum.Roles;
import store.api.storeapi.Model.Enum.TransitionType;
import store.api.storeapi.Model.Transaction;
import store.api.storeapi.Model.UserAccount;
import store.api.storeapi.Model.Wallet;
import store.api.storeapi.Repos.*;

import java.util.List;

@Service
@Slf4j
public class UserServices extends AbstractService
{


    public UserServices(UserAccountDAO userAccountDAO,
                        CartDAO cartDAO,
                        CommentsDAO commentsDAO,
                        WalletDAO walletDAO,
                        TransactionDAO transactionDAO,
                        ProductDAO productDAO,
                        Mapper mapper,
                        HistoryDAO historyDAO) {
        super(userAccountDAO, cartDAO, commentsDAO, walletDAO, transactionDAO, productDAO, mapper,historyDAO);
    }

    public void createUser(Long oid)
    {
        Wallet userWallet=new Wallet();
        userWallet.setOwner_id(oid);
        userWallet.setBalance(0.00);
        walletDAO().save(userWallet);


    }

}
