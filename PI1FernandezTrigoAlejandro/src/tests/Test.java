/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 1
 */

package tests;

// Librerias:
import java.util.List;
import java.util.Map;

import us.lsi.geometria.Punto2D;

import ejercicios.*;

public class Test {
	
	// Funcion principal:
	public static void main(String[] args) {
		
		// Variables:
		List <List <Integer> > listaEnteros = Ejercicio1.leeDatosEjercicio1("ficheros/PI1Ej1DatosEntrada.txt");
		List <Integer> resultadoEjercicio1 = Ejercicio1.compruebaSiEsPrimo(listaEnteros);
		List <Integer> listaLimites = Ejercicio2.leeDatosEjercicio2("ficheros/PI1Ej2DatosEntrada.txt");
		List <Punto2D> listaPuntos = Ejercicio3.leeDatosEjercicio3("ficheros/PI1Ej3DatosEntrada.txt");
		Map <Punto2D.Cuadrante, Double> resultadoEjercicio3 = Ejercicio3.sumaPorCuadrantes(listaPuntos);
		
		// Salida por consola:
		System.out.println("##################################################################");
		System.out.println("######################## Test de Ejercicio 1 #####################");
		System.out.println("Datos de entrada --> Lista de enteros: ");
		System.out.println(listaEnteros);
		System.out.println("Resultado del ejercicio 1 --> Lista de primos: ");
		System.out.println(resultadoEjercicio1);
		System.out.println("##################################################################");
		System.out.println("##################################################################");
		System.out.println("");
		
		System.out.println("##################################################################");
		System.out.println("######################## Test de Ejercicio 2 #####################");
		System.out.println("Datos de entrada --> Limites: ");
		System.out.println(listaLimites);
		System.out.println("Resultado del ejercicio 2 --> Cuadrado de los siguientes primos: ");
		Ejercicio2.funcionAuxiliarEjercicio2(listaLimites);
		System.out.println("##################################################################");
		System.out.println("##################################################################");
		System.out.println("");
		
		System.out.println("##################################################################");
		System.out.println("######################## Test de Ejercicio 3 #####################");
		System.out.println("Datos de entrada --> Lista de puntos: ");
		System.out.println(listaPuntos);
		System.out.println("Resultado del ejercicio 3 --> Cuadrantes con sus sumas por coordenada X: ");
		System.out.println(resultadoEjercicio3);
		System.out.println("##################################################################");
		System.out.println("##################################################################");
		
	}
			
}
