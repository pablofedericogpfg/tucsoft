package com.tucusoft.tucsoft;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetalleOrden {
    private Integer id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;


}
