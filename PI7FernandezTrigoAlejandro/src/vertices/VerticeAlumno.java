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
	public Integer indice;
	public List<Integer> plazas;
	public static Integer grupos = Ejercicio1.getNGrupos();
	public static Integer reparto = Ejercicio1.getReparto();
	public static Integer alumnos = Ejercicio1.getNAlumnos();

	// MÉTODOS DE LA CLASE
	public static VerticeAlumno of(Integer indice, List<Integer> plazas) {
		
		return new VerticeAlumno(indice, plazas);
		
	}

	// CONSTRUCTORES DE LA CLASE
	public VerticeAlumno(Integer indice, List<Integer> plazas) {
		
		super();
		
		this.indice = indice;
		this.plazas = plazas;
		
	}

	// MÉTODOS PARA GRAFOS VIRTUALES
	
	/*
	 * Vértice de inicio.
	*/
	public static VerticeAlumno initialVertex() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			auxiliar.add(reparto);
			i++;
			
		}

		// Vértice inicial (0) con sus plazas vacías (reparto):
		return of(0, auxiliar);
		
	}

	/*
	 * Vértice de final (cota superior del problema).
	*/
	public static VerticeAlumno lastVertex() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			auxiliar.add(0);
			i++;
			
		}
		
		// Vértice final (alumnos) con sus plazas llenas (0):
		return of(alumnos, auxiliar);
		
	}
	
	/*
	 * 
	*/
	public static VerticeAlumno copy(VerticeAlumno vertice) {
		
		return new VerticeAlumno(vertice.indice, vertice.plazas);
		
	}
	
	/*
	 * 
	*/
	public static Predicate<VerticeAlumno> objetivo() {
		
		return (VerticeAlumno vertice) -> vertice.equals(lastVertex());
		
	}
	
	/*
	 * Heurística: optimación de lo que falta para maximizar el resultado.
	*/
	public Double heuristica() {
		
		int i = 0;
		int j = 0;
		Integer maximo = 0;
		Double resultado = 0.0;

		while (i < alumnos) {
			while (j < grupos) {
			
				// Si plazas NO están llenas:
				if (plazas.get(j) > 0) {
					
					Integer afinidad = Ejercicio1.afinidadPorIndice(i, j);
					if (afinidad > maximo) {
						
						maximo = afinidad;
						
					}
					
				}
				
				j++;
				
			}
			
			resultado += maximo;
			i++;
			
		}
		
		return resultado;

	}

	// MÉTODOS HEREDADOS
	
	@Override
	/*
	 * Determinar si un vértice es válido o no.
	*/
	public Boolean isValid() {
		
		int i = 0;
		Boolean resultado = false;
		
		// Si el vértice NO es inicio ni supera el límite:
		if (!(indice >= 0 && indice <= alumnos)) {
			
			resultado = true;
			
		}
		
		// Si las plazas no están llenas:
		while (i < grupos) {
			
			if (plazas.get(i) > 0) {
				
				resultado = true;
				
			}
			
			i++;
			
		}

		return resultado;
		
	}

	@Override
	/*
	 * Determinar la acción que corresponde a un vértice dado. 
	*/
	public List<Integer> actions() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos)  {
			
			// Si la afinidad NO es cero Y plazas NO están llenas:
			if (Ejercicio1.afinidadPorIndice(indice, i) > 0 && plazas.get(i) > 0) {
				
				auxiliar.add(i);
				i++;
				
			}
			
		}
		
		return auxiliar;

	}

	@Override
	/*
	 * Determinar los vértices conexos (vecinos). 
	*/
	public VerticeAlumno neighbor(Integer accion) {
		
		return null;
		
	}

	@Override
	/*
	 * 
	*/
	public AristaAlumno edge(Integer accion) {
		
		return null;
		
	}
	
	// TO_STRING, EQUALS Y HASHCODE DE LA CLASE
	@Override
	public String toString() {
		
		return "[Indice: " + indice + ", plazas: " + plazas + "]";
		
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((indice == null) ? 0 : indice.hashCode());
		result = prime * result + ((plazas == null) ? 0 : plazas.hashCode());
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
		if (plazas == null) {
			if (other.plazas != null)
				return false;
		} else if (!plazas.equals(other.plazas))
			return false;
		return true;
		
	}

	public Integer getIndice() {
		
		return indice;
		
	}

}
