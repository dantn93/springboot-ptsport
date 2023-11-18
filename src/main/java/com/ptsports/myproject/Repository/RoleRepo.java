package com.ptsports.myproject.Repository;


import com.ptsports.myproject.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {


}
