/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package tests;

import java.util.List;

import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio4;

public class Test {

	public static void main(String[] args) {
		
		// Variables:
		Integer [][] matriz1 = Ejercicio1.leeDatosEjercicio1("ficheros/PI3Ej1DatosEntrada1.txt");
		Integer [][] matriz2 = Ejercicio1.leeDatosEjercicio1("ficheros/PI3Ej1DatosEntrada2.txt");
		Integer [][] matriz3 = Ejercicio1.leeDatosEjercicio1("ficheros/PI3Ej1DatosEntrada3.txt");
		Integer [][] matriz4 = Ejercicio1.leeDatosEjercicio1("ficheros/PI3Ej1DatosEntrada4.txt");
		Integer [][] matriz5 = Ejercicio1.leeDatosEjercicio1("ficheros/PI3Ej1DatosEntrada5.txt");
		Integer [][] matriz6 = Ejercicio1.leeDatosEjercicio1("ficheros/PI3Ej1DatosEntrada6.txt");
		List <List<Integer>> listaNumeros2 = Ejercicio2.leeDatosEjercicio2("ficheros/PI3Ej2DatosEntrada.txt");
		
		// Salida por consola:
		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 1 ############################");
		Ejercicio1.funcionAuxiliarEjercicio1(matriz1);
		Ejercicio1.funcionAuxiliarEjercicio1(matriz2);
		Ejercicio1.funcionAuxiliarEjercicio1(matriz3);
		Ejercicio1.funcionAuxiliarEjercicio1(matriz4);
		Ejercicio1.funcionAuxiliarEjercicio1(matriz5);
		Ejercicio1.funcionAuxiliarEjercicio1(matriz6);
		System.out.println("#######################################################################");
		System.out.println("#######################################################################");
		System.out.println("\n");
		
		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 2 ############################");		
		Ejercicio2.funcionAuxiliarEjercicio2(listaNumeros2);
		System.out.println("#######################################################################");
		System.out.println("#######################################################################");
		System.out.println("\n");
		
		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 3 ############################");

		System.out.println("#######################################################################");
		System.out.println("#######################################################################");
		System.out.println("\n");
		
		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 4 ############################");

		System.out.println("#######################################################################");
		System.out.println("#######################################################################");
		System.out.println("\n");

	}

}
