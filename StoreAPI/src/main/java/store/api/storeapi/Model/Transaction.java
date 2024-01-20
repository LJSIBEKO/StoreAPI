package store.api.storeapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import store.api.storeapi.Model.Enum.TransitionType;

@Entity
@Table(name = "transaction")
@Data
public class Transaction extends AbstractModel
{
    private TransitionType type;
    private double amount;
    private long to_id;
}
