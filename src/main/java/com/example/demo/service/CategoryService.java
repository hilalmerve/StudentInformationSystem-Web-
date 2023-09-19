package com.example.demo.service;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;
import com.example.demo.model.vm.CategoryVm;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    public String addCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        String nameDto = categoryDto.getName();
        category.setName(nameDto);
        category = categoryRepository.save(category);
        CategoryVm categoryVm = modelMapper.map(category, CategoryVm.class);
        return categoryVm.getName();
        
    } 
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public List<CategoryVm> getAllCategories() {
        return categoryRepository.findAll()
        .stream()
        .map(this::getCategoryVm)
        .toList();
    }

    public CategoryVm getCategoryVm(Category savedCategory) {
        return modelMapper.map(savedCategory, CategoryVm.class);
    }
}
