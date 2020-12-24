/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 4
 */

package tests;

import java.util.List;

import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio4;
import ejercicios.Ejercicio5;
import us.lsi.common.Tuple2;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class Test {

	public static void main(String[] args) {
	
		// Variables:
		List <BinaryTree<Integer>> lista1 = Ejercicio1.leeDatosEjercicio1("ficheros/PI4Ej1DatosEntrada.txt");
		List<Tuple2<BinaryTree<String>, List<String>>> lista2 = Ejercicio2.leeDatosEjercicio2("ficheros/PI4Ej2DatosEntrada.txt");
		List <Tree<String>> lista3 = Ejercicio3.leeDatosEjercicio3("ficheros/PI4Ej3DatosEntrada.txt");
		List <Tree<String>> lista4 = Ejercicio4.leeDatosEjercicio4("ficheros/PI4Ej4DatosEntrada.txt");
		List <Tree<String>> lista5 = Ejercicio5.leeDatosEjercicio5("ficheros/PI4Ej5DatosEntrada.txt");
		
		// Salida por consola:
		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 1 ############################");
		Ejercicio1.funcionAuxiliarEjercicio1(lista1);
		System.out.println("#######################################################################");
		System.out.println("#######################################################################");
		System.out.println("\n");
		
		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 2 ############################");
		Ejercicio2.funcionAuxiliarEjercicio2(lista2);
		System.out.println("#######################################################################");
		System.out.println("#######################################################################");
		System.out.println("\n");
		
		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 3 ############################");
		Ejercicio3.funcionAuxiliarEjercicio3Par(lista3);
		Ejercicio3.funcionAuxiliarEjercicio3Primo(lista3);
		System.out.println("#######################################################################");
		System.out.println("#######################################################################");
		System.out.println("\n");

		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 4 ############################");
		Ejercicio4.funcionAuxiliarEjercicio4(lista4);
		System.out.println("#######################################################################");
		System.out.println("#######################################################################");
		System.out.println("\n");
		
		System.out.println("#######################################################################");
		System.out.println("######################### TEST EJERCICIO 5 ############################");
		Ejercicio5.funcionAuxiliarEjercicio5(lista5);
		System.out.println("#######################################################################");
		System.out.println("#######################################################################");

	}

}
