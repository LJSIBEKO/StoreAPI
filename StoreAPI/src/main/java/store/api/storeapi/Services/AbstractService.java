package store.api.storeapi.Services;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.api.storeapi.Extra.Mapper.Mapper;
import store.api.storeapi.Model.Cart;
import store.api.storeapi.Repos.*;

@Service
public abstract class AbstractService
{

    private final UserAccountDAO userAccountDAO;
    private  final CartDAO cartDAO;
    private final CommentsDAO commentsDAO;
    private final WalletDAO walletDAO;
    private final TransactionDAO transactionDAO;
    public final ProductDAO productDAO;
    private final Mapper mapper;
    private final HistoryDAO historyDAO;

    @Autowired
    public AbstractService(UserAccountDAO userAccountDAO,
                           CartDAO cartDAO,
                           CommentsDAO commentsDAO,
                           WalletDAO walletDAO,
                           TransactionDAO transactionDAO,
                           ProductDAO productDAO,
                           Mapper mapper,
                           HistoryDAO historyDAO) {
        this.userAccountDAO = userAccountDAO;
        this.cartDAO = cartDAO;
        this.commentsDAO = commentsDAO;
        this.walletDAO = walletDAO;
        this.transactionDAO = transactionDAO;
        this.productDAO = productDAO;
        this.mapper = mapper;
        this.historyDAO = historyDAO;
    }





    public Mapper mapper() {
        return mapper;
    }
    public CartDAO cartDAO() {
        return cartDAO;
    }

    public CommentsDAO commentsDAO() {
        return commentsDAO;
    }

    public WalletDAO walletDAO() {
        return walletDAO;
    }

    public TransactionDAO transactionDAO() {
        return transactionDAO;
    }

    public ProductDAO productDAO() {
        return productDAO;
    }


    public UserAccountDAO userAccountDAO() {
        return userAccountDAO;
    }

    public HistoryDAO historyDAO() {
        return historyDAO;
    }
}
