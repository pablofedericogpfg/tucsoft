package com.tucusoft.tucsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tucusoft.tucsoft.model.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor,Integer> {

}
