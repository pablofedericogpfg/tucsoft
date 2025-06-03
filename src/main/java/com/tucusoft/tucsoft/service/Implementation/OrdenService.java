package com.tucusoft.tucsoft.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucusoft.tucsoft.model.Orden;
import com.tucusoft.tucsoft.repository.IOrdenRepository;

@Service
public class OrdenService {
    
    @Autowired
    private IOrdenRepository ordenRepository;

    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    public String generarNumeroOrden(){
        
        Integer maxId=ordenRepository.findMaxId();
        if (maxId == null) {
            maxId = 1;
        }
        // Convierte a String con ceros a la izquierda (8 caracteres)
        return String.format("%08d", maxId+1);
    }
    

}
