package com.curso.semanaDos.excepciones;

public class InsufficientBalanceException extends Exception {
	
    private final double deficit; /* TODO */
    
    public InsufficientBalanceException(double deficit) {
    	super("Cantidad no autorizada." + deficit);
    	this.deficit = deficit;
    }
    
    public double getDeficit() {
        return deficit;
    }
}
