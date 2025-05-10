package com.tucusoft.tucsoft.service.Implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tucusoft.tucsoft.model.Producto;
import com.tucusoft.tucsoft.repository.ProductoRepository;
import com.tucusoft.tucsoft.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

    ProductoRepository productoRepository;
    @Override
    public Producto save(Producto producto) {
     
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> get(Integer id) {
      
        return productoRepository.findById(id);
    }

    @Override
    public void update(Producto producto) {
       
        productoRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }

}
