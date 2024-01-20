package store.api.storeapi.Extra.DTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse  extends DTO
{
    public long id;
    public String username;
    public String token;
}
