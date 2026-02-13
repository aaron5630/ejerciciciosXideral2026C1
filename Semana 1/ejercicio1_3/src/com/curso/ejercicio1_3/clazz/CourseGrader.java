package com.curso.ejercicio1_3.clazz;

public class CourseGrader {
	private double[] calificaciones = {8.4,7.2,9.4,10,6.0};

	public void showCalificaciones() {
		for(double cal : calificaciones) {
			if (cal == 0) {
				continue;
			}
			if(cal <6) {
				System.out.println("Calificación: " + cal + "; Reprobado");}
			else if(cal <= 6.9) {
				System.out.println("Calificación: " + cal + "; Aprobado");
			}
			else if(cal <= 8.9) {
				System.out.println("Calificación: " + cal + "; Bueno");
			}
			else {
				System.out.println("Calificación: " + cal + "; Escelente");
			}
		}
	}
	
	private double calcularPromedio() {
		double suma = 0;
		for(double cal : calificaciones) {
			suma += cal;
		}
		return suma/calificaciones.length;
	}
	
	public void aprobarGrupo() {
		System.out.println("El grupo: " + (calcularPromedio() > 7 ? "Aprueba": "Reprueba") + "; Promedio: "  +
	calcularPromedio());
	}
	
	
}
