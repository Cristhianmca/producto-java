package com.producto.producto.services;

import java.util.List;

import com.producto.producto.entities.Producto;

public interface ProductoService {

    List<Producto> listarProductos();
    Producto guardarProducto(Producto producto);
    //  Producto buscarProductoPorId(Long id);
    //  void eliminarProducto(Long id);
    //  Producto actualizarProducto(Producto producto);

}
