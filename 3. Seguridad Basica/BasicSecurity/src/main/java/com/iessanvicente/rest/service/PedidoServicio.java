package com.iessanvicente.rest.service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.iessanvicente.rest.dto.pedidos.CreatePedidoDto;
import com.iessanvicente.rest.modelo.LineaPedido;
import com.iessanvicente.rest.modelo.Pedido;
import com.iessanvicente.rest.modelo.Producto;
import com.iessanvicente.rest.repos.PedidoRepositorio;
import com.iessanvicente.rest.service.base.BaseService;
import com.iessanvicente.rest.users.models.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServicio extends BaseService<Pedido, Long, PedidoRepositorio> {
	
	private final ProductoServicio productoServicio;
	
	public Page<Pedido> findByUser(UserEntity user, Pageable pageable){
		return this.repositorio.findByCliente(user, pageable);
	}
	
	public Pedido save(CreatePedidoDto pedido, UserEntity user) {
		return save(Pedido.builder()
				.cliente(user)
				.lineas(
					pedido.getLineas().stream()
					.map( lineaDto -> {
						Optional<Producto> p = productoServicio.findById(lineaDto.getProductoId());
						if(p.isPresent()) {
							Producto producto = p.get();
							return LineaPedido.builder()
									.cantidad(lineaDto.getCantidad())
									.precio(producto.getPrecio())
									.producto(producto)
									.build();
						} else {
							return null;
						}
					})
					.filter(Objects::nonNull)
					.collect(Collectors.toSet())
					)
					.build());
	}
	
}
