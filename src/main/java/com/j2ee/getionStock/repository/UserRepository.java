package com.j2ee.getionStock.repository;


import com.j2ee.getionStock.entities.Commande;
import com.j2ee.getionStock.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email) ;

}
