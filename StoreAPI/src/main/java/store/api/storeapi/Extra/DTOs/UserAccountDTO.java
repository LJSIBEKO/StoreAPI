package store.api.storeapi.Extra.DTOs;

import jakarta.persistence.Column;
import store.api.storeapi.Model.Enum.Roles;

public class UserAccountDTO extends DTO
{
    public String name;
    public String surname;

    public String email;
    public Roles role;
}
