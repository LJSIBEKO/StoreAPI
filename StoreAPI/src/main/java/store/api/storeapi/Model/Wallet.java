package store.api.storeapi.Model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Wallet extends AbstractModel
{
    private Double balance;
}
