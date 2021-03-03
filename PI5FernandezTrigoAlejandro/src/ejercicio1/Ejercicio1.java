/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio1;

import java.util.Set;

import org.jgrapht.Graph;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

/*
Una red social imaginaria y peque�a, se representa con un grafo en el que los v�rtices
modelan a los miembros de la red y las aristas (sin etiqueta ni peso) modelan la
amistad entre dos miembros. Desarrolle:

a. Un m�todo que devuelva un conjunto con aquellos miembros que no tengan
ning�n amigo, y otro m�todo que devuelva un conjunto con aquellos
miembros que tienen el mayor n�mero de amigos. Muestre el grafo
configurando su apariencia de forma que se resalten de un color los miembros
que no tienen ning�n amigo, y de otro color los que tienen el mayor n�mero
de amigos.

b. Un m�todo que, dados dos miembros, devuelva la lista m�s corta de amigos
que hay desde un miembro a otro miembro. Muestre el grafo configurando su
apariencia de forma que se resalte la lista m�s corta de amigos que hay desde
un miembro a otro miembro.

c. Determine cu�ntos grupos de miembros hay y cu�l es su composici�n. 2
miembros pertenecen al mismo grupo si est�n relacionados directamente entre
s� o si existen algunos miembros intermedios que los relacionan. Muestre el
grafo configurando su apariencia de forma que se coloree cada grupo de un
color diferente.

d. Se han dise�ado unos cuestionarios a ser cumplimentados por los miembros
de la red sobre las relaciones de amistad. Se desea enviar dichos cuestionarios
a un conjunto seleccionado de miembros tales que: todas las relaciones de
amistad est�n representadas (una relaci�n de amistad est� representada por
alguno de sus 2 miembros), se minimice el n�mero de cuestionarios a enviar
(es decir, el n�mero de miembros seleccionados). Muestre el grafo
configurando su apariencia de forma que se coloreen los miembros
seleccionados.
*/

public class Ejercicio1 {

	/*
	 * Lectura de datos; devuelve un grafo de tipo <Persona, Relacion> siendo estos
	 * clases definidas para nodos/v�rtices (usuarios) y aristas (conexiones).
	 */
	private static Graph<Persona, Relacion> lecturaDatosEjercicio1(String fichero) {

		Graph<Persona, Relacion> redSocial = GraphsReader.newGraph(
				fichero,
				Persona::ofFormat,
				Relacion::ofFormat,
				Graphs2::simpleWeightedGraph,
				Relacion::getId);

		return redSocial;

	}

	/*
	 * Cambiando en la clase el atributo id por entero y eliminando el getter de Id,
	 * se escribe como: Graph<Persona,Relacion> redSocial = GraphsReader.newGraph(
	 * fichero, Persona::ofFormat, Relacion::ofFormat, Graphs2::simpleGraph);
	 */

	/*
	 * Apartado A.1): Devuelve un conjunto con los nodos/v�rtices que NO tienen
	 * ninguna conexi�n con otro (esto es, no tienen amigos).
	 */
	private static Set<Graph<Persona, Relacion>> ejercicio1A1(Graph<Persona, Relacion> grafo) {

		Set<Graph<Persona, Relacion>> resultado = null;

		return resultado;

	}

	/*
	 * Apartado A.2): Devuelve un conjunto con los nodos/v�rtices que SI tienen
	 * alguna conexi�n con otro (esto es, tienen alg�n amigo).
	 */
	private static Set<Graph<Persona, Relacion>> ejercicio1A2(Graph<Persona, Relacion> grafo) {

		Set<Graph<Persona, Relacion>> resultado = null;

		return resultado;

	}

	/*
	 * Apartado A.3): Muestra el grafo generado en los apartados A.1 y A.2 coloreado
	 * de forma distinta.
	 */
	private static void ejercicio1A(Graph<Persona, Relacion> grafo) {

		Set<Graph<Persona, Relacion>> sinAmigos = ejercicio1A1(grafo);
		Set<Graph<Persona, Relacion>> conAmigos = ejercicio1A2(grafo);

	}

	/*
	 * Apartado B.1): Devuelve una lista con el camino mas corto que existe desde un
	 * miembro (Persona) a otro.
	 */
	private static void ejercicio1B1(Graph<Persona, Relacion> grafo) {

	}

	/*
	 * Apartado B.2): Muestra el grafo coloreando la lista mas corta devuelta por el
	 * m�todo anterior que calcula el camino m�s corto entre miembros.
	 */
	private static void ejercicio1B2(Graph<Persona, Relacion> grafo) {

	}

	/*
	 * Apartado C.1): Devuelve los grupos existentes entre nodos/v�rtices del grafo
	 * (siendo estos aquellos miembros (Personas) que est�n unidos directamente por
	 * una arista o conectados mediante v�rtices intermedios).
	 */
	private static void ejercicio1C1(Graph<Persona, Relacion> grafo) {

	}

	/*
	 * Apartado C.2): Muestra el grafo coloreando cada grupo de miembros resultante
	 * de la funci�n calculaMiembros() de un color distinto.
	 */
	private static void ejercicio1C2(Graph<Persona, Relacion> grafo) {

	}

	/*
	 * Apartado D.1): Devuelve los nodos/v�rtices seleccionados de forma que todas
	 * las relaciones de amistad (Relacion) esten cubiertas. Esto es, se seleccione
	 * al menos un nodo/v�rtice (Persona) de cada par de amigos.
	 */
	private static void ejercicio1D1(Graph<Persona, Relacion> grafo) {

	}

	/*
	 * Apartado D.2): Muestra el grafo coloreando cada miembro (Persona)
	 * seleccionado por el m�todo seleccionaNodos().
	 */
	private static void ejercicio1D2(Graph<Persona, Relacion> grafo) {

	}
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio1(String fichero) {

		System.out.println("Red social (grafo de entrada): ");
		Graph<Persona, Relacion> grafo = lecturaDatosEjercicio1(fichero);
		System.out.println(grafo);
		Graphs2.toDot(grafo, "salida/salidaEjercicio1.gv");
		
	}

}
