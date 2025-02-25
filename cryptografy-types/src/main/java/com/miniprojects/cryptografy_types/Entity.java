package com.miniprojects.cryptografy_types;

import java.math.BigDecimal;

public class Entity {
    
    
    private Integer id;
    private String userDocument;
    
    private String creditCardToken;
    
    private BigDecimal value;
    
    public Entity(String userDocument, String creditCardToken, BigDecimal value){
        this.id = 1;
        this.creditCardToken = creditCardToken;
        this.userDocument = userDocument;
        this.value = value;
    }
    
    public Integer getId() {
        return id;
    }
    
    
    public String getUserDocument() {
        return userDocument;
    }
    
    
    public String getCreditCardToken() {
        return creditCardToken;
    }
    
    
    public BigDecimal getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", userDocument='" + userDocument + '\'' +
                ", creditCardToken='" + creditCardToken + '\'' +
                ", value=" + value +
                '}';
    }
}
