package com.miniprojects.cryptografy_types;

import java.security.NoSuchAlgorithmException;

public interface Cryptografy {
    public String encrypt(String text);
    
    public String decrypt(String text);
}
