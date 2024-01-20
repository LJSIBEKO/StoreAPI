package store.api.storeapi.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import store.api.storeapi.Extra.DTOs.ProductDTO;
import store.api.storeapi.Services.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@Slf4j
public class ProductController
{
    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto){
        return new ResponseEntity<>(productService.createProduct(dto), HttpStatus.OK);
    }
    @GetMapping("/all/{userOid}")
    public ResponseEntity<List<ProductDTO>> getAllProductForUser(@PathVariable("userOid") Long oid){
        return new ResponseEntity<>(productService.getProductFoeUser(oid),HttpStatus.OK);
    }
}
