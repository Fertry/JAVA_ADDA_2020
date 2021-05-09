/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.jgrapht.GraphPath;

import aristas.AristaAlumno;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeAlumno;

/*
	Una academia de inglés tiene n alumnos a ser repartidos en m grupos (n múltiplo
	de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
	afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
	rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
	todos los grupos deben tener el mismo número de alumnos, maximizando la
	afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no está
	permitido asignar un alumno a un grupo para el que presente afinidad 0.
	
	Solución por A*.
*/

public class Ejercicio1A {
	
	public static class AStarAlumno implements Comparable<AStarAlumno> {
		
		// PROPIEDADES DE LA CLASE
		VerticeAlumno vertice = null;
		Integer accion = null;
		VerticeAlumno verticeFinal = null;
		Double distanciaOrigen = null;
		Double distanciaFinal = null;
		
		// MÉTODOS DE LA CLASE
		public VerticeAlumno vertice() {
			
			return vertice;
			
		}
		
		public Integer accion() {
			
			return accion;
			
		}
		
		public VerticeAlumno verticeFinal() {
			
			return verticeFinal;
			
		}
		
		public Double distanciaOrigen() {
			
			return distanciaOrigen;
			
		}
		
		public Double distanciaFinal() {
			
			return distanciaFinal;
			
		}
		
		public static AStarAlumno of(VerticeAlumno vertice, Integer accion, VerticeAlumno verticeFinal, Double distanciaOrigen, Double distanciaFinal) {
			
			return new AStarAlumno(vertice, accion, verticeFinal, distanciaOrigen, distanciaFinal);
			
		}
		
		public AStarAlumno(VerticeAlumno vertice, Integer accion, VerticeAlumno verticeFinal, Double distanciaOrigen, Double distanciaFinal) {
			
			super();
			this.vertice = vertice;
			this.accion = accion; 
			this.verticeFinal = verticeFinal;
			this.distanciaOrigen = distanciaOrigen;
			this.distanciaFinal = distanciaFinal;
			
		}

		@Override
		public int compareTo(AStarAlumno alumno) {

			return this.distanciaFinal().compareTo(alumno.distanciaFinal);
			
		}

		@Override
		public int hashCode() {
			
			final int prime = 31;
			int result = 1;
			result = prime * result + ((accion == null) ? 0 : accion.hashCode());
			result = prime * result + ((distanciaFinal == null) ? 0 : distanciaFinal.hashCode());
			result = prime * result + ((distanciaOrigen == null) ? 0 : distanciaOrigen.hashCode());
			result = prime * result + ((vertice == null) ? 0 : vertice.hashCode());
			result = prime * result + ((verticeFinal == null) ? 0 : verticeFinal.hashCode());
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
			AStarAlumno other = (AStarAlumno) obj;
			if (accion == null) {
				if (other.accion != null)
					return false;
			} else if (!accion.equals(other.accion))
				return false;
			if (distanciaFinal == null) {
				if (other.distanciaFinal != null)
					return false;
			} else if (!distanciaFinal.equals(other.distanciaFinal))
				return false;
			if (distanciaOrigen == null) {
				if (other.distanciaOrigen != null)
					return false;
			} else if (!distanciaOrigen.equals(other.distanciaOrigen))
				return false;
			if (vertice == null) {
				if (other.vertice != null)
					return false;
			} else if (!vertice.equals(other.vertice))
				return false;
			if (verticeFinal == null) {
				if (other.verticeFinal != null)
					return false;
			} else if (!verticeFinal.equals(other.verticeFinal))
				return false;
			return true;
			
		}
		
	}
	
	// PROPIEDADES DE LA CLASE
	public VerticeAlumno inicio;
	public Map<VerticeAlumno, AStarAlumno> arbol;
	public PriorityQueue<AStarAlumno> heap;
	public Boolean objetivo;
	
	
	// MÉTODOS DE LA CLASE
	
	public static Ejercicio1A of(VerticeAlumno inicio) {
		
		return new Ejercicio1A(inicio);
		
	}
	
	// CONSTRUCTOR DE LA CLASE
	
	private Ejercicio1A(VerticeAlumno inicio) {
		
		super();
		this.inicio = inicio;
		
		AStarAlumno alumno = AStarAlumno.of(inicio, null, null, 0.0, Heuristica.heuristica(inicio));
		this.arbol = new HashMap<>();
		this.arbol.put(inicio, alumno);
		this.heap = new PriorityQueue<>();
		this.heap.add(alumno);
		this.objetivo = false;
		
	}
	
	private List<Integer> acciones(VerticeAlumno v) {
		List<Integer> ls = new ArrayList<>();
		Integer a = this.arbol.get(v).a();
		while (a != null) {
			ls.add(a);
			v = this.arbol.get(v).verticeFinal();
			a = this.arbol.get(v).a();
		}
		Collections.reverse(ls);
		return ls;
	}


	public List<Integer> search() {
		VerticeAlumno vertexActual = null;
		while (!heap.isEmpty() && !objetivo) {
			AStarAlumno dataActual = heap.poll();
			vertexActual = dataActual.vertice();
			for (Integer a : vertexActual.actions()) {
				VerticeAlumno v = vertexActual.neighbor(a);
				Double newDistance = dataActual.distanciaOrigen()-a*Ejercicio1.()(vertexActual.getIndice());
				Double newDistanceToEnd = newDistance - Heuristica.heuristica(v);				
				if (!arbol.containsKey(v)) {	
					AStarAlumno ac = AStarAlumno.of(v, a, vertexActual, newDistance, newDistanceToEnd);
					heap.add(ac);
					arbol.put(v, ac);	
				}else if (newDistance < arbol.get(v).distanciaOrigen()) {
					heap.remove(arbol.get(v));
					AStarAlumno ac = AStarAlumno.of(v, a, vertexActual, newDistance, newDistanceToEnd);
					heap.add(ac);
					arbol.put(v, ac);
				}
			}
			this.objetivo = vertexActual.getIndice() == Ejercicio1.getReparto();
		}
		return acciones(vertexActual);
	}
	
	public SolucionMochila solucion(List<Integer> acciones) {
		return SolucionMochila.of(inicio,acciones);
	}
	
	
	
	
	
//	public static void EjecutaEjercicio1A(String fichero) {
//		
//		// Inicializar las variables de la clase Ejercicio1
//		Ejercicio1.iniDatos(fichero);
//		
//		// Inicializar los vértices inicio y final:
//		VerticeAlumno destino = VerticeAlumno.lastVertex();
//		VerticeAlumno inicio = VerticeAlumno.initialVertex();
//		
//		// Modelar el problema cómo un grafo virtual:
//		EGraph<VerticeAlumno, AristaAlumno> grafo = Graphs2.simpleVirtualGraph(inicio, x -> -x.getEdgeWeight());
//		
//		// DEBUG
//		System.out.println("Grafo: " + grafo);
//		
//		// Invocar al algoritmo de resolución de A*
//		AStar<VerticeAlumno, AristaAlumno> objeto = GraphAlg.aStarEnd(grafo, destino, VerticeAlumno::heuristica);
//		
//		// Obtener los caminos (vertices
//		GraphPath<VerticeAlumno, AristaAlumno> caminos = objeto.search().get();
//		
//		// DEBUG
//		List<VerticeAlumno> vertices = caminos.getVertexList();
//		for (VerticeAlumno vertice : vertices) {
//			
//			System.out.println("Vertice: " + vertice);
//			
//		}
//		
//	}



}
