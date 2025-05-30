package com.tucusoft.tucsoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.tucusoft.tucsoft.model.DetalleOrden;
import com.tucusoft.tucsoft.model.Menu;
import com.tucusoft.tucsoft.model.Orden;
import com.tucusoft.tucsoft.model.Producto;
import com.tucusoft.tucsoft.model.Usuario;
import com.tucusoft.tucsoft.service.ProductoService;
import com.tucusoft.tucsoft.service.ProveedorService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private List<DetalleOrden> detalleOrdenes = new ArrayList<DetalleOrden>();
    private Orden orden = new Orden();

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("")
    public String home(HttpSession session, Model model) {
        List<Menu> menus = List.of(
                new Menu(0, "prueba", "descripcion prueba", "ira"));
        session.setAttribute("homedelusuario", "");
        session.setAttribute("appname", "Ecomerce Prueba");
        session.setAttribute("usuario", Usuario.builder().id(0).nombre("Usuario").email("").build());

        // model.addAttribute("usuario", "USUARIO");
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("proveedores", proveedorService.findAll());
        // model.addAttribute("menu1", "Opciones");

        session.setAttribute("menus", menus);
        model.addAttribute("cart", detalleOrdenes);
        model.addAttribute("orden", orden);
          LOGGER.info("detalle Ordenes Actualizado {}", detalleOrdenes);
        return "usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String productohome(@PathVariable Integer id, Model model) {
        model.addAttribute("producto", productoService.get(id).get());

        return "usuario/productohome";
    }

    @PostMapping("cart")
    public String addCart(@RequestParam Integer id, @RequestParam double cantidad, Model model) {
        // TODO: process POST request

        Producto producto = productoService.get(id).get();
        boolean existeprod =false;
        for (DetalleOrden dt : detalleOrdenes) {
            if (dt.getProducto().getId() == id) {
                dt.setCantidad(cantidad);
                dt.setTotal(cantidad*dt.getPrecio());
                existeprod=true;
                 LOGGER.info("cambio la detalle item {}", dt);

            }
        }
        if (existeprod==false) {
            DetalleOrden detalleOrden = new DetalleOrden();
           

            detalleOrden.setCantidad(cantidad);
            detalleOrden.setProducto(producto);
            detalleOrden.setPrecio(producto.getPrecioFinal());
            detalleOrden.setTotal(producto.getPrecioFinal() * cantidad);
            detalleOrden.setNombre(producto.getNombre());
            detalleOrdenes.add(detalleOrden);
            LOGGER.info("detalle item {}", detalleOrden);
            LOGGER.info("producto Item {}", producto);
            LOGGER.info("cantidad {}", cantidad);            
        }
        double sumaTota = 0;
        sumaTota = detalleOrdenes.stream().mapToDouble(dt -> dt.getTotal()).sum();
        orden.setTotal(sumaTota);
        orden.setTotalitems(detalleOrdenes.size());

        orden.setTotal(sumaTota);

 
        LOGGER.info("Items de Detalleordenes", detalleOrdenes);

        model.addAttribute("cart", detalleOrdenes);
        model.addAttribute("orden", orden);

      

        // return "usuario/carrito";
        return "redirect:/";
    }

    @GetMapping("delete/cart/{id}")
    public String deleteProductoCart(@PathVariable Integer id, Model model) {

        List<DetalleOrden> detallesNuevo = new ArrayList<DetalleOrden>();
        for (DetalleOrden dt : detalleOrdenes) {
            if (dt.getProducto().getId() != id) {
                detallesNuevo.add(dt);

            }
        }
        LOGGER.info("id recibido {}", id);
        detalleOrdenes = detallesNuevo;
        LOGGER.info("detalle Ordenes Nuevo {} ", detallesNuevo);
        LOGGER.info("detalle Ordenes Actualizado {}", detalleOrdenes);

        Double sumaTota = detalleOrdenes.stream().mapToDouble(dt -> dt.getTotal()).sum();
        orden.setTotal(sumaTota);
         orden.setTotalitems(detalleOrdenes.size());
        model.addAttribute("cart", detalleOrdenes);
        model.addAttribute("orden", orden);
        // return "usuario/carrito";
        return "usuario/home";
    }

    @GetMapping("carrito")
    public String ircarrito(Model model) {
        model.addAttribute("cart", detalleOrdenes);
        model.addAttribute("orden", orden);
        /*  */
        return "usuario/carrito";
    }

}
