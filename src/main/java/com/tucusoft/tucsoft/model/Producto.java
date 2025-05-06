package com.tucusoft.tucsoft.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precioCosto;
    private double precio;
    private double cantidad;
    
 

}
