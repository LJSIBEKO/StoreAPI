package store.api.storeapi.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.api.storeapi.Extra.DTOs.CreateUserDTO;
import store.api.storeapi.Extra.DTOs.UserAccountDTO;
import store.api.storeapi.Model.Transaction;
import store.api.storeapi.Model.UserAccount;
import store.api.storeapi.Model.Wallet;
import store.api.storeapi.Services.UserServices;

import java.util.List;

@RestController
@RequestMapping("api/v1/user/account")
@Slf4j
public class UserRestController
{

    private final UserServices userServices;


    public UserRestController(UserServices userServices) {
        this.userServices = userServices;
    }





}
