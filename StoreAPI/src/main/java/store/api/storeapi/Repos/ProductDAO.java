package store.api.storeapi.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import store.api.storeapi.Model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDAO extends JpaRepository<Product,Long>
{
    @Query("SELECT s FROM Product s where s.owner_id=?1")
    List<Product> findProductByOwner_id(long owner_id);

        Optional<Product> findProductById(long id);
}
