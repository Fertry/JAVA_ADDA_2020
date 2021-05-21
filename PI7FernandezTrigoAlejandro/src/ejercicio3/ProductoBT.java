/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import heuristicas.HeuristicaProducto;
import us.lsi.common.Lists2;
import vertices.VerticeProducto;

/*
 * Objeto único que recorre los vértices del grafo virtual. Guarda la información del vértice, el valor acumulado de la 
 * función objetivo así cómo la lista de acciones tomadas. 
*/

public class ProductoBT {
	
	// Clase de "Estado" que representa el estado puntual del grafo virtual:
	public static class EstadoProducto {
		
		// MÉTODOS DE LA CLASE
		public static EstadoProducto inicial(VerticeProducto vertice) {
			
			List<VerticeProducto> vertices = Lists2.of(vertice);
			
			return new EstadoProducto(vertice, 0.0, new ArrayList<Integer>(), vertices);
			
		}
		
		public static EstadoProducto of(VerticeProducto vertice, Double valorAcumulado, List<Integer> acciones, List<VerticeProducto> vertices) {
			
			return new EstadoProducto(vertice, valorAcumulado, acciones, vertices);
			
		}
		
		// ATRIBUTOS DE LA CLASE
		private Double valorAcumulado;
		private List<Integer> acciones;
		private VerticeProducto vertice;
		private List<VerticeProducto> vertices;
		
		// CONSTRUCTORES DE LA CLASE
		private EstadoProducto(VerticeProducto vertice, Double valorAcumulado, List<Integer> acciones, List<VerticeProducto> vertices) {
			
			super();
			
			this.vertice = vertice;
			this.acciones = acciones;
			this.vertices = vertices;
			this.valorAcumulado = valorAcumulado;
			
		}
		
		// GETTERS DE LA CLASE
		
		// Devuelve el vértice:
		public VerticeProducto getVertice() {
			
			return vertice;
			
		}
		
		// Devuelve la lista de vértices: 
		public List<VerticeProducto> getVertices() {
			
			return vertices;
			
		}
		
		// Devuelve el valor acumulado:
		public Double getValorAcumulado() {
			
			return valorAcumulado;
			
		}
		
		// Devuelve la lista de acciones:
		public List<Integer> getAcciones() {
			
			return acciones;
			
		}
		
		// Devuelve el índice del vértice en cuestión dado que
		// este representa el nº del producto seleccionado:
		public Integer solucion() {
			
			return vertice.getIndice();
			
		}
		
		// MÉTODOS PARA TRABAJAR CON BACKTRACKING
		
		// Método para avanzar en el grafo virtual:
		EstadoProducto avanza(Integer accion) {
			
			List<Integer> as = List2addLast(acciones, accion);
			VerticeProducto vcn = vertice.neighbor(accion);
			List<VerticeProducto> vt = List2addLast(vertices, vcn);
			return EstadoProducto.of(vcn, valorAcumulado + (accion * Ejercicio3.getPrecio(vertice.getIndice())), as, vt);
			
		}
		
		// Método para retroceder en el grafo virtual:
		EstadoProducto retrocede(Integer accion) {
			
			List<Integer> as = List2removeLast(acciones);
			List<VerticeProducto> vt = List2removeLast(vertices);
			VerticeProducto van = List2last(vt);
			return EstadoProducto.of(van, this.getValorAcumulado() - (accion * Ejercicio3.getPrecio(van.getIndice())), as, vt);
			
		}
		
		// HASHCODE Y EQUALS EN BASE A TODAS LAS PROPIEDADES DE LA CLASE

