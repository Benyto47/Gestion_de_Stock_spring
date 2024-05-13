package com.j2ee.getionStock.repository;

import com.j2ee.getionStock.entities.Appvment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository /* on va utiliser Hibernate d'une certainees façon pour la persistence des données*/
public interface AppvmentRepository extends JpaRepository<Appvment,Long> {
}
