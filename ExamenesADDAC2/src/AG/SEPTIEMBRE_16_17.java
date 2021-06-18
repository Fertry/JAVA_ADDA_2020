package AG;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEPTIEMBRE_16_17 {
	
	// 1. Tipo cromosoma

	// 2. Definir (explicar) la función fitness
	
	// 3. Implementación:
	
	public class ProblemaProyectoAG implements IChromosome<T> {
		
		List<Persona> personas;
		List<Proyecto> proyectos;
		
		public Double fitnessFunction() {
			
			List<Integer> cromosomas = cr.decode();
			
			// Para MINIMIZAR:
			return -penalizacion(cromosomas); 
			
		}
		
		public Double penalizacion(List<Integer> cromosomas) {
			
			// Minimizar el nº de repartos incompatibles:
			Double incompatibilidades = 0.0;
			for(int i = 0; i < cromosomas.size(); i++) {
				
				if (!ProblemaProyectosAG.proyectos.get(i).getRequisitos().containsAll(ProblemaProyectosAG.personas.get(cromosomas.get(i)).getRequisitos())) {
					
					incompatibilidades++;
					
				}
					
			}
			
			return incompatibilidades;
			
		}
		
		public Map<Persona,Proyecto> getSolucion() {
			
			List<Integer> cromosomas = cr.decode();
			Map<Persona,Proyecto> mapa = new HashMap<>();
			
			for(int i = 0; i < cromosomas.size(); i++) {
				
				// El cromosoma es [4,5,6,2,1] donde las posiciones son proyectos
				// y los valores las personas:
				mapa.put(ProblemaProyectoAG.personas.get(i), ProblemaProyectoAG.proyectos.get(cromosomas.get(i)));
				
			}
			
			return mapa;
			
		}
		
	}

}
