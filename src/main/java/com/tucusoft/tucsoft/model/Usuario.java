package com.tucusoft.tucsoft.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Table(name = "usuarios")

//@Getter
//@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;
    private Integer idaccess;
    private String codPostal;
    private String localidad;
    private String provincia;

   @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Orden> ordenes;


}
