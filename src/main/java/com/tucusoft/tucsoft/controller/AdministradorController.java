package com.tucusoft.tucsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @GetMapping("")
    public String home(){
        return "/administrador/home.html";
    }

}
