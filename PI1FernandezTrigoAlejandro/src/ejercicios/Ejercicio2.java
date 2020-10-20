/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 1
 */

package ejercicios;

//Librerias:
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.math.Math2;

public class Ejercicio2 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 2 				##################
	// ###################################################################################
	// ###################################################################################

	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea un concepto "Limite: numero", toma ese numero para pasarlo
	// como parametro a la funcion del ejercicio 2:
	public static List<Integer> leeDatosEjercicio2(String fichero) {

		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List<Integer> resultado = new ArrayList<Integer>();
		int i = 0;

		while (i < lista.size()) {

			String fila = lista.get(i);
			String numero = fila.replace("Limite: ", "");
			resultado.add(Integer.parseInt(numero));
			i++;

		}

		return resultado;

	}

	// Dado un numero entero, devuelve una cadena (con saltos de linea) formada por
	// todos los nº primos (al cuadrado) desde el 1 hasta el limite (numero
	// introducido como parametro):
	public static String primosHastaLimite(Integer limite) {

		int i = 0;
		Integer cuadrado = 0;
		String resultado = new String();

		while (i <= limite) {

			if (i == 0) {

				cuadrado = 4;
				resultado = resultado + cuadrado.toString() + "\n";

			} else {

				if (Math2.siguientePrimo(i) <= limite) {

					cuadrado = (int) Math.pow(Math2.siguientePrimo(i), 2);
					resultado = resultado + cuadrado.toString() + "\n";

				}

			}

			// El iterador pasa al siguiente primo
			i = Math2.siguientePrimo(i);

		}

		return resultado;

	}

	// Función auxiliar para mostrar el resultado del ejercicio 2. Dado que se
	// recibe un entero (no una lista), iteramos para llamar a la función tantas
	// veces como límites nos den en el fichero de entrada:
	public static void funcionAuxiliarEjercicio2(List<Integer> listaLimites) {

		int i = 0;
		String resultado = new String();

		while (i < listaLimites.size()) {

			resultado = primosHastaLimite(listaLimites.get(i));
			System.out.println("Limite " + listaLimites.get(i).toString() + ":");
			System.out.println(resultado.toString());
			i++;

		}

	}

}
