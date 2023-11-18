package com.ptsports.myproject.Repository;


import com.ptsports.myproject.Entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer> {
}
