package Grafos;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.interfaces.VertexCoverAlgorithm.VertexCover;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.shortestpath.FloydWarshallShortestPaths;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.alg.vertexcover.GreedyVCImpl;

public class JUNIO_16_17_1 {
	
	// 1. Tipo de grafo.
	Graph<Dispositivo, Interconexion> grafo = SimpleWeightedGraph<Dispositivo, Interconexion>();
	
	/*
	 * Porque es bidireccional y el camino tiene latencia (ms).
	 */
	
	// 2. Colocar dispositivos en el nº minimo de vertices para observar todas las interconexiones.
	public Set<Dispositivo> getMonitorizaciónMenor(Graph<Dispositivo,Interconexion> red) {
		
		GreedyVCImpl<Dispositivo,Interconexion> greedy = new GreedyVCImpl<>();
		
		VertexCover<Dispositivo> conjunto = greedy.getVertexCover(red);
		
		return conjunto.getVertices();
		
	}
	
	// 3. Dados 2 dispositivos, la ruta de menor latencia.
	public List<Dispositivo> getRutaMenorLatencia(Graph<Dispositivo,Interconexion> red, Dispositivo d1, Dispositivo d2) {
		
		FloydWarshallShortestPaths<Dispositivo,Interconexion> floyd = new FloydWarshallShortestPaths<>(red);
		
		return floyd.getShortestsPathAsVertexList(d1,d2);
		
	}
	
	// 4. Grupos aislados (componentes fuertemente conexas: Connectivity Inspector).
	public int getGruposAislados(Graph<Dispositivo,Interconexion> red) {
		
		ConnectivityInspector<Dispositivo,Interconexion> connect = new ConnectivityInspector<>(red);
		
		return connect.connectedSets().size();
		
	}
	
	// 5. Dada la antena, que dispositivos son accesibles desde esta (connectivity inspector):
	public Set<Dispositivo> getAccesibles(Graph<Dispositivo,Interconexion> red) {
		
		Dispositivo antena = Dispositivo.create("A");
		ConnectivityInspector<Dispositivo,Interconexion> connect = new ConnectivityInspector<>(red);
		
		return connect.connectedSetsOf(antena);
		
	}
	
	// 6. Que dispositivos apagar para que la conectividad se mantenga y la latencia sea minima (Kruskal):
	public Set<Interconexion> getInterconexionesInnecesarias(Graph<Dispositivo,Interconexion> red) {
		
		Set<Interconexion> todas = red.edgeSet();
		KruskalMinimumSpanningTree<Dispositivo,Interconexion> kruskal = new KruskalMinimumSpanningTree<>(red);
		
		Set<Interconexion> necesarias = kruskal.getMinimumSpanningTreeEdgeSet();
		
		return todas.removeAll(necesarias);
		
	}
	
}
