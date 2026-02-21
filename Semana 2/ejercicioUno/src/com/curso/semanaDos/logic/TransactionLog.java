package com.curso.semanaDos.logic;

public class TransactionLog implements AutoCloseable {

	public TransactionLog() {
        System.out.println("Iniciando log de transacción...");
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }

    @Override
    public void close() {
        System.out.println("LOG: Cerrando log de transacción...");
    }
    /* TODO */ 
	}