		@Override
		public int hashCode() {
			
			final int prime = 31;
			int result = 1;
			result = prime * result + ((acciones == null) ? 0 : acciones.hashCode());
			result = prime * result + ((valorAcumulado == null) ? 0 : valorAcumulado.hashCode());
			result = prime * result + ((vertice == null) ? 0 : vertice.hashCode());
			result = prime * result + ((vertices == null) ? 0 : vertices.hashCode());
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
			EstadoProducto other = (EstadoProducto) obj;
			if (acciones == null) {
				if (other.acciones != null)
					return false;
			} else if (!acciones.equals(other.acciones))
				return false;
			if (valorAcumulado == null) {
				if (other.valorAcumulado != null)
					return false;
			} else if (!valorAcumulado.equals(other.valorAcumulado))
				return false;
			if (vertice == null) {
				if (other.vertice != null)
					return false;
			} else if (!vertice.equals(other.vertice))
				return false;
			if (vertices == null) {
				if (other.vertices != null)
					return false;
			} else if (!vertices.equals(other.vertices))
				return false;
			return true;
			
		}
		
		// TO_STRING DE LA CLASE (Sólo para debug)
		@Override
		public String toString() {
			
			return "";
			
		}

	}

	
	/*
	 * Desarrollo del algoritmo de Backtracking manual. 
	*/
	
	// ATRIBUTOS ESTÁTICOS DE LA CLASE
	public static VerticeProducto start;
	public static EstadoProducto estado;
	public static Double maxValue;
	public static Set<Integer> soluciones;
	
	public static void btm(Set<Integer> requisitos) {
		
		ProductoBT.maxValue = Double.MIN_VALUE;
		ProductoBT.soluciones = new HashSet<Integer>();
		ProductoBT.start = VerticeProducto.of(0, requisitos);
		ProductoBT.estado = EstadoProducto.inicial(start);
		
		btm();
		
	}
	
	public static void btm(Set<Integer> requisitos, Double maxValue, Integer solucion) {
		
		ProductoBT.start = VerticeProducto.of(0, requisitos);
		ProductoBT.estado = EstadoProducto.inicial(start);
		ProductoBT.maxValue = maxValue;
		ProductoBT.soluciones = new HashSet<>();
		ProductoBT.soluciones.add(solucion);
		
		btm();
		
	}
	
	/*
	 * Algoritmo desarrollado de BT Manual:
	*/
	public static void btm() {
		
		if (ProductoBT.estado.getVertice().getIndice() == Ejercicio3.getNProductos()) {
			
			Double value = estado.getValorAcumulado();
			if(value > ProductoBT.maxValue) {
				
				ProductoBT.maxValue = value;
				ProductoBT.soluciones.add(ProductoBT.estado.solucion());
				
			}
			
		} else {
			
			List<Integer> alternativas = ProductoBT.estado.getVertice().actions();
			for(Integer accion : alternativas) {	
				
				Double cota = ProductoBT.estado.getValorAcumulado() + HeuristicaProducto.cota(ProductoBT.estado.getVertice(), accion);
				if(cota < ProductoBT.maxValue) continue;
				ProductoBT.estado = ProductoBT.estado.avanza(accion);
				btm();  
				ProductoBT.estado = ProductoBT.estado.retrocede(accion);
				
			}
			
		}
		
	}

	// MÉTODOS AUXILIARES PARA TRABAJAR CON ALGORITMOS MANUALES 
	public static <E> List<E> List2addLast(List<E> ls, E e){
		
		List<E> cp = new ArrayList<>(ls);
		cp.add(e);
		return cp;
		
	}
	
	/**
	 * @param <E> tipo de los elementos de la lista
	 * @param ls Una lista
	 * @pre La lista no puede estar vacia
	 * @return Una copia de la lista con el ultimo elemnto eliminado
	 */
	public static <E> List<E> List2removeLast(List<E> ls){
		
		List<E> cp = new ArrayList<>(ls);
		int last = cp.size()-1;
		cp.remove(last);
		return cp;
		
	}
	
	/**
	 * @pre La lista no esta vacia
	 * @param <E> Tipo de los elementos
	 * @param ls Una lista
	 * @return Su ultimo elemento
	 */
	public static <E> E List2last(List<E> ls){
		
		int n = ls.size();
		return ls.get(n-1);
		
	}	
	
}
