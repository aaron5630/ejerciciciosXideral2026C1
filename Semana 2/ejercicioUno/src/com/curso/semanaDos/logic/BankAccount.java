package com.curso.semanaDos.logic;

import com.curso.semanaDos.excepciones.InsufficientBalanceException;

public class BankAccount {
	private double saldo;
	
	public BankAccount(double balance) {
		this.saldo = balance;
	}
	
    public void withdraw(double amt) throws InsufficientBalanceException {
    	/* TODO */
    	if(amt < 0) {
    		throw new InsufficientBalanceException(amt);
    	}
    	
    	if (amt > saldo) {
            double deficit = amt - saldo;
            throw new InsufficientBalanceException(deficit);
        }
    	
    	saldo -= amt;
    }
    
    public void transfer(BankAccount t, double amt) { 
    	
    	try (TransactionLog tl = new TransactionLog()) {
    		tl.log("Comenzando la transaccion.");
    		this.withdraw(amt);
    		t.setSaldo(amt);
    		tl.log("Transaccion exitosa");
    		
    	} catch (InsufficientBalanceException e) {

			System.out.println(e.getMessage());
		}
    }
    
    private void setSaldo(double amt) {
    	this.saldo += amt;
    }
    
    public double getSaldo() {
    	return this.saldo;
    }
}