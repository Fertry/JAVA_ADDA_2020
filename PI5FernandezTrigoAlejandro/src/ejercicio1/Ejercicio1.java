/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
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

		// Se han creado dos clases adicionales: Persona y Relacion, para representar los v�rtices y las
		// aristas respectivamente. Se emplea simpleWeightedGraph usando como atributo para el peso, el Id. 
		// Esto �ltimo no es estrictamente necesario, se puede eliminar el atributo Id de la clase Relacion, 
		// y se escribir�a como: Graph<Persona,Relacion> redSocial = GraphsReader.newGraph(
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
	 * Apartado A.1): Devuelve un conjunto con los nodos/v�rtices que NO tienen
	 * ninguna conexi�n con otro (esto es, no tienen amigos).
	 */
	private static Set<String> ejercicio1A1(Graph<Persona, Relacion> grafo) {

		Set<String> resultado = new HashSet<>();
		
		// Recorremos todos los v�rtices del grafo:
		for (Persona persona : grafo.vertexSet()) {
			
			// Si el grado del v�rtice es 0, esto es, ninguna arista le conecta:
			if (grafo.degreeOf(persona) == 0) {
				
				resultado.add(persona.getNombre());
				
			}
		}

		return resultado;

	}

	/*
	 * Apartado A.2): Devuelve un conjunto con los nodos/v�rtices que SI tienen
	 * alguna conexi�n con otro (esto es, tienen alg�n amigo). Para ello, calculamos 
	 * primero el n� m�ximo de amigos y luego usamos ese n� para buscar los v�rtices requeridos.
	 */
	private static Set<String> ejercicio1A2(Graph<Persona, Relacion> grafo, Integer maximo) {

		Set<String> resultado = new HashSet<>();
		
		// Recorremos el grafo v�rtice a v�rtice:
		for (Persona persona : grafo.vertexSet()) {
			
			// Si el grado del v�rtice seleccionado coincide con el n� max. de amigos:
			if (grafo.degreeOf(persona) == maximo) {
				
				resultado.add(persona.getNombre());
				
			}
		}

		return resultado;

	}
	
	/*
	 * M�todo auxiliar que dado un grafo, calcula el n� m�ximo de amigos, siendo este
	 * el grado de los v�rtices. Recorre todos los v�rtices (persona) comparando su n�.
	 */
	private static Integer maximo(Graph<Persona, Relacion> grafo) {
		
		int maximo = 0;
		
		// Recorremos el grafo v�rtice a v�rtice:
		for (Persona persona : grafo.vertexSet()) {
			
			// Buscamos el max. n� de amigos:
			if (grafo.degreeOf(persona) > maximo) {
				
				maximo = grafo.degreeOf(persona);
				
			}
		}
		
		return maximo;
		
	}

	/*
	 * Apartado A.3): Muestra el grafo generado en los apartados A.1 y A.2 coloreado
	 * de forma distinta. Emplea el m�todo auxiliar colorearA() para obtener los colores 
	 * de un mapa generado en base a las condiciones del ejercicio. 
	 */
	private static void ejercicio1A3(Graph<Persona, Relacion> grafo) {

		Graphs2.toDot(
				grafo, 																			// Grafo de entrada
				"salida/salidaEjercicio1A.gv",													// Ruta de salida de fichero
				v -> v.getNombre() + " (" + grafo.degreeOf(v) + " amigos)",						// Valor de v�rtices, editado para mostrar el grado (n� de amigos)
				e -> "",																		// Valor de las aristas en blanco
				v -> colorearA(v, ejercicio1A1(grafo), ejercicio1A2(grafo, maximo(grafo))),		// Coloreado usando un mapa devuelto por la func. colorearA() en base a las funciones ejercicio1A1() y ejercicio1A2()
				e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo
		
	}
	
	/*
	 * M�todo auxiliar para, dado un v�rtice de entrada, un set de Personas sin amigos y un set de Personas 
	 * con m�s amigos, devueltos por los m�todos previamente desarrollados, asignar colores a cada v�rtice por 
	 * separado. Se usa este m�todo al tratarse de una selecci�n de 3 o m�s colores que no permite hacerlo con getColorIf().
	 */
	private static Map<String, Attribute> colorearA(Persona persona, Set<String> ceroAmigos, Set<String> masAmigos) {
		
		// Si el v�rtice persona est� en el conjunto con cero amigos:
		if (ceroAmigos.contains(persona.getNombre())) {
			
			return GraphColors.getColor(GraphColors.Color.gray);
			
		// Si el v�rtice persona est� en el conjunto con m�s amigos:
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
	 * el grafo para calcular el camino m�s corto entre dos Personas dadas. 
	 */
	private static List<Persona> ejercicio1B1(Graph<Persona, Relacion> grafo, String persona1, String persona2) {

		// Objeto DijkstraShortestPath<> para el grafo:
		ShortestPathAlgorithm<Persona, Relacion> camino = new DijkstraShortestPath<Persona, Relacion>(grafo);
		
		// Para que el m�todo sea reutilizable y no restringido a dos personas fijas, dado los dos nombres
		// empleo el m�todo personaPorNombre() que busca en el grafo una Persona dado un nombre por par�metro:
		Persona origen = personaPorNombre(grafo, persona1);
		Persona destino = personaPorNombre(grafo, persona2);
		
		// Si se han encontrado a la persona1 y persona2, se devuelve la lista del camino m�nimo; 
		// de lo contrario, se devuelve la lista vac�a:
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
	 * m�todo anterior que calcula el camino m�s corto entre miembros.
	 */
	private static void ejercicio1B2(Graph<Persona, Relacion> grafo, String persona1, String persona2) {
		
		Graphs2.toDot(
				grafo, 																			// Grafo de entrada
				"salida/salidaEjercicio1B.gv",													// Ruta de salida de fichero
				v -> v.getNombre() + " (" + grafo.degreeOf(v) + " amigos)",						// Valor de v�rtices, editado para mostrar el grado (n� de amigos)
				e -> "",																		// Valor de las aristas en blanco
				v -> GraphColors.getColorIf(													// Coloreado del grafo usando el m�todo getColorIf basandose en el booleano
						GraphColors.Color.green,												// devuelto por el m�todo anterior.
						GraphColors.Color.black,												// Si el v�rtice est� en la lista devuelta por ejercicio1B1()
						ejercicio1B1(grafo, persona1, persona2).contains(v)),					// se pinta verde, de lo contrario, en negro.
				e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo
		
	}

	/*
	 * Apartado C.1): Devuelve los grupos existentes entre nodos/v�rtices del grafo
	 * (siendo estos aquellos miembros (Personas) que est�n unidos directamente por
	 * una arista o conectados mediante v�rtices intermedios). Se emplea el tipo 
	 * ConnectivityInspector<> de JGraph para devolver una lista con todos los grupos
	 * (Sets<>) de Personas. 
	 */
	private static void ejercicio1C1(Graph<Persona, Relacion> grafo) {

		// M�todo connectedSets() del objeto ConnectivityInspector<> para el grafo:
		List<Set<Persona>> conjuntos = new ConnectivityInspector<>(grafo).connectedSets();
		
		/*
		 * Para el coloreado creo un mapa en el que asocio enteros a colores de forma que pueda
		 * colorear tantos grupos como haya en el grafo, y de esta forma el m�todo sea m�s reutilizable.
		 * Teniendo en cuenta eso s�, que solo hay disponibles 9 colores en el enumerado de la librer�a.
		 * PD: en realidad son 10 pero blank es nulo as� que no lo tengo en cuenta.
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
		 * Creo un iterador, calculo el n� de conjuntos que existen y creo un mapa 
		 * para asociar a cada persona un n� que representar� el color.
		 */
		int i = 0;
		Integer numeroDeConjuntos = conjuntos.size();
		Map<Persona, Integer> personasColoreadas = new HashMap<Persona, Integer>();
		
		/*
		 * Recorriendo el Set<Persona>, por cada set mostramos el grupo (osea, el Set), y le asociamos 
		 * un color gracias a mapaDeColores(i) adem�s de actualizar el mapa de personasColoreadas que 
		 * guarda a cada Persona junto a su n� para luego poder colorearlos mediante el toDot(). 
		 */
		System.out.println(" Existen " + numeroDeConjuntos + " grupos. Su composici�n es: ");
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
			v -> v.getNombre(),																// Valor de v�rtices: su nombre
			e -> "",																		// Valor de las aristas en blanco
			v -> GraphColors.getColor(colorearC(mapaDeColores, personasColoreadas, v)),		// Llamada al m�todo colorearC() que devuelve un tipo Color en base al n� asociado a ese v�rtice
			e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo

	}
	
	/*
	 * M�todo auxiliar para colorear cada v�rtice (Personas) de forma que todas las personas que pertenezcan al mismo grupo
	 * tengan el mismo color. Para ello se dispone de dos mapas que guardan los colores asociados a un n� y las personas
	 * ya con su n� asociado. 
	 */
	private static Color colorearC(Map<Integer, Color> mapaDeColores, Map<Persona, Integer> personasColoreadas, Persona persona) {
		
		// Obtener el n� asociado a la persona del mapa que guarda todas las personas con su n� color:
		Integer nColor = personasColoreadas.get(persona);
		
		// Obtener el color asociado al n� anterior del mapa que guarda los colores asociados a un n�:
		Color color = mapaDeColores.get(nColor);
		
		return color;
		
	}

	/*
	 * Apartado D.1): Devuelve los nodos/v�rtices seleccionados de forma que todas
	 * las relaciones de amistad (Relacion) esten cubiertas. Esto es, se seleccione
	 * al menos un nodo/v�rtice (Persona) de cada par de amigos.
	 * Se emplea el m�todo getVertexCover() del tipo GreedyVImpl<> para obtener los
	 * v�rtices de menor recubrimiento; esto es, aquellos que permiten conectar todo
	 * el grafo con el menor n� de aristas.
	 */
	private static Set<Persona> ejercicio1D1(Graph<Persona, Relacion> grafo) {

		// M�todo getVertexCover() del objeto GreedyVCImpl<> para el grafo:
		Set<Persona> vertices = new GreedyVCImpl<>(grafo).getVertexCover();
		
		return vertices;
	
	}

	/*
	 * Apartado D.2): Muestra el grafo coloreando cada miembro (Persona)
	 * seleccionado por el m�todo ejercicio1D1().
	 */
	private static void ejercicio1D2(Graph<Persona, Relacion> grafo, Set<Persona> conjunto) {

		Graphs2.toDot(
				grafo, 																			// Grafo de entrada
				"salida/salidaEjercicio1D.gv",													// Ruta de salida de fichero
				v -> v.getNombre(),																// Valor de v�rtices: su nombre
				e -> "",																		// Valor de las aristas en blanco
				v -> GraphColors.getColorIf(													// Coloreado en base el booleano 
						GraphColors.Color.green,												// devuelto por el contains(v) que 
						GraphColors.Color.black,												// comprueba si el vertice est� en el
						conjunto.contains(v)),												    // conjunto que devuelve el m�todo ejercicio1D1()
				e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo
		
	}
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio1(String fichero) {

		// Lectura de datos de entrada y generaci�n del grafo:
		Graph<Persona, Relacion> grafo = lecturaDatosEjercicio1(fichero);

		System.out.println("Apartado A). - N� de amigos");
		 System.out.println(" Los miembros con cero amigos son: " + ejercicio1A1(grafo));
		 System.out.println(" Los miembros con m�s amigos (" + maximo(grafo) + ") son: " + ejercicio1A2(grafo, maximo(grafo)));
		 System.out.println(" Salida volcada en fichero salidaEjercicio1A.gv");
		 ejercicio1A3(grafo);
		 System.out.println("");
	    System.out.println("Apartado B). - Lista m�s corta");
	     System.out.println(" La lista m�s corta entre Juan y Ramiro es: " + ejercicio1B1(grafo, "Juan", "Ramiro"));
		 System.out.println(" Salida volcada en fichero salidaEjercicio1B.gv");
		 ejercicio1B2(grafo, "Juan", "Ramiro");
		 System.out.println("");
		System.out.println("Apartado C). - Grupos de amigos");
		 ejercicio1C1(grafo);
		 System.out.println(" Salida volcada en fichero salidaEjercicio1C.gv");
		 System.out.println("");
		System.out.println("Apartado D). - Cuestionarios a grupos");
		 System.out.println(" Se enviar�n " + ejercicio1D1(grafo).size() + " cuestionarios a los siguientes miembros: " + ejercicio1D1(grafo));
		 ejercicio1D2(grafo, ejercicio1D1(grafo));
		 System.out.println(" Salida volcada en fichero salidaEjercicio1D.gv");
		 System.out.println("");
		  
	}

}
