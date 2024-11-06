package com.producto.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;


import com.producto.producto.entities.Producto;
import com.producto.producto.entities.ProductoDto;
import com.producto.producto.services.ProductoService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService servicio;
    

    @GetMapping({"","/"})
    public String getProducto(Model model, HttpSession session ){ {
        if(session.getAttribute("tiposession")== null ){
            return "redirect:/login";
        }
        var producto = servicio.listarProductos();
        model.addAttribute("producto", producto);
        return "producto/index";
    }
}
    // @GetMapping("/create")
    // public String mostrarFormulario(Model model) {
    //     Producto producto = new Producto(); 
    //     model.addAttribute("producto", producto); 
    //     return "producto/form"; 
    // }

    @GetMapping("/create")
    public String createProducto(Model model, HttpSession session) {
        if(session.getAttribute("tiposession")== null ){
            return "redirect:/login";
        }
        ProductoDto dto = new ProductoDto();
        model.addAttribute("dto", dto);
        return "producto/create";

    }
    
    @PostMapping("/create")
    public String createProducto(@ModelAttribute("dto") ProductoDto dto) {
        Producto producto = new Producto();
        producto.setCodigo(dto.getCodigo());
        producto.setMarca(dto.getMarca());
        producto.setDescripcion(dto.getDescripcion());
        producto.setStock(dto.getStock());
        producto.setPrecio(dto.getPrecio());
      
        // por que debo poner todos estos campos previos si con el servicio ya se guarda ?
        // por que el servicio guarda el producto y el producto tiene todos estos campos

        
        servicio.guardarProducto(producto);

        return "redirect:/producto";
    }
    // @PostMapping("/save")
    // public String guardarProducto(@ModelAttribute("producto") Producto producto) {
    //     servicio.guardarProducto(producto); 
    //     return "redirect:/producto"; 
    // }
  

    @GetMapping("/edit")
    public String editProducto(Model model,@RequestParam Long id , HttpSession session) {
        if(session.getAttribute("tiposession")== null ){
            return "redirect:/login";
        }
        Producto producto = servicio.leeIdProducto(id);
        if (producto == null) {
            return "redirect:/producto";
            
        }
        ProductoDto dto = new ProductoDto();
        dto.setCodigo(producto.getCodigo());
        dto.setMarca(producto.getMarca());
        dto.setDescripcion(producto.getDescripcion());
        dto.setStock(producto.getStock());
        dto.setPrecio(producto.getPrecio());
        model.addAttribute("dto", dto);
        model.addAttribute("producto", producto);
        return "producto/edit";


       
    }
    @PostMapping("/edit")
    public String editProducto(@RequestParam Long id, @ModelAttribute("dto") ProductoDto dto) { 

        
        Producto producto = new Producto();
        producto.setIdproducto(id);
        producto.setCodigo(dto.getCodigo());
        producto.setMarca(dto.getMarca());
        producto.setDescripcion(dto.getDescripcion());
        producto.setStock(dto.getStock());
        producto.setPrecio(dto.getPrecio());
        servicio.guardarProducto(producto);
        return "redirect:/producto";
    }


    
    @GetMapping("/delete")
    public String deleteProducto(@RequestParam Long id, HttpSession session) {
        if(session.getAttribute("tiposession")== null ){
            return "redirect:/login";
        }
        Producto producto = servicio.leeIdProducto(id);
        if (producto!=null) {
            servicio.deleteProducto(id);     
        } 
        return "redirect:/producto";
    }
    
}



