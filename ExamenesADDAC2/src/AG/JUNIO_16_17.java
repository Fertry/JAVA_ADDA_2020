package AG;

import java.util.ArrayList;
import java.util.List;

public class JUNIO_16_17 {
	
	// 1. Tipo de cromosomas:
	/*
	 * Binario, ya que consiste en seleccionar si se escoge o no (1 o 0) una actividad. 
	*/

	// 2. Definir y explicar la funcion fitness
	/*
	 * La funcion fitness debe maximizar la valoración de las actividades escogidas
	 * (que serán los cromosomas del problema), penalizando cuando se sobrepase del 
	 * presupuesto, además, se penalizará cuando se seleccionen dos actividades que
	 * sean incompatibles.
	 * 
	 * La solución será una lista de elementos binarios, cuyo indice representa la 
	 * actividad, y el valor indica si se selecciona (1) o no (0).
	 */
	
	// 3. Implementacion
	public class ProblemaFiestaAG implements IChromosome<T> {
		
		public Double fitness(ValuesInRangeChromosome<E> cr) {
			
			List<Integer> cromosomas = cr.decode();
			
			return recompensa(cromosomas) - penalizacion(cromosomas);
			
		}
		
		public Double recompensa(List<Integer> cromosomas) {
			
			// Maximizar la valoracion de las actividades:
			Double valor = 0.0;
			for(int i = 0; i < cromosomas.size(); i++) {
				if(cromosomas.get(i) == 1) {
					valor += ProblemaFiesta.getActividad(i).getValoracion();
				}
				
			}
			
			return valor;
			
		}
		
		public Double penalizacion(List<Integer> cromosomas) {
			
			// No se puede pasar del presupuesto:
			Double castigo = 0.0;
			Double coste = 0.0;
			List<Actividad> actividades = new ArrayList<>();
			for(int i = 0; i < cromosomas.size(); i++) {
				if(cromosomas.get(i) == 1) {
					coste += ProblemaFiesta.getActividad(i).getCoste();
					actividades.add(ProblemaFiesta.getActividad(i));
				}
				
			}
			
			if(coste > ProblemaFiesta.getPresupuestoTotal()) {
				
				castigo += 1.0;
				
			}
			
			// No se pueden tener actividades incompatibles:
			for(Par<Actividad,Actividad> par : ProblemaFiesta.restricciones) {
				
				if (actividades.contains(par.p1) && actividades.contains(par.p2)) {
					
					castigo += 1.0;
					
				}
			}
			
			return castigo * 120000;
			
		}
		
		public List<Actividad> getSolucion(ValuesInRangeChromosome<E> cr) {
			
			List<Integer> cromosomas = cr.decode();
			
			// Lista de actividades seleccionadas:
			List<Actividad> actividades = new ArrayList<>();
			
			for (int i = 0; i < cromosomas.size(); i++) {
				
				if(crosomoma == 1) {
					
					actividades.add(ProblemaFiesta.getActividad(i));
					
				}
				
			}
			
			return actividades;

		}

	}
	
}
