package com.j2ee.getionStock.service;

import com.j2ee.getionStock.entities.User;

import java.util.List;


public interface UserService {

     User loginUser(User user) ;
   void logoutUser(User auth) ;
   User forgotPassword(String email) ;

}
