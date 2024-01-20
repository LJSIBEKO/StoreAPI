package store.api.storeapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
public class ProductComment extends AbstractModel
{
    private String comment;
    private double rating;
    private long product_id;

}
