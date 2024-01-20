package store.api.storeapi.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.api.storeapi.Extra.DTOs.CartAdd;
import store.api.storeapi.Extra.DTOs.CartDTO;
import store.api.storeapi.Services.CartServices;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
@Slf4j
public class CartController
{
    private final CartServices cartServices;

    @Autowired
    public CartController(CartServices cartServices) {
        this.cartServices = cartServices;
    }

    @GetMapping("/total/{userOid}")
    public ResponseEntity<Double> getCartTotal(@PathVariable("userOid") long userOid){
        return new ResponseEntity<>(cartServices.getCartTotal(userOid), HttpStatus.OK);
    }
    @GetMapping("{userOid}")
    public ResponseEntity<List<CartDTO>> getCart(@PathVariable("userOid") long userOid){
        log.info("======"+userOid);
        return new ResponseEntity<>(cartServices.viewCart(userOid),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<List<CartDTO>> addToCart(@RequestBody List<CartAdd> cartAdd){

        return new ResponseEntity<>(cartServices.addToCart(cartAdd),HttpStatus.OK);
    }

}
