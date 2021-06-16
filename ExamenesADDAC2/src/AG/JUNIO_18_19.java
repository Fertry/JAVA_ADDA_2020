package AG;

import java.util.List;

public class JUNIO_18_19 {
	
	// a. Tipo de cromosoma:
	/*
	 * Cromosomas tipo rango (range) porque la solución es mapeada
	 * (indica que libro va a que estante). 
	*/
	
	// b. ProblemaLibrosAG
	
	// Variable numbers
	public static Integer getVariableNumber() {
		
		return ProblemaLibros.numLibros;
	
	}
	
	// Max
	public static Integer getMaximo(Integer E) {
		
		// Nº de estantes
		return ProblemaLibros.numEstantes;
		
	}
	
	// Min
	public static Integer getMinimo(Integer E) {
		
		return 0;
		
	}
	
	// Fitness
	/*
	 * Maximizar el nº de libros colocados en los estantes:
	 */
	public static Double fitnessFunction(ValuesInRangeChromosome<E> cr) {

		List<Integer> cromosomas = cr.decode();
		
		return recompensa(cromosomas) - penalizacion(cromosomas);
		
	}
	
	public static Double recompensa(List<Integer> cromosomas) {
		
		// Nº de libros ubicados: si es -1, se ha pasado de índice
		Double contador = 0.0;
		
		for (Integer cromosoma : cromosomas) {
			
			if (cromosoma != -1) {
				
				contador += 1.0;
				
			}
			
		}
		
		return contador;
		
	}
	
	public static Double penalizacion(List<Integer> cromosomas) {
		
		Double castigo = 0.0;
		
		// Si la altura del libro supera la del estante
		for (Integer cromosoma : cromosomas) {
			
			if (cromosoma != -1) {
				
				// Si el libro supera la altura:
				if (ProblemaLibros.getLibro(cromosoma).getAltura() > ProblemaLibros.getEstante(????)) {
					
					castigo += 1.0;
					
				}
				
			}
			
		}
		
		// Si el ancho del libro supera el espacio del estante
		for (Integer cromosoma : cromosomas) {
			
			if (cromosoma != -1) {
				
				// Si el libro supera la anchura:
				if (ProblemaLibros.getLibro(cromosoma).getAnchura() > ProblemaLibros.anchuraEstanteria) {
					
					castigo += 1.0;
					
				}
				
			}
			
		}
		
		return castigo * 200000;
		
	}
	
}
