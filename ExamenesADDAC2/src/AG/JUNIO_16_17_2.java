package AG;

import java.util.List;

public class JUNIO_16_17_2 {
	
	// 1. Tipo cromosoma: Permutación, dado que el orden es relevante para el problema.
	
	// 2. [1,4,0,3,2] donde los nº son los productos y su orden es el orden en que se consumen.
	
	// 3. Explicar y definir la funcion fitness:
	
	// 4. Implementar los métodos:
	
	public class Patata implements Brocoli<> {
		
		public Integer getObjectsNumber() {
			
			return ProblemaMeCaduda.AL.size();
			
		}
		
		public Integer getMax(int index) {
			
			//return ProblemaMeCaduda.AL.get(index).dC;
			return 1;
			
		}
		
		public Double fitnessFunction(IndexChromosome<E> cr) {
			
			List<Integer> cromosomas = cr.decode();
			
			return recompensa(cromosomas) - penalizacion(cromosomas);
			
		}
		
		public Double recompensa(List<Integer> cromosomas) {
			
			// Maximizar la suma de los cuadrados de los días que le quedan para caducar a cada
			// producto al ser consumidos:
			Double sum = 0.0;
			for(int i = 0; i<cromosomas.size(); i++) {
				
				sum += Math.pow((ProblemaMeCaduca.AL.get(cromosomas.get(i)).dC - i), 2);

			}
			
			return sum;
			
		}
		
		public Double penalizacion(List<Integer> cromosomas) {
			
			// SOLO pueden ser consumidos antes de su fecha de caducidad:
			Double castigo = 0.0;
			for(int i = 0; i<cromosomas.size(); i++) {
				 
				if(ProblemaMeCaduca.AL.get(cromosomas.get(i)).dC < i) {
				// if(ProblemaMeCaduca.AL.get(i).dC - i < 0) {
					//castigo += Math.abs(ProblemaMeCaduca.AL.get(i).dC - i);
					castigo++;
				}
			}
			
			// NO pueden consumirse consecutivamente alimentos del mismo tipo:
			for(int i = 0; i<cromosomas.size()-1; i++) {
				
				if(ProblemaMeCaduca.AL.get(cromosomas.get(i)).tipo == ProblemaMeCaduca.AL.get(cromosomas.get(i+1)).tipo) {
					
					castigo++;
					
				}
			}
			
			return castigo * 1000000000000;
			
		}
		
	}

}
