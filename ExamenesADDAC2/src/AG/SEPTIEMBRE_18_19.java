package AG;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEPTIEMBRE_18_19 {
	
	// 1. Tipo cromosoma:
	/*
	 * No es binario pq hay multiseleccion y no es de permutacion pq no importa el orden.
	 * El mejor cromosoma es de rango pq permite mapear una configuracion a cada miembro
	 * permitiendo la multiselección. 
	*/
	
	// 2. Implementación
	public class ProblemaPC implements ValuesInRangeProblemAG<E,S> {
		
		// variable number o cells number
		public Integer getVariableNumber() {
			
			return ProblemaPCs.necesidades.size();
			
		}
		
		// get Max y Min
		public Integer getMax(Integer i) {
			
			return ProblemaPCs.configuraciones.size();
			
		}
		
		public Integer getMin(Integer i) {
			
			return 0;
			
		}
		
		// fitness: minimizar el coste total
		public Double fitness(ValuesInRangeChromosome<E> cr) {
			
			List<Integer> cromosomas = cr.decode();
			
			return recompensa(cromosomas) - penalizacion(cromosomas);
			
		}
		
		public Double recompensa(List<Integer> cromosomas) {
			
			// Menor coste:
			Double precio = 0.0;
			for(int i = 0; i < cromosomas.size(); i++) {
				
				precio += ProblemaPCs.configuraciones.get(cromosomas.get(i)).precio;
				
			}
			
			// Para MINIMIZAR:
			return -precio;
			
		}
		
		public Double penalizacion(List<Integer> cromosomas) {
			
			// Cumplir todas las necesidades: Procesador, RAM y Disco:
			Double castigo = 0.0;
			
			for(int i = 0; i < cromosomas.size(); i++) {
				
				if(ProblemaPCs.necesidades.get(i).proc < ProblemaPCs.configuraciones.get(cromosomas.get(i)).proc) {
					
					castigo++;
					
				} else if (ProblemaPCs.necesidades.get(i).ram < ProblemaPCs.configuraciones.get(cromosomas.get(i)).ram) {
					
					castigo++;
					
				} else if (ProblemaPCs.necesidades.get(i).disco < ProblemaPCs.configuraciones.get(cromosomas.get(i)).disco) {
					
					castigo++;
					
				} else if (ProblemaPCs.configuraciones.get(cromosomas.get(i)).dispo == 0) {
					
					castigo++;
					
				}
				
			}
			
			return castigo * 100000;
				
		}
		
		// solucion
		public Map<Integer,String> getSolucion(ValuesInRangeChromosome<E> cr) {
			
			List<Integer> cromosomas = cr.decode();
			Map<Integer,Strig> mapa = new HashMap<>();
			
			for(int i = 0; i < cromosomas.size(); i++) {
				
				// Clave: usuario, valor: configuracion asociada:
				mapa.put(i, ProblemaPCs.configuraciones.get(cromosomas.get(i)).config);
				
			}
			
			return mapa;
			
		}
	}

}
