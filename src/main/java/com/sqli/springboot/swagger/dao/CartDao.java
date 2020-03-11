package com.sqli.springboot.swagger.dao;

import java.util.Optional;
import java.util.Set;

import com.sqli.springboot.swagger.model.Cart;
import com.sqli.springboot.swagger.model.Product;

public interface CartDao {

    public Set<Cart> getCartsFromDao();

    public Optional<Cart> getCartByIdFromDao(Long cartId);

    public void addCartLineFromDao(Long cartId, Product product);

    public Integer cartCalculatedFromDao(Long cartId);
}