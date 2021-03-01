/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import ejercicio1.Persona;
import ejercicio1.Relacion;
import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

/*
En una academia se imparten una serie de grupos por parte de un conjunto de
profesores. Cada profesor imparte varios grupos, y cada grupo es impartido por 2
profesores. Para minimizar el tiempo en el que la academia estará abierta al público,
se van a impartir grupos en paralelo de forma que se minimicen las franjas horarias
con clases.

a. Determine qué grupos deberían impartirse en paralelo y cuántas franjas
horarias son necesarias, teniendo en cuenta que no se pueden poner en paralelo
grupos impartidos por el mismo profesor.

b. Muestre el problema como un grafo en el que los vértices son los grupos, y
configure su apariencia de forma que se muestren los vértices coloreados en
función de la franja horaria en la que se impartan. 
*/

public class Ejercicio2 {

	/*
	 * Lectura de datos; devuelve una lista de listas de....
	 */
	public static List<List<String>> lecturaDatosEjercicio2(String fichero) {

		int i = 0;
		int j = 0;
		List<List<String>> resultado = new ArrayList<List<String>>();
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {
			
			String fila = lista.get(i);
			// Hay que reemplazar los ":"
			String contenido = fila.replace(":", ",");
			// Una vez reemplazado, hacer split en base a la coma
			String[] texto = contenido.split(",");
			
			// Creamos una lista auxiliar que representa cada fila
			List<String> miniFila = new ArrayList<String>();
			while (j < texto.length) {
				
				miniFila.add(texto[j]);
				j++;
				
			}
			
			// Añadimos cada fila a la lista resultante
			resultado.add(miniFila);
			j = 0;
			i++;
			
		}

		return resultado;

	}
	
	public Graph<String, DefaultEdge> grafo = new SimpleGraph(DefaultEdge.class);
	
	grafo.addVertex("");

	grafo.addEdge("Sevilla", "Cadiz");
	//Graph<Profesor, Grupo> grupos = GraphsReader.newGraph???????

	
	/*
	 * Apartado A): Devuelve una lista....
	 */
	
	/*
	 * Apartado B): Muestra el problema como un grafo donde los nodos/vértices representan los grupos
	 * y colorea los nodos/vértices en base a la franja horaria en la que se imparten dichos grupos.
	 */

}
