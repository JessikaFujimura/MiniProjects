import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encrypty {

    public static String encryptPassword(String password) {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();
    
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptPassword = cipher.doFinal(password.getBytes());
            return Base64.getEncoder().encodeToString(encryptPassword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}