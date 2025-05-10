package com.tucusoft.tucsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    @GetMapping("")
    public String show() {
        return "productos/show";
    }
    


}
