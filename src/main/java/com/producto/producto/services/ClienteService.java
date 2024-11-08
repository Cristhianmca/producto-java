package com.producto.producto.services;

import java.util.List;

import com.producto.producto.entities.Cliente;

public interface ClienteService { // la interface sirve para definir los metodos que se van a implementar en la clase y el class 


     List<Cliente> listCliente();
    Cliente saveCliente(Cliente usuario);
    Cliente leeIdCliente(Long id);
    void deleteCliente(Long id);
    // Cliente leeLogin(String dni, String clave);
}
