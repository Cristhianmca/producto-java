package com.producto.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.producto.producto.entities.Producto;
import com.producto.producto.entities.ProductoDto;
import com.producto.producto.entities.Usuario;
import com.producto.producto.entities.UsuarioDto;
import com.producto.producto.services.ProductoService;
import com.producto.producto.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {



      @Autowired
    private UsuarioService servicio;
    

    @GetMapping({"","/"})
    public String getUsuario(Model model, HttpSession session ){ {
        if(session.getAttribute("tiposession")== null ){
            return "redirect:/login";
        }
        var usuario = servicio.listUsuario();
        model.addAttribute("usuario", usuario);
        return "usuario/index";
    }
}
 @GetMapping("/create")
    public String createUsuario(Model model, HttpSession session) {
        if(session.getAttribute("tiposession")== null ){
            return "redirect:/login";
        }
        UsuarioDto dto = new UsuarioDto();
        model.addAttribute("dto", dto);
        return "usuario/create";

    }
    @PostMapping("/create")
    public String createUsuario(@ModelAttribute("dto") UsuarioDto dto) {
        Usuario usuario = new Usuario();
        usuario.setDni(dto.getDni());
        usuario.setApellidos(dto.getApellidos());
        usuario.setNombres(dto.getNombres());
        usuario.setClave(dto.getClave());
        usuario.setTipo(dto.getTipo());
        usuario.setEstado(dto.getEstado());
      
        // por que debo poner todos estos campos previos si con el servicio ya se guarda ?
        // por que el servicio guarda el producto y el producto tiene todos estos campos

        
        servicio.saveUsuario(usuario);

        return "redirect:/usuario";
    }

     @GetMapping("/edit")
    public String editUsuario(Model model,@RequestParam Long id , HttpSession session) {
        if(session.getAttribute("tiposession")== null ){
            return "redirect:/login";
        }
        Usuario usuario = servicio.leeIdUsuario(id);
        if (usuario == null) {
            return "redirect:/usuario";
            
        }
        UsuarioDto dto = new UsuarioDto();
        dto.setDni(usuario.getDni());
        dto.setApellidos(usuario.getApellidos());
        dto.setNombres(usuario.getNombres());
        dto.setClave(usuario.getClave());
        dto.setTipo(usuario.getTipo());
        dto.setEstado(usuario.getEstado());
        model.addAttribute("dto", dto);
        model.addAttribute("usuario", usuario);
        return "usuario/edit";
    }

    @PostMapping("/edit")
    public String editUsuario(@RequestParam Long id, @ModelAttribute("dto") UsuarioDto dto) { 

        // Usuario usuario = new Usuario();
        Usuario usuario = servicio.leeIdUsuario(id);
        usuario.setDni(dto.getDni());
        usuario.setApellidos(dto.getApellidos());
        usuario.setNombres(dto.getNombres());
        usuario.setClave(dto.getClave());
        usuario.setTipo(dto.getTipo());
        usuario.setEstado(dto.getEstado());
        servicio.saveUsuario(usuario);

        return "redirect:/usuario";
    }

    @GetMapping("/delete")
    public String deleteProducto(@RequestParam Long id, HttpSession session) {
        if(session.getAttribute("tiposession")== null ){
            return "redirect:/login";
        }
        Usuario usuario = servicio.leeIdUsuario(id);
        if (usuario!=null) {
            servicio.deleteUsuario(id);     
        } 
        return "redirect:/usuario";
    }
}