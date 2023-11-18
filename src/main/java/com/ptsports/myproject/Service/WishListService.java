package com.ptsports.myproject.Service;


import com.ptsports.myproject.DTO.WishListDto;
import com.ptsports.myproject.Entity.WishList;

public interface WishListService {
    WishListDto getWishListByUser(Integer userID);

    WishListDto addToWishList(Integer userID, Integer productID);

    WishListDto convertToWishListDto(WishList wishList);

    WishList convertToWishList(WishListDto wishListDto);
}
