package com.ptsports.myproject.Repository;


import com.ptsports.myproject.Entity.Length;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LengthRepo extends JpaRepository<Length,Integer> {
}
