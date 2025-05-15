package com.tucusoft.tucsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.tucusoft.tucsoft.model.Producto;
import com.tucusoft.tucsoft.model.Usuario;

import com.tucusoft.tucsoft.service.ProductoService;
import com.tucusoft.tucsoft.service.UploadFileService;

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

    @Autowired
    private UploadFileService uploadFileService;

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
    public String save(@ModelAttribute Producto producto,@RequestParam("img") MultipartFile file) {
        //TODO: process POST request
        LOGGER.info("Este es el objeto de la vista {}",producto);
        if (producto.getId()==null) {
            producto.setUsuario(Usuario.builder().id(1).codPostal("").direccion("").email("").localidad("").nombre("").build());
            String nombreImagen=uploadFileService.saveImage(file);
            producto.setImagen(nombreImagen);
        } else {
            if (file.isEmpty()){ // esto es porque no se inyecta la imagencuando se edita el producto entonces vine file vacio
                Producto p =productoService.get(producto.getId()).get();
                producto.setImagen(p.getImagen());

            } else {
                uploadFileService.deleteImage(productoService.get(producto.getId()).get().getImagen());
                producto.setImagen(uploadFileService.saveImage(file));
            }
        }
       
       
        
        
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
    public String update(@ModelAttribute Producto producto,@RequestParam("img") MultipartFile file ) {
        //TODO: process POST request
        LOGGER.info("Este es el objeto de la vista {}",producto);
             if (file.isEmpty()){ // esto es porque no se inyecta la imagencuando se edita el producto entonces vine file vacio
                Producto p =productoService.get(producto.getId()).get();
                producto.setImagen(p.getImagen());
                 LOGGER.info("No se cargo imagen",producto);
            } else {
                LOGGER.info("Imagen antes de modificar",producto);
                uploadFileService.deleteImage(productoService.get(producto.getId()).get().getImagen());
                producto.setImagen(uploadFileService.saveImage(file));
                LOGGER.info("Imagen luego de modificar",producto);
            }   
        
        productoService.save(producto);

        return "redirect:/productos";
    }

    @PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        uploadFileService.deleteImage(productoService.get(id).get().getImagen());
        productoService.delete(id);
        redirectAttributes.addFlashAttribute("mensaje", "Producto eliminado correctamente");
		
		return "redirect:/productos";
	}

    
}
