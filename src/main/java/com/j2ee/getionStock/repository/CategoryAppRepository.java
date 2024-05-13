package com.j2ee.getionStock.repository;

import com.j2ee.getionStock.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryAppRepository extends JpaRepository<Cat,Long> {
}
