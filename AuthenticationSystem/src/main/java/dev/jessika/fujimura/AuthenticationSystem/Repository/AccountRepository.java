package dev.jessika.fujimura.AuthenticationSystem.Repository;

import org.springframework.data.repository.CrudRepository;

import dev.jessika.fujimura.AuthenticationSystem.Entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{
    
}
