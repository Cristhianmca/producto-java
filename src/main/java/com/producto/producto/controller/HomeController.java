package com.producto.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.producto.producto.entities.Usuario;
import com.producto.producto.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired // inyeccion de dependencias
    UsuarioService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login") // ruta para el login de mis archvios html aqui puedo poner cualquier
    public String login(Model model) {
        Usuario u = new Usuario();
        model.addAttribute("usuario", u); // esta en rojo porque no esta importado el model
        return "/usuario/login"; // retorna la vista login de la carpeta usuario
    }

    @PostMapping("/login")
    public String login(@RequestParam String dni, @RequestParam String clave, Model model, HttpSession session) {
        Usuario u = service.leeLogin(dni, clave);
        if (u == null) {
            return "redirect:/";
        }
        model.addAttribute("usuario", u);
        session.setAttribute("idsession", u.getIdusuario() ); // getidusuario es el nombre de la variable que esta en la
                                                             // clase usuario pero me sale rojo porque no esta importado
        session.setAttribute("tiposession", u.getTipo());
        System.out.println("Conexión exitosa");
        return "redirect:/";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("idsession");
        session.removeAttribute("tiposession");
        return "redirect:/";
    }

}
