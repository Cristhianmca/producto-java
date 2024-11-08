package com.producto.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.producto.producto.entities.Cliente;


@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
   
}