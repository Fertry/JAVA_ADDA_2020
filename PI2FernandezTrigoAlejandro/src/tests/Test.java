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
		
		List<List<String>> listaFrases = Ejercicio1Iterativa.leeDatosEjercicio1Iterativo("ficheros/PI2Ej1DatosEntrada.txt");
		Ejercicio1Iterativa.funcionAuxiliarEjercicio1Iterativo(listaFrases);
		
	}

}
