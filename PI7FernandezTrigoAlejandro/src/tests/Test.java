/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
 */

package tests;

import java.util.Locale;

import ejercicio1.Ejercicio1A;
import ejercicio1.Ejercicio1BT;
import ejercicio1.Ejercicio1PD;
import ejercicio2.Ejercicio2A;
import ejercicio2.Ejercicio2BT;
import ejercicio2.Ejercicio2PD;
import ejercicio3.Ejercicio3A;
import ejercicio3.Ejercicio3BT;
import ejercicio3.Ejercicio3BTManual;
import ejercicio3.Ejercicio3PD;
import ejercicio4.Ejercicio4A;
import ejercicio4.Ejercicio4BT;
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
			Ejercicio1A.ejercicio1A("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio1BT.ejercicio1BT("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio1PD.ejercicio1PD("");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 2 ############################\n");
			Ejercicio2A.ejercicio2A("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio2BT.ejercicio2BT("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio2PD.ejercicio2PD("");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 3 ############################\n");
			Ejercicio3A.ejercicio3A("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio3BT.ejercicio3BT("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio3BTManual.ejercicio3BTManual("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio3PD.ejercicio3PD("");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 4 ############################\n");
			Ejercicio4A.ejercicio4A("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio4BT.ejercicio4BT("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio4PD.ejercicio4PD("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio4PDManual.ejercicio4PDManual("");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
	}

}
