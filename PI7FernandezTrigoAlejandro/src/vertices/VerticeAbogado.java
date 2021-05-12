/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import aristas.AristaAbogado;
import ejercicio2.Ejercicio2;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase vértice abogado para representar vértices del grafo de un tipo definido.
 * 
 * Interpretación: Encontrar la asignación de casos a abogados, desde indice hasta el final, que minimice
 * cargaMaxima, teniendo en cuenta las cargas ya acumuladas para los abogados.
*/
public class VerticeAbogado extends ActionVirtualVertex<VerticeAbogado, AristaAbogado, Integer> {

	// MÉTODOS DE LA CLASE
	public static VerticeAbogado of(Integer indice, List<Integer> plazasRestantes) {
		
		return new VerticeAbogado(indice, plazasRestantes);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	
	// Variables básicas:
	private Integer indice;
	private List<Integer> cargaAbogado;
	
	// Variables compartidas (Extraidas de clase general donde se inicializan los datos):
	private static Integer casos = Ejercicio2.getNCasos();
	private static Integer abogados = Ejercicio2.getNAbogados();

	// Variables derivadas (calculadas en la propia clase):
	private static Integer cargaMaxima;
	private static Integer cargaMinima;
	private static Integer abogadoMaximo;
	private static Integer abogadoMinimo;
	
	// CONSTRUCTORES DE LA CLASE
	public VerticeAbogado(Integer indice, List<Integer> cargaAbogado) {
		
		super();
		
		this.indice = indice;
		this.cargaAbogado = cargaAbogado;
	
	}
	
	// GETTERS DE LA CLASE

	// Devuelve el índice del vértice:
	public Integer getIndice() {
		
		return indice;
		
	}
	
	// MÉTODOS PARA TRABAJAR CON GRAFOS VIRTUALES
	
	// Método que verifica si alcanzamos el objetivo o no: el índice alcanze el nº de alumnos:
	public static Predicate<VerticeAbogado> objetivo() {
		
		return (VerticeAbogado vertice) -> vertice.getIndice() == VerticeAbogado.abogados;
		
	}
	
	// Definir un vértice de comienzo dónde todas sus plazas están "vacías",
	// esto es, sus capacidades son máximas (alumnos / grupos):
	public static VerticeAbogado verticeInicial() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < casos) {
			
			auxiliar.add(0);
			i++;
			
		}
		
		VerticeAbogado resultado = VerticeAbogado.of(0, auxiliar);
		return resultado;
	
	}

	// Definir un vértice de destino dónde todas sus plazas están "llenas", 
	// esto es, sus capacidades son cero:
	public static VerticeAbogado verticeFinal() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < casos) {
			
			auxiliar.add(0);
			i++;
			
		}
		
		VerticeAbogado resultado = VerticeAbogado.of(abogados, auxiliar);
		return resultado;
			
	}
	
	// Método para copiar vértices: devuelve una copia del vértice dado cómo parámetro:
	public static VerticeAbogado copiar(VerticeAbogado vertice) {
		
		VerticeAbogado resultado = VerticeAbogado.of(vertice.indice, vertice.cargaAbogado);
		
		return resultado;
		
	}
	
	// MÉTODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acción aplicada a un vértice (por donde se desplaza):
	public AristaAbogado edge(Integer accion) {
		
		// 1º obtener el vértice "vecino" correspondiente a la acción:
		VerticeAbogado vertice = this.neighbor(accion);
		
		// 2º obtener la arista que los conecta (el camino): origen, destino, accion
		AristaAbogado resultado = AristaAbogado.of(this, vertice, accion);
		
		return resultado;
		
	}
	
	@Override
	// 
	public Boolean isValid() {
		
		int i = 0;
		Boolean valido = false;
		
		// Si NO es el vértice inicial NI el final:
		if (this.indice >= 0 && this.indice <= abogados) {
			
			valido = true;
			
		}

		// Si el grupo i NO está lleno (hay plazas):
		while (i < casos) {
		
			if (this.cargaAbogado.get(i) > 0) {
				
				valido = true;
				
			}
			
			i++;
			
		}
				
		return valido;
	
	}
	
	@Override
	// Devuelve el vértice "vecino" que corresponde a la acción tomada:
	public VerticeAbogado neighbor(Integer accion) {
		
		// 1º obtener el siguiente indice:
		Integer siguiente = this.indice + 1;
		
		// 2º copiar la lista de plazasRestantes actual:
		List<Integer> auxiliar = new ArrayList<>(this.cargaAbogado);
		
		// 3º alterar el valor de la lista: esto es, para la posición del grupo indicada por la acción
		// restarle uno indicando que hay una capacidad menos:
		auxiliar.set(accion, (this.cargaAbogado.get(accion) - 1));
		
		// 4º devolver el vértice nuevo:
		VerticeAbogado resultado = VerticeAbogado.of(siguiente, auxiliar);
		
		return resultado;
		
	}

	@Override
	// Devuelve la lista de acciones (movimientos en el grafo) posibles en base a las restricciones:
	public List<Integer> actions() {
		
		int i = 0;
		List<Integer> acciones = new ArrayList<Integer>();
		
		while (i < casos) {
			
			// Si hay plazas disponibles en el grupo:
			if (this.cargaAbogado.get(i) > 0) {
				
				// Y si la afinidad para el movimiento NO es cero:
				if (Ejercicio2.tiempoPorIndice(this.indice, i) > 0) {
					
					// Entonces es una acción posible de mejora:
					acciones.add(i);
					
				}
			}
			
			i++;
			
		}
		
		return acciones;
			
	}

	// HASHCODE Y EQUALS DE LA CLASE EN BASE A INDICE Y CARGA ABOGADO
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargaAbogado == null) ? 0 : cargaAbogado.hashCode());
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
		VerticeAbogado other = (VerticeAbogado) obj;
		if (cargaAbogado == null) {
			if (other.cargaAbogado != null)
				return false;
		} else if (!cargaAbogado.equals(other.cargaAbogado))
			return false;
		if (indice == null) {
			if (other.indice != null)
				return false;
		} else if (!indice.equals(other.indice))
			return false;
		return true;
		
	}
		
	// TO_STRING DE LA CLASE (Sólo para debug)
	@Override
	public String toString() {
		
		return "[Indice: " + this.indice + ", cuenta con una carga tal qué: " + this.cargaAbogado + "]";
		
	}

}
