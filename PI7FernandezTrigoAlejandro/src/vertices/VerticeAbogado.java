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
import aristas.AristaAlumno;
import ejercicio1.Ejercicio1;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase vértice abogado para representar vértices del grafo de un tipo definido.
*/
public class VerticeAbogado extends ActionVirtualVertex<VerticeAlumno, AristaAlumno, Integer> {

	public Integer indice;
	public List<Integer> plazasRestantes = new ArrayList<Integer>();

	public static Integer alumnos = Ejercicio1.getNAlumnos();
	public static Integer grupos = Ejercicio1.getNGrupos();
	public static Integer reparto = alumnos / grupos;

	public static VerticeAlumno of(int indice, List<Integer> plazasRestantes) {
		return new VerticeAlumno(indice, plazasRestantes);
	}

	public VerticeAlumno(int indice, List<Integer> plazasRestantes) {
		super();
		List<Integer> plazasRestantesFinal = new ArrayList<Integer>();
		for (int i = 0; i < grupos; i++) {
			plazasRestantesFinal.add(0);
		}
		this.indice = indice;
		if (indice < alumnos) {
			this.plazasRestantes = plazasRestantes;
		} else {
			this.plazasRestantes = plazasRestantesFinal;
		}
	}

	public static VerticeAlumno initialVertex() {
		List<Integer> plazasRestantesInicial = new ArrayList<Integer>();
		for (int i = 0; i < grupos; i++) {
			plazasRestantesInicial.add(reparto);
		}
		return of(0, plazasRestantesInicial);
	}

	public static VerticeAlumno copy(VerticeAlumno grupos) {
		return of(grupos.indice, grupos.plazasRestantes);
	}

	public static VerticeAlumno lastVertex() {
		List<Integer> plazasRestantesFinal = new ArrayList<Integer>();
		for (int i = 0; i < grupos; i++) {
			plazasRestantesFinal.add(0);
		}
		return of(alumnos, plazasRestantesFinal);
	}

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
		List<Integer> res = new ArrayList<Integer>();
		for (int a = 0; a < grupos; a++) {
			if (plazasRestantes.get(a) > 0 && Ejercicio1.getAfinidadPorIndice(indice, a) > 0) {
				res.add(a);
			}
		}
		return res;
	}

	@Override
	public VerticeAlumno neighbor(Integer a) {
		int i = indice + 1;
		List<Integer> list = new ArrayList<>(plazasRestantes);
		list.set(a, (this.plazasRestantes.get(a) - 1));
		return of(i, list);
	}

	public static Predicate<VerticeAlumno> goal() {
		return (VerticeAlumno v) -> v.indice == VerticeAlumno.alumnos;
	}

	@Override
	public AristaAlumno edge(Integer a) {
		VerticeAlumno v = this.neighbor(a);
		return AristaAlumno.of(this, v, a);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((indice == null) ? 0 : indice.hashCode());
		result = prime * result + ((plazasRestantes == null) ? 0 : plazasRestantes.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "VerticeAlumno [indice=" + indice + ", plazasRestantes=" + plazasRestantes + ", alumnos=" + alumnos + ", grupos=" + grupos + ", reparto=" + reparto + "]";
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

//	// GETTERS DE LA CLASE
//	
	// Devuelve el índice del vértice:
	public Integer getIndice() {
		
		return indice;
		
	}
	
	// Devuelve la lista de plazas del vértice:
	public List<Integer> getPlazasRestantes() {
		
		return plazasRestantes;
		
	}
	
}
