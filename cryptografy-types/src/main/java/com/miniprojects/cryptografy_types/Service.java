package com.miniprojects.cryptografy_types;

import java.math.BigDecimal;

@org.springframework.stereotype.Service
public class Service {
    
    private final AES aesMethod;
    
    public Service(AES aesMethod){
        this.aesMethod = aesMethod;
    }
    public Entity createEntity(Entity entity){
        String userDocument = aesMethod.encrypt(entity.getUserDocument());
        String creditCardToken = aesMethod.encrypt(entity.getCreditCardToken());
        return new Entity(userDocument, creditCardToken, BigDecimal.ONE);
    }
    
    public Entity translateEntity(Entity entity){
        String userDocument = aesMethod.decrypt(entity.getUserDocument());
        String creditCardToken = aesMethod.decrypt(entity.getCreditCardToken());
        return new Entity(userDocument, creditCardToken, entity.getValue());
    }
    
}
