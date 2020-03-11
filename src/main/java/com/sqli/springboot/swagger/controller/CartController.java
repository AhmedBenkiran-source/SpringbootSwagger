package com.sqli.springboot.swagger.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sqli.springboot.swagger.model.Cart;
import com.sqli.springboot.swagger.model.Product;
import com.sqli.springboot.swagger.service.CartService;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService service;

    RestTemplate restTemplate = new RestTemplate();
    private final String fooResourceUrl = "http://localhost:8080/product";

    @GetMapping(value = "/getAll")
    public Set<Cart> getCarts() {
        return service.getCartsFromService();
    }

    @GetMapping(value = "/get/{id}")
    public Optional<Cart> getCartById(@PathVariable(name = "id") Long cartId) {
        return service.getCartByIdFromService(cartId);
    }

    @GetMapping(value = "/{id}/lines")
    public void addCartLine(@PathVariable Long id, @RequestParam("productId") Long productId, @RequestParam("quantity") int quantity) {
        Product product = restTemplate
            .getForObject(fooResourceUrl + "/get/" + productId, Product.class);
        product.setQuantity(quantity);
        service.addCartLineFromService(id, product);
    }

    @GetMapping(value = "/{cartId}/lines")
    public void cartCalculated(@PathVariable Long cartId) {
        service.cartCalculatedFromService(cartId);
    }
}