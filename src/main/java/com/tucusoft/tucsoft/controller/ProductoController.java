package com.tucusoft.tucsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.tucusoft.tucsoft.model.Producto;
import com.tucusoft.tucsoft.model.Usuario;

import com.tucusoft.tucsoft.service.ProductoService;


import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

//import java.util.Optional;
import org.slf4j.*;




@Controller
@RequestMapping("/productos")
public class ProductoController {
private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
   

    
    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos",productoService.findAll());
        return "/productos/show";
    }
    
    @GetMapping("/nuevo")
    public String create() {
        return "/productos/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Producto producto) {
        //TODO: process POST request
        LOGGER.info("Este es el objeto de la vista {}",producto);
       
        //producto.setUsuario(Usuario.builder().id(1).codPostal("").direccion("").email("").localidad("").nombre("").build());
        productoService.save(producto);

        return "redirect:/productos";
    }
    

    @GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto producto= new Producto();
		Optional<Producto> optionalProducto=productoService.get(id);
		producto= optionalProducto.get();
		
		LOGGER.info("Producto buscado: {}",producto);
		model.addAttribute("producto", producto);
		
		return "/productos/edit";
	}
    @PostMapping("/update")
    public String update(@ModelAttribute Producto producto) {
        //TODO: process POST request
        LOGGER.info("Este es el objeto de la vista {}",producto);
       
        //producto.setUsuario(Usuario.builder().id(1).codPostal("").direccion("").email("").localidad("").nombre("").build());
        productoService.save(producto);

        return "redirect:/productos";
    }

    @PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        productoService.delete(id);
        redirectAttributes.addFlashAttribute("mensaje", "Producto eliminado correctamente");
		
		return "redirect:/productos";
	}
    
}
