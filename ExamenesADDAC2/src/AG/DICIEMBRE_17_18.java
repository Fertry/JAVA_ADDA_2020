package AG;

import java.util.List;

public class DICIEMBRE_17_18 {
	
	public class ProblemaTransporte implements ProblemaTransporteAG<> {
		
		/*
		 * Tipo rango pq toma valores en un rango [0,1].
		 */
		
		// variable numbers o cells numbers
		public static Integer getVariableNumber() {
			
			return ProblemaTransporteAG.pesos.size();
			
		}
		
		// fitness function
		public static Double fitnessFunction(ValuesInRangeChromosome<E> cr) {
			
			List<Integer> cromosomas = cr.decode();
			
			// NO se puede superar 3*n/4 objetos en el mismo brazo:
			Double castigo = 0.0;
			Integer n = ProblemaTransporteAG.pesos.size();
			if(SolucionTransporte.objetosBrazoIzquierdo.size() > (3*n)/4) {
				castigo++;
			} 
			
			if(SolucionTransporte.objetosBrazoDerecho.size() > (3*n)/4) {
				castigo++;
			} 
			
			// Cada objeto debe estar en un único brazo:
			if(SolucionTransporte.objetosBrazoIzquierdo.containsAny(SolucionTransporte.objetosBrazoDerecho)) {
				castigo++;
			}
			
			// NO tiene recompensa: en su lugar se devuelve la menor penalizacion posible!!!!
			return -castigo;
			
		}
		
		// solucion
		public static SolucionTransporte getSolucion(ValuesInRangeChromosome<E> cr) {
			
			List<Integer> cromosomas = cr.decode();
			
		}
		
	}

}
