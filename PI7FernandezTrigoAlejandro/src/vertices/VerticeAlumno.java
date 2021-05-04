/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.List;

import aristas.AristaAlumno;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase vértice alumno para representar vértices del grafo de un tipo definido.
*/
public abstract class VerticeAlumno extends ActionVirtualVertex <VerticeAlumno, AristaAlumno, Integer> {

	// ATRIBUTOS DE LA CLASE
	private final Integer id;
	private final Integer pl[];
	
	public static Integer grupos; 
	public static Integer alumnos;
	public static Integer reparto;
	
	// CONSTRUCTORES DE LA CLASE
	private VerticeAlumno() {
		
		
	}
	
	@Override
	public Boolean isValid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> actions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerticeAlumno neighbor(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AristaAlumno edge(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}


}
