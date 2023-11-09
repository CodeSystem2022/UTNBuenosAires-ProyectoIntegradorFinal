package com.proyecto_integrador.utnbuenosaires.model.service;

import java.util.List;

import com.proyecto_integrador.utnbuenosaires.model.dto.CartDTO;

public interface CartService {
	
	CartDTO addProductToCart(Long cartId, Long productId, Integer quantity);
	
	List<CartDTO> getAllCarts();
	
	CartDTO getCart(String emailId, Long cartId);
	
	CartDTO updateProductQuantityInCart(Long cartId, Long productId, Integer quantity);
	
	void updateProductInCarts(Long cartId, Long productId);
	
	String deleteProductFromCart(Long cartId, Long productId);
	
}
