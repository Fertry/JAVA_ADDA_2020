/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package tests;

import ejercicio1.Ejercicio1;
import ejercicio2.Ejercicio2;
import ejercicio3.Ejercicio3;

public class Test {

	public static void main(String[] args) {

		// Mostrar datos por pantalla y volcar la salida en un fichero .gv para cada apartado que
		// lo necesite (se encuentran en la carpeta salida).
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 1 - APARTADO A) ###################");
		Ejercicio1.ejercicio1("ficheros/PI5Ej1DatosEntrada.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 2 - APARTADO A) ###################");
		Ejercicio2.ejercicio2("ficheros/PI5Ej2DatosEntrada.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 3 - APARTADO A) ###################");
		Ejercicio3.ejercicio3("ficheros/PI5Ej3DatosEntrada.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
	}

}
