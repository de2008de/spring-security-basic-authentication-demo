package com.david.springsecuriryapplication.controllers;

import java.util.HashMap;
import java.util.Map;

import com.david.springsecuriryapplication.entities.Product;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    @GetMapping
    public Map<String, Object> getProduct() {

        Map<String, Object> map = new HashMap<>();

        Product product = new Product();

        product.setId(1);
        product.setName("iPad");
        product.setQuantity(100);

        map.put("data", product);
        
        return map;

    }

}
