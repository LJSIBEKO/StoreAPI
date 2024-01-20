package store.api.storeapi.Extra.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public abstract class DTO
{
    public long id;
    public LocalDateTime createdAt;
    public LocalDateTime lastUpdate;
    public long owner_id;


}
