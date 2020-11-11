/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
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
	// la funci�n de lectura, invocar a la funci�n elevaA() tantas veces
	// como pares de integers recibamos por fichero:
	public static void funcionAuxiliarEjercicio3(List<List<Integer>> lista) {
					
		int i = 0;
		Integer base;
		Integer exponente;
		Long resultadoIterativo;
		//Long resultadoRecursivoFinal;
		//Long resultadoRecursivoNoFinal;
		//Long resultadoFuncional;
		Long ejemploDeMierda;
					
		while (i < lista.size()) {
						
			base = lista.get(i).get(0);
			exponente = lista.get(i).get(1);
			resultadoIterativo = Ejercicio3Iterativa.elevaAIterativo(base, exponente);
			ejemploDeMierda = Ejercicio3Iterativa.elevaAIterativo(5, 0);
			//resultadoRecursivoFinal = Ejercicio3RecursivaFinal.elevaARecursivoFinal(base, exponente);
			//resultadoRecursivoNoFinal = Ejercicio3RecursivaNoFinal.elevaARecursivoNoFinal(base, exponente);
			//resultadoFuncional = Ejercicio3Funcional.elevaAFuncional(base, exponente);
			System.out.println("1. Ejemplo: " + ejemploDeMierda);	
			System.out.println(base + " elevado a " + exponente + " : ");
			System.out.println("1. Iterativo: " + resultadoIterativo);		
			//System.out.println("2. Recursivo final: " + resultadoRecursivoFinal);	
			//System.out.println("2. Recursivo no final: " + resultadoRecursivoNoFinal);	
			//System.out.println("3. Funcional: " + resultadoFuncional);	
			System.out.println("\n");
			i++;
					
		}
						
	}

}
