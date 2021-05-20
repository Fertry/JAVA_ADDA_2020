/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package aristas;

import ejercicio3.Ejercicio3;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import vertices.VerticeProducto;

/*
 * Clase arista producto para representar aristas del grafo de un tipo definido.
*/
public class AristaProducto extends ActionSimpleEdge<VerticeProducto, Integer> {

	// MÉTODOS DE LA CLASE
	public static AristaProducto of(VerticeProducto origen, VerticeProducto destino, Integer accion) {
		
		return new AristaProducto(origen, destino, accion);
		
	}

	// ATRIBUTOS DE LA CLASE
	private Integer accion;

	// CONSTRUCTORES DE LA CLASE (heredado de la superclase)
	private AristaProducto(VerticeProducto origen, VerticeProducto destino, Integer accion) {
		
		super(origen, destino);
		
		this.accion = accion;
		// PESO DE LA ARISTA: a * pi
		this.weight = Ejercicio3.getPrecio(origen.getIndice()) * accion;
		
	}

	// TO_STRING DE LA CLASE (source/target pertenecen a la superclase)
	@Override
	public String toString() {
		
		return "(" + this.source.getIndice() + ", " + accion + ")";
		
	}
	
}
