package dev.jessika.fujimura.AuthenticationSystem.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.jessika.fujimura.AuthenticationSystem.Entity.Account;
import dev.jessika.fujimura.AuthenticationSystem.Service.AuthenticationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("/create-account") 
    public String createAccount(@RequestBody Account account){
        return this.authenticationService.saveNewAccount(account);
    }


    @PostMapping("/login")
    public String login(@RequestBody Account account) {
        return this.authenticationService.loginUser(account);
    }


    // private static String createAccount(String email, String password){
    //     if(email == null || password == null){
    //         return "Não é possivel criar a conta!";
    //     }
    //     String passwordEncrypt = Encrypty.encryptPassword(password);
    //     Account account = new Account(1L, email, passwordEncrypt);
    //     // accounts.add(account);
    //     return "Account criada com sucesso!";
    // }

    // private static String logIn(String email, String password){
    //     Account account = getAccountByEmail(email) ;
    //     if(account == null){
    //         return "Conta não encontrada!";
    //     }
    //     String passwordDecrypted = Encrypty.decryptPassword(account.password());
    //     if(!passwordDecrypted.equals(password)){
    //         return "Falha no login!";
    //     }
    //     return "Login com sucesso!";
    // }

    // private static String recoverPassword(String email){
    //     Account account = getAccountByEmail(email);
    //     if(account == null){
    //         return "Conta não encontrada!";
    //     }
    //     return Encrypty.decryptPassword(account.password());
    // }


    // private static Account getAccountByEmail(String email){
    //     return new Account(null, email, email);
    //     // return accounts.stream().filter(ac -> ac.email().equals(email)).findFirst().orElse(null);
    // }
    
}
