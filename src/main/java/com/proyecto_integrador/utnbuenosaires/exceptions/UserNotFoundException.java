package com.proyecto_integrador.utnbuenosaires.exceptions;

public class UserNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {}
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
}
