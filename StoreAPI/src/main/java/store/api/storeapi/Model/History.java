package store.api.storeapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "History")
@Data
public class History extends AbstractModel
{
    @OneToMany
    private List<Product> boughtProduct;
}
