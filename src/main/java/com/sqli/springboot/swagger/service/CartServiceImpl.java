package com.sqli.springboot.swagger.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.springboot.swagger.dao.CartDao;
import com.sqli.springboot.swagger.model.Cart;
import com.sqli.springboot.swagger.model.Product;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;


	@Override
	public Set<Cart> getCartsFromService() {
		return cartDao.getCartsFromDao();
	}

	@Override
	public Optional<Cart> getCartByIdFromService(Long cartId) {
		return cartDao.getCartByIdFromDao(cartId);
	}

	@Override
	public void addCartLineFromService(Long cartId , Product product) {
		 cartDao.addCartLineFromDao(cartId,product);

	}
	@Override
	public Integer cartCalculatedFromService(Long cartId){
		return  cartDao.cartCalculatedFromDao(cartId);
	}

}