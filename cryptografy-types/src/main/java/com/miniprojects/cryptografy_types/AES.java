package com.miniprojects.cryptografy_types;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class AES implements Cryptografy{
    
    private static SecretKey secretKey;
    
    static {
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            secretKey = keyGenerator.generateKey();
            
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
       
    }
    @Override
    public String encrypt(final String text){
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] byteEncrypt = cipher.doFinal(text.getBytes());
            String textEncrypt = Base64.getEncoder().encodeToString(byteEncrypt);
            System.out.println("Texto cryptogrado é: "+ textEncrypt);
            return textEncrypt;
        } catch (Exception exception ){
            System.out.println(exception.getMessage());
        }
        return null;
    }
    
    @Override
    public String decrypt(final String text) {
        try{
            byte[] byteDecrypt = Base64.getDecoder().decode(text);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] textDecrypt = cipher.doFinal(byteDecrypt);
            String finalText = new String(textDecrypt);
            System.out.println("Texto descriptogrado é: "+ finalText);
            return finalText;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
