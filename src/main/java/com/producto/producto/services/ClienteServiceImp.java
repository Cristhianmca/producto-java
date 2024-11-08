package com.producto.producto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.producto.producto.entities.Cliente;

import com.producto.producto.repository.ClienteRepository;
import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    ClienteRepository repository;

    @Override
    public List<Cliente> listCliente() {
        return repository.findAll();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente leeIdCliente(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteCliente(Long id) {
        repository.deleteById(id);
    }
    
}