/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package aristas;

import ejercicio4.Ejercicio4;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import vertices.VerticeConjunto;

/*
 * Clase arista conjunto para representar aristas del grafo de un tipo definido.
*/
public class AristaConjunto extends ActionSimpleEdge<VerticeConjunto, Integer> {

	// MÉTODOS DE LA CLASE
	public static AristaConjunto of(VerticeConjunto origen, VerticeConjunto destino, Integer accion) {
		
		return new AristaConjunto(origen, destino, accion);
		
	}

	// ATRIBUTOS DE LA CLASE
	private Integer accion;

	// CONSTRUCTORES DE LA CLASE (heredado de la superclase)
	private AristaConjunto(VerticeConjunto origen, VerticeConjunto destino, Integer accion) {
		
		super(origen, destino);
		
		this.accion = accion;
		this.weight = (double) Ejercicio4.getSumatorio() * accion;
		
	}

	// TO_STRING DE LA CLASE (Sólo para debug; source/target pertenecen a la superclase)
	@Override
	public String toString() {
		
		return "[Conjunto origen: " + this.source.getIndice() + ", conjunto destino: " + this.target.getIndice() + ", con sumatorio: " + this.getEdgeWeight() + "]";
		
	}
	
}
