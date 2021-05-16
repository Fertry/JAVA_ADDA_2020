/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import ejercicio4.Ejercicio4;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase vértice conjunto para representar vértices del grafo de un tipo definido.
 * 
 * Interpretación: Encontrar a qué subconjunto pertenece cada elemento, desde indice hasta el final,
 * que minimice el número de elementos de uno de los subconjuntos.
*/
public class VerticeConjunto extends ActionVirtualVertex <VerticeConjunto, ActionSimpleEdge<VerticeConjunto, Integer>, Integer> {
	
	// MÉTODOS DE LA CLASE
	public static VerticeConjunto of(Integer indice, List<Integer> conjunto) {

		return new VerticeConjunto(indice, conjunto);

	}

	// ATRIBUTOS DE LA CLASE

	// Variables básicas:
	private Integer indice;
	private List<Integer> conjunto;

	// Variables compartidas (Extraidas de clase general donde se inicializan los datos):
	private static Integer elementos = Ejercicio4.getSizeConjunto();
	
	// CONSTRUCTORES DE LA CLASE
	public VerticeConjunto(Integer indice, List<Integer> conjunto) {
			
			super();
			
			this.indice = indice;
			this.conjunto = conjunto;
		
		}

	// GETTERS DE LA CLASE

	// Devuelve el índice del vértice:
	public Integer getIndice() {

		return indice;

	}
	
	// Devuelve la lista de elementos (conjunto):
	public List<Integer> getConjunto() {
		
		return conjunto;
		
	}

	// MÉTODOS PARA TRABAJAR CON GRAFOS VIRTUALES

	// Método que verifica si alcanzamos el objetivo o no: el índice alcanze el nº
	// de :
	public static Predicate<VerticeConjunto> objetivo() {

		return (VerticeConjunto vertice) -> vertice.getIndice() == VerticeConjunto.elementos;

	}

	// Definir un vértice de comienzo dónde todas sus plazas están "vacías",
	// esto es, sus capacidades son máximas (alumnos / grupos):
	public static VerticeConjunto verticeInicial() {

		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();

		while (i < elementos) {

			auxiliar.add(0);
			i++;

		}

		VerticeConjunto resultado = VerticeConjunto.of(0, auxiliar);
		return resultado;

	}

	// MÉTODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acción aplicada a un vértice (por
	// donde se desplaza):
	public ActionSimpleEdge<VerticeConjunto, Integer> edge(Integer accion) {

		ActionSimpleEdge<VerticeConjunto, Integer> resultado = ActionSimpleEdge.of(this, neighbor(accion), accion);

		return resultado;

	}

	@Override
	//
	public Boolean isValid() {

		Boolean valido = false;

		// Si NO es el vértice inicial NI el final:
		if (this.indice >= 0 && this.indice <= elementos) {

			valido = true;

		}
		
		return valido;

	}

	@Override
	// Devuelve el vértice "vecino" que corresponde a la acción tomada:
	public VerticeConjunto neighbor(Integer accion) {

		// 1º obtener el siguiente indice:
		Integer siguiente = this.indice + 1;

		VerticeConjunto resultado = VerticeConjunto.of(siguiente, this.conjunto);

		return resultado;

	}

	@Override
	// Devuelve la lista de acciones (movimientos en el grafo) posibles en base a
	// las restricciones:
	public List<Integer> actions() {

		List<Integer> acciones = new ArrayList<Integer>();

		return acciones;

	}

	// HASHCODE Y EQUALS DE LA CLASE EN BASE A INDICE Y CONJUNTO

	// TO_STRING DE LA CLASE
	@Override
	public String toString() {

		return this.conjunto + "\n";

	}
		
}
