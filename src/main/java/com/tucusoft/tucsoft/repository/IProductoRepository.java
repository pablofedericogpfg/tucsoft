package com.tucusoft.tucsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tucusoft.tucsoft.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "SELECT * FROM productos WHERE UPPER(descripcion) LIKE :busqueda", nativeQuery = true)
    List<Producto> buscarPorNombre(@Param("busqueda") String busqueda);

     @Query(value = "SELECT * FROM productos WHERE idproveedo= :busqueda", nativeQuery = true)
    List<Producto> buscarPorProveedor(@Param("busqueda") Integer busqueda);
}
