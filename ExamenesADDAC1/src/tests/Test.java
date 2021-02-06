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
		List<Integer> listaEnteros1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> listaEnteros2 = List.of(2, 4, 8);
		//Integer[] v = { 1, 2, 3, 4, 5, 6, 3, 2, 1, 5, 3, 12 };
		Integer[][] matrix1 = {{2, 3, 5, 6}, {2, 6, 7, 8}, {2, 6, 7, 8}, {2, 3, 5, 6}};
		Integer[][] matrix2 = {{17, 23, 12, 30}, {37, 43, 4, 22}, {20, 63, 5, 10}, {8, 51, 16, 21}};
		Integer[][] matrix3 = {{1, 1}, {2, 2}};
		String letras = "aabbccddeeffgghhii";
		
		System.out.println("Ejercicio 1 Recursivo No Final 17/18: \n" + examenes17_18.Ejercicio1Recursividad.esProgGeom(listaEnteros1));
		System.out.println("Ejercicio 1 Recursivo Final 17/18: \n" + examenes17_18.Ejercicio1Recursividad.esProgGeomFinal(listaEnteros1));
		System.out.println("Ejercicio 1 Iterativo 17/18: \n" + examenes17_18.Ejercicio1Recursividad.esProgGeomIterativo(listaEnteros1));
		
		System.out.println("\n\n");
		System.out.println("Ejercicio 1 Recursivo No Final 17/18: \n" + examenes17_18.Ejercicio1Recursividad.esProgGeom(listaEnteros2));
		System.out.println("Ejercicio 1 Recursivo Final 17/18: \n" + examenes17_18.Ejercicio1Recursividad.esProgGeomFinal(listaEnteros2));
		System.out.println("Ejercicio 1 Iterativo 17/18: \n" + examenes17_18.Ejercicio1Recursividad.esProgGeomIterativo(listaEnteros2));
		
		//System.out.println("Ejercicio 1 Funcional 18/19: \n" + examenes18_19.Ejercicio1Recursividad.ejercicioFuncional(listaEnteros));
		//System.out.println("Ejercicio 1 Iterativo 18/19: \n" + examenes18_19.Ejercicio1Recursividad.ejercicioIterativo(listaEnteros));
		//System.out.println("Ejercicio 1 Recursivo Final 18/19: \n" + examenes18_19.Ejercicio1Recursividad.ejercicioRecursivo(listaEnteros));
		
		//System.out.println("Recursión final: \n" + examenes16_17.Ejercicio1Recursividad.sfactorialFinal(1024));
	    //System.out.println("Recursión no final: \n" + examenes16_17.Ejercicio1Recursividad.sfactorialNoFinal(1024));
	    //System.out.println("Iteración: \n" + examenes16_17.Ejercicio1Recursividad.sfactorialIter(1024));

	    //System.out.println("Sming recursivo final: \n" + examenes15_16.Ejercicio1Recursividad.smingFinal(0, v.length, v));
	    //System.out.println("Sming recursivo no final: \n" + examenes15_16.Ejercicio1Recursividad.smingNoFinal(0, v.length, v));
	    //System.out.println("Sming iterativo: \n" + examenes15_16.Ejercicio1Recursividad.smingFinal(0, v.length, v));
		
		//System.out.println("Elimina par DyD: \n" + examenes18_19.Ejercicio3DivideYVenceras.eliminaPar(listaEnteros, 3, 4));
		//System.out.println("Elimina par DyD: \n" + examenes18_19.Ejercicio3DivideYVenceras.eliminaPar(listaEnteros, 5, 6));
		//System.out.println("Elimina par DyD: \n" + examenes18_19.Ejercicio3DivideYVenceras.eliminaPar(listaEnteros, 9, 10));

		System.out.println("\n\n");
	    System.out.println("Test: \n" + examenes18_19.EjercicioSecuenciasIterativaRecursivaFuncional.secuencia(letras));
	    System.out.println("Test recursivo: \n" + examenes18_19.EjercicioSecuenciasIterativaRecursivaFuncional.secuenciaRecursivaPublica(letras));
	    System.out.println("Test recursivo no final: \n" + examenes18_19.EjercicioSecuenciasIterativaRecursivaFuncional.secuenciaRecursivaPublicaNoFinal(letras));
	    System.out.println("Test funcional que funciona: \n" + examenes18_19.EjercicioSecuenciasIterativaRecursivaFuncional.secuenciaFuncional(letras));
	    
	    System.out.println("\n\n");
	    System.out.println("Test de matrices: \n" + examenes18_19.Ejercicio3Matrices.coincidenSumasMatriz(matrix1));
	    System.out.println("Test de matrices: \n" + examenes18_19.Ejercicio3Matrices.coincidenSumasMatriz(matrix2));
	    System.out.println("Test de matrices: \n" + examenes18_19.Ejercicio3Matrices.coincidenSumasMatriz(matrix3));
	    
	    System.out.println("\n\n");
	    System.out.println("Test de bottom-up: \n" + examenes19_20.Bottom_up.exam1(4, 8));
	    System.out.println("Test de bottom-up: \n" + examenes19_20.Bottom_up.exam1BottomUp(4, 8));
	    System.out.println("Test de bottom-up: \n" + examenes19_20.Bottom_up.exam1(1, 50));
	    System.out.println("Test de bottom-up: \n" + examenes19_20.Bottom_up.exam1BottomUp(1, 50));
	   
	}

}
