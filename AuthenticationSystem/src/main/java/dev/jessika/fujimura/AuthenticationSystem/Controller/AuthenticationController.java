package dev.jessika.fujimura.AuthenticationSystem.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.jessika.fujimura.AuthenticationSystem.Entity.Account;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping()    
    public String createAccount(@RequestBody Account account){

        return "ok";
    }


    @GetMapping()   
    public String login(@RequestBody Account account){

        return "ok";
    }
    
}
