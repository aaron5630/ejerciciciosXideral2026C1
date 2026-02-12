package com.bootcamp.week1;
import java.time.LocalDate;
import java.util.Scanner;

public class StudentCard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombre;
		int edad;
		String lenguaje;
		System.out.println("¿Cual es tu nombre?");
		nombre =sc.nextLine();
		
		System.out.println("¿Cual es tu edad?");
		edad = sc.nextInt();
		sc.nextLine();
		
		System.out.println("¿Cual es tu lenguaje de programación favorito?");
		lenguaje = sc.nextLine();
		System.out.println(show(nombre, edad, lenguaje));
		
		
	}
	
	public static String show(String nombre, int edad, String lenguaje) {
		String studentCard = "STUDENT CARD";
		String studentName = "Name: ";
		String studentAge = "Age: ";
		String studentLanguage = "Fav Language: ";
		String dateTittle = "Date: ";
		StringBuilder sb = new StringBuilder();
		sb.repeat("*",33);
		sb.append("\n*   "+ studentCard);
		sb.repeat(" ",32 - studentCard.length() - 4);//+ "*");
		sb.append("*");
		sb.append("\n*   " + studentName + nombre);  
		sb.repeat(" ",32 - studentName.length() - nombre.length()-4);
		sb.append("*");
		sb.append("\n*   " + studentAge + edad);
		sb.repeat(" ",32 - studentAge.length() - String.valueOf(edad).length()-4);
		sb.append("*");
		sb.append("\n*   " + studentLanguage + lenguaje );
		sb.repeat(" ",32 - studentLanguage.length() - lenguaje.length()-4);
		sb.append("*");
		sb.append("\n*   " + dateTittle + LocalDate.now());
		sb.repeat(" ", 32 - dateTittle.length() - String.valueOf(LocalDate.now()).length() - 4); //+ "*");
		sb.append("*");
		sb.append("\n");
		sb.repeat("*", 33);
		return sb.toString();
	}
}
