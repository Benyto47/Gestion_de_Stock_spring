package com.j2ee.getionStock.restcontroller;

import com.j2ee.getionStock.entities.Cat;
import com.j2ee.getionStock.service.CategoryAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoryAppvment")
@CrossOrigin
public class CategoryAppvmentController {

    @Autowired
    private CategoryAppService categoryAppvmentService ;

    @PostMapping
    public Cat saveCategory(@RequestBody Cat cat) {
        Cat savedCategory = categoryAppvmentService.saveCategoryAppvment(cat);
        return savedCategory;
    }

    @PostMapping("/saveAll")
    public List<Cat> saveCategories(@RequestBody List<Cat> cats) {
        List<Cat> savedCategories = categoryAppvmentService.saveAllCategoryAppvment(cats);
        return savedCategories;
    }


    @PutMapping
    public ResponseEntity<Cat> updateCategory(@RequestBody Cat cat) {
        Cat savedCategory = categoryAppvmentService.saveCategoryAppvment(cat);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @PutMapping("/saveAll")
    public List<Cat> updateCategories(@RequestBody List<Cat> categories) {

        List<Cat> savedCategories = categoryAppvmentService.saveAllCategoryAppvment(categories);
        return savedCategories;
    }

    @GetMapping(value="/{id}")
    public Cat findCategory(@PathVariable Long id){

        return categoryAppvmentService.findCategoryAppvmentById(id);
    }

    @GetMapping("/all")
    public List<Cat> findAllCategory(){

        return categoryAppvmentService.findAllCategoryAppvment() ;
    }

    @DeleteMapping("/{id}")
    public void deleteCategryById(@PathVariable Long id) {

        categoryAppvmentService.deleteCategoryAppvmentById(id);
    }
}
