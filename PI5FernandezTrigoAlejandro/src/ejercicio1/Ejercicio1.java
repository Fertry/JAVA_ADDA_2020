/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.vertexcover.GreedyVCImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.Attribute;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.colors.GraphColors.Style;
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

		// Se han creado dos clases adicionales: Persona y Relacion, para representar los vértices y las
		// aristas respectivamente. Se emplea simpleWeightedGraph usando como atributo para el peso, el Id. 
		// Esto último no es estrictamente necesario, se puede eliminar el atributo Id de la clase Relacion, 
		// y se escribiría como: Graph<Persona,Relacion> redSocial = GraphsReader.newGraph(
		// fichero, Persona::ofFormat, Relacion::ofFormat, Graphs2::simpleGraph). Es similar en cualquier caso. 
		Graph<Persona, Relacion> grafo = GraphsReader.newGraph(
				fichero,
				Persona::ofFormat,
				Relacion::ofFormat,
				Graphs2::simpleWeightedGraph,
				Relacion::getId);

		return grafo;

	}

	/*
	 * Apartado A.1): Devuelve un conjunto con los nodos/vértices que NO tienen
	 * ninguna conexión con otro (esto es, no tienen amigos).
	 */
	private static Set<String> ejercicio1A1(Graph<Persona, Relacion> grafo) {

		Set<String> resultado = new HashSet<>();
		
		// Recorremos todos los vértices del grafo:
		for (Persona persona : grafo.vertexSet()) {
			
			// Si el grado del vértice es 0, esto es, ninguna arista le conecta:
			if (grafo.degreeOf(persona) == 0) {
				
				resultado.add(persona.getNombre());
				
			}
		}

		return resultado;

	}

	/*
	 * Apartado A.2): Devuelve un conjunto con los nodos/vértices que SI tienen
	 * alguna conexión con otro (esto es, tienen algún amigo). Para ello, calculamos 
	 * primero el nº máximo de amigos y luego usamos ese nº para buscar los vértices requeridos.
	 */
	private static Set<String> ejercicio1A2(Graph<Persona, Relacion> grafo, Integer maximo) {

		Set<String> resultado = new HashSet<>();
		
		// Recorremos el grafo vértice a vértice:
		for (Persona persona : grafo.vertexSet()) {
			
			// Si el grado del vértice seleccionado coincide con el nº max. de amigos:
			if (grafo.degreeOf(persona) == maximo) {
				
				resultado.add(persona.getNombre());
				
			}
		}

		return resultado;

	}
	
	/*
	 * Método auxiliar que dado un grafo, calcula el nº máximo de amigos, siendo este
	 * el grado de los vértices. Recorre todos los vértices (persona) comparando su nº.
	 */
	private static Integer maximo(Graph<Persona, Relacion> grafo) {
		
		int maximo = 0;
		
		// Recorremos el grafo vértice a vértice:
		for (Persona persona : grafo.vertexSet()) {
			
			// Buscamos el max. nº de amigos:
			if (grafo.degreeOf(persona) > maximo) {
				
				maximo = grafo.degreeOf(persona);
				
			}
		}
		
		return maximo;
		
	}

	/*
	 * Apartado A.3): Muestra el grafo generado en los apartados A.1 y A.2 coloreado
	 * de forma distinta. Emplea el método auxiliar colorearA() para obtener los colores 
	 * de un mapa generado en base a las condiciones del ejercicio. 
	 */
	private static void ejercicio1A3(Graph<Persona, Relacion> grafo) {

		Graphs2.toDot(
				grafo, 																			// Grafo de entrada
				"salida/salidaEjercicio1A.gv",													// Ruta de salida de fichero
				v -> v.getNombre() + " (" + grafo.degreeOf(v) + " amigos)",						// Valor de vértices, editado para mostrar el grado (nº de amigos)
				e -> "",																		// Valor de las aristas en blanco
				v -> colorearA(v, ejercicio1A1(grafo), ejercicio1A2(grafo, maximo(grafo))),		// Coloreado usando un mapa devuelto por la func. colorearA() en base a las funciones ejercicio1A1() y ejercicio1A2()
				e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo
		
	}
	
	/*
	 * Método auxiliar para, dado un vértice de entrada, un set de Personas sin amigos y un set de Personas 
	 * con más amigos, devueltos por los métodos previamente desarrollados, asignar colores a cada vértice por 
	 * separado. Se usa este método al tratarse de una selección de 3 o más colores que no permite hacerlo con getColorIf().
	 */
	private static Map<String, Attribute> colorearA(Persona persona, Set<String> ceroAmigos, Set<String> masAmigos) {
		
		// Si el vértice persona está en el conjunto con cero amigos:
		if (ceroAmigos.contains(persona.getNombre())) {
			
			return GraphColors.getColor(GraphColors.Color.gray);
			
		// Si el vértice persona está en el conjunto con más amigos:
		} else if (masAmigos.contains(persona.getNombre())) {
			
			return GraphColors.getColor(GraphColors.Color.green);
			
		// En otro caso:
		} else {
			
			return GraphColors.getColor(GraphColors.Color.black);
			
		}
	
	}

	/*
	 * Apartado B.1): Devuelve una lista con el camino mas corto que existe desde un
	 * miembro (Persona) a otro. Emplea el tipo DijkstraShortestPath<> de JGraph dado
	 * el grafo para calcular el camino más corto entre dos Personas dadas. 
	 */
	private static List<Persona> ejercicio1B1(Graph<Persona, Relacion> grafo, String persona1, String persona2) {

		// Objeto DijkstraShortestPath<> para el grafo:
		ShortestPathAlgorithm<Persona, Relacion> camino = new DijkstraShortestPath<Persona, Relacion>(grafo);
		
		// Para que el método sea reutilizable y no restringido a dos personas fijas, dado los dos nombres
		// empleo el método personaPorNombre() que busca en el grafo una Persona dado un nombre por parámetro:
		Persona origen = personaPorNombre(grafo, persona1);
		Persona destino = personaPorNombre(grafo, persona2);
		
		// Si se han encontrado a la persona1 y persona2, se devuelve la lista del camino mínimo; 
		// de lo contrario, se devuelve la lista vacía:
		if (origen == null || destino == null) {
			
			List<Persona> resultado = new ArrayList<>();
			return resultado;
		
		} else {
			
			return camino.getPath(origen, destino).getVertexList();
			
		}
		
	}
	
	private static Persona personaPorNombre(Graph<Persona, Relacion> grafo, String nombre) {

		Persona resultado = null;
		
		for (Persona persona : grafo.vertexSet()) {
			
			if (persona.getNombre().equals(nombre)) {
				
				resultado = persona;
				
			}
		}
		
		return resultado;
		
	}
		
	/*
	 * Apartado B.2): Muestra el grafo coloreando la lista mas corta devuelta por el
	 * método anterior que calcula el camino más corto entre miembros.
	 */
	private static void ejercicio1B2(Graph<Persona, Relacion> grafo, String persona1, String persona2) {
		
		Graphs2.toDot(
				grafo, 																			// Grafo de entrada
				"salida/salidaEjercicio1B.gv",													// Ruta de salida de fichero
				v -> v.getNombre() + " (" + grafo.degreeOf(v) + " amigos)",						// Valor de vértices, editado para mostrar el grado (nº de amigos)
				e -> "",																		// Valor de las aristas en blanco
				v -> GraphColors.getColorIf(													// Coloreado del grafo usando el método getColorIf basandose en el booleano
						GraphColors.Color.green,												// devuelto por el método anterior.
						GraphColors.Color.black,												// Si el vértice está en la lista devuelta por ejercicio1B1()
						ejercicio1B1(grafo, persona1, persona2).contains(v)),					// se pinta verde, de lo contrario, en negro.
				e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo
		
	}

	/*
	 * Apartado C.1): Devuelve los grupos existentes entre nodos/vértices del grafo
	 * (siendo estos aquellos miembros (Personas) que están unidos directamente por
	 * una arista o conectados mediante vértices intermedios). Se emplea el tipo 
	 * ConnectivityInspector<> de JGraph para devolver una lista con todos los grupos
	 * (Sets<>) de Personas. 
	 */
	private static void ejercicio1C1(Graph<Persona, Relacion> grafo) {

		// Método connectedSets() del objeto ConnectivityInspector<> para el grafo:
		List<Set<Persona>> conjuntos = new ConnectivityInspector<>(grafo).connectedSets();
		
		/*
		 * Para el coloreado creo un mapa en el que asocio enteros a colores de forma que pueda
		 * colorear tantos grupos como haya en el grafo, y de esta forma el método sea más reutilizable.
		 * Teniendo en cuenta eso sí, que solo hay disponibles 9 colores en el enumerado de la librería.
		 * PD: en realidad son 10 pero blank es nulo así que no lo tengo en cuenta.
		 */		
		Map<Integer, Color> mapaDeColores = new HashMap<Integer, Color>();
		mapaDeColores.put(0, GraphColors.Color.green);		
		mapaDeColores.put(1, GraphColors.Color.red);		
		mapaDeColores.put(2, GraphColors.Color.yellow);	
		mapaDeColores.put(3, GraphColors.Color.gray);	
		mapaDeColores.put(4, GraphColors.Color.cyan);		
		mapaDeColores.put(5, GraphColors.Color.orange);
		mapaDeColores.put(6, GraphColors.Color.magenta);
		mapaDeColores.put(7, GraphColors.Color.blue);
		mapaDeColores.put(8, GraphColors.Color.black);
		
		/*
		 * Creo un iterador, calculo el nº de conjuntos que existen y creo un mapa 
		 * para asociar a cada persona un nº que representará el color.
		 */
		int i = 0;
		Integer numeroDeConjuntos = conjuntos.size();
		Map<Persona, Integer> personasColoreadas = new HashMap<Persona, Integer>();
		
		/*
		 * Recorriendo el Set<Persona>, por cada set mostramos el grupo (osea, el Set), y le asociamos 
		 * un color gracias a mapaDeColores(i) además de actualizar el mapa de personasColoreadas que 
		 * guarda a cada Persona junto a su nº para luego poder colorearlos mediante el toDot(). 
		 */
		System.out.println(" Existen " + numeroDeConjuntos + " grupos. Su composición es: ");
		for (Set<Persona> set : conjuntos) {
			
			for (Persona persona : set) {
				
				personasColoreadas.put(persona, i);
				
			}
			
			System.out.println(" Grupo " + mapaDeColores.get(i) + " (" + set.size() + " usuario)");
			System.out.println(set);
			i++; 
			
		}
		
		// Muestra el grafo coloreando cada grupo de miembros resultante del calculo anterior con un color distinto:
		Graphs2.toDot(
			grafo, 																			// Grafo de entrada
			"salida/salidaEjercicio1C.gv",													// Ruta de salida de fichero
			v -> v.getNombre(),																// Valor de vértices: su nombre
			e -> "",																		// Valor de las aristas en blanco
			v -> GraphColors.getColor(colorearC(mapaDeColores, personasColoreadas, v)),		// Llamada al método colorearC() que devuelve un tipo Color en base al nº asociado a ese vértice
			e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo

	}
	
	/*
	 * Método auxiliar para colorear cada vértice (Personas) de forma que todas las personas que pertenezcan al mismo grupo
	 * tengan el mismo color. Para ello se dispone de dos mapas que guardan los colores asociados a un nº y las personas
	 * ya con su nº asociado. 
	 */
	private static Color colorearC(Map<Integer, Color> mapaDeColores, Map<Persona, Integer> personasColoreadas, Persona persona) {
		
		// Obtener el nº asociado a la persona del mapa que guarda todas las personas con su nº color:
		Integer nColor = personasColoreadas.get(persona);
		
		// Obtener el color asociado al nº anterior del mapa que guarda los colores asociados a un nº:
		Color color = mapaDeColores.get(nColor);
		
		return color;
		
	}

	/*
	 * Apartado D.1): Devuelve los nodos/vértices seleccionados de forma que todas
	 * las relaciones de amistad (Relacion) esten cubiertas. Esto es, se seleccione
	 * al menos un nodo/vértice (Persona) de cada par de amigos.
	 * Se emplea el método getVertexCover() del tipo GreedyVImpl<> para obtener los
	 * vértices de menor recubrimiento; esto es, aquellos que permiten conectar todo
	 * el grafo con el menor nº de aristas.
	 */
	private static Set<Persona> ejercicio1D1(Graph<Persona, Relacion> grafo) {

		// Método getVertexCover() del objeto GreedyVCImpl<> para el grafo:
		Set<Persona> vertices = new GreedyVCImpl<>(grafo).getVertexCover();
		
		return vertices;
	
	}

	/*
	 * Apartado D.2): Muestra el grafo coloreando cada miembro (Persona)
	 * seleccionado por el método ejercicio1D1().
	 */
	private static void ejercicio1D2(Graph<Persona, Relacion> grafo, Set<Persona> conjunto) {

		Graphs2.toDot(
				grafo, 																			// Grafo de entrada
				"salida/salidaEjercicio1D.gv",													// Ruta de salida de fichero
				v -> v.getNombre(),																// Valor de vértices: su nombre
				e -> "",																		// Valor de las aristas en blanco
				v -> GraphColors.getColorIf(													// Coloreado en base el booleano 
						GraphColors.Color.green,												// devuelto por el contains(v) que 
						GraphColors.Color.black,												// comprueba si el vertice está en el
						conjunto.contains(v)),												    // conjunto que devuelve el método ejercicio1D1()
				e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo
		
	}
	
	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio1(String fichero) {

		// Lectura de datos de entrada y generación del grafo:
		Graph<Persona, Relacion> grafo = lecturaDatosEjercicio1(fichero);

		System.out.println("Apartado A). - Nº de amigos");
		 System.out.println(" Los miembros con cero amigos son: " + ejercicio1A1(grafo));
		 System.out.println(" Los miembros con más amigos (" + maximo(grafo) + ") son: " + ejercicio1A2(grafo, maximo(grafo)));
		 System.out.println(" Salida volcada en fichero salidaEjercicio1A.gv");
		 ejercicio1A3(grafo);
		 System.out.println("");
	    System.out.println("Apartado B). - Lista más corta");
	     System.out.println(" La lista más corta entre Juan y Ramiro es: " + ejercicio1B1(grafo, "Juan", "Ramiro"));
		 System.out.println(" Salida volcada en fichero salidaEjercicio1B.gv");
		 ejercicio1B2(grafo, "Juan", "Ramiro");
		 System.out.println("");
		System.out.println("Apartado C). - Grupos de amigos");
		 ejercicio1C1(grafo);
		 System.out.println(" Salida volcada en fichero salidaEjercicio1C.gv");
		 System.out.println("");
		System.out.println("Apartado D). - Cuestionarios a grupos");
		 System.out.println(" Se enviarán " + ejercicio1D1(grafo).size() + " cuestionarios a los siguientes miembros: " + ejercicio1D1(grafo));
		 ejercicio1D2(grafo, ejercicio1D1(grafo));
		 System.out.println(" Salida volcada en fichero salidaEjercicio1D.gv");
		 System.out.println("");
		  
	}

}
