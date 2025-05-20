package com.tucusoft.tucsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.tucusoft.tucsoft.model.Menu;
import com.tucusoft.tucsoft.model.Usuario;
import com.tucusoft.tucsoft.service.ProductoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String home(HttpSession session, Model model) {
        List<Menu> menus = List.of(
                new Menu(1, "Productos", "Ver Productos", "productos"));
        session.setAttribute("homedelusuario", "administrador");
        model.addAttribute("productos", productoService.findAll());
        // model.addAttribute("menu1", "productos");
        // model.addAttribute("usuario", "ADMIN");
        session.setAttribute("menus", menus);
        session.setAttribute("usuario", Usuario.builder().id(1).nombre("ADMIN").email("").build());
        return "/administrador/home.html";
    }

}
