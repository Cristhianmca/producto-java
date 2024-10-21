package com.producto.producto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producto.producto.entities.Producto;
import com.producto.producto.repository.ProductoRepository;


@Service
public class ProductoServiceImp implements ProductoService{

    @Autowired
    ProductoRepository repository;
    @Override



    public List<Producto> listarProductos() {
       return repository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return repository.save(producto);
    }
    

}
