package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.vm.CategoryVm;
import com.example.demo.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addCategory(@RequestBody CategoryDto categoryDto) {
        String category = categoryService.addCategory(categoryDto);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    ResponseEntity<List<CategoryVm>> getAllProduct(){
        List<CategoryVm> allCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }
}
