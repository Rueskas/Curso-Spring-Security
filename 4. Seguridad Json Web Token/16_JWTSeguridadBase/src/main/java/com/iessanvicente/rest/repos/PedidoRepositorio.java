package com.iessanvicente.rest.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iessanvicente.rest.modelo.Pedido;
import com.iessanvicente.rest.users.model.UserEntity;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
	public Page<Pedido> findByCliente(UserEntity cliente, Pageable pageable);

}
