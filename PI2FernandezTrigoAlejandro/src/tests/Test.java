/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package tests;

import java.util.List;

import ejercicios.*;

public class Test {

	public static void main(String[] args) {
		
		// Variables:
		List<List<String>> listaFrases = Ejercicio1.leeDatosEjercicio1("ficheros/PI2Ej1DatosEntrada.txt");
		List<List<Integer>> listaEnteros = Ejercicio2.leeDatosEjercicio2("ficheros/PI2Ej2DatosEntrada.txt");
		List<List<Integer>> listaElevados = Ejercicio3.leeDatosEjercicio3("ficheros/PI2Ej3DatosEntrada.txt");
		
		// Salida por consola:
		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 1 ############################");
		Ejercicio1.funcionAuxiliarEjercicio1(listaFrases);
		System.out.println("#######################################################################");
		System.out.println("\n");
		
		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 2 ############################");		
		Ejercicio2.funcionAuxiliarEjercicio2(listaEnteros);
		System.out.println("#######################################################################");
		System.out.println("\n");
		
		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 3 ############################");
		Ejercicio3.funcionAuxiliarEjercicio3(listaElevados);
		System.out.println("#######################################################################");
		System.out.println("\n");
		
	}

}
