import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final List<Account>  accounts = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu email: ");
        String email = sc.nextLine();
        System.out.println("Digite sua senha: ");
        String password = sc.nextLine();
        String result = App.createAccount(email, password);
        System.out.println(result);
        sc.close();
    }

    private static String createAccount(String email, String password){
        if(email == null || password == null){
            return "Não é possivel criar a conta!";
        }
        String passwordEncrypt = Encrypty.encryptPassword(password);
        Account account = new Account(1L, email, passwordEncrypt);
        accounts.add(account);
        return "Account criada com sucesso!";
    }
}
