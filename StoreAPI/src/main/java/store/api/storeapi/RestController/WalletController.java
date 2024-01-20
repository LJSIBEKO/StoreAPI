package store.api.storeapi.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.api.storeapi.Extra.DTOs.WalletDTO;
import store.api.storeapi.Extra.DTOs.WalletToUpDTO;
import store.api.storeapi.Services.WalletServices;

@RestController
@RequestMapping("api/v1/wallet")
@Slf4j
public class WalletController
{
     private final WalletServices wallet;

    @Autowired
    public WalletController(WalletServices wallet) {
        this.wallet = wallet;
    }


    @GetMapping("balance/{userOid}")
    public ResponseEntity<WalletDTO> viewBalance(@PathVariable("userOid") Long oid){
        return new ResponseEntity<>(wallet.getBalance(oid),HttpStatus.OK);
    }
}
