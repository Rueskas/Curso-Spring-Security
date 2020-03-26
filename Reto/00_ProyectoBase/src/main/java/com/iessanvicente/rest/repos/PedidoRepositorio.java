package com.iessanvicente.rest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iessanvicente.rest.modelo.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
	
	

}
