/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package tests;

import java.util.Locale;
import ejercicio1.Ejercicio1AG;
import ejercicio1.Ejercicio1LP;
import ejercicio2.Ejercicio2AG;
import ejercicio2.Ejercicio2LP;
import ejercicio3.Ejercicio3AG;
import ejercicio3.Ejercicio3LP;
import ejercicio4.Ejercicio4;
import ejercicio5.Ejercicio5;

public class Test {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("en", "US"));
		
		/*
		 *  Mostrar datos por pantalla formateados por las clases soluci�n de todos los ejercicios.
		 *	Todos los ejercicios tienen una funci�n p�blica que ejecuta los test de todas las funciones
		 *	implicadas. El ejercicio 5 recibe como par�metro adicional el predicado a utilizar (1 o 2).
		*/
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 1 ############################\n");
			Ejercicio1LP.ejercicio1LP("ficheros/PI6Ej1DatosEntrada1.txt");
			Ejercicio1LP.ejercicio1LP("ficheros/PI6Ej1DatosEntrada2.txt");
			Ejercicio1LP.ejercicio1LP("ficheros/PI6Ej1DatosEntrada3.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio1AG.ejercicio1AG("ficheros/PI6Ej1DatosEntrada1.txt");
			Ejercicio1AG.ejercicio1AG("ficheros/PI6Ej1DatosEntrada2.txt");
			Ejercicio1AG.ejercicio1AG("ficheros/PI6Ej1DatosEntrada3.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 2 ############################\n");
			Ejercicio2LP.ejercicio2LP("ficheros/PI6Ej2DatosEntrada1.txt");
			Ejercicio2LP.ejercicio2LP("ficheros/PI6Ej2DatosEntrada2.txt");
			Ejercicio2LP.ejercicio2LP("ficheros/PI6Ej2DatosEntrada3.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio2AG.ejercicio2AG("ficheros/PI6Ej2DatosEntrada1.txt");
			Ejercicio2AG.ejercicio2AG("ficheros/PI6Ej2DatosEntrada2.txt");
			Ejercicio2AG.ejercicio2AG("ficheros/PI6Ej2DatosEntrada3.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
	
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 3 ############################\n");
			Ejercicio3LP.ejercicio3LP("ficheros/PI6Ej3DatosEntrada1.txt");
			Ejercicio3LP.ejercicio3LP("ficheros/PI6Ej3DatosEntrada2.txt");
			Ejercicio3LP.ejercicio3LP("ficheros/PI6Ej3DatosEntrada3.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio3AG.ejercicio3AG("ficheros/PI6Ej3DatosEntrada1.txt");
			Ejercicio3AG.ejercicio3AG("ficheros/PI6Ej3DatosEntrada2.txt");
			Ejercicio3AG.ejercicio3AG("ficheros/PI6Ej3DatosEntrada3.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 4 ############################\n");
			Ejercicio4.ejercicio4("ficheros/PI6Ej4DatosEntrada.txt");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
     	System.out.println("##################################################################");
		System.out.println("######################### EJERCICIO 5 ############################\n");
			Ejercicio5.ejercicio5("ficheros/PI6Ej5DatosEntrada1.txt", 1);
			Ejercicio5.ejercicio5("ficheros/PI6Ej5DatosEntrada1.txt", 2);
			Ejercicio5.ejercicio5("ficheros/PI6Ej5DatosEntrada2.txt", 1);
			Ejercicio5.ejercicio5("ficheros/PI6Ej5DatosEntrada2.txt", 2);
			Ejercicio5.ejercicio5("ficheros/PI6Ej5DatosEntrada3.txt", 1);
			Ejercicio5.ejercicio5("ficheros/PI6Ej5DatosEntrada3.txt", 2);
		System.out.println("##################################################################");
		System.out.println("##################################################################");
		
	}
	
}
