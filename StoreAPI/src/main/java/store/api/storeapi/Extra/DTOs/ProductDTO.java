package store.api.storeapi.Extra.DTOs;

import jakarta.persistence.ManyToMany;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import store.api.storeapi.Model.Enum.ProductCategorey;
import store.api.storeapi.Model.ProductComment;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO extends DTO
{
    public long id;
    public LocalDateTime createdAt;
    public LocalDateTime lastUpdate;
    public long owner_id;
    public String name;
    public String description;
    public double amount;
    public ProductCategorey category;
    public double ratings;
    public List<ProductComment> comments;

    @Getter
    public int quantity;
}
