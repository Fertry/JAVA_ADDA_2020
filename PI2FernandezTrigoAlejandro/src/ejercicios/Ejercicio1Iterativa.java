/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

public class Ejercicio1Iterativa {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 1 - ITERATIVO				##################
	// ###################################################################################
	// ###################################################################################
	
	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea dos frases separadas por un "#", devuelve una lista de listas de strings,
	// donde cada lista contiene cada par de frases:
	public static List<List<String>> leeDatosEjercicio1Iterativo(String fichero) {
		
		int i = 0;
		int j = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List<List<String>> resultado = new ArrayList<List<String>>();
		
		while (i < lista.size()) {
			
			String fila = lista.get(i);
			String[] frases = fila.split("#");
			List<String> miniLista = new ArrayList<>();
			
			while (j < frases.length) {
				
				miniLista.add(frases[j]);
				j++;
				
			}
			
			resultado.add(miniLista);
			j = 0;
			i++;
			
		}
		
		return resultado;
		
	}
	
	// Dada una lista de listas de strings, donde cada lista contiene dos frases,
	// itera sobre ambas frases de cada lista. Determina en que punto de ambas frases
	// dejan de ser iguales y devuelve esa posición numérica:
	public static Integer hastaDondeSonIgualesIterativo(List<String> lista) {
		
		int i = 0;
		char[] frase1;
		char[] frase2;
		Integer resultado = 0;
		
		frase1 = lista.get(0).toCharArray();
		frase2 = lista.get(1).toCharArray();
		
		while (i < frase1.length && i < frase2.length) {
			
			if (frase1[i] != frase2[i]) {
				
				resultado = i;
				return resultado;
				
			}
			
			i++;
			
		}
		
		return resultado;
		
	}

	// Función auxiliar para, dado una lista de listas de strings devuelta por
	// la función de lectura, invocar a la función hastaDondeSonIgualesIterativo()
	// tantas veces como pares de frases recibamos por fichero:
	public static void funcionAuxiliarEjercicio1Iterativo(List<List<String>> lista) {
		
		int i = 0;
		//int j = 0;
		String frase1;
		String frase2;
		Integer posicion = 0;
		
		while (i < lista.size()) {
			
			List<String> frases = new ArrayList<String>();
			frase1 = lista.get(i).get(0);
			frase2 = lista.get(i).get(1);
			frases.add(frase1);
			frases.add(frase2);
			posicion = hastaDondeSonIgualesIterativo(frases);
			System.out.println(frase1 +  " # " + frase2);
			System.out.println("Son iguales hasta la posición: " + posicion);
			i++;
		
		}
			
	}
	
}
	