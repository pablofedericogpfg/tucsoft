package com.tucusoft.tucsoft.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tucusoft.tucsoft.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{

}
