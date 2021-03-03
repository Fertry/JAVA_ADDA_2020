/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio1;

import java.util.Set;

import org.jgrapht.Graph;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

/*
Una red social imaginaria y pequeña, se representa con un grafo en el que los vértices
modelan a los miembros de la red y las aristas (sin etiqueta ni peso) modelan la
amistad entre dos miembros. Desarrolle:

a. Un método que devuelva un conjunto con aquellos miembros que no tengan
ningún amigo, y otro método que devuelva un conjunto con aquellos
miembros que tienen el mayor número de amigos. Muestre el grafo
configurando su apariencia de forma que se resalten de un color los miembros
que no tienen ningún amigo, y de otro color los que tienen el mayor número
de amigos.

b. Un método que, dados dos miembros, devuelva la lista más corta de amigos
que hay desde un miembro a otro miembro. Muestre el grafo configurando su
apariencia de forma que se resalte la lista más corta de amigos que hay desde
un miembro a otro miembro.

c. Determine cuántos grupos de miembros hay y cuál es su composición. 2
miembros pertenecen al mismo grupo si están relacionados directamente entre
sí o si existen algunos miembros intermedios que los relacionan. Muestre el
grafo configurando su apariencia de forma que se coloree cada grupo de un
color diferente.

d. Se han diseñado unos cuestionarios a ser cumplimentados por los miembros
de la red sobre las relaciones de amistad. Se desea enviar dichos cuestionarios
a un conjunto seleccionado de miembros tales que: todas las relaciones de
amistad estén representadas (una relación de amistad está representada por
alguno de sus 2 miembros), se minimice el número de cuestionarios a enviar
(es decir, el número de miembros seleccionados). Muestre el grafo
configurando su apariencia de forma que se coloreen los miembros
seleccionados.
*/

public class Ejercicio1 {

	/*
	 * Lectura de datos; devuelve un grafo de tipo <Persona, Relacion> siendo estos
	 * clases definidas para nodos/vértices (usuarios) y aristas (conexiones).
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
	 * Apartado A.1): Devuelve un conjunto con los nodos/vértices que NO tienen
	 * ninguna conexión con otro (esto es, no tienen amigos).
	 */
	private static Set<Graph<Persona, Relacion>> ejercicio1A1(Graph<Persona, Relacion> grafo) {

		Set<Graph<Persona, Relacion>> resultado = null;

		return resultado;

	}

	/*
	 * Apartado A.2): Devuelve un conjunto con los nodos/vértices que SI tienen
	 * alguna conexión con otro (esto es, tienen algún amigo).
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
	 * método anterior que calcula el camino más corto entre miembros.
	 */
	private static void ejercicio1B2(Graph<Persona, Relacion> grafo) {

	}

	/*
	 * Apartado C.1): Devuelve los grupos existentes entre nodos/vértices del grafo
	 * (siendo estos aquellos miembros (Personas) que están unidos directamente por
	 * una arista o conectados mediante vértices intermedios).
	 */
	private static void ejercicio1C1(Graph<Persona, Relacion> grafo) {

	}

	/*
	 * Apartado C.2): Muestra el grafo coloreando cada grupo de miembros resultante
	 * de la función calculaMiembros() de un color distinto.
	 */
	private static void ejercicio1C2(Graph<Persona, Relacion> grafo) {

	}

	/*
	 * Apartado D.1): Devuelve los nodos/vértices seleccionados de forma que todas
	 * las relaciones de amistad (Relacion) esten cubiertas. Esto es, se seleccione
	 * al menos un nodo/vértice (Persona) de cada par de amigos.
	 */
	private static void ejercicio1D1(Graph<Persona, Relacion> grafo) {

	}

	/*
	 * Apartado D.2): Muestra el grafo coloreando cada miembro (Persona)
	 * seleccionado por el método seleccionaNodos().
	 */
	private static void ejercicio1D2(Graph<Persona, Relacion> grafo) {

	}
	
	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio1(String fichero) {

		System.out.println("Red social (grafo de entrada): ");
		Graph<Persona, Relacion> grafo = lecturaDatosEjercicio1(fichero);
		System.out.println(grafo);
		Graphs2.toDot(grafo, "salida/salidaEjercicio1.gv");
		
	}

}
