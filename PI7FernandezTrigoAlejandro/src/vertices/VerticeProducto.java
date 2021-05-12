/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.ArrayList;
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
	public static VerticeProducto of(Integer indice, List<Integer> plazasRestantes) {
		
		return new VerticeProducto(indice, plazasRestantes);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	
	// Variables básicas:
	private Integer indice;
	private Set<Integer> funcionalidadesPorCubrir;
	
	// Variables compartidas (Extraidas de clase general donde se inicializan los datos):
	private static Integer productos = Ejercicio3.getNProductos();
	private static Set<Integer> funcionalidadesDeseadas = Ejercicio3.;
	
	// CONSTRUCTORES DE LA CLASE
	public VerticeProducto(Integer indice, List<Integer> plazasRestantes) {
		
		super();
		
		this.indice = indice;
		this.plazasRestantes = plazasRestantes;
	
	}
	
	// GETTERS DE LA CLASE

	// Devuelve el índice del vértice:
	public Integer getIndice() {
		
		return indice;
		
	}
	
	// MÉTODOS PARA TRABAJAR CON GRAFOS VIRTUALES
	
	// Método que verifica si alcanzamos el objetivo o no: el índice alcanze el nº de alumnos:
	public static Predicate<VerticeProducto> objetivo() {
		
		return (VerticeProducto vertice) -> vertice.getIndice() == VerticeProducto.alumnos;
		
	}
	
	// Definir un vértice de comienzo dónde todas sus plazas están "vacías",
	// esto es, sus capacidades son máximas (alumnos / grupos):
	public static VerticeProducto verticeInicial() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			auxiliar.add(reparto);
			i++;
			
		}
		
		VerticeProducto resultado = VerticeProducto.of(0, auxiliar);
		return resultado;
	
	}

	// Definir un vértice de destino dónde todas sus plazas están "llenas", 
	// esto es, sus capacidades son cero:
	public static VerticeProducto verticeFinal() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			auxiliar.add(0);
			i++;
			
		}
		
		VerticeProducto resultado = VerticeProducto.of(alumnos, auxiliar);
		return resultado;
			
	}
	
	// Método para copiar vértices: devuelve una copia del vértice dado cómo parámetro:
	public static VerticeProducto copiar(VerticeProducto vertice) {
		
		VerticeProducto resultado = VerticeProducto.of(vertice.indice, vertice.plazasRestantes);
		
		return resultado;
		
	}
	
	// MÉTODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acción aplicada a un vértice (por donde se desplaza):
	public AristaProducto edge(Integer accion) {
		
		// 1º obtener el vértice "vecino" correspondiente a la acción:
		VerticeProducto vertice = this.neighbor(accion);
		
		// 2º obtener la arista que los conecta (el camino): origen, destino, accion
		AristaProducto resultado = AristaProducto.of(this, vertice, accion);
		
		return resultado;
		
	}
	
	@Override
	// 
	public Boolean isValid() {
		
		int i = 0;
		Boolean valido = false;
		
		// Si NO es el vértice inicial NI el final:
		if (this.indice >= 0 && this.indice <= alumnos) {
			
			valido = true;
			
		}

		// Si el grupo i NO está lleno (hay plazas):
		while (i < grupos) {
		
			if (this.plazasRestantes.get(i) > 0) {
				
				valido = true;
				
			}
			
			i++;
			
		}
				
		return valido;
	
	}
	
	@Override
	// Devuelve el vértice "vecino" que corresponde a la acción tomada:
	public VerticeProducto neighbor(Integer accion) {
		
		// 1º obtener el siguiente indice:
		Integer siguiente = this.indice + 1;
		
		// 2º copiar la lista de plazasRestantes actual:
		List<Integer> auxiliar = new ArrayList<>(this.plazasRestantes);
		
		// 3º alterar el valor de la lista: esto es, para la posición del grupo indicada por la acción
		// restarle uno indicando que hay una capacidad menos:
		auxiliar.set(accion, (this.plazasRestantes.get(accion) - 1));
		
		// 4º devolver el vértice nuevo:
		VerticeProducto resultado = VerticeProducto.of(siguiente, auxiliar);
		
		return resultado;
		
	}

	@Override
	// Devuelve la lista de acciones (movimientos en el grafo) posibles en base a las restricciones:
	public List<Integer> actions() {
		
		int i = 0;
		List<Integer> acciones = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			// Si hay plazas disponibles en el grupo:
			if (this.plazasRestantes.get(i) > 0) {
				
				// Y si la afinidad para el movimiento NO es cero:
				if (Ejercicio3.getAfinidadPorIndice(this.indice, i) > 0) {
					
					// Entonces es una acción posible de mejora:
					acciones.add(i);
					
				}
			}
			
			i++;
			
		}
		
		return acciones;
			
	}

	// HASHCODE Y EQUALS DE LA CLASE EN BASE A INDICE Y FUNCIONALIDADES POR CUBRIR
	

	// TO_STRING DE LA CLASE (Sólo para debug)
	@Override
	public String toString() {
		
		return "[Indice: " + this.indice + ", cuenta con las plazas: " + this.plazasRestantes + "]";
		
	}
	
}
