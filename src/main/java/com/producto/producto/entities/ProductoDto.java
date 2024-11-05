package com.producto.producto.entities;


import lombok.Data;

@Data // esto es para  que se genere los getter y setter
public class ProductoDto {

 private String codigo;
 
 private String marca;
 
 private String descripcion;

 private int stock;

 private float precio;


}
