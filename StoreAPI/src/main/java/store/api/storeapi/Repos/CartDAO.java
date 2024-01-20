package store.api.storeapi.Repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import store.api.storeapi.Model.Cart;
import store.api.storeapi.Model.Product;

import java.util.List;

@Repository
public interface CartDAO extends AbstractRepo<Cart>
{
    @Query(value = "SELECT s FROM Cart s WHERE s.owner_id = ?1")
    List<Cart> findCartByOwner_id(long owner_id);

//    @Query(value = "SELECT s FROM Cart s where s.owner_id = ?1 AND S.product.id = ?2")
//    Cart findCartByOwner_idAndProduct(long owner_Id, long productId);
}
