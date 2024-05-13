package com.j2ee.getionStock.service;

import com.j2ee.getionStock.entities.Cat;
import com.j2ee.getionStock.repository.CategoryAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryAppServiceImpl implements CategoryAppService {


    @Autowired
    private CategoryAppRepository categoryAppRepository ;

    @Override
    public Cat saveCategoryAppvment(Cat cat) {
        return categoryAppRepository.save(cat);
    }

    @Override
    public List<Cat> saveAllCategoryAppvment(List<Cat> cats) {
        return categoryAppRepository.saveAll(cats);
    }

    @Override
    public Cat updateCategoryAppvment(Cat cat) {
        return categoryAppRepository.save(cat);
    }

    @Override
    public List<Cat> updateAllCategoryAppvment(List<Cat> cats) {
        return categoryAppRepository.saveAll(cats);
    }

    @Override
    public void deleteCategoryAppvmentById(Long id) {

        categoryAppRepository.deleteById(id);
    }

    @Override
    public void deleteCategoryAppvment(Cat cat) {

        categoryAppRepository.delete(cat);
    }

    @Override
    public Cat findCategoryAppvmentById(Long id) {
        return categoryAppRepository.findById(id).get();
    }

    @Override
    public List<Cat> findAllCategoryAppvment() {
        return categoryAppRepository.findAll();
    }
}
