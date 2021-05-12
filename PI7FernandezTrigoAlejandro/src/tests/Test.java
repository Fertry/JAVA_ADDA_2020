/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package tests;

import java.util.Locale;

import ejercicio1.Ejercicio1A;
import ejercicio2.Ejercicio2A;
import ejercicio2.Ejercicio2PD;

import ejercicio3.Ejercicio3BTManual;
import ejercicio3.Ejercicio3PD;
import ejercicio4.Ejercicio4;
import ejercicio4.Ejercicio4PD;
import ejercicio4.Ejercicio4PDManual;

public class Test {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("en", "US"));
		
		/*
		 *  Mostrar datos por pantalla formateados por las clases solución de todos los ejercicios.
		 *	Todos los ejercicios tienen una función pública que ejecuta los test de todas las funciones
		 *	implicadas.
		*/
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 1 ############################\n");
			Ejercicio1A.EjecutaEjercicio1A("ficheros/PI7Ej1DatosEntrada1.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//			Ejercicio1PD.EjecutaEjercicio1PD("ficheros/PI7Ej1DatosEntrada1.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 2 ############################\n");
			Ejercicio2A.EjecutaEjercicio2A("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio2PD.ejercicio2PD("");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 3 ############################\n");
		//	Ejercicio3.ejercicio3A("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio3BTManual.ejercicio3BTManual("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio3PD.ejercicio3PD("");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 4 ############################\n");
//			Ejercicio4.ejercicio4A("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio4PD.ejercicio4PD("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio4PDManual.ejercicio4PDManual("");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
	}

}
