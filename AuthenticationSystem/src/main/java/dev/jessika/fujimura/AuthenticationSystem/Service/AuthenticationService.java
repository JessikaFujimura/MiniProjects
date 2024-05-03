package dev.jessika.fujimura.AuthenticationSystem.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.jessika.fujimura.AuthenticationSystem.Config.Encrypty;
import dev.jessika.fujimura.AuthenticationSystem.Entity.Account;
import dev.jessika.fujimura.AuthenticationSystem.Exception.AccountException;
import dev.jessika.fujimura.AuthenticationSystem.Repository.AccountRepository;

@Service
public class AuthenticationService {
    
    private AccountRepository accountRepository;
    private Encrypty encrypty;

    public AuthenticationService(AccountRepository accountRepository, Encrypty encrypty){
        this.accountRepository = accountRepository;
        this.encrypty = encrypty;
    }

    @Transactional
    public String saveNewAccount(Account account){
        String passwordEncrypt = encrypty.encryptPassword(account.password());
        Account accountToBePersisted = new Account(account.id(), account.email(),passwordEncrypt);
        Account accountSaved = accountRepository.save(accountToBePersisted);
        return String.format("%d - Account %s save successfully!", accountSaved.id(), accountSaved.email());
    }

    public String loginUser(Account account) {
        Account userRegistry = accountRepository.findById(account.id())
            .orElseThrow(() -> new AccountException("Account not found"));
        String passwordDecrypty = encrypty.decryptPassword(userRegistry.password());
        if(account.email().equals(userRegistry.email()) && account.password().equals(passwordDecrypty)){
            return "Login with success!";
        }
        return "Login failed!";
    }

    public String recoverPassword(String email) {
        Account userRegistry = accountRepository.findByEmail(email);
        String passwordDecrypt = encrypty.decryptPassword(userRegistry.password());
        return passwordDecrypt;
    }

}
