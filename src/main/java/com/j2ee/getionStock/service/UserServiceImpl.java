package com.j2ee.getionStock.service;


import com.j2ee.getionStock.entities.Article;
import com.j2ee.getionStock.entities.User;
import com.j2ee.getionStock.repository.ArticleRepository;
import com.j2ee.getionStock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private ArticleRepository articleRepository ;

    @Autowired
    private UserRepository userRepository ;

    @Override
    public User loginUser(User user) {

        User costumer = userRepository.findByEmail(user.getEmail()) ;

        if(user.getPassword().equals(costumer.getPassword()) && user.getEmail().equals(costumer.getEmail())
        )
        {
            costumer.setConnected(true);
            userRepository.save(costumer) ;

            return costumer  ;
        }
        else{
            return null ;
        }
    }

    @Override
    public void logoutUser(User auth) {

        //si on ne trouve pas l'utilisateur on le déconnecte pas et on return false
        User user = userRepository.findById(auth.getId()).get();

            //je le déconnecte
            user.setConnected(false);
            //mise à jour
            userRepository.save(user) ;
    }

    @Override
    public User forgotPassword(String email) {

        User user = userRepository.findByEmail(email) ;

        return user ;
    }


}
