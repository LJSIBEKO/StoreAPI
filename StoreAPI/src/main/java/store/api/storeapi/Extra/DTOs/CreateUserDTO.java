package store.api.storeapi.Extra.DTOs;

import store.api.storeapi.Model.Enum.Gender;

public class CreateUserDTO extends DTO
{
    public String name;
    public String surname;
    public String email;
    public Gender gender;
    public String password;
}
