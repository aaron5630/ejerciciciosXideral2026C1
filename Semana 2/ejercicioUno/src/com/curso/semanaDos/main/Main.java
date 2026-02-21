package com.curso.semanaDos.main;

import com.curso.semanaDos.logic.BankAccount;

public class Main {
	public static void main(String[] args) {
	BankAccount bankUno =new BankAccount(500);
	BankAccount bankDos = new BankAccount(0);
	
	bankUno.transfer(bankDos, 200);
	
	System.out.println(bankUno.getSaldo());
	System.out.println(bankDos.getSaldo());
	
	}
}
