package com.producto.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        Producto producto = new Producto(); // Creas un nuevo objeto producto
        model.addAttribute("producto", producto); // Añades el producto al modelo
        return "producto/form"; // Redirige a la vista del formulario
    }

    @PostMapping("/save")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        servicio.guardarProducto(producto); // Llamas al servicio para guardar
        return "redirect:/producto"; // Redirige al listado después de guardar
    }

    @PostMapping("/api/producto/save")
    public ResponseEntity<Producto> guardarProductoDesdeApi(@RequestBody Producto producto) {
        Producto nuevoProducto = servicio.guardarProducto(producto); 
        return ResponseEntity.ok(nuevoProducto); 
    }
}



