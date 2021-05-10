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

	// ATRIBUTOS DE LA CLASE
	public Integer accion;
	
	// MÉTODOS DE LA CLASE
	public static AristaAlumno of(VerticeAlumno origen,  VerticeAlumno destino, Integer accion) {
		
		return new AristaAlumno(origen, destino, accion);
		
	}
	
	// CONSTRUCTORES DE LA CLASE (heredado de la superclase)
	private AristaAlumno(VerticeAlumno origen, VerticeAlumno destino, Integer accion) {
		
		super(origen, destino);
		
		// En base a la afinidad por alumno: 
		this.accion = accion;
		this.weight = (double) (accion * Ejercicio1.getAfinidadPorIndice(origen.getIndice(), accion));
		
	}
	
	// TO_STRING DE LA CLASE (Sólo para debug)
	@Override
	public String toString() {
		
		return "[Vertice: " + accion + "]";
		
	}

}
