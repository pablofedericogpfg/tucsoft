package com.tucusoft.tucsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucusoft.tucsoft.model.DetalleOrden;
import com.tucusoft.tucsoft.repository.IDetalleOrdenRepository;

@Service
public class DetalleOrdenService {

    @Autowired
    private IDetalleOrdenRepository detalleOrdenRepository;

    public DetalleOrden save(DetalleOrden detalleOrden){
       return detalleOrdenRepository.save(detalleOrden);

    }

}
