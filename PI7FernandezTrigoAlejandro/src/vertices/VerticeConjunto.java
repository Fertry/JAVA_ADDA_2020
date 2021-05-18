/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import ejercicio2.Ejercicio2;
import ejercicio4.Ejercicio4;
import us.lsi.common.Lists2;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase v�rtice conjunto para representar v�rtices del grafo de un tipo definido.
 * 
 * Interpretaci�n: Encontrar a qu� subconjunto pertenece cada elemento, desde indice hasta el final,
 * que minimice el n�mero de elementos de uno de los subconjuntos.
*/
public class VerticeConjunto extends ActionVirtualVertex <VerticeConjunto, ActionSimpleEdge<VerticeConjunto, Integer>, Integer> {
	
	// M�TODOS DE LA CLASE
	public static VerticeConjunto of(Integer indice, List<Integer> conjunto) {

		return new VerticeConjunto(indice, conjunto);

	}

	// ATRIBUTOS DE LA CLASE

	// Variables b�sicas:
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

	// Devuelve el �ndice del v�rtice:
	public Integer getIndice() {

		return indice;

	}
	
	// Devuelve la lista de elementos (conjunto):
	public List<Integer> getConjunto() {
		
		return conjunto;
		
	}

	// M�TODOS PARA TRABAJAR CON GRAFOS VIRTUALES

	// M�todo que verifica si alcanzamos el objetivo o no: el �ndice alcanze el n� de elementos:
	public static Predicate<VerticeConjunto> objetivo() {

		return (VerticeConjunto vertice) -> vertice.getIndice() == VerticeConjunto.elementos;

	}

	// Definir un v�rtice de comienzo d�nde ...
	public static VerticeConjunto verticeInicial() {

		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();

		while (i < 3) {

			auxiliar.add(0);
			i++;

		}

		VerticeConjunto resultado = VerticeConjunto.of(0, auxiliar);
		return resultado;

	}

	// M�TODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acci�n aplicada a un v�rtice (por
	// donde se desplaza):
	public ActionSimpleEdge<VerticeConjunto, Integer> edge(Integer accion) {

		ActionSimpleEdge<VerticeConjunto, Integer> resultado = ActionSimpleEdge.of(this, neighbor(accion), accion);

		return resultado;

	}

	@Override
	//
	public Boolean isValid() {

		int i = 0;
		Boolean valido = false;

		// Si NO es el v�rtice inicial NI el final:
		if (this.indice >= 0 && this.indice <= elementos) {

			// Mientras que vr[i] >= 0: 
			while (i < 3) {
			
				if (this.conjunto.get(i) >= 0) {
					
					valido = true;
					
				}
			
				i++;
				
			}
			
		}
		
		return valido;

	}

	@Override
	// Devuelve el v�rtice "vecino" que corresponde a la acci�n tomada:
	// i+1,vr' donde vr'[a]=vr[a]-ei
	public VerticeConjunto neighbor(Integer accion) {

		// 1� obtener el siguiente indice:
		Integer siguiente = this.indice + 1;

		// 2� copiar el conjunto actual:
		List<Integer> auxiliar = this.conjunto;
		
		// 3� modificar el valor de auxiliar para el �ndice dado:
		auxiliar.set(accion, (this.conjunto.get(accion) - this.indice)); 

		VerticeConjunto resultado = VerticeConjunto.of(siguiente, auxiliar);

		return resultado;

	}

	@Override
	// Devuelve la lista de acciones (movimientos en el grafo) posibles en base a
	// las restricciones:
	public List<Integer> actions() {

		List<Integer> acciones = new ArrayList<Integer>();

		// Caso i = n-1:
		if (this.indice == elementos - 1) {
			
			// Caso vr[i] = 0, i != a, 
			if (this.conjunto.get(this.indice) == 0 && this.indice != accion) {
				
				
				
			} else {
				
				return Lists2.of();
				
			}
			
		} else {
			
			
		}
		
		return acciones;

	}

	// HASHCODE Y EQUALS DE LA CLASE EN BASE A INDICE Y CONJUNTO

	// TO_STRING DE LA CLASE
	@Override
	public String toString() {

		return this.conjunto + "\n";

	}
		
}
