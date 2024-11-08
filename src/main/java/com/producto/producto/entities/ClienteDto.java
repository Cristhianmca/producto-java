package com.producto.producto.entities;


import lombok.Data;

@Data

public class ClienteDto {  
    
    private String nombre;
    
    private String apellido;
    
    private String documento; // DNI, RUC, etc.
   
    private String direccion;
    
    private String telefono;
    
    private String email;
     // esto es para empresas pero no es obligatorio entronces seria false o true dependiendo de la necesidad
    private String razonSocial; // esto es para empresas pero no es obligatorio
    
    private int tipo;
   
    private int estado;
}
