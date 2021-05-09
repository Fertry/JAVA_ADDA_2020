/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package heuristicas;

import vertices.VerticeAlumno;

public class HeuristicaAlumno {
	
	private static class HAlumno {
		
		private Integer indice = null;
		private Double capacidadRestante = null;
		
		public static HAlumno of(Integer indice, Double capacidadRestante) {
			
			return new HAlumno(indice, capacidadRestante);
			
		}
		
		public HAlumno(Integer indice, Double capacidadRestante) {
			
			super();
			this.indice = indice;
			this.capacidadRestante = capacidadRestante;
			
		}
		
		public Double heuristicAction() {
			
			return null;
			
		}
		
		public HAlumno vecino(Double accion) {
			
			return null;
			
		}
		
		public Integer indice() {
			
			return indice;
			
		}
		
		public Double capacidadRestante() {
			
			return capacidadRestante;
			
		}

		@Override
		public int hashCode() {
			
			final int prime = 31;
			int result = 1;
			result = prime * result + ((capacidadRestante == null) ? 0 : capacidadRestante.hashCode());
			result = prime * result + ((indice == null) ? 0 : indice.hashCode());
			return result;
			
		}

		@Override
		public boolean equals(Object obj) {
			
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			HAlumno other = (HAlumno) obj;
			if (capacidadRestante == null) {
				if (other.capacidadRestante != null)
					return false;
			} else if (!capacidadRestante.equals(other.capacidadRestante))
				return false;
			if (indice == null) {
				if (other.indice != null)
					return false;
			} else if (!indice.equals(other.indice))
				return false;
			return true;
			
		}
		
	}
	
	public static Integer voraz(VerticeAlumno vertice) {
		
		VerticeAlumno v = v1;
		Integer r = 0;
		while (v.capacidadRestante() > 0 && v.indice() < Ejercicio1.n) {
			Integer a = v.greedyAction();
			r = r + a * Ejercicio1.getValor(v.indice());
			v = v.vecino(a);
		}
		return r;
		
	}
	
	public static SolucionAlumno solucionVoraz(MochilaProblem v1) {
		SolucionAlumno r = SolucionAlumno.empty();
		VerticeAlumno v = v1;
		while (v.capacidadRestante() > 0 && v.indice() < Ejercicio1.n) {
			Integer a = v.greedyAction();
			r.add(Ejercicio1.getObjeto(v.indice()), a);
			v = VerticeAlumno.of(v.indice() + 1, v.capacidadRestante() - a * Ejercicio1.getPeso(v.indice()));
		}
		return r;
	}
	
	public static Double heuristica(MochilaProblem v1) {
		HMochila v = HMochila.of(v1.index(),v1.capacidadRestante().doubleValue());
		Double r = 0.;
		while (v.capacidadRestante() > 0 && v.index() < DatosMochila.n) {
			Double a = v.heuristicAction();
			r = r + a * DatosMochila.getValor(v.index());
			v = v.vecino(a);
		}
		return r;
	}
	
	public static Integer heuristica2(MochilaProblem v1) {
		MochilaProblem v = v1;
		Integer r = 0;
		while (v.capacidadRestante() > 0 && v.index() < DatosMochila.n) {
			Integer a = v.greedyAction()+1;
			r = r + a * DatosMochila.getValor(v.index());
			Integer cr = v.capacidadRestante() - a * DatosMochila.getPeso(v.index());
			v = MochilaProblem.of(v.index() + 1, cr>=0?cr:0);
		}
		return r;
	}
	
	
	public static Double cota(MochilaProblem v1, Integer a) {
		MochilaProblem v2 = v1.vecino(a);
		return a*DatosMochila.getValor(v1.index()).doubleValue()+heuristica(v2);
	}
	
	public static Double cota2(MochilaProblem v1, Integer a) {
		MochilaProblem v2 = v1.vecino(a);
		return a*DatosMochila.getValor(v1.index()).doubleValue()+heuristica2(v2);
	}

}
