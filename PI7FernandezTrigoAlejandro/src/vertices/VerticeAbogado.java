/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
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
 * Clase v�rtice abogado para representar v�rtices del grafo de un tipo definido.
 * 
 * Interpretaci�n: Encontrar la asignaci�n de casos a abogados, desde indice hasta el final, que minimice
 * cargaMaxima, teniendo en cuenta las cargas ya acumuladas para los abogados.
*/
public class VerticeAbogado extends ActionVirtualVertex<VerticeAbogado, AristaAbogado, Integer> {

	// M�TODOS DE LA CLASE
	public static VerticeAbogado of(Integer indice, List<Integer> plazasRestantes) {
		
		return new VerticeAbogado(indice, plazasRestantes);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	
	// Variables b�sicas:
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

	// Devuelve el �ndice del v�rtice:
	public Integer getIndice() {
		
		return indice;
		
	}
	
	// M�TODOS PARA TRABAJAR CON GRAFOS VIRTUALES
	
	// M�todo que verifica si alcanzamos el objetivo o no: el �ndice alcanze el n� de alumnos:
	public static Predicate<VerticeAbogado> objetivo() {
		
		return (VerticeAbogado vertice) -> vertice.getIndice() == VerticeAbogado.abogados;
		
	}
	
	// Definir un v�rtice de comienzo d�nde todas sus plazas est�n "vac�as",
	// esto es, sus capacidades son m�ximas (alumnos / grupos):
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

	// Definir un v�rtice de destino d�nde todas sus plazas est�n "llenas", 
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
	
	// M�todo para copiar v�rtices: devuelve una copia del v�rtice dado c�mo par�metro:
	public static VerticeAbogado copiar(VerticeAbogado vertice) {
		
		VerticeAbogado resultado = VerticeAbogado.of(vertice.indice, vertice.cargaAbogado);
		
		return resultado;
		
	}
	
	// M�TODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acci�n aplicada a un v�rtice (por donde se desplaza):
	public AristaAbogado edge(Integer accion) {
		
		// 1� obtener el v�rtice "vecino" correspondiente a la acci�n:
		VerticeAbogado vertice = this.neighbor(accion);
		
		// 2� obtener la arista que los conecta (el camino): origen, destino, accion
		AristaAbogado resultado = AristaAbogado.of(this, vertice, accion);
		
		return resultado;
		
	}
	
	@Override
	// 
	public Boolean isValid() {
		
		int i = 0;
		Boolean valido = false;
		
		// Si NO es el v�rtice inicial NI el final:
		if (this.indice >= 0 && this.indice <= abogados) {
			
			valido = true;
			
		}

		// Si el grupo i NO est� lleno (hay plazas):
		while (i < casos) {
		
			if (this.cargaAbogado.get(i) > 0) {
				
				valido = true;
				
			}
			
			i++;
			
		}
				
		return valido;
	
	}
	
	@Override
	// Devuelve el v�rtice "vecino" que corresponde a la acci�n tomada:
	public VerticeAbogado neighbor(Integer accion) {
		
		// 1� obtener el siguiente indice:
		Integer siguiente = this.indice + 1;
		
		// 2� copiar la lista de plazasRestantes actual:
		List<Integer> auxiliar = new ArrayList<>(this.cargaAbogado);
		
		// 3� alterar el valor de la lista: esto es, para la posici�n del grupo indicada por la acci�n
		// restarle uno indicando que hay una capacidad menos:
		auxiliar.set(accion, (this.cargaAbogado.get(accion) - 1));
		
		// 4� devolver el v�rtice nuevo:
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
					
					// Entonces es una acci�n posible de mejora:
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
		
	// TO_STRING DE LA CLASE (S�lo para debug)
	@Override
	public String toString() {
		
		return "[Indice: " + this.indice + ", cuenta con una carga tal qu�: " + this.cargaAbogado + "]";
		
	}

}
