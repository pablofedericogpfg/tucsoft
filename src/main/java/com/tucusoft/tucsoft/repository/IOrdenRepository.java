package com.tucusoft.tucsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tucusoft.tucsoft.model.Orden;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer>{
    @Query("SELECT MAX(o.id) FROM Orden o")
    Integer findMaxId();

}
