package com.tucusoft.tucsoft;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orden {

    private Integer id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;

    private double total;
}
