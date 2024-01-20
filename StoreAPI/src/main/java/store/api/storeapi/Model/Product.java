package store.api.storeapi.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.ColumnDefault;
import store.api.storeapi.Extra.DTOs.image;
import store.api.storeapi.Model.Enum.ProductCategorey;

import java.util.List;

@Entity
@Table(name = "Product")
@Data

public class Product extends AbstractModel
{
    private String name;
    private String description;
    private double amount;
    private ProductCategorey category;
    private double ratings;

    @ManyToMany
    @Nullable
    private List<ProductComment> comments;

  //  private byte[] images;

    @NotNull
    private int quantity;


}
