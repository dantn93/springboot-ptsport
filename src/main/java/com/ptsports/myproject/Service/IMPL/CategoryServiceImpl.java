package com.ptsports.myproject.Service.IMPL;


import com.ptsports.myproject.DTO.CategoryDto;
import com.ptsports.myproject.Entity.Category;
import com.ptsports.myproject.Exeption.ResoureNotFoundException;
import com.ptsports.myproject.Repository.CategoryRepo;
import com.ptsports.myproject.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = convertToCategory(categoryDto);
        categoryRepo.save(category);
        return convertToCategoryDto(category);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()
                -> new ResoureNotFoundException("Category", "ID", categoryId));
        Category category1 = convertToCategory(categoryDto);
        category1.setCategoryId(category.getCategoryId());
        categoryRepo.save(category1);
        return convertToCategoryDto(category1);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()
                -> new ResoureNotFoundException("Category", "ID", categoryId));

        return convertToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategorys() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            categoryDtos.add(convertToCategoryDto(categories.get(i)));
        }
        return categoryDtos;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new ResoureNotFoundException("Category", "ID", categoryId));
categoryRepo.deleteById(category.getCategoryId());
    }

    @Override
    public void addCategorysService(List<Category> categoryId) {
categoryRepo.saveAll(categoryId);
    }

    @Override
    public void deleteCategorysService(List<Integer> ids) {
categoryRepo.deleteAllById(ids);
    }

    @Override
    public CategoryDto convertToCategoryDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public Category convertToCategory(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}
