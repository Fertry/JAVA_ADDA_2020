/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package aristas;

import ejercicio2.Ejercicio2;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import vertices.VerticeAbogado;

/*
 * Clase arista abogado para representar aristas del grafo de un tipo definido.
*/
public class AristaAbogado extends ActionSimpleEdge<VerticeAbogado, Integer> {

	// MÉTODOS DE LA CLASE
	public static AristaAbogado of(VerticeAbogado origen, VerticeAbogado destino, Integer accion) {
		
		return new AristaAbogado(origen, destino, accion);
		
	}

	// ATRIBUTOS DE LA CLASE
	private Integer accion;

	// CONSTRUCTORES DE LA CLASE (heredado de la superclase)
	private AristaAbogado(VerticeAbogado origen, VerticeAbogado destino, Integer accion) {
		
		super(origen, destino);
		
		this.accion = accion;
		this.weight = (double) Ejercicio2.tiempoPorIndice(origen.getIndice(), accion);
		
	}

	// TO_STRING DE LA CLASE (Sólo para debug; source/target pertenecen a la superclase)
	@Override
	public String toString() {
		
		return "[Abogado origen: " + this.source.getIndice() + ", Abogado destino: " + this.target.getIndice() + ", Caso: " + accion + ", con horas: " + this.getEdgeWeight() + "]";
		
	}
	
}