package com.tucusoft.tucsoft.service;

import java.util.List;
import java.util.Optional;

import com.tucusoft.tucsoft.model.Proveedor;

public interface ProveedorService {
	public Proveedor save( Proveedor proveedor);
	public Optional<Proveedor> get(Integer id);
    
	public void update(Proveedor proveedor);
	public void delete(Integer id);
	public List<Proveedor> findAll();
	
}
