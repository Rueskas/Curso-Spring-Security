package com.iessanvicente.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.iessanvicente.rest.dto.CreatePedidoDto;
import com.iessanvicente.rest.dto.GetPedidoDto;
import com.iessanvicente.rest.dto.converter.PedidoDtoConverter;
import com.iessanvicente.rest.error.exceptions.PedidoNotFoundException;
import com.iessanvicente.rest.modelo.Pedido;
import com.iessanvicente.rest.service.PedidoServicio;
import com.iessanvicente.rest.users.model.UserEntity;
import com.iessanvicente.rest.users.model.UserRole;
import com.iessanvicente.rest.util.pagination.PaginationLinksUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

	private final PedidoServicio pedidoServicio;
	private final PaginationLinksUtils paginationLinksUtils;
	private final PedidoDtoConverter dtoConverter;
	
	
	@GetMapping("/")
	public ResponseEntity<?> pedidos(
			Pageable pageable,
			HttpServletRequest request,
			@AuthenticationPrincipal UserEntity user)
					throws PedidoNotFoundException {
		Page<Pedido> result = null;
		if(user.getRoles().contains(UserRole.ADMIN)) {
			result = pedidoServicio.findAll(pageable);
		} else {
			result = pedidoServicio.findByUser(user, pageable);
		}
		
		if (result.isEmpty()) {
			throw new PedidoNotFoundException();
		} else {
			
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

			return ResponseEntity.ok().header("link", paginationLinksUtils.createLinkHeader(result, uriBuilder))
					.body(result);
		}
	}
	
	// TODO Pendiente de unir con la seguridad para poder obtener el usuario
	@PostMapping("/")
	public ResponseEntity<?> nuevoPedido(CreatePedidoDto pedido, 
			@AuthenticationPrincipal UserEntity user) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(dtoConverter.convertPedidoToGetPedidoDto(
						pedidoServicio.nuevoPedido(pedido, user)));
	}
	
	
	
}
