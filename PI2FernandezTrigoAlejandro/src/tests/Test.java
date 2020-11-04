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
		
		List<List<String>> listaFrases = Ejercicio1.leeDatosEjercicio1("ficheros/PI2Ej1DatosEntrada.txt");
		System.out.println(listaFrases.toString());
		Ejercicio1.funcionAuxiliarEjercicio1(listaFrases);
		
		//List<List<Integer>> listaEnteros = Ejercicio2.leeDatosEjercicio2("ficheros/PI2Ej2DatosEntrada.txt");
		//System.out.println(listaEnteros.toString());
		//Ejercicio2.funcionAuxiliarEjercicio2(listaEnteros);
		
		/*
		boolean prueba1 = Ejercicio2Iterativa.esMultiploIterativo(8, 2);
		boolean prueba2 = Ejercicio2Iterativa.esMultiploIterativo(13, 4);
		boolean prueba3 = Ejercicio2Iterativa.esMultiploIterativo(256, 14);
		boolean prueba4 = Ejercicio2Iterativa.esMultiploIterativo(1234567, 9753);
		boolean prueba5 = Ejercicio2Iterativa.esMultiploIterativo(420, 23);
		boolean prueba6 = Ejercicio2Iterativa.esMultiploIterativo(88, 17);
		
		System.out.println(prueba1);
		System.out.println(prueba2);
		System.out.println(prueba3);
		System.out.println(prueba4);
		System.out.println(prueba5);
		System.out.println(prueba6);
		*/
		
	}

}
