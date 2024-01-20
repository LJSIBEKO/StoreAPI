package store.api.storeapi.Repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import store.api.storeapi.Model.Wallet;

@Repository
public interface WalletDAO extends AbstractRepo<Wallet>
{
    @Query(value = "SELECT s from Wallet s where s.owner_id = ?1")
   Wallet findWalletByOwner(Long id);
}
