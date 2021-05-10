package heuristicas;

import java.util.function.Predicate;

import ejercicio1.Ejercicio1;
import us.lsi.mochila.datos.DatosMochila;
import vertices.VerticeAlumno;

public class HeuristicaAlumno {
	
	public static Double heuristic_negate(VerticeAlumno v1, Predicate<VerticeAlumno> goal, VerticeAlumno v2) {
		return -heuristic(v1.getIndice(), v1.getPlazasRestantes().size(), v2.getIndice());
	}
	
	public static Double heuristic(VerticeAlumno v1, Predicate<VerticeAlumno> goal, VerticeAlumno v2) {
		return heuristic(v1.getIndice(), v1.getPlazasRestantes().size(), v2.getIndice());
	}

	public static Double heuristic(int index, Integer capacidadRestante, int lastIndex) {
		Double r = 0.;
		
		while (capacidadRestante> 0 && index < lastIndex) {
//			Double a = (double) Math.max(capacidadRestante / Ejercicio1.getPeso(index), DatosMochila.getNumMaxDeUnidades(index));
//			r = r + a * Ejercicio1.getValor(index);
//			capacidadRestante = (int) (capacidadRestante - a * Ejercicio1.getPeso(index));
			index = index + 1;
		}
		return r;
	}	

}
