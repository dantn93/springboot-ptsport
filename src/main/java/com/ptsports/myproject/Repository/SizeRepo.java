package com.ptsports.myproject.Repository;


import com.ptsports.myproject.Entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepo extends JpaRepository<Size, Integer> {
}
