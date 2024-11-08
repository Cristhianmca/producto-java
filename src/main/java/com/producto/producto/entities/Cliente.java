package com.producto.producto.entities;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Builder.Default;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Column(length = 50, nullable = false)
    private String apellido;
    @Column(length = 11, nullable = false)
    private String documento; // DNI, RUC, etc.
    @Column(length = 100, nullable = false)
    private String direccion;
    @Column(length = 9, nullable = false)
    private String telefono;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 100, nullable = false) // esto es para empresas pero no es obligatorio entronces seria false o true dependiendo de la necesidad
    private String razonSocial; // esto es para empresas pero no es obligatorio
    @Column(length = 1, nullable = false)
    private int tipo;
    @Column(length = 1, nullable = false)
    @ColumnDefault("1")
    private int estado;
}
