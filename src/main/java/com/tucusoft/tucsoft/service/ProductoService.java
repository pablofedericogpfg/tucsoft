package com.tucusoft.tucsoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.tucusoft.tucsoft.model.Producto;

public interface ProductoService {
	public Producto save( Producto producto);
	public Optional<Producto> get(Integer id);
    public Producto finProducto(Integer id);
	public void update(Producto producto);
	public void delete(Integer id);
	public List<Producto> findAll();
	public List<Producto> buscarPorNombre(@Param("busqueda") String busqueda);
	List<Producto> buscarPorProveedor(@Param("busqueda") Integer busqueda);


}
