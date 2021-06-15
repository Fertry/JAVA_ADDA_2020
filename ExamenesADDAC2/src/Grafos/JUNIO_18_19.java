package Grafos;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import us.lsi.common.Tuple2;

public class JUNIO_18_19 {
	
	// Grafo ponderado y dirigido:
	Graph<Estado,Transicion> grafo = new SimpleDirectedWeightedGraph<>();
	
	// 1. El número de estados y número de transiciones para hacer explotar el reactor desde el
	// Estado de normalidad en el menor tiempo posible.
	public Tuple2<Integer,Integer> exploit(Graph<Estado, Transición> g) {
		
		DijkstraShortestPath<Estado,Transicion> dijkstra = new DijkstraShortestPath<Estado,Transicion>(g);
		
		// Obtener el estado inicio y fin:
		Estado inicio = Estado.create("Normalidad");
		Estado final = Estado.create("Explota");
		
		// Obtener el camino:
		GraphPath<Estado,Transicion> camino = dijkstra.getPath(inicio, final);
		
		// Lista de estados y transiciones:
		Integer estados = camino.getVertexList().size();
		Integer transiciones = camino.getEdgeList().size();
		
		// Devolver una tupla:
		return Tuple2.create(estados, transiciones);
		
	}
	
	// 2. número mínimo de inspectores necesarios para inspeccionar todos los estados.
	public Integer minInspector(Graph<Estado, Transicion> grafo) {
		
		VertexColoringAlgorithm<Estado> greedy = new GreedyColoring<Estado, Transicion>(grafo);
		
		return greedy.getColoring().getNumberColors();
		
	}
	
	// 3. Aquellos estados en los que una vez alcanzados no se puede volver al estado Normalidad.
	public List<Estado> noReturn(Graph<Estado, Transición> g, List<Estados> lista) {
		
		Estado normalidad = Estado.create("Normalidad");
		List<Estado> resultado = new ArrayList<Estado>();
		DijkstraShortestPath<Estado,Transicion> dijkstra = new DijkstraShortestPath<Estado,Transicion>(g);
		
		for (Estado estado : lista) {
			
			if (dijkstra.getPath(estado, normalidad) == null) {
				
				resultado.add(estado);
				
			}
		}
		
		return resultado;
		
	}
	
}
