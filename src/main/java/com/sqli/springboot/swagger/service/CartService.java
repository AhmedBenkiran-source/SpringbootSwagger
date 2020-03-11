package com.sqli.springboot.swagger.service;

import java.util.Optional;
import java.util.Set;

import com.sqli.springboot.swagger.model.Cart;
import com.sqli.springboot.swagger.model.Product;

public interface CartService {

    public Set<Cart> getCartsFromService();

    public Optional<Cart> getCartByIdFromService(Long cartId);

    public void addCartLineFromService(Long cartId, Product product);

    public Integer cartCalculatedFromService(Long cartId);
}