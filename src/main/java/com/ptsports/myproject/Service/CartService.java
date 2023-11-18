package com.ptsports.myproject.Service;


import com.ptsports.myproject.DTO.CartDto;
import com.ptsports.myproject.DTO.CartItemDto;
import com.ptsports.myproject.Entity.Cart;
import com.ptsports.myproject.Entity.CartItem;

public interface CartService {
    CartDto getCart(Integer userID);

    CartDto addToCart(Integer userID, CartItemDto cartItemDto);

    void deleteCartItem(int userID, int id, int sizeID, int colorID);

    CartItemDto updateCartItem(int userID, int itemID, CartItemDto cartItemDto);

    void deleteCart(int userID);

    int countItem(int userID);

    double totalPrice(int userID);

    CartDto convertToCartDto(Cart cart);

    Cart convertToCart(CartDto cartDto);

    CartItemDto convertToCartItemDto(CartItem cartItem);

    CartItem convertToCartItem(CartItemDto cartItemDto);
}
