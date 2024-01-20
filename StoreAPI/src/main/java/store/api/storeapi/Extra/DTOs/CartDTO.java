package store.api.storeapi.Extra.DTOs;

import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import store.api.storeapi.Model.Product;

@Data
public class CartDTO extends DTO
{
    public int numberOfProduct;

    public ProductDTO product;
}
