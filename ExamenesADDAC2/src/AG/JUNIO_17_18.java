package AG;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JUNIO_17_18 {
	
	// a. Tipo cromosoma:
	/*
	 * Tipo rango porque se puede seleccionar una solución múltiples veces, el tipo
	 * rango da una solución mapeada de acorde a lo que se pide.
	 */
	
	// b. Como seria la estructura de la solucion o que recibe
	/*
	 * Map<Integer,Integer> que representa el dia y el nº de correos 
	*/
	
	// c. Implementar ProblemaRedSocialAG
	public class ProblemaRedSocialAG implements ValuesInRangePrblemAG<E,S> {
			
		// Variable number (o cells number)
		public static Integer getVariableNumber() {
			
			return DiaSemana.values().length();
			
		}
		
		// getMax
		public static Integer getMax(Integer E) {
			
			return ProblemaRedSocial.maxPorDia;
			
		}
		
		// getMin
		public static Integer getMin(Integer E) {
			
			return 0;
			
		}
		
		// fitness: maximizar el nº de visitas semanales
		public static Double fitnessFunction(ValuesInRangeChromosome<E> cr) {
			
			List<Integer> cromosomas = cr.decode();
			
			return recompensa(cromosomas) - penalizacion(cromosomas);
			
		}
		
		public static Double recompensa(List<Integer> cromosomas) {
			
			// Visitas por semana:
			Integer contador = 0;
			for(int i = 0;i<7;i++) {
				
				contador += ProblemaRedSocial.getVisitasPromedio(cromosomas.get(i),DiaSemana.values()[i]);
				
			}
			
			return (double) contador;
			
		}
		
		public static Double penalizacion(List<Integer> cromosomas) {
	
			// Cuantos correos llevamos enviados:
			Integer contador = 0;
			for(int i = 0;i<7;i++) {
				
				// Acumulado de correos enviados:
				contador += cromosomas.get(i);
				
			}
			
			// Pasarse del limite por semana:
			if (contador < ProblemaRedSocial.maxPorSemana) {
				
				return 0.0;
				
			} else {
				
				// De pasarse del limite, restarselo
				return (double) (contador - ProblemaRedSocial.maxPorSemana) * 200000;
				
			}
				
		}
		
		// getSolucion
		public static Map<Integer,Integer> getSolucion(ValuesInRangeChromosome<E> cr) {
			
			List<Integer> cromosomas = cr.decode();
			Map<Integer,Integer> resultado = new HashMap<Integer,Integer>();
			
			for(int i = 0;i<7;i++) {
				
				// Construir el mapa resultado cuyas claves son el dia y valores el nº de correos
				resultado.put(DiaSemana.values()[i], cromosomas.get(i));
				
			}
			
			return resultado;
			
		}
	
	}

}
