package com.miniprojects.cryptografy_types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/entities")
public class Controller {
    
    @Autowired
    private Service service;
    
    @PostMapping("/encode")
    public Entity encode(
            @RequestBody Entity entity, @RequestParam(value = "type") TYPE_CRIPTO type){
        return service.createEntity(entity, type);
    }
    
    @PostMapping("/decode")
    public Entity decode(@RequestBody Entity entity, @RequestParam(value = "type") TYPE_CRIPTO type){
        return service.translateEntity(entity, type);
    }
    
}
