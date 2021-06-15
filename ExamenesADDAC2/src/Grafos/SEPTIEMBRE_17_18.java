package Grafos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DirectedMultigraph;

public class SEPTIEMBRE_17_18 {
	
	// Tipo grafo
	Graph<Plaza,Calle> grafo = new DirectedMultigraph<Plaza,Calle>();
	
	// 1. �Cu�ntos pasos de peatones habr�a que pintar en cada calle si deseamos que haya uno al
	// final de cada calle antes de llegar a cada plaza?
	public static Integer pasosPeatones(Graph<Plaza,Calle> grafo) {
		
		Set<Calle> aristas = grafo.edgesSet();
		
		return aristas.size();
		
	}
	
	// 2. C�mo podr�amos conocer las plazas que quedar�an excluidas del
	// servicio de recogida de basuras. Aquellas plazas a las que no apunta ninguna y
	// de las que no puede salir: fuertemente conexas:
	public static Set<Plaza> noApunta(Graph<Plaza,Calle> grafo) {
		
		Set<Plaza> aux = new HashSet<Plaza>();
		KosarajuStrongConnectivityInspector<Plaza,Calle> kosaraju = new KosarajuStrongConnectivityInspector<>();
		
		for(Set<Plaza> plazas : kosaraju.stronglyConnectedSets()) {
			
			// Si el set SOLO contiene una plaza: no est� conectado:
			if(plazas.size() == 1) {
				
				aux.addAll(plazas);
				
			}
			
		}
		
		return aux;
		
	}
	
	/*
	 * Justificar: isStronglyConnected() devuelve un booleano true/false si se verifica o no.
	 */
	
	// 3. Ruta m�s segura entre ambas plazas, que ser� aquella por la que transite el menor n�mero de coches.
	public static List<Plaza> getRuta(Graph<Plaza,Calle> grafo) {
		
		// Plazas:
		Plaza p3 = Plaza.create("P3");
		Plaza p4 = Plaza.create("P4");
		
		DijkstraShortestPath<Plaza,Calle> dijkstra = new DijkstraShortestPath<>();
		
		return dijkstra.getPath(p3,p4).getVertexList();
		
	}

}
