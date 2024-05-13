package com.j2ee.getionStock.restcontroller;

import com.j2ee.getionStock.entities.Category;
import com.j2ee.getionStock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService ;

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.saveCategory(category);
        return savedCategory;
    }

    @PostMapping("/saveAll")
    public List<Category> saveCategories(@RequestBody List<Category> categories) {
        List<Category> savedCategories = categoryService.saveAllCategory(categories);
        return savedCategories;
    }


    @PutMapping
    public Category updateCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.saveCategory(category);
        return savedCategory;
    }

    @PutMapping("/saveAll")
    public List<Category> updateCategories(@RequestBody List<Category> categories) {

        List<Category> savedCategories = categoryService.saveAllCategory(categories);
        return savedCategories;
    }

    @GetMapping(value="/{id}")
    public Category findCategory(@PathVariable Long id){

        return categoryService.findCategoryById(id);
    }

    @GetMapping("/all")
    public List<Category> findAllCategory(){

        return categoryService.findAllCategory() ;
    }

    @DeleteMapping("/{id}")
    public void deleteCategryById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }
}
