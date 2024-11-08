package com.producto.producto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.producto.producto.entities.Cliente;
import com.producto.producto.entities.ClienteDto;

import com.producto.producto.entities.UsuarioDto;
import com.producto.producto.services.ClienteService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

 @Autowired
     ClienteService servicio;

     @GetMapping({"","/"})
    public String getUsuario(Model model, HttpSession session ){ {
        if(session.getAttribute("tiposession")== null ){
            return "redirect:/login";
        }
        var cliente = servicio.listCliente();
        model.addAttribute("cliente", cliente);
        return "cliente/index";
    }
}

    
@GetMapping("/create")
public String createCliente(Model model, HttpSession session) {
    if (session.getAttribute("tiposession") == null) {
        return "redirect:/login";
    }
    ClienteDto dto = new ClienteDto(); 
    model.addAttribute("dto", dto);
    return "cliente/create";
}

     @PostMapping("/create")
    public String createCliente(@ModelAttribute("dto") ClienteDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setDocumento(dto.getDocumento());
        cliente.setDireccion(dto.getDireccion());
        cliente.setTelefono(dto.getTelefono());
        cliente.setEmail(dto.getEmail());
        cliente.setRazonSocial(dto.getRazonSocial());
        cliente.setTipo(dto.getTipo());
        cliente.setEstado(dto.getEstado());
      
        // por que debo poner todos estos campos previos si con el servicio ya se guarda ?
        // por que el servicio guarda el producto y el producto tiene todos estos campos

        
        servicio.saveCliente(cliente);

        return "redirect:/cliente";
    }

     @GetMapping("/edit")
    public String editUsuario(Model model,@RequestParam Long id , HttpSession session) {
        if(session.getAttribute("tiposession")== null ){
            return "redirect:/login";
        }
        Cliente cliente = servicio.leeIdCliente(id);
        if (cliente == null) {
            return "redirect:/cliente";
            
        }
        ClienteDto dto = new ClienteDto();
        dto.setDocumento(cliente.getDocumento());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setDireccion(cliente.getDireccion());
        dto.setTelefono(cliente.getTelefono());
        dto.setEmail(cliente.getEmail());
        dto.setRazonSocial(cliente.getRazonSocial());
        dto.setTipo(cliente.getTipo());
        dto.setEstado(cliente.getEstado());
        model.addAttribute("dto", dto);
        model.addAttribute("cliente", cliente);
        return "cliente/edit";

    }
    @PostMapping("/edit")
    public String editUsuario(@RequestParam Long id, @ModelAttribute("dto") ClienteDto dto){

        // Usuario usuario = new Usuario();
        Cliente cliente = servicio.leeIdCliente(id);
        cliente.setDocumento(dto.getDocumento());
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setDireccion(dto.getDireccion());
        cliente.setTelefono(dto.getTelefono());
        cliente.setEmail(dto.getEmail());
        cliente.setRazonSocial(dto.getRazonSocial());
        cliente.setTipo(dto.getTipo());
        cliente.setEstado(dto.getEstado());
        servicio.saveCliente(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/delete")
    public String deleteProducto(@RequestParam Long id, HttpSession session) {
        if(session.getAttribute("tiposession")== null ){
            return "redirect:/login";
        }
        servicio.deleteCliente(id);
        return "redirect:/cliente";
    }
}
