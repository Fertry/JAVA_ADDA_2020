/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import aristas.AristaAlumno;
import ejercicio1.Ejercicio1;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase v�rtice alumno para representar v�rtices del grafo de un tipo definido.
 * 
 * Interpretaci�n: Encontrar la asignaci�n de estudiantes a grupos, desde indice hasta el final, que
 * optimicen la afinidad.
*/
public class VerticeAlumno extends ActionVirtualVertex<VerticeAlumno, AristaAlumno, Integer> {

	// M�TODOS DE LA CLASE
	public static VerticeAlumno of(Integer indice, List<Integer> plazasRestantes) {
		
		return new VerticeAlumno(indice, plazasRestantes);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	
	// Variables b�sicas:
	private Integer indice;
	private List<Integer> plazasRestantes;
	
	// Variables compartidas (Extraidas de clase general donde se inicializan los datos):
	private static Integer grupos = Ejercicio1.getNGrupos();
	private static Integer alumnos = Ejercicio1.getNAlumnos();
	
	// Variables derivadas (calculadas en la propia clase):
	private static Integer reparto = alumnos / grupos;
	
	// CONSTRUCTORES DE LA CLASE
	public VerticeAlumno(Integer indice, List<Integer> plazasRestantes) {
		
		super();
		
		this.indice = indice;
		this.plazasRestantes = plazasRestantes;
	
	}
	
	// GETTERS DE LA CLASE

	// Devuelve el �ndice del v�rtice:
	public Integer getIndice() {
		
		return indice;
		
	}
	
	// M�TODOS PARA TRABAJAR CON GRAFOS VIRTUALES
	
	// M�todo que verifica si alcanzamos el objetivo o no: el �ndice alcanze el n� de alumnos:
	public static Predicate<VerticeAlumno> objetivo() {
		
		return (VerticeAlumno vertice) -> vertice.getIndice() == VerticeAlumno.alumnos;
		
	}
	
	// Definir un v�rtice de comienzo d�nde todas sus plazas est�n "vac�as",
	// esto es, sus capacidades son m�ximas (alumnos / grupos):
	public static VerticeAlumno verticeInicial() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			auxiliar.add(reparto);
			i++;
			
		}
		
		VerticeAlumno resultado = VerticeAlumno.of(0, auxiliar);
		return resultado;
	
	}

	// Definir un v�rtice de destino d�nde todas sus plazas est�n "llenas", 
	// esto es, sus capacidades son cero:
	public static VerticeAlumno verticeFinal() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			auxiliar.add(0);
			i++;
			
		}
		
		VerticeAlumno resultado = VerticeAlumno.of(alumnos, auxiliar);
		return resultado;
			
	}
	
	// M�todo para copiar v�rtices: devuelve una copia del v�rtice dado c�mo par�metro:
	public static VerticeAlumno copiar(VerticeAlumno vertice) {
		
		VerticeAlumno resultado = VerticeAlumno.of(vertice.indice, vertice.plazasRestantes);
		
		return resultado;
		
	}
	
	// M�TODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acci�n aplicada a un v�rtice (por donde se desplaza):
	public AristaAlumno edge(Integer accion) {
		
		// 1� obtener el v�rtice "vecino" correspondiente a la acci�n:
		VerticeAlumno vertice = this.neighbor(accion);
		
		// 2� obtener la arista que los conecta (el camino): origen, destino, accion
		AristaAlumno resultado = AristaAlumno.of(this, vertice, accion);
		
		return resultado;
		
	}
	
	@Override
	// 
	public Boolean isValid() {
		
		int i = 0;
		Boolean valido = false;
		
		// Si NO es el v�rtice inicial NI el final:
		if (this.indice >= 0 && this.indice <= alumnos) {
			
			valido = true;
			
		}

		// Si el grupo i NO est� lleno (hay plazas):
		while (i < grupos) {
		
			if (this.plazasRestantes.get(i) > 0) {
				
				valido = true;
				
			}
			
			i++;
			
		}
				
		return valido;
	
	}
	
	@Override
	// Devuelve el v�rtice "vecino" que corresponde a la acci�n tomada:
	public VerticeAlumno neighbor(Integer accion) {
		
		// 1� obtener el siguiente indice:
		Integer siguiente = this.indice + 1;
		
		// 2� copiar la lista de plazasRestantes actual:
		List<Integer> auxiliar = new ArrayList<>(this.plazasRestantes);
		
		// 3� alterar el valor de la lista: esto es, para la posici�n del grupo indicada por la acci�n
		// restarle uno indicando que hay una capacidad menos:
		auxiliar.set(accion, (this.plazasRestantes.get(accion) - 1));
		
		// 4� devolver el v�rtice nuevo:
		VerticeAlumno resultado = VerticeAlumno.of(siguiente, auxiliar);
		
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
				if (Ejercicio1.getAfinidadPorIndice(this.indice, i) > 0) {
					
					// Entonces es una acci�n posible de mejora:
					acciones.add(i);
					
				}
			}
			
			i++;
			
		}
		
		return acciones;
			
	}

	// HASHCODE Y EQUALS DE LA CLASE EN BASE A INDICE Y PLAZAS RESTANTES
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((indice == null) ? 0 : indice.hashCode());
		result = prime * result + ((plazasRestantes == null) ? 0 : plazasRestantes.hashCode());
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
		VerticeAlumno other = (VerticeAlumno) obj;
		if (indice == null) {
			if (other.indice != null)
				return false;
		} else if (!indice.equals(other.indice))
			return false;
		if (plazasRestantes == null) {
			if (other.plazasRestantes != null)
				return false;
		} else if (!plazasRestantes.equals(other.plazasRestantes))
			return false;
		return true;
		
	}

	// TO_STRING DE LA CLASE (S�lo para debug)
	@Override
	public String toString() {
		
		return "[Indice: " + this.indice + ", cuenta con las plazas: " + this.plazasRestantes + "]";
		
	}
	
}
