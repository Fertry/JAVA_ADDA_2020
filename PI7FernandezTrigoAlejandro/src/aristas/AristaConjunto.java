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

	public static AristaConjunto of(VerticeConjunto v1, VerticeConjunto v2, Integer a) {
		return new AristaConjunto(v1, v2, a);
	}

	public Integer a;

	private AristaConjunto(VerticeConjunto v1, VerticeConjunto v2, Integer a) {
		super(v1, v2);
		this.a = a;
		super.weight = null;
	}

	@Override
	public String toString() {
		
		return null;
		
	}
}
