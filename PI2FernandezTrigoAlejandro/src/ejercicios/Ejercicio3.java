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
		
	// Función auxiliar para, dado una lista de listas de integers devuelta por
	// la función de lectura, invocar a la función elevaA() tantas veces
	// como pares de integers recibamos por fichero:
	public static void funcionAuxiliarEjercicio3(List<List<Integer>> lista) {
					
		int i = 0;
		Integer numero1;
		Integer numero2;
		Long resultadoIterativo;
		//Integer resultadoRecursivoFinal;
		//Integer resultadoFuncional;
		//Integer resultadoRecursivoNoFinal;
					
		while (i < lista.size()) {
						
			numero1 = lista.get(i).get(0);
			numero2 = lista.get(i).get(1);
			resultadoIterativo = Ejercicio3Iterativa.elevaAIterativo(numero1, numero2);
			//resultadoRecursivoFinal = Ejercicio3RecursivaFinal.elevaARecursivoFinal(numero1, numero2);
			//resultadoRecursivoNoFinal = Ejercicio3RecursivaNoFinal.elevaARecursivoNoFinal(numero1, numero2);
			//resultadoFuncional = Ejercicio2Funcional.elevaAIterativo(numero1, numero2);
			System.out.println(numero1 + " elevado a " + numero2 + " : ");
			System.out.println("1. Iterativo: " + resultadoIterativo);		
			//System.out.println("2. Recursivo final: " + resultadoRecursivoFinal);	
			//System.out.println("3. Funcional: " + resultadoFuncional);	
			System.out.println("\n");
			i++;
					
		}
						
	}

}
