package Grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.SimpleWeightedGraph;

public class JUNIO_17_18 {

	// Tipo de grafo
	Graph<Cruce, Calle> grafo = new SimpleWeightedGraph<>();
	
	/*
	 * Calle: longitud, superficie, tiempoCoche, tiempoPie
	 */
	
	// 1. Calles que hay que asfaltar, para colocar contenedores que cubran todo el área.
	public Set<Calle> callesAsfaltado(Graph<Cruce,Calle> pueblo) {
		
		KruskalMinimumSpanningTree<Cruce,Calle> kruskal = new KruskalMinimumSpanningTree<>(pueblo);
		
		return kruskal.getSpanningTree().getEdges();
		
	}
	
	// 2. Tiempo que se gana en coche, tras asfaltar, desde c1 a c2. 
	public double informeReduccionTiemposRutas(Graph<Cruce,Calle> pueblo, Set<Calle> callesAsfaltadas, Cruce c1, Cruce c2) {
		
		Double sum = 0.0; 
		DijkstraShortestPath<Cruce,Calle> dijkstra = new DijkstraShortestPath<>(pueblo);
		
		List<Calle> lista = dijkstra.getPath(c1,c2).getEdgeList();
		
		for(Calle calle : lista) {
			
			if (callesAsfaltadas.contains(calle)) {
				
				sum = sum + calle.getTiempoCoche() / 2.0;
				
				
			} else {
				
				sum = sum + calle.getTiempoCoche();
				
			}
		}
		
		return sum;
		
	}
	
	// 3. Devolver los grupos de cruces conectados entre sí por calles de tierra.
	public List<Set<Cruce>> gruposRutasPorTierra(Graph<Cruce,Calle> pueblo, Set<Calle> callesAsfaltadas) {
		
		ConnectivityInspector<Cruce,Calle> kosaraju = new ConnectivityInspector<>(pueblo);
		
		List<Set<Cruce>> aux = new ArrayList<>();
		List<Set<Cruce>> listaSets = kosaraju.connectedSets();
		
		for (Set<Cruce> set : listaSets) {
			
			set.removeAll(callesAsfaltadas);
			aux.add(set);
			
		}
		
		return aux;
		
	}
	
}
