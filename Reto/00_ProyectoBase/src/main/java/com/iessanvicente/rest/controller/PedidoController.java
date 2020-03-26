package com.iessanvicente.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.iessanvicente.rest.error.PedidoNotFoundException;
import com.iessanvicente.rest.modelo.Pedido;
import com.iessanvicente.rest.service.PedidoServicio;
import com.iessanvicente.rest.util.pagination.PaginationLinksUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

	private final PedidoServicio pedidoServicio;
	private final PaginationLinksUtils paginationLinksUtils;
	
	
	@GetMapping("/")
	public ResponseEntity<?> pedidos(Pageable pageable, HttpServletRequest request) throws PedidoNotFoundException {
		Page<Pedido> result = pedidoServicio.findAll(pageable);
		
		
		if (result.isEmpty()) {
			throw new PedidoNotFoundException();
		} else {
			
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

			return ResponseEntity.ok().header("link", paginationLinksUtils.createLinkHeader(result, uriBuilder))
					.body(result);

			
			
		}
	}
	
	
	
}
