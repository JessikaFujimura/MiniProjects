package com.miniprojects.cryptografy_types;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

@Component
public class RSA implements Cryptography {
    
    private static PublicKey publicKey;
    private static PrivateKey privateKey;
    static {
        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keypair = keyPairGenerator.generateKeyPair();
            publicKey = keypair.getPublic();
            privateKey = keypair.getPrivate();
            
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        
    }
    @Override
    public String encrypt(final String text) {
        try{
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] textEncrypt = cipher.doFinal(text.getBytes());
            String textBase64 = Base64.getEncoder().encodeToString(textEncrypt);
            System.out.println("Texto cryptogrado é: " + textBase64);
            return textBase64;
        }
        catch (Exception ex){
            ex.getMessage();
        };
        return null;
    }
    
    @Override
    public String decrypt(String text) {
        try {
            byte[] textDecode = Base64.getDecoder().decode(text);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            byte[] byteDecrypt = cipher.doFinal(textDecode);
            String textDecrypt = new String(byteDecrypt);
            System.out.println("Texto descriptogrado é: "+ textDecrypt);
            return textDecrypt;
        } catch (Exception ex){
            ex.getMessage();
        }
        return null;
    }
}
