package com.tucusoft.tucsoft.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tucusoft.tucsoft.model.Menu;
import com.tucusoft.tucsoft.model.Usuario;
import com.tucusoft.tucsoft.service.ProductoService;

import jakarta.servlet.http.HttpSession;





@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String home( HttpSession session,Model model){
        List<Menu> menus= List.of(
            new Menu(0,"prueba","descripcion prueba","ira")
        );
        session.setAttribute("homedelusuario", "");
        session.setAttribute("appname", "Ecomerce Prueba");
        session.setAttribute("usuario", Usuario.builder().id(0).nombre("Usuario").email("").build());

        //model.addAttribute("usuario", "USUARIO"); 
        model.addAttribute("productos", productoService.findAll());
        //model.addAttribute("menu1", "Opciones");    
            
        session.setAttribute("menus", menus);
        return "usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String productohome(@PathVariable Integer id,Model model) {
        model.addAttribute("producto", productoService.get(id).get());
        
        return "usuario/productohome.html";
    }
    

}
