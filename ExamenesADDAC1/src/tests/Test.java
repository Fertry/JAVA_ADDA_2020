/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package tests;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Exámenes de ADDA del primer cuatrimestre.\n");
		
		// Algunos tests:
		List<Integer> listaEnteros = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		
		System.out.println("Lista enteros: \n" +  listaEnteros);
		System.out.println("Ejercicio 1 Recursivo No Final 17/18: \n" + examenes17_18.Ejercicio1Recursividad.esProgGeom(listaEnteros));
		System.out.println("Ejercicio 1 Recursivo Final 17/18: \n" + examenes17_18.Ejercicio1Recursividad.esProgGeomFinal(listaEnteros));
		//System.out.println("Ejercicio 1 Iterativo 17/18: \n" + examenes17_18.Ejercicio1Recursividad.esProgGeomIterativo(listaEnteros));
		//System.out.println("Ejercicio 1 Funcional 18/19: \n" + examenes18_19.Ejercicio1Recursividad.ejercicioFuncional(listaEnteros));
		//System.out.println("Ejercicio 1 Iterativo 18/19: \n" + examenes18_19.Ejercicio1Recursividad.ejercicioIterativo(listaEnteros));
		System.out.println("Ejercicio 1 Recursivo Final 18/19: \n" + examenes18_19.Ejercicio1Recursividad.ejercicioRecursivo(listaEnteros));
		
	}

}
