package com.tucusoft.tucsoft.service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucusoft.tucsoft.model.Producto;
import com.tucusoft.tucsoft.repository.IProductoRepository;
import com.tucusoft.tucsoft.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    IProductoRepository productoRepository;
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

	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

    @Override
    public Producto finProducto(Integer id) {
        return productoRepository.findById(id).get();
    }

	



}
