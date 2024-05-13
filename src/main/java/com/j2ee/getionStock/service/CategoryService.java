package com.j2ee.getionStock.service;

import com.j2ee.getionStock.entities.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category) ;
    List<Category> saveAllCategory(List<Category> categories);
    Category updateCategory(Category category) ;
    List<Category> updateAllCategory(List<Category> categories);
    void deleteCategoryById(Long id) ;
    void deleteCategory(Category category) ;
    Category findCategoryById(Long id)  ;
    List<Category> findAllCategory() ;


}
