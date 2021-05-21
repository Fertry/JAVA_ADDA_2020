/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import aristas.AristaProducto;
import ejercicio3.Ejercicio3;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase vértice producto para representar vértices del grafo de un tipo definido.
 * 
 * Interpretación: Encontrar la elección adecuada de productos, desde indice hasta el final, que
 * minimicen el precio total y cubran todas las funcionalidades deseadas.
*/
public class VerticeProducto extends ActionVirtualVertex <VerticeProducto, AristaProducto, Integer> {

	// MÉTODOS DE LA CLASE
	public static VerticeProducto of(Integer indice, Set<Integer> funcionalidadesPorCubrir) {
		
		return new VerticeProducto(indice, funcionalidadesPorCubrir);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	
	// Variables básicas:
	private Integer indice;
	private Set<Integer> funcionalidadesPorCubrir;
	
	// Variables compartidas (Extraidas de clase general donde se inicializan los datos):
	private static Integer productos = Ejercicio3.getNProductos();
	private static Set<Integer> funcionalidadesDeseadas = Ejercicio3.getRequisitos();
	
	// CONSTRUCTORES DE LA CLASE
	public VerticeProducto(Integer indice, Set<Integer> funcionalidadesPorCubrir) {
		
		super();
		
		this.indice = indice;
		this.funcionalidadesPorCubrir = funcionalidadesPorCubrir;
	
	}
	
	// GETTERS DE LA CLASE

	// Devuelve el índice del vértice:
	public Integer getIndice() {
		
		return indice;
		
	}
	
	// Devuelve el Set<> de funcionalidades por cubrir:
	public Set<Integer> getFuncionalidadesPorCubrir() {
		
		return funcionalidadesPorCubrir;
		
	}
	
	// MÉTODOS PARA TRABAJAR CON GRAFOS VIRTUALES
	
	// Método que verifica si alcanzamos el objetivo o no: el índice alcanze el nº de productos:
	public static Predicate<VerticeProducto> objetivo() {
		
		return (VerticeProducto vertice) -> vertice.getIndice() == VerticeProducto.productos;
		
	}
	
	// Definir un vértice de comienzo dónde todas sus plazas están "vacías",
	// esto es, sus capacidades son máximas (alumnos / grupos):
	public static VerticeProducto verticeInicial() {
				
		VerticeProducto resultado = VerticeProducto.of(0, funcionalidadesDeseadas);
		
		return resultado;
	
	}

	// Método para copiar vértices: devuelve una copia del vértice dado cómo parámetro:
	// Tan solo es usado en Backtracking.
	public static VerticeProducto copiar(VerticeProducto vertice) {
		
		VerticeProducto resultado = VerticeProducto.of(vertice.indice, vertice.funcionalidadesPorCubrir);
		
		return resultado;
		
	}
	
	// MÉTODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acción aplicada a un vértice (por donde se desplaza):
	public AristaProducto edge(Integer accion) {
		
		AristaProducto resultado = AristaProducto.of(this, neighbor(accion), accion);
		
		return resultado;
		
	}
	
	@Override
	// Comprueba la validez de un vértice dado, esto es: se encuentra dentro del intervalo cerrado [0, n]
	// y además, cuenta con plazas disponibles para i, donde i >= 0 y i < m:
	public Boolean isValid() {
		
		Boolean valido = false;
		
		// Si NO es el vértice inicial NI el final, y el conjunto contiene las funcionalidades requeridas:
		if (this.indice >= 0 && this.indice <= productos && funcionalidadesDeseadas.containsAll(funcionalidadesPorCubrir)) {
		
			valido = true;
	
		}
	
		return valido;
	
	}
	
	@Override
	// Devuelve el vértice "vecino" que corresponde a la acción tomada:
	public VerticeProducto neighbor(Integer accion) {
		
		// Obtener el siguiente indice:
		Integer siguiente = this.indice + 1;

		// Caso base fc = 0:
		// neighbor = (n,O)
		if (funcionalidadesPorCubrir.isEmpty()) {
			
			Set<Integer> setNulo = new HashSet<Integer>();
			VerticeProducto verticeNulo = VerticeProducto.of(productos, setNulo);
			return verticeNulo;
		
		// Casos generales:
		} else {
			
			// Caso general accion = 0:
			// neighbor(0) = (i+1, fc)
			if (accion == 0) {
				
				VerticeProducto verticeCaso1 = VerticeProducto.of(siguiente, funcionalidadesPorCubrir);
				return verticeCaso1;
			
			// Caso general accion = 1:
			// neighbor(1) = (i+1, fc-findex)
			} else {
				
				Set<Integer> funciones = new HashSet<>(funcionalidadesPorCubrir);
				funciones.removeAll(Ejercicio3.getFuncionalidades(this.indice));
				VerticeProducto verticeCaso2 = VerticeProducto.of(siguiente, funciones);
				return verticeCaso2;
				
			}

		}
			
	}

	@Override
	// Devuelve la lista de acciones (movimientos en el grafo) posibles en base a las restricciones:
	public List<Integer> actions() {
		
//		// Caso i = n:
//		if (this.indice == productos) {
//			
//			return Lists2.of();
//			
//		}
//		
//		// Caso conjunto nulo:
//		if (funcionalidadesPorCubrir.isEmpty()) {
//
//			return Lists2.of(0);
//			
//		}
//		
//		// Caso i = n-1 && fc-(fn-1) = 0:
//		if (this.indice == productos - 1) {
//			
//			if (funcionalidadesPorCubrir.removeAll(Ejercicio3.getFuncionalidades(productos - 1))) {
//				
//				return Lists2.of(1);
//				
//			}
//			
//		}
//		
//		// Caso i = n-1 && fc-(fn-1) != 0:
//		if (this.indice == productos - 1) {
//			
//			if (!funcionalidadesPorCubrir.removeAll(Ejercicio3.getFuncionalidades(productos - 1))) {
//				
//				return Lists2.of();
//				
//			}
//		
//		}
//		
//		// En otro caso: {0,1}
//		return Lists2.of(0,1);
		
		List<Integer> res = new ArrayList<Integer>();
		if (this.indice == productos) {
			res.clear();
		} else if (funcionalidadesPorCubrir.size() == 0) {
			res.add(0);
		} else if (this.indice == (productos - 1) && (funcionalidadesPorCubrir.size() - Ejercicio3.getFuncionalidades(productos - 1).size()) == 0) {
			res.add(1);
		} else if (this.indice == (productos - 1) && (funcionalidadesPorCubrir.size() - Ejercicio3.getFuncionalidades(productos - 1).size()) == 0) {
			res.clear();
		} else {
			res.add(0);
			res.add(1);
		}
		return res;
			
	}

	// HASHCODE Y EQUALS DE LA CLASE EN BASE A INDICE Y FUNCIONALIDADES POR CUBRIR
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionalidadesPorCubrir == null) ? 0 : funcionalidadesPorCubrir.hashCode());
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
		VerticeProducto other = (VerticeProducto) obj;
		if (funcionalidadesPorCubrir == null) {
			if (other.funcionalidadesPorCubrir != null)
				return false;
		} else if (!funcionalidadesPorCubrir.equals(other.funcionalidadesPorCubrir))
			return false;
		if (indice == null) {
			if (other.indice != null)
				return false;
		} else if (!indice.equals(other.indice))
			return false;
		return true;
		
	}	

	// TO_STRING DE LA CLASE
	@Override
	public String toString() {
		
		return this.funcionalidadesPorCubrir + "\n";
		
	}
	
}
