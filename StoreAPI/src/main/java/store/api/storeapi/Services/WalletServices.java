package store.api.storeapi.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import store.api.storeapi.Extra.DTOs.WalletDTO;
import store.api.storeapi.Extra.DTOs.WalletToUpDTO;
import store.api.storeapi.Extra.Mapper.Mapper;
import store.api.storeapi.Model.Wallet;
import store.api.storeapi.Repos.*;

import java.util.List;

@Service
@Slf4j
public class WalletServices extends AbstractService
{

    public WalletServices(UserAccountDAO userAccountDAO,
                          CartDAO cartDAO,
                          CommentsDAO commentsDAO,
                          WalletDAO walletDAO,
                          TransactionDAO transactionDAO,
                          ProductDAO productDAO,
                          Mapper mapper,
                          HistoryDAO historyDAO) {
        super(userAccountDAO, cartDAO, commentsDAO, walletDAO, transactionDAO, productDAO, mapper,historyDAO);
    }

    public WalletDTO getBalance(Long oid)
    {
        return mapper().toDTO(WalletDTO.class,walletDAO().findWalletByOwner(oid));
    }
}
