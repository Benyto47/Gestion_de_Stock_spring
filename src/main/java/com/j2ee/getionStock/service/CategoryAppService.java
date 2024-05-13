package com.j2ee.getionStock.service;

import com.j2ee.getionStock.entities.Cat;

import java.util.List;

public interface CategoryAppService {

    Cat saveCategoryAppvment(Cat cat) ;
    List<Cat> saveAllCategoryAppvment(List<Cat> cats);
    Cat updateCategoryAppvment(Cat cat) ;
    List<Cat> updateAllCategoryAppvment(List<Cat> cats);
    void deleteCategoryAppvmentById(Long id) ;
    void deleteCategoryAppvment(Cat cat) ;
    Cat findCategoryAppvmentById(Long id)  ;
    List<Cat> findAllCategoryAppvment() ;

}
