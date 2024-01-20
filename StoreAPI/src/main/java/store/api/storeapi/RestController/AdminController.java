package store.api.storeapi.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
@Slf4j
public class AdminController
{
    @GetMapping("hello")
    public ResponseEntity<String> helloAdmin(){
        return new ResponseEntity<>("Hello Admin", HttpStatus.OK);
    }
}
