package com.curso.semanaDos.excepciones;

public class InvalidAmountException extends RuntimeException {
	/* TODO */ 
	public InvalidAmountException(double ammount) {
		super("Cantidad Invalida: " + ammount);
		}
	}
