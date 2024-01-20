package store.api.storeapi.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import store.api.storeapi.Extra.DTOs.*;
import store.api.storeapi.Model.Cart;
import store.api.storeapi.Model.Product;
import store.api.storeapi.Model.UserAccount;
import store.api.storeapi.Services.ProductService;
import store.api.storeapi.Services.SessionService;

import java.util.List;

@RestController
@RequestMapping("api/v1/session")
@Slf4j
public class SessionController
{
    private final SessionService service;
    private final ProductService productService;

    @Autowired
    public SessionController(SessionService service,ProductService productService) {
        this.service = service;
        this.productService=productService;
    }

    @PostMapping("create/user")
    public ResponseEntity<RegisterResponse> createUser(@RequestBody UserAccountRegisterDTO accountDTO)
    {
       return new ResponseEntity<>(service.registerUserAccount(accountDTO), HttpStatus.CREATED);
    }
    @PostMapping("create/admin")
    public ResponseEntity<RegisterResponse> createAdmin(@RequestBody UserAccountRegisterDTO accountRegisterDTO)
    {
        return new ResponseEntity<>(service.registerAdmin(accountRegisterDTO),HttpStatus.OK);
    }
    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest)
    {

        return new ResponseEntity<>(service.authenticate(loginRequest),HttpStatus.OK);
    }
    @GetMapping("all/product")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }


    @PostMapping("view/product/{id}")
    public ResponseEntity<ProductDTO> send(@PathVariable("id") long id){

        return new ResponseEntity<>(productService.getProductWithId(id),HttpStatus.OK);
    }
    @PostMapping("test2")
    public ResponseEntity<List<Cart>> cart(){
        return new ResponseEntity<>(service.getCart(),HttpStatus.OK);
    }



}
