package AG;

import java.util.ArrayList;
import java.util.List;

public class DICIEMBRE_18_19 {

	// a. Tipo cromosoma: binario --> el problema se decide seleccionando, o no, desde 
	// una lista de canciones. 
	
	// b. Implementar ProblemaListaReproduccionAG
	
	public class ProblemaListaReproduccionAG implements ValuesInRangeProblemAG<E,S> {
		
		// variable number o cells numbers:
		public static Integer getCellsNumbers() {
			
			return ProblemaListaReproduccion.todasLasCanciones.size();
			
		}
		
		// max y min
		public static Integer getMax(Integer E) {
			
			return ProblemaListaReproduccion.presupuesto;
			
		}
		
		public static Integer getMin(Integer E) {
			
			return 0;
			
		}
		
		// fitness: maximizar la duración:
		public static Double fitnessFunction(ValuesInRangeChromosome<E> cr) {
			
			List<Integer> cromosomas = cr.decode();
			
			return recompensa(cromosomas) - penalizacion(cromosomas);
			
		}
		
		public static Double recompensa(List<Integer> cromosomas) {
			
			// Devolver el tiempo total de la playlist:
			Double sum = 0.0;
			for(int i = 0;i<cromosomas.size();i++) {
				if(cromosomas.get(i) == 1) {
					
					sum += ProblemaListaReproduccion.todasLasCanciones.get(i).getDuracion();
					
				}
				
			}
			
			return sum;
		}
		
		public static Double penalizacion(List<Integer> cromosomas) {
			
			// No pasarse del presupuesto:
			Double coste = 0.0;
			Double afinidadTotal = 0.0;
			Integer numeroCanciones = 0;
			for(int i = 0;i<cromosomas.size();i++) {
				if(cromosomas.get(i) == 1) {
					
					coste += (double) ProblemaListaReproduccion.todasLasCanciones.get(i).getCoste();
					afinidadTotal += (double) ProblemaListaReproduccion.todasLasCanciones.get(i).getAfinidad();
					numeroCanciones++;
					
				}
				
			}
			
			Double castigo = 0.0;
			if(coste > ProblemaListaReproduccion.presupuesto) {
				
				castigo++;
				
			}
			
			// La afinidad media debe ser superior al umbral:
			Double afinidadMedia = afinidadTotal / numeroCanciones;
			if(afinidadMedia < ProblemaListaReproduccion.umbralAfinidad) {
				
				castigo++;
				
			}
		
			return castigo * 10000;
			
		}
		
		// solucion
		public static List<Cancion> getSolucion(ValuesInRangeChromosome<E> cr) {
			
			List<Cancion> cromosomas = cr.decode();
			List<Cancion> resultado = new ArrayList<>();
			
			for(int i = 0;i<cromosomas.size();i++) {
				if(cromosomas.get(i) == 1) {
					
					resultado.add(ProblemaListaReproduccion.todasLasCanciones.get(i));
					
				}
				
			}
			
			return resultado;
			
		}
		
	}
	
}
