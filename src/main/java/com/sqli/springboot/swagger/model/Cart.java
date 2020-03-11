package com.sqli.springboot.swagger.model;

import java.util.List;

import lombok.Getter;

@Getter
public class Cart {

    private Long id;
    private  List<Product> products;

    private Cart(Long id, List<Product> product) {
        this.id = id;
        this.products = product;
    }

    public List<Product> addProductToCart(Product product){
       products.add(product);
       return products;
    }


}