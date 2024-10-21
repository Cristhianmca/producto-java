package com.producto.producto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idproducto;
 @Column(length = 23, nullable = false)
 private String codigo;
 @Column(length = 30, nullable = false)
 private String marca;
 @Column(length = 100, nullable = false)
 private String descripcion;
 @Column(nullable = false)
 private int stock;
@Column(nullable = false)
 private float precio;


}
