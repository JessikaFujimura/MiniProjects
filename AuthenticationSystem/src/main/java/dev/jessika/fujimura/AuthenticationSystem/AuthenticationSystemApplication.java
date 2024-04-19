package dev.jessika.fujimura.AuthenticationSystem;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.jessika.fujimura.AuthenticationSystem.Entity.Account;


@SpringBootApplication
public class AuthenticationSystemApplication {
    
   
    public static void main(String[] args) throws Exception {
        SpringApplication.run(AuthenticationSystemApplication.class, args);
    }

    private static void getOption(){
        Scanner sc = new Scanner(System.in);
        String option = "OPTION";
        Thread thread = new Thread();
        while(!option.equals("SAIR")){
            System.out.println("Escolha sua opção: \nA: Criar conta \nB: Fazer login \nC: Recuperar senha \nSAIR");
            option = sc.nextLine();
            String email, password, result = null;
            switch (option) {
                case "A":
                    System.out.println("Digite seu email: ");
                    email = sc.nextLine();
                    System.out.println("Digite sua senha: ");
                    password = sc.nextLine();
                    result = AuthenticationSystemApplication.createAccount(email, password);
                    System.out.println(result);
                    break;
                case "B":
                    System.out.println("Digite seu email: ");
                    email = sc.nextLine();
                    System.out.println("Digite sua senha: ");
                    password = sc.nextLine();
                    result = AuthenticationSystemApplication.logIn(email, password);
                    System.out.println(result);
                    break;
                case "C":
                    System.out.println("Digite seu email: ");
                    email = sc.nextLine();
                    result = AuthenticationSystemApplication.recoverPassword(email);
                    System.out.println(result);
                    break;
                default:
                    break;
            }
            // thread.sleep(3000);
            System.out.println("\n \n");

    }
        sc.close();
    }

    private static String createAccount(String email, String password){
        if(email == null || password == null){
            return "Não é possivel criar a conta!";
        }
        String passwordEncrypt = Encrypty.encryptPassword(password);
        Account account = new Account(1L, email, passwordEncrypt);
        // accounts.add(account);
        return "Account criada com sucesso!";
    }

    private static String logIn(String email, String password){
        Account account = getAccountByEmail(email) ;
        if(account == null){
            return "Conta não encontrada!";
        }
        String passwordDecrypted = Encrypty.decryptPassword(account.password());
        if(!passwordDecrypted.equals(password)){
            return "Falha no login!";
        }
        return "Login com sucesso!";
    }

    private static String recoverPassword(String email){
        Account account = getAccountByEmail(email);
        if(account == null){
            return "Conta não encontrada!";
        }
        return Encrypty.decryptPassword(account.password());
    }


    private static Account getAccountByEmail(String email){
        return new Account(null, email, email);
        // return accounts.stream().filter(ac -> ac.email().equals(email)).findFirst().orElse(null);
    }
}
