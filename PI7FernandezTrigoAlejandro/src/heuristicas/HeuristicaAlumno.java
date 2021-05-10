package heuristicas;

import java.util.function.Predicate;

import ejercicio1.Ejercicio1;
import vertices.VerticeAlumno;

public class HeuristicaAlumno {
	
	public static Double heuristica(VerticeAlumno origen, Predicate<VerticeAlumno> goal, VerticeAlumno destino) {
		
		Double resultado = 0.0;
		Integer max = 0;
		for (int i = origen.getIndice(); i < Ejercicio1.getNAlumnos(); i++) {
			for (int j = 0; j < Ejercicio1.getNGrupos(); j++) {
				if (origen.getPlazasRestantes().get(j) > 0) {
					if (Ejercicio1.getAfinidadPorIndice(i, j) > max) {
						max = Ejercicio1.getAfinidadPorIndice(i, j);
					}
				}
			}
			resultado += max;
			max = 0;
		}
		return resultado;
	}

}
