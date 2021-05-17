/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import ejercicio3.Ejercicio3;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase v�rtice producto para representar v�rtices del grafo de un tipo definido.
 * 
 * Interpretaci�n: Encontrar la elecci�n adecuada de productos, desde indice hasta el final, que
 * minimicen el precio total y cubran todas las funcionalidades deseadas.
*/
public class VerticeProducto extends ActionVirtualVertex <VerticeProducto, ActionSimpleEdge<VerticeProducto, Integer>, Integer> {

	// M�TODOS DE LA CLASE
	public static VerticeProducto of(Integer indice, Set<Integer> plazasRestantes) {
		
		return new VerticeProducto(indice, plazasRestantes);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	
	// Variables b�sicas:
	private Integer indice;
	private Set<Integer> funcionalidadesPorCubrir;
	
	// Variables compartidas (Extraidas de clase general donde se inicializan los datos):
	private static Integer productos = Ejercicio3.getNProductos();
	private static Set<Integer> funcionalidadesDeseadas = Ejercicio3.getRequisitos();
	
	// CONSTRUCTORES DE LA CLASE
	public VerticeProducto(Integer indice, Set<Integer> funcionalidadesPorCubrir) {
		
		super();
		
		this.indice = indice;
		this.funcionalidadesPorCubrir = funcionalidadesPorCubrir;
	
	}
	
	// GETTERS DE LA CLASE

	// Devuelve el �ndice del v�rtice:
	public Integer getIndice() {
		
		return indice;
		
	}
	
	// Devuelve el Set<> de funcionalidades por cubrir:
	public Set<Integer> getFuncionalidadesPorCubrir() {
		
		return funcionalidadesPorCubrir;
		
	}
	
	// M�TODOS PARA TRABAJAR CON GRAFOS VIRTUALES
	
	// M�todo que verifica si alcanzamos el objetivo o no: el �ndice alcanze el n� de productos:
	public static Predicate<VerticeProducto> objetivo() {
		
		return (VerticeProducto vertice) -> vertice.getIndice() == VerticeProducto.productos;
		
	}
	
	// Definir un v�rtice de comienzo d�nde todas sus plazas est�n "vac�as",
	// esto es, sus capacidades son m�ximas (alumnos / grupos):
	public static VerticeProducto verticeInicial() {
				
		VerticeProducto resultado = VerticeProducto.of(0, funcionalidadesDeseadas);
		
		return resultado;
	
	}

	// M�todo para copiar v�rtices: devuelve una copia del v�rtice dado c�mo par�metro:
	// Tan solo es usado en Backtracking.
	public static VerticeProducto copiar(VerticeProducto vertice) {
		
		VerticeProducto resultado = VerticeProducto.of(vertice.indice, vertice.funcionalidadesPorCubrir);
		
		return resultado;
		
	}
	
	// M�TODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acci�n aplicada a un v�rtice (por donde se desplaza):
	public ActionSimpleEdge<VerticeProducto, Integer> edge(Integer accion) {
		
		ActionSimpleEdge<VerticeProducto, Integer> resultado = ActionSimpleEdge.of(this, neighbor(accion), accion);
		
		return resultado;
		
	}
	
	@Override
	// Comprueba la validez de un v�rtice dado, esto es: se encuentra dentro del intervalo cerrado [0, n]
	// y adem�s, cuenta con plazas disponibles para i, donde i >= 0 y i < m:
	public Boolean isValid() {
		
		Boolean valido = false;
		
		// Si NO es el v�rtice inicial NI el final:
		if (this.indice >= 0 && this.indice <= productos) {
			
			// Si el conjunto contiene las funcionalidades requeridas:
			if (funcionalidadesPorCubrir.containsAll(funcionalidadesDeseadas)) {
				
				valido = true;
				
			}
			
		}
	
		return valido;
	
	}
	
	@Override
	// Devuelve el v�rtice "vecino" que corresponde a la acci�n tomada:
	public VerticeProducto neighbor(Integer accion) {
		
		// 1� obtener el siguiente indice:
		Integer siguiente = this.indice + 1;

		// TO-DO
		
		VerticeProducto resultado = VerticeProducto.of(siguiente, this.funcionalidadesPorCubrir);
		
		return resultado;
		
	}

	@Override
	// Devuelve la lista de acciones (movimientos en el grafo) posibles en base a las restricciones:
	public List<Integer> actions() {
		
		List<Integer> acciones = new ArrayList<Integer>();
		
		// TO-DO
		
		return acciones;
			
	}

	// HASHCODE Y EQUALS DE LA CLASE EN BASE A INDICE Y FUNCIONALIDADES POR CUBRIR
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionalidadesPorCubrir == null) ? 0 : funcionalidadesPorCubrir.hashCode());
		result = prime * result + ((indice == null) ? 0 : indice.hashCode());
		return result;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VerticeProducto other = (VerticeProducto) obj;
		if (funcionalidadesPorCubrir == null) {
			if (other.funcionalidadesPorCubrir != null)
				return false;
		} else if (!funcionalidadesPorCubrir.equals(other.funcionalidadesPorCubrir))
			return false;
		if (indice == null) {
			if (other.indice != null)
				return false;
		} else if (!indice.equals(other.indice))
			return false;
		return true;
		
	}	

	// TO_STRING DE LA CLASE
	@Override
	public String toString() {
		
		return this.funcionalidadesPorCubrir + "\n";
		
	}
	
}
