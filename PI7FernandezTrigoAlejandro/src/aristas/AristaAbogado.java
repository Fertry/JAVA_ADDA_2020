/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package aristas;

import us.lsi.graphs.virtual.ActionSimpleEdge;
import vertices.VerticeAbogado;

/*
 * Clase arista abogado para representar aristas del grafo de un tipo definido.
*/
public class AristaAbogado extends ActionSimpleEdge<VerticeAbogado, Integer> {

	public static AristaAbogado of(VerticeAbogado v1, VerticeAbogado v2, Integer a) {
		return new AristaAbogado(v1, v2, a);
	}

	public Integer a;

	private AristaAbogado(VerticeAbogado v1, VerticeAbogado v2, Integer a) {
		super(v1, v2);
		this.a = a;
		super.weight = null;
	}

	@Override
	public String toString() {
		
		return null;
		
	}
}