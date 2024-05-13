package com.j2ee.getionStock.service;

import com.j2ee.getionStock.entities.Appvment;
import com.j2ee.getionStock.entities.Article;
import com.j2ee.getionStock.entities.Category;

import java.util.List;

public interface AppvmentService {

    Appvment saveAppvment(Appvment appvment) ;
    List<Appvment> saveAllAppvment(List<Appvment> appvments) ;
    Appvment updateAppvment(Appvment appvment) ;
    void deleteAppvmentById(Long id) ;
    void deleteAppvment(Appvment appvment) ;
    List<Appvment> getAllAppvment() ;
    Appvment getAppvmentById(Long id) ;

}
