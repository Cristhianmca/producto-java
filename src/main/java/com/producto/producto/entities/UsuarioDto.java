package com.producto.producto.entities;

import lombok.Data;

@Data

public class UsuarioDto {
    private String dni;

    private String apellidos;

    private String nombres;

    private String clave;

    private int tipo;

    private int estado;
}
