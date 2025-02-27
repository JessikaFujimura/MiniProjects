package dev.jessika.fujimura.AuthenticationSystem.Config;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

@Component
public class Encrypty {
    private static KeyGenerator keyGen ;
    private static SecretKey secretKey ;
    private static Cipher cipher ;

    static {
        try{
            keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            secretKey = keyGen.generateKey();
    
            cipher = Cipher.getInstance("AES");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public String encryptPassword(String password) {
            byte[] encryptedPassword = new byte[]{};
            try {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                encryptedPassword = cipher.doFinal(password.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Base64.getEncoder().encodeToString(encryptedPassword);

    }

    public String decryptPassword(String password){
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedPassword = cipher.doFinal(Base64.getDecoder().decode(password));
            return new String(decryptedPassword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}