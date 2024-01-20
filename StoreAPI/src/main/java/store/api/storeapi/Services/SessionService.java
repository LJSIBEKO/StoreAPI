package store.api.storeapi.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import store.api.storeapi.Config.JwtService;
import store.api.storeapi.Exceptions.ClientsException;
import store.api.storeapi.Extra.DTOs.LoginRequest;
import store.api.storeapi.Extra.DTOs.LoginResponse;
import store.api.storeapi.Extra.DTOs.RegisterResponse;
import store.api.storeapi.Extra.DTOs.UserAccountRegisterDTO;
import store.api.storeapi.Model.Cart;
import store.api.storeapi.Model.Enum.Roles;
import store.api.storeapi.Model.UserAccount;
import store.api.storeapi.Model.Wallet;
import store.api.storeapi.Repos.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SessionService {

    private final PasswordEncoder passwordEncoder;
    private final UserAccountDAO userAccountDAO;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserServices userServices;
    private final CartDAO cartDAO;


    public RegisterResponse registerUserAccount(UserAccountRegisterDTO userAccountDTO)
    {
        var user= UserAccount.builder()
                .name(userAccountDTO.name)
                .surname(userAccountDTO.surname)
                .email(userAccountDTO.email)
                .password(passwordEncoder.encode(userAccountDTO.password))
                .role(Roles.CUSTOMER)
                .build();


        Long oid= userAccountDAO.save(user).getId();

        userServices.createUser(oid);




    var jwtToken =jwtService.generateToken(user);

        return RegisterResponse
                .builder()
                .username(user.getEmail())
                .id(oid)
                .token(jwtToken)
                .build();
    }
    public LoginResponse authenticate(LoginRequest loginRequest)
    {

        log.info("=======================Login user ["+loginRequest.username+"] ======================");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username.toLowerCase(),
                        loginRequest.password
                ));

        var user=userAccountDAO.findUserAccountByEmail(loginRequest.username).orElseThrow();


        var jwtToken=jwtService.generateToken(user);
        log.info("================Login Successful for ["+loginRequest.username+"]=====================");

        return LoginResponse
                .builder()
                .username(user.getUsername())
                .id(user.getId())
                .token(jwtToken)
                .build();
    }

    public String createReq(){
        RestTemplate restTemplate=new RestTemplate();
        String url="https://pokeapi.co/api/v2/pokemon/ditto";
       String result= restTemplate.getForObject(url, String.class);
        return result;
    }
    public List<UserAccount> getAll(){
        return userAccountDAO.findAll();
    }
    public  List<Cart> getCart(){
        return cartDAO.findAll();
    }

    public RegisterResponse registerAdmin(UserAccountRegisterDTO userAccountDTO)
    {
        var user= UserAccount.builder()
                .name(userAccountDTO.name)
                .surname(userAccountDTO.surname)
                .email(userAccountDTO.email)
                .password(passwordEncoder.encode(userAccountDTO.password))
                .role(Roles.ADMIN)
                .build();


        Long oid= userAccountDAO.save(user).getId();

        userServices.createUser(oid);




        var jwtToken =jwtService.generateToken(user);

        return RegisterResponse
                .builder()
                .username(user.getEmail())
                .id(oid)
                .token(jwtToken)
                .build();

    }
}
