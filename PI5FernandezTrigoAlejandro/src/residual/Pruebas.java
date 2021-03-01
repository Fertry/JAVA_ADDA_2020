package residual;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class Pruebas {
	
	public static void testing() {
		
		System.out.println("#############################################################");
		System.out.println("#############################################################");
		Graph<String, DefaultEdge> grafo = new SimpleGraph(DefaultEdge.class);
		
		grafo.addVertex("Sevilla");
		grafo.addVertex("Huelva");
		grafo.addVertex("Cadiz");

		grafo.addEdge("Sevilla", "Huelva");
		grafo.addEdge("Sevilla", "Cadiz");
	
		System.out.println("Grafo completo: " + grafo);
		System.out.println("Vértices del grafo: " + grafo.vertexSet());
		System.out.println("Aristas del grafo: " + grafo.edgeSet());
		Graphs2.toDot(grafo, "salida/grafo.gv");
		System.out.println("#############################################################");
		System.out.println("#############################################################\n");
		
		System.out.println("#############################################################");
		System.out.println("#############################################################");
		Graph<Ciudad,Carretera> andalucia = GraphsReader.newGraph("ficheros/andalucia.txt",
				Ciudad::ofFormat, 
				Carretera::ofFormat, 
				Graphs2::simpleWeightedGraph,
				Carretera::getKm);
		
		System.out.println(andalucia);
		Graphs2.toDot(andalucia, "salida/andalucia.gv");
		System.out.println("#############################################################");
		System.out.println("#############################################################\n");
		
	}

}
