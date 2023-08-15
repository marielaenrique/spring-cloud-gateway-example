package com.dh.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping(path = "/detail/{id}")
    public Map<String, Object> detail(@PathVariable("id") Long idProduct) {
        Map<String, Object> response = new HashMap<>();
        response.put("id_product", idProduct);
        return response;
    }

}