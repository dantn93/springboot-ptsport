package com.ptsports.myproject.Repository;


import com.ptsports.myproject.Entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepo extends JpaRepository<Catalog,Integer> {


}
