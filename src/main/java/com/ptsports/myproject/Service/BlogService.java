package com.ptsports.myproject.Service;



import com.ptsports.myproject.DTO.BlogDto;
import com.ptsports.myproject.Entity.Blog;

import java.util.List;

public interface BlogService {
    BlogDto createBlog(BlogDto blogDto);
    BlogDto updateBlog(BlogDto blogDto,Integer BlogId);
    BlogDto getBlogById(Integer blogId);
    List<BlogDto> getAllBlogs();
    void deleteBlog(Integer blogId);

    BlogDto convertToBlogDto(Blog blog);
    Blog convertToBlog(BlogDto blogDto);
}
