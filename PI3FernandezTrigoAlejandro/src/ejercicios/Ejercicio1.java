/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Arrays2;
import us.lsi.flujossecuenciales.StreamsS;

public class Ejercicio1 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 1 				 #################
	// ###################################################################################
	// ###################################################################################

	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea un nº n de numeros enteros, las filas del fichero representan las
	// filas de una matriz cuadrada de orden n*n. Pasamos los numeros de las filas al metodo
	// toMultiArray() de Miguel Toro para acceder a las posiciones con facilidad:
	public static Integer [][] leeDatosEjercicio1(String fichero) {
		
		int fila = 0;
		int columna = 0;
		int dimension = 0;
		List <String> filas = StreamsS.file(fichero).collect(Collectors.toList());
		int rango = filas.get(0).split(" ").length;
		Integer[] resultado = new Integer [rango * rango];
		
		while (fila < filas.size()) {
			
			String[] numeros = filas.get(fila).split(" ");
			
			while (columna < numeros.length) {
				
				resultado [dimension] = Integer.parseInt(numeros[columna]);
				
				columna++;
				dimension++;
					
			}
			
			fila++;
			columna = 0;
	
		}
		
		return Arrays2.toMultiArray(resultado, rango, rango);
		
	}

	// Funcion auxiliar para, dado una matriz leida por la funcion leeDatosEjercicio1(),
	// llamar a la función recursiva que resuelve el ejercicio y formatear la salida
	// acorde al fichero de salida de ejemplo proporcionado:
	public static void funcionAuxiliarEjercicio1(Integer [][] matriz) {

		int dimension = matriz.length;
		Boolean resultado = Ejercicio1Recursiva.ejercicio1Recursivo(matriz);
		
		System.out.println("Matriz de entrada de dimensión: " + dimension + "*" + dimension + " : " + dimension * dimension);
		muestraMatrizPorPantalla(matriz);
		System.out.println("\n");
		System.out.println("¿Es la matriz válida? --> " + resultado);
		System.out.println("\n");
		
	}
	
	// Funcion privada para mostrar una matriz por pantalla al pasarse esta
	// por parametro siempre y cuando la dimension no exceda 16:
	private static void muestraMatrizPorPantalla(Integer [][] matriz) {
		
		if (matriz.length > 16) {
			
			System.out.println("La matriz no se muestra debido al tamaño.");
			
		} else {
			
			for (int fila = 0; fila < matriz.length; fila++) {
				for (int columna = 0; columna < matriz.length; columna++) {
					
					System.out.print(matriz [fila][columna]);
					
					if (columna != matriz.length - 1) {
						
						System.out.print(" ");
						
					}
						
				}
				
				System.out.println("");
				
			}
			
		}

	}

}
