package com.tucusoft.tucsoft.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "proveedores")


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idproveedo;	
    private String nombre;	
    private String cativa;	
    private String cuit;	
    private String direccion;	
    private Integer codpos;	
    private String fax;	
    private String telefono;	
    private String mail;	
    private String directivos;	
    private String viajante;	
    private String direc_v;	
    private String telef_v;	
    private String mail_v;	
    private String estado;	
    private double reten;	
    private double base;	
    private String tipo_ret;	
    private String observac;	
    private String tipo;	
    private boolean relacionabanco;	
    private int idbanco;	
    private double saldo;	
    private String localidad;	
    private String provincia;	
    private Integer orden;	
    private String cargacell;	
    private String letras;	
    private String terminal;	
    private String username;	
   
    private String imagen;

}
