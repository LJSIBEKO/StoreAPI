package store.api.storeapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Cart")
public class Cart extends AbstractModel
{
    private int numberOfProduct;
    @OneToOne
    private Product product;

}
