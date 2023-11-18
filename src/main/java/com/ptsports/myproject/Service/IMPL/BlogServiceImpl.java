package com.ptsports.myproject.Service.IMPL;


import com.ptsports.myproject.DTO.BlogDto;
import com.ptsports.myproject.Entity.Blog;
import com.ptsports.myproject.Entity.Category;
import com.ptsports.myproject.Exeption.ResoureNotFoundException;
import com.ptsports.myproject.Repository.BlogRepo;
import com.ptsports.myproject.Repository.CategoryRepo;
import com.ptsports.myproject.Service.BlogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepo blogRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        Blog blog = convertToBlog(blogDto);
        Category category = categoryRepo.findById(blogDto.getCategoryID()).orElseThrow(()
                -> new ResoureNotFoundException("Category", "ID", blogDto.getCategoryID()));
        blog.setCategory(category);
        blogRepo.save(blog);
        return convertToBlogDto(blog);
    }

    @Override
    public BlogDto updateBlog(BlogDto blogDto, Integer BlogId) {
        Blog blog = blogRepo.findById(BlogId).orElseThrow(() -> new ResoureNotFoundException("Blog", "ID", BlogId));

        Blog blog1 = convertToBlog(blogDto);
        blog1.setBlogId(blog.getBlogId());

        Category category = categoryRepo.findById(blogDto.getCategoryID()).orElseThrow(() -> new ResoureNotFoundException("Category", "ID", blogDto.getCategoryID()));
        blog1.setCategory(category);
        blogRepo.save(blog1);
        return convertToBlogDto(blog1);
    }

    @Override
    public BlogDto getBlogById(Integer blogId) {
        Blog blog = blogRepo.findById(blogId).orElseThrow(() -> new ResoureNotFoundException("Blog", "ID", blogId));

        return convertToBlogDto(blog);
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        List<Blog>blogs = blogRepo.findAll();
        List<BlogDto> blogDtos = new ArrayList<>();
        for (int i = 0; i < blogs.size(); i++) {
            blogDtos.add(convertToBlogDto(blogs.get(i)));
        }
        return blogDtos;
    }

    @Override
    public void deleteBlog(Integer blogId) {
        Blog blog = blogRepo.findById(blogId).orElseThrow(() -> new ResoureNotFoundException("Blog", "ID", blogId));
blogRepo.deleteById(blog.getBlogId());
    }


    @Override
    public BlogDto convertToBlogDto(Blog blog) {
        return modelMapper.map(blog, BlogDto.class);
    }

    @Override
    public Blog convertToBlog(BlogDto blogDto) {
        return modelMapper.map(blogDto, Blog.class);
    }
}
