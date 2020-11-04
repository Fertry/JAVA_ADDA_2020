package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

public class Ejercicio2 {
	
	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea dos integers separados por una ",", devuelve una lista de listas de integers,
	// donde cada lista contiene cada par de integers:
	public static List<List<Integer>> leeDatosEjercicio2(String fichero) {
			
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
	// la función de lectura, invocar a la función esMultiplo() tantas veces
	// como pares de integers recibamos por fichero:
	public static void funcionAuxiliarEjercicio2(List<List<Integer>> lista) {
				
		int i = 0;
		Integer numero1;
		Integer numero2;
		boolean resultadoIterativo;
		//boolean resultadoRecursivoFinal = true;
		//boolean resultadoFuncional = true;
				
		while (i < lista.size()) {
					
			numero1 = lista.get(i).get(0);
			numero2 = lista.get(i).get(1);
			resultadoIterativo = Ejercicio2Iterativa.esMultiploIterativo(numero1, numero2);
			//resultadoRecursivoFinal = Ejercicio2RecursivaFinal.esMultiploRecursivoFinal(numeros);
			//resultadoFuncional = Ejercicio2Funcional.esMultiploFuncional(numeros);
			System.out.println("¿Es el Nº " + numero1 + " multiplo del " + " nº " + numero2 + "?");
			System.out.println("1. Iterativo: " + resultadoIterativo);		
			//System.out.println("2. Recursivo final: " + resultadoRecursivoFinal);	
			//System.out.println("3. Funcional: " + resultadoFuncional);	
			System.out.println("\n");
			i++;
				
		}
					
	}

}
