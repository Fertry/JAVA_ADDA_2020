/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package aristas;

import ejercicio1.Ejercicio1;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import vertices.VerticeAlumno;

/*
 * Clase arista alumno para representar aristas del grafo de un tipo definido.
*/
public class AristaAlumno extends ActionSimpleEdge<VerticeAlumno, Integer> {

	// MÉTODOS DE LA CLASE
	public static AristaAlumno of(VerticeAlumno origen, VerticeAlumno destino, Integer accion) {
		
		return new AristaAlumno(origen, destino, accion);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	private Integer accion;

	// CONSTRUCTORES DE LA CLASE (heredado de la superclase)
	private AristaAlumno(VerticeAlumno origen, VerticeAlumno destino, Integer accion) {
		
		super(origen, destino);
		
		this.accion = accion;
		// PESO DE LA ARISTA: w = af(index,a)
		this.weight = (double) Ejercicio1.getAfinidadPorIndice(origen.getIndice(), accion);
		
	}

	// TO_STRING DE LA CLASE (Sólo para debug; source/target pertenecen a la superclase)
	@Override
	public String toString() {

		return "[Alumno origen: " + this.source.getIndice() + ", Alumno destino: " + this.target.getIndice() + ", con afinidad: " + this.getEdgeWeight() + ", Acción: " + accion + "]";
		
	}
	
}
