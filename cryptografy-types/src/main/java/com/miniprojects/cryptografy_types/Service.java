package com.miniprojects.cryptografy_types;

import java.math.BigDecimal;

@org.springframework.stereotype.Service
public class Service {
    
    private final AES aesMethod;
    
    private final RSA rsaMethod;
    
    public Service(AES aesMethod, RSA rsaMethod){
        this.aesMethod = aesMethod;
        this.rsaMethod = rsaMethod;
    }
    public Entity createEntity(Entity entity, TYPE_CRIPTO type){
        String userDocument;
        String creditCardToken;
        switch (type){
            case AES -> {
                userDocument = aesMethod.encrypt(entity.getUserDocument());
                creditCardToken = aesMethod.encrypt(entity.getCreditCardToken());
                return new Entity(userDocument, creditCardToken, BigDecimal.ONE);
            }
            case RSA -> {
                userDocument = rsaMethod.encrypt(entity.getUserDocument());
                creditCardToken = rsaMethod.encrypt(entity.getCreditCardToken());
                return new Entity(userDocument, creditCardToken, BigDecimal.ONE);
            }
        }
      return null;
    }
    
    public Entity translateEntity(Entity entity, TYPE_CRIPTO type){
        String userDocument;
        String creditCardToken;
        switch (type){
            case AES -> {
                userDocument = aesMethod.decrypt(entity.getUserDocument());
                creditCardToken = aesMethod.decrypt(entity.getCreditCardToken());
                return new Entity(userDocument, creditCardToken, entity.getValue());
            }
            case RSA -> {
                userDocument = rsaMethod.decrypt(entity.getUserDocument());
                creditCardToken = rsaMethod.decrypt(entity.getCreditCardToken());
                return new Entity(userDocument, creditCardToken, entity.getValue());
            }
        }
        return null;
    }
    
}
