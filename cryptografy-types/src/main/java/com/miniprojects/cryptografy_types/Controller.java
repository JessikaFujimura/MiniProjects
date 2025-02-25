package com.miniprojects.cryptografy_types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/entities")
public class Controller {
    
    @Autowired
    private Service service;
    
    @PostMapping("/encode")
    public Entity encode(
            @RequestBody Entity entity){
        return service.createEntity(entity);
    }
    
    @PostMapping("/decode")
    public Entity decode(@RequestBody Entity entity){
        return service.translateEntity(entity);
    }
    
}
