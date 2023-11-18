package com.ptsports.myproject.Repository;


import com.ptsports.myproject.Entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishLitsRepo extends JpaRepository<WishList, Integer> {
    WishList getWishListByUserID(Integer id);
}
