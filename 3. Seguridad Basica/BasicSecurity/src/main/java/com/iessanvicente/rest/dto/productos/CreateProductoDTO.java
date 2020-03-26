package com.iessanvicente.rest.dto.productos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateProductoDTO {

	private String nombre;
	
	private float precio;

	private long categoriaId;

}
