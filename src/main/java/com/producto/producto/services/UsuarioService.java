package com.producto.producto.services;

import java.util.List;

import com.producto.producto.entities.Usuario;


public interface UsuarioService {

    List<Usuario> listUsuario();
    Usuario saveUsuario(Usuario usuario);
    Usuario leeIdUsuario(Long id);
    void deleteUsuario(Long id);
    Usuario leeLogin(String dni, String clave);

}
