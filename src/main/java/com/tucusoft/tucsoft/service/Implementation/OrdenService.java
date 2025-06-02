package com.tucusoft.tucsoft.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucusoft.tucsoft.controller.IOrdenRepository;
import com.tucusoft.tucsoft.model.Orden;

@Service
public class OrdenService {
    
    @Autowired
    private IOrdenRepository ordenRepository;

    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

}
