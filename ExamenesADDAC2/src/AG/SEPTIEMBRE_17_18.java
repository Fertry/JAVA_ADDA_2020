package AG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SEPTIEMBRE_17_18 {
	
	// 1.
	
	// Tipo de cromosoma:
	/*
	 * Cromosoma binario ya que los paquetes solo pueden comprarse una vez, no hay
	 * repetición; se trata de elegir que paquetes se compran y cuales no  (0 o 1).
	 */
	
	// Características del cromosoma (decodificado):
	/*
	 * [010101011] lista binaria, donde la posicion indica el paquete, el tamaño es
	 * el nº de paquetes, y el valor indica si se compra (1) o no (0).
	 */
	
	// Características de la fitness (que hace):
	/*
	 * La fitness tiene que minimizar el coste total de la compra; penalizará repetir
	 * piezas y no cubrir las necesidades requeridas. 
	 */
	
	// Características de la solución: 
	/*
	 * List<PaqueteDePiezas> que será una lista de objetos que representan los paquetes
	 * comprados al final.
	 */

	// 2. Implementación:
	
	public class ProblemaPiezasRobot implements ValuesInRangeProblemAG<E,S> {
		
		public Integer getVariableNumber() {
			
			return paquetesDisponibles.size();
			
		}
		
		public Integer getMax(Integer i) {
			
			return 1;
			
		}
		
		public Integer getMin(Integer i) {
			
			return 0;
			
		}
		
		public Double fitnessFunction(ValuesInRangeChromosome<Integer> cr) {
			
			List<Integer> cromosomas = cr.decode();
			
			return recompensa(cromosomas) - penalizacion(cromosomas);

		}
		
		public Double recompensa(List<Integer> cromosomas) {
			
			// Menor coste:
			Double precio = 0.0;
			for(int i = 0; i < cromosomas.size(); i++) {
				
				if (cromosomas.get(i) == 1) {
					
					precio += ProblemaPiezasRobot.paquetesDisponibles.get(i).getCoste();
					
				}
			}
			
			// Para MINIMIZAR:
			return -precio;
			
		}
		
		public Double penalizacion(List<Integer> cromosomas) {
			
			Double castigo = 0.0;
			Set<Pieza> seleccionados = new HashSet<>();
			for(int i = 0; i < cromosomas.size(); i++) {
				
				if (cromosomas.get(i) == 1) {
					
					seleccionados.addAll(ProblemaPiezasRobot.paquetesDisponibles.get(i).getPiezas());

				}
				
			}
			
			// Si no se cubren las necesidades:
			if(!ProblemaPiezasRobot.piezasNecesarias.containsAll(seleccionados)) {
				
				castigo++;
				
			}
			
			return castigo * 100000;
				
		}
		
		public List<PaqueteDePiezas>getSolucion(ValuesInRangeChromosome<Integer> cr) {
			
			List<Integer> cromosomas = cr.decode();
			List<PaqueteDePiezas> res = new ArrayList<>();
			
			for(int i = 0; i < cromosomas.size(); i++) {
				
				if(cromosomas.get(i) == 1) {
					
					// Lista con los paquetes seleccionados:
					res.add(ProblemaPiezasRobot.paquetesDisponibles.get(i));
					
				}
				
			}
			
			return res;
		
		}
		
	}
		
}
