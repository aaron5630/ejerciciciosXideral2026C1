package com.curso.ejercicio1_2.main;

public class StudentProfile {
	
	private byte edad;
	private int id;
	private long numeroTelefono;
	private float promedioParcial;
	private double promedioFinal;
	private boolean becado;
	char seccion;
	String nombreCompleto;
	
	public StudentProfile(byte edad, int id, long numeroTelefono, float promedioParcial, double promedioFinal,
			char seccion, String nombreCompleto, boolean becado) {
		this.edad = edad;
		this.id = id;
		this.numeroTelefono = numeroTelefono;
		this.promedioParcial = promedioParcial;
		this.promedioFinal = promedioFinal;
		this.seccion = seccion;
		this.nombreCompleto = nombreCompleto;
		this.becado = becado;
	}
	
	public void show() {
		System.out.println("Edad: " + edad + "; tamaño: " + Byte.BYTES);
		System.out.println("Id: " + id + "; tamaño: " + Integer.BYTES);
		System.out.println("Numero de telefono: " + numeroTelefono + "; tamaño: " + Long.BYTES);
		System.out.println("Promedio parcial" + promedioParcial + "; tamañao: " + Float.BYTES);
		System.out.println("Promedio final: " + promedioFinal + "; tamaño: " + Double.BYTES);
		System.out.println("Seccion: " + seccion + "; tamaño: " + Character.BYTES);
		System.out.println("¿Es becado? " + becado);
		System.out.println("Nombre; " + nombreCompleto);
		
		
	}
	
}
