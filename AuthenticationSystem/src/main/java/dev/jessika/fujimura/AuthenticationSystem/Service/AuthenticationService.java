package dev.jessika.fujimura.AuthenticationSystem.Service;

import org.springframework.stereotype.Service;

import dev.jessika.fujimura.AuthenticationSystem.Config.Encrypty;
import dev.jessika.fujimura.AuthenticationSystem.Entity.Account;
import dev.jessika.fujimura.AuthenticationSystem.Repository.AccountRepository;

@Service
public class AuthenticationService {
    
    private AccountRepository accountRepository;
    private Encrypty encrypty;

    public AuthenticationService(AccountRepository accountRepository, Encrypty encrypty){
        this.accountRepository = accountRepository;
        this.encrypty = encrypty;
    }

    public String saveNewAccount(Account account){
        String passwordEncrypt = Encrypty.encryptPassword(account.password());
        Account accountToBePersisted = new Account(account.id(), account.email(),passwordEncrypt);
        // accountRepository.save(accountToBePersisted);
        return "Account save successfully!";
    }
}
