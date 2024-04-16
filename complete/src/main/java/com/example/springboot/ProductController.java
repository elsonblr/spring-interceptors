package com.example.springboot;

import com.example.springboot.model.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {

    @GetMapping(value = "list")
    public List<Product> getProducts() {
        System.out.println("--List of products -- I will get to see on console");

        return List.of(
                new Product(1, "i-Phone 11", 5),
                new Product(2, "i-Phone 12", 10),
                new Product(3, "i-Phone 13", 15)
        );
    }

    @PostMapping(value = "/new")
    public Product createProduct(@RequestBody Product product) {
        System.out.println("Return ing thye same product");
        return product;
    }

}
