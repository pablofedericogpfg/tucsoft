package com.tucusoft.tucsoft.controller;

import com.tucusoft.tucsoft.model.Producto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "imagenesproductos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ImagenesProductos {
    /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idimagen; */

    @Id
    private Integer idproducto;
    @Lob
    @Column(name = "imagen", columnDefinition = "LONGTEXT")
    private String imagen;

    /* @OneToOne

    private Producto producto; */




}
