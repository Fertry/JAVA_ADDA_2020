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

public class Ejercicio1 {
	
	//###################################################################################
	//###################################################################################
	//#######################		EJERCICIO 1                         #################
	//###################################################################################
	//###################################################################################
	
	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea dos frases separadas por un "#", devuelve una lista de listas de strings,
	// donde cada lista contiene cada par de frases:
	public static List<List<String>> leeDatosEjercicio1(String fichero) {
		
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
	
	// Funcion auxiliar para, dado una lista de listas de strings devuelta por
	// la función de lectura, invocar a la función hastaDondeSonIguales()
	// tantas veces como pares de frases recibamos por fichero:
	public static void funcionAuxiliarEjercicio1(List<List<String>> lista) {
			
		int i = 0;
		String frase1;
		String frase2;
		Integer posicionIterativo;
		Integer posicionRecursivoFinal;
		Integer posicionFuncional;

		while (i < lista.size()) {
				
			frase1 = lista.get(i).get(0);
			frase2 = lista.get(i).get(1);
			posicionIterativo = Ejercicio1Iterativa.hastaDondeSonIgualesIterativo(frase1, frase2);
			posicionRecursivoFinal = Ejercicio1RecursivaFinal.hastaDondeSonIgualesRecursivo(frase1, frase2);
			posicionFuncional = Ejercicio1Funcional.hastaDondeSonIgualesFuncional(frase1, frase2);
			System.out.println(frase1 +  " # " + frase2);
			System.out.println("1. Iterativo: " + posicionIterativo);	
			System.out.println("2. Recursivo final: " + posicionRecursivoFinal);	
			System.out.println("3. Funcional: " + posicionFuncional);	
			System.out.println("\n");
			i++;
			
		}
				
	}
		
}

