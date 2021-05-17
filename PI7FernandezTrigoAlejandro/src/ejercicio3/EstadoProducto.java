/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio3;

import java.util.ArrayList;
import java.util.List;

import us.lsi.alg.mochila.MochilaEdge;
import us.lsi.alg.mochila.MochilaVertex;
import us.lsi.common.Lists2;
import vertices.VerticeProducto;

/*
 * Objeto único que recorre los vértices del grafo virtual. Guarda la información del vértice, el valor acumulado de la 
 * función objetivo así cómo la lista de acciones tomadas. 
*/

public class EstadoProducto {

	// MÉTODOS DE LA CLASE
	public static EstadoProducto inicial() {
		
		return new EstadoProducto(VerticeProducto.verticeInicial(), 0, new ArrayList<Integer>());
		
	}
	
	public static EstadoProducto of(VerticeProducto vertice, Integer valorAcumulado, List<Integer> acciones) {
		
		return new EstadoProducto(vertice, valorAcumulado, acciones);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	public List<Integer> acciones;
	public Integer valorAcumulado;
	public VerticeProducto vertice;
	
	// CONSTRUCTORES DE LA CLASE
	private EstadoProducto(VerticeProducto vertice, Integer valorAcumulado, List<Integer> acciones) {
		
		super();
		
		this.vertice = vertice;
		this.acciones = acciones;
		this.valorAcumulado = valorAcumulado;
		
	}
	
	// GETTERS DE LA CLASE
	
	// Devuelve el vértice:
	public VerticeProducto getVertice() {
		
		return vertice;
		
	}
	
	// Devuelve el valor acumulado:
	public Integer getValorAcumulado() {
		
		return valorAcumulado;
		
	}
	
	// Devuelve la lista de acciones:
	public List<Integer> getAcciones() {
		
		return acciones;
		
	}
	
	// MÉTODOS PARA TRABAJAR CON BACKTRACKING
	
	// Método para avanzar en el grafo virtual:
	public static void avanza(Integer accion) {
		
		VerticeProducto old = this.vertice;
		this.vertex = this.vertex.neighbor(a);
		this.alternativas.add(a);
		this.valorAcumulado += MochilaEdge.of(old,this.vertex, a).weight.intValue();
		
	}
	
	// Método para retroceder en el grafo virtual:
	public static void retrocede(Integer accion) {
		
		VerticeProducto old = this.vertex;
		Integer index = this.vertex.index;
		Integer capacidadRestante = this.vertex.capacidadRestante;
		this.vertex = VerticeProducto.of(index, capacidadRestante);
		Lists2.removeLast(this.alternativas);
		this.valorAcumulado -= MochilaEdge.of(this.vertex,old, a).weight.intValue();
		
	}
	
	// TO_STRING DE LA CLASE (Sólo para debug)
	@Override
	public String toString() {
		
		return "[acciones=" + acciones + ", valorAcumulado=" + valorAcumulado + ", vertice=" + vertice + "]";
		
	}
	
}
