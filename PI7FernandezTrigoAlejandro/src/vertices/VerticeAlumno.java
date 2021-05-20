/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import aristas.AristaAlumno;
import ejercicio1.Ejercicio1;
import us.lsi.common.Lists2;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase vértice alumno para representar vértices del grafo de un tipo definido.
 * 
 * Interpretación: Encontrar la asignación de estudiantes a grupos, desde indice hasta el final, que
 * optimicen la afinidad.
*/
public class VerticeAlumno extends ActionVirtualVertex<VerticeAlumno, AristaAlumno, Integer> {

	// MÉTODOS DE LA CLASE
	public static VerticeAlumno of(Integer indice, List<Integer> plazasRestantes) {
		
		return new VerticeAlumno(indice, plazasRestantes);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	
	// Variables básicas:
	private Integer indice;
	private List<Integer> plazasRestantes;
	
	// Variables compartidas (Extraidas de clase general donde se inicializan los datos):
	private static Integer grupos = Ejercicio1.getNGrupos();
	private static Integer alumnos = Ejercicio1.getNAlumnos();
		
	// Variables derivadas (calculadas en la propia clase):
	private static Integer reparto = getReparto();
		
	// CONSTRUCTORES DE LA CLASE
	public VerticeAlumno(Integer indice, List<Integer> plazasRestantes) {
		
		super();
		
		this.indice = indice;
		this.plazasRestantes = plazasRestantes;
	
	}
	
	// GETTERS DE LA CLASE

	// Devuelve el índice del vértice:
	public Integer getIndice() {
		
		return indice;
		
	}
	
	// Devuelve la lista de plazas restantes:
	public List<Integer> getPlazasRestantes() {
		
		return plazasRestantes;
		
	}
	
	// MÉTODOS PARA SETEAR LAS VARIABLES DERIVADAS DE LA CLASE
	
	// Devuelve el tamaño del reparto: alumnos / grupos:
	public static Integer getReparto() {
		
		return alumnos / grupos;
		
	}
	
	// MÉTODOS PARA TRABAJAR CON GRAFOS VIRTUALES
	
	// Método que verifica si alcanzamos el objetivo o no: el índice alcanze el nº de alumnos:
	public static Predicate<VerticeAlumno> objetivo() {
		
		return (VerticeAlumno vertice) -> vertice.getIndice() == VerticeAlumno.alumnos;
		
	}
	
	// Definir un vértice de comienzo dónde todas sus plazas están "vacías",
	// esto es, sus capacidades son máximas (alumnos / grupos):
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
	
	// MÉTODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acción aplicada a un vértice (por donde se desplaza):
	public AristaAlumno edge(Integer accion) {
		
		AristaAlumno resultado = AristaAlumno.of(this, neighbor(accion), accion);
		
		return resultado;
		
	}
	
	@Override
	// Comprueba la validez de un vértice dado, esto es: se encuentra dentro del intervalo cerrado [0, n]
	// y además, cuenta con plazas disponibles para i, donde i >= 0 y i < m:
	public Boolean isValid() {
		
		int i = 1;
		Boolean valido = false;
		
		// Si NO es el vértice inicial NI el final (Intervalo cerrado):
		if (this.indice >= 0 && this.indice <= alumnos) {
			
			valido = true;
			
		}

		// Si el grupo i NO está lleno (hay plazas):
		while (i < grupos) {
		
			if (this.plazasRestantes.get(i) >= 0) {
				
				valido = true;
				
			}
			
			i++;
			
		}
				
		return valido;
	
	}
	
	@Override
	// Devuelve el vértice "vecino" que corresponde a la acción tomada.
	// neighbor(a) = (i+1, pl') donde pl'[a] = pl[a]-1:
	public VerticeAlumno neighbor(Integer accion) {
		
		// 1º obtener el siguiente indice:
		Integer siguiente = this.indice + 1;
		
		// 2º copiar la lista de plazasRestantes actual:
		List<Integer> auxiliar = new ArrayList<>(this.plazasRestantes);
		
		// 3º alterar el valor de la lista: esto es, para la posición del grupo indicada por la acción
		// restarle uno indicando que hay una capacidad menos:
		auxiliar.set(accion, (this.plazasRestantes.get(accion) - 1));
		
		// 4º devolver el vértice nuevo:
		VerticeAlumno resultado = VerticeAlumno.of(siguiente, auxiliar);
		
		return resultado;
		
	}

	@Override
	// Devuelve la lista de acciones (movimientos en el grafo) posibles en base a las restricciones:
	public List<Integer> actions() {
		
		int i = 0;
		List<Integer> acciones = new ArrayList<Integer>();
		
		// De alcanzar el límite, no hay más acciones:
		if (this.indice == alumnos) {
			
			return Lists2.of();
			
		} 
		
		// De no alcanzar el límite, comprobar si pl[a] > 0 && af(index,a) > 0:
		while (i < grupos) {
		
			// Si hay plazas disponibles en el grupo:
			if (this.plazasRestantes.get(i) > 0) {
				
				// Y si la afinidad para el movimiento NO es cero:
				if (Ejercicio1.getAfinidadPorIndice(this.indice, i) > 0) {
					
					// Entonces es una acción posible de mejora:
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

	// TO_STRING DE LA CLASE
	@Override
	public String toString() {
		
		return "Alumno: " + this.indice + " - " + this.plazasRestantes + "\n";
		
	}
	
}
