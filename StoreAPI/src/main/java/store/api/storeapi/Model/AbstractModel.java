package store.api.storeapi.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractModel implements Serializable
{
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;


    @CreationTimestamp
    @Column(updatable = true)
    private LocalDateTime lastUpdate;

    private long owner_id;

}
