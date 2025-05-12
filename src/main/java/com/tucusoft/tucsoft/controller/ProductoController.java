package com.tucusoft.tucsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.tucusoft.tucsoft.model.Producto;
import com.tucusoft.tucsoft.model.Usuario;
import com.tucusoft.tucsoft.service.ProductoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j


@Controller
@RequestMapping("/productos")
public class ProductoController {

    
    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String show() {
        return "/productos/show";
    }
    
    @GetMapping("/nuevo")
    public String create() {
        return "/productos/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Producto producto) {
        //TODO: process POST request
        log.info("Este es el objeto de la vista {}",producto.toString());
       
        producto.setUsuario(Usuario.builder().id(1).codPostal("").direccion("").email("").localidad("").nombre("").build());
        productoService.save(producto);

        return "redirect:/productos";
    }
    

    @GetMapping("/editar/{id}")
    public String getMethodName(@RequestParam Integer id) {
        return new String();
    }


    
}
