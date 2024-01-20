package store.api.storeapi.Repos;

import org.springframework.stereotype.Repository;
import store.api.storeapi.Model.Transaction;

@Repository
public interface TransactionDAO extends AbstractRepo<Transaction> {
}
