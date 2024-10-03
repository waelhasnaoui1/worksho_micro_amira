package org.wael.microservice_workshp_maven.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wael.microservice_workshp_maven.dto.CategoryRequest;
import org.wael.microservice_workshp_maven.entities.Category;
import org.wael.microservice_workshp_maven.service.category.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequest categoryDTO,
                                                   HttpServletRequest request) {
        try {
            Category category = categoryService.createCategory (categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body (category);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
