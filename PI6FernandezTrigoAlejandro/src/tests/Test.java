/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package tests;

import java.util.Locale;

import ejercicio1.Ejercicio1;
import ejercicio2.Ejercicio2;
import ejercicio3.Ejercicio3;
import ejercicio4.Ejercicio4;
import ejercicio5.Ejercicio5;

public class Test {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("en", "US"));
		
		/*
		 *  Mostrar datos por pantalla y volcar la salida en un fichero .gv para el quinto apartado.
		 *	Todos los ejercicios tienen una función pública que ejecuta los test de todas las funciones
		 *	implicadas.
		*/
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 1 ############################");
			Ejercicio1.ejercicio1("ficheros/PI6Ej1DatosEntrada1.txt");
			Ejercicio1.ejercicio1("ficheros/PI6Ej1DatosEntrada2.txt");
			Ejercicio1.ejercicio1("ficheros/PI6Ej1DatosEntrada3.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 2 ############################");
			Ejercicio2.ejercicio2("ficheros/PI6Ej2DatosEntrada1.txt");
			Ejercicio2.ejercicio2("ficheros/PI6Ej2DatosEntrada2.txt");
			Ejercicio2.ejercicio2("ficheros/PI6Ej2DatosEntrada3.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
	
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 3 ############################");
			Ejercicio3.ejercicio3("ficheros/PI6Ej3DatosEntrada1.txt");
			Ejercicio3.ejercicio3("ficheros/PI6Ej3DatosEntrada2.txt");
			Ejercicio3.ejercicio3("ficheros/PI6Ej3DatosEntrada3.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 4 ############################");
			Ejercicio4.ejercicio4("ficheros/PI6Ej4DatosEntrada.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
     	System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 5 ############################");
			Ejercicio5.ejercicio5("ficheros/PI6Ej5DatosEntrada1.txt");
			Ejercicio5.ejercicio5("ficheros/PI6Ej5DatosEntrada2.txt");
			Ejercicio5.ejercicio5("ficheros/PI6Ej5DatosEntrada3.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################");
		
	}

}
