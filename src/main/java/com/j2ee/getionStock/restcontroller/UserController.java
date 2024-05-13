package com.j2ee.getionStock.restcontroller;

import com.j2ee.getionStock.entities.User;
import com.j2ee.getionStock.repository.UserRepository;
import com.j2ee.getionStock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService ;

    @Autowired
    private UserRepository userRepository ;


    @PostMapping("/login")
    public User loginUser(@RequestBody User user){

       return userService.loginUser(user) ;
    }

    @PostMapping("/logout")
    public void logoutAuth(@RequestBody User user ){

        userService.logoutUser(user) ;

    }



    @GetMapping("/forgot/{email}")
    public User forgotPassword(@PathVariable("email") String email){

        return userService.forgotPassword(email) ;
    }


}
