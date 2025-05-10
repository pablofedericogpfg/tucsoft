package com.tucusoft.tucsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tucusoft.tucsoft.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    

}
