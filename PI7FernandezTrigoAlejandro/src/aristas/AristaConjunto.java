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

	protected AristaConjunto(VerticeConjunto c1, VerticeConjunto c2) {
		super(c1, c2);
		// TODO Auto-generated constructor stub
	}

}
