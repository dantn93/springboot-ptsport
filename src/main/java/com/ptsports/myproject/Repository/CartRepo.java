package com.ptsports.myproject.Repository;


import com.ptsports.myproject.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
    Cart findCartByUserId(Integer id);
}
