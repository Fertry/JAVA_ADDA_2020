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

public class Ejercicio3 {
	
	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea dos integers (+ y -) separados por una ",", devuelve una lista de listas de
	// integers donde cada lista contiene cada par de integers:
	public static List<List<Integer>> leeDatosEjercicio3(String fichero) {
				
		int i = 0;
		int j = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
				
		while (i < lista.size()) {
					
			String fila = lista.get(i);
			String[] numeros = fila.split(",");
			List<Integer> miniLista = new ArrayList<>();
					
			while (j < numeros.length) {
						
				miniLista.add(Integer.parseInt(numeros[j]));
				j++;
						
			}
					
			resultado.add(miniLista);
			j = 0;
			i++;
					
		}
				
		return resultado;
				
	}
		
	// Funcion auxiliar para, dado una lista de listas de integers devuelta por
	// la función de lectura, invocar a la función elevaA() tantas veces
	// como pares de integers recibamos por fichero:
	public static void funcionAuxiliarEjercicio3(List<List<Integer>> lista) {
					
		int i = 0;
		Integer n;
		Integer exponente;
		Long resultadoIterativo;
		Long resultadoRecursivoFinal;
		Long resultadoRecursivoNoFinal;
		Long resultadoFuncional;
					
		while (i < lista.size()) {
						
			exponente = lista.get(i).get(0);
			n = lista.get(i).get(1);
			resultadoIterativo = Ejercicio3Iterativa.elevaAIterativo((long) exponente, n);
			resultadoRecursivoFinal = Ejercicio3RecursivaFinal.elevaARecursivoFinal(exponente, n);
			resultadoRecursivoNoFinal = Ejercicio3RecursivaNoFinal.elevaARecursivoNoFinal(exponente, n);
			resultadoFuncional = Ejercicio3Funcional.elevaAFuncional(exponente, n);
			System.out.println("Exponente: " + exponente + " n: " + n);
			System.out.println("1. Iterativo: " + resultadoIterativo);		
			System.out.println("2. Recursivo final: " + resultadoRecursivoFinal);	
			System.out.println("3. Recursivo no final: " + resultadoRecursivoNoFinal);	
			System.out.println("4. Funcional: " + resultadoFuncional);	
			System.out.println("\n");
			i++;
					
		}
						
	}

}
