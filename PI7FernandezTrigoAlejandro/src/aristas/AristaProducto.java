/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package aristas;

import us.lsi.graphs.virtual.ActionSimpleEdge;
import vertices.VerticeProducto;

/*
 * Clase arista producto para representar aristas del grafo de un tipo definido.
*/
public class AristaProducto extends ActionSimpleEdge<VerticeProducto, Integer> {

	public static AristaProducto of(VerticeProducto v1, VerticeProducto v2, Integer a) {
		return new AristaProducto(v1, v2, a);
	}

	public Integer a;

	private AristaProducto(VerticeProducto v1, VerticeProducto v2, Integer a) {
		super(v1, v2);
		this.a = a;
		super.weight = null;
	}

	@Override
	public String toString() {
		
		return null;
		
	}
}
