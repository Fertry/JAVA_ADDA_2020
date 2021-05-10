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
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase vértice alumno para representar vértices del grafo de un tipo definido.
*/
public class VerticeAlumno extends ActionVirtualVertex<VerticeAlumno, AristaAlumno, Integer> {

	// ATRIBUTOS DE LA CLASE
	private Integer indice;
	private List<Integer> plazasRestantes;
	
	private static Integer grupos = Ejercicio1.getNGrupos();
	private static Integer alumnos = Ejercicio1.getNAlumnos();
	
	// MÉTODOS DE LA CLASE
	public static VerticeAlumno of(Integer indice, List<Integer> plazasRestantes) {
		
		return new VerticeAlumno(indice, plazasRestantes);
		
	}
	
	// CONSTRUCTORES DE LA CLASE
	private VerticeAlumno(Integer indice, List<Integer> plazasRestantes) {
				
		super();
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			// Estado inicial: todas las plazas están vacías:
			auxiliar.add(0);
			i++;
			
		}

		this.indice = indice;
		this.plazasRestantes = plazasRestantes;
		
		// SÓLO si indice > nº alumnos, entonces plazasRestantes = estado final = auxiliar:
//		if (alumnos < indice) {
//			
//			this.plazasRestantes = plazasRestantes;
//			
//		} else {
//			
//			this.plazasRestantes = auxiliar;
//			
//		}
		
	}

	// GETTERS DE LA CLASE
	
	// Devuelve el índice del vértice:
	public Integer getIndice() {
		
		return indice;
		
	}
	
	// Devuelve la lista de plazas del vértice:
	public List<Integer> getPlazasRestantes() {
		
		return plazasRestantes;
		
	}

	// MÉTODOS HEREDADOS DE LA SUPERCLASE
	
	@Override
	public Boolean isValid() {
		boolean res = true;
		if (!(indice >= 0 && indice <= alumnos)) {
			res = false;
		}
		for (int k = 0; k < grupos; k++) {
			if (plazasRestantes.get(k) < 0) {
				res = false;
			}
		}
		return res;
	}

	@Override
	public List<Integer> actions() {
		
		int accion = 0;
		List<Integer> acciones = new ArrayList<Integer>();
		
		while (accion < grupos) {
			
			// Si la afinidad para el movimiento "accion" NO es cero:
			if (Ejercicio1.getAfinidadPorIndice(indice, accion) > 0) {
				
				// Y si hay plazas disponibles en el grupo:
				if (plazasRestantes.get(accion) > 0) {
					
					acciones.add(accion);
					
				}
			}
			
			accion++;
			
		}
		
		return acciones;
		
	}

	@Override
	public VerticeAlumno neighbor(Integer a) {
		
		Integer nuevoIndice = indice++;
		VerticeAlumno resultado = null;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		auxiliar.set(a, (this.plazasRestantes.get(a) - 1));
		
		resultado = VerticeAlumno.of(nuevoIndice, auxiliar);
		return resultado;
		
	}

	@Override
	public AristaAlumno edge(Integer a) {
		
		VerticeAlumno v = this.neighbor(a);
		return AristaAlumno.of(this, v, a);
		
	}
	
	// MÉTODOS PARA TRABAJAR CON GRAFOS VIRTUALES
	
	// Definir un vértice de comienzo dónde todas sus plazas están "vacías",
	// esto es, sus capacidades son máximas (alumnos / grupos):
	public static VerticeAlumno initialVertex() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			auxiliar.add(alumnos / grupos);
			System.out.println(alumnos / grupos);
			i++;
			
		}
		
		System.out.println(auxiliar);
		VerticeAlumno resultado = VerticeAlumno.of(0, auxiliar);
		return resultado;

	}

	// Definir un vértice de destino dónde todas sus plazas están "llenas", 
	// esto es, sus capacidades son cero:
	public static VerticeAlumno lastVertex() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			auxiliar.add(0);
			i++;
			
		}
		
		VerticeAlumno resultado = VerticeAlumno.of(grupos, auxiliar);
		return resultado;
		
	}
	
	// Método que verifica si alcanzamos el objetivo o no: el índice alcanze el nº de alumnos:
	public static Predicate<VerticeAlumno> goal() {
		
		return (VerticeAlumno vertice) -> vertice.indice == VerticeAlumno.alumnos;
		
	}
	
	// Método para copiar vértices: devuelve una copia del vértice dado cómo parámetro:
	public static VerticeAlumno copy(VerticeAlumno vertice) {
		
		VerticeAlumno resultado = VerticeAlumno.of(vertice.getIndice(), vertice.getPlazasRestantes());
		
		return resultado;
		
	}
	
	public static Double heuristica(VerticeAlumno origen, Predicate<VerticeAlumno> goal, VerticeAlumno destino) {
		
		Double resultado = 0.0;
		Integer max = 0;
		for (int i = origen.getIndice(); i < Ejercicio1.getNAlumnos(); i++) {
			for (int j = 0; j < Ejercicio1.getNGrupos(); j++) {
				if (origen.getPlazasRestantes().get(j) > 0) {
					if (Ejercicio1.getAfinidadPorIndice(i, j) > max) {
						max = Ejercicio1.getAfinidadPorIndice(i, j);
					}
				}
			}
			resultado += max;
			max = 0;
		}
		return resultado;
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
	
	// TO_STRING DE LA CLASE (Sólo para debug)
	@Override
	public String toString() {
		
		return "[El grupo: " + indice + ", dispone de " + plazasRestantes + " plazas]";
		
	}
	
}
