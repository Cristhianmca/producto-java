package com.producto.producto.services;

import java.util.List;

import com.producto.producto.entities.Producto;

public interface ProductoService {

    List<Producto> listarProductos();

    Producto guardarProducto(Producto producto);

    Producto leeIdProducto(Long id);

    void deleteProducto(Long id);

    // para actualizar producto se usa el metodo guardarProducto por que si el id
    // existe actualiza y si no existe lo crea

    // void eliminarProducto(Long id);
    // Producto actualizarProducto(Producto producto);

}
