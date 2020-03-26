package com.iessanvicente.rest.error;

public class NewUserWithDifferentPasswordsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7978601526802035152L;

	public NewUserWithDifferentPasswordsException() {
		super("Las contraseñas no coinciden");
	}
	
	
	

}