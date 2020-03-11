package com.sqli.springboot.swagger.dao;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.sqli.springboot.swagger.model.Cart;
import com.sqli.springboot.swagger.model.Product;


@Repository
public class CartDaoImpl implements CartDao {

    static Set<Cart> carts;
    static List<Product> products;

    @Override
    public Set<Cart> getCartsFromDao() {
        return carts;
    }

    @Override
    public Optional<Cart> getCartByIdFromDao(Long cartId) {
        return Optional.empty();
    }

    @Override
    public void addCartLineFromDao(Long cartId, Product product) {
        Cart cart = (Cart) carts.stream().filter(car -> car.getId().equals(cartId));
        cart.addProductToCart(product);
        carts.add(cart);
    }

    @Override
    public Integer cartCalculatedFromDao(Long cartId) {
        int sum = 0;
        Cart cart = (Cart) carts.stream().filter(car -> car.getId().equals(cartId));
        for (Product product : cart.getProducts()) {
            sum += product.getQuantity() * product.getPrice();
        }
        return sum;
    }
}