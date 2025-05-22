package com.tucusoft.tucsoft.service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucusoft.tucsoft.model.Proveedor;
import com.tucusoft.tucsoft.repository.ProveedorRepository;
import com.tucusoft.tucsoft.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Optional<Proveedor> get(Integer id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public void update(Proveedor proveedor) {
        proveedorRepository.save(proveedor);

    }

    @Override
    public void delete(Integer id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

}
