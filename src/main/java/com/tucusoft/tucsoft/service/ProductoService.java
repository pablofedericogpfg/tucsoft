package com.tucusoft.tucsoft.service;

import java.util.Optional;

import com.tucusoft.tucsoft.model.Producto;

public interface ProductoService {
    public Producto save(Producto producto);
    public Optional<Producto> get(Integer id);
    public void update(Producto producto);
    public void delete(Integer id);
    

}
