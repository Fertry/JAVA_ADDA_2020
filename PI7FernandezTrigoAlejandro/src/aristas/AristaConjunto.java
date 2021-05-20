/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package aristas;

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
		// PESO DE LA ARISTA: a==0?1:0
		this.weight = (accion == 0) ? 1.0 : 0.0;
		
	}

	// TO_STRING DE LA CLASE (source/target pertenecen a la superclase)
	@Override
	public String toString() {
		
		return "(" + this.source.getIndice() + ", " + accion + ")";
		
	}
	
}
