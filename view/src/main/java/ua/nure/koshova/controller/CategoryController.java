package ua.nure.koshova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.nure.koshova.entity.Category;
import ua.nure.koshova.entity.Product;
import ua.nure.koshova.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping("/categories")
    public int createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @PutMapping("/categories")
    public boolean updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
