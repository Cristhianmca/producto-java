package com.producto.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;


import com.producto.producto.entities.Producto;
import com.producto.producto.services.ProductoService;



@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService servicio;
    

    @GetMapping({"","/"})
    public String getProducto(Model model){ {

        var producto = servicio.listarProductos();
        model.addAttribute("producto", producto);
        return "producto/index";
    }
}
    @GetMapping("/create")
    public String mostrarFormulario(Model model) {
        Producto producto = new Producto(); 
        model.addAttribute("producto", producto); 
        return "producto/form"; 
    }

    @PostMapping("/save")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        servicio.guardarProducto(producto); 
        return "redirect:/producto"; 
    }

}



