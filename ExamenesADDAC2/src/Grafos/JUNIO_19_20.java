package Grafos;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm.SpanningTree;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;

public class JUNIO_19_20 {
	
	private static Graph<Localizacion,Trayecto> g = null;
	
	// 1. Devuelve la localización asociada al identificador id
	public static Localizacion getLocalizacionById(String id) {
		
		Localizacion resultado = null;
		
		for(Localizacion vertice : g.vertexSet()) {
			
			if (vertice.getId() == id) {
				
				resultado = vertice;
				break;
				
			} 
			
		}
		
		return resultado;
		
	}
	
	// 2. Devuelve un subgrafo con todas las localizaciones con cierto atractivo, los atractivos para 
	// el filtrado se pasan en forma de array por parámetro. El subgrafo también contendrá los 
	// trayectos entre las localizaciones filtradas.
	public static Graph<Localizacion,Trayecto> getSubMapa(Integer ... atractivos) {
		
		// Grafo ponderado
		Graph<Localizacion,Trayecto> resultado = new SimpleWeightGraph<Localizacion,Trayecto>();
		
		List<Integer> atractivos = Arrays.asList(atractivos);
		
		for(Localizacion vertice : g.vertexSet()) {
			
			// if(atractivos.contains(vertice.getAtractivo()) {
				// resultado.addVertex(vertice);
			// }
			
			for(Integer atractividad : atractivos) {
				
				if (vertice.getAtractivo() == atractividad) {
					
					resultado.addVertex(vertice);
					
				}
				
			}
			
		}
		
		// El subgrafo también contendrá los trayectos entre las localizaciones filtradas.
		for(Trayecto carretera : g.edgeSet()) {

			if (resultado.vertexSet().contains(carretera.getDestino) && resultado.vertexSet().contains(carretera.getOrigen)) {
				
				resultado.addEdge(carretera.getOrigen(), carretera.getDestino());
				
			}
				
		}
		
		return resultado;
		
	}
	
	// 3. 
	public static Set<Localizacion> getZonaDeInfluencia(String id, int limiteDeMinutosXDesplazamiento) {
		
		Localizacion localizacion = getLocalizacionById(id);
		Set<Localizacion> resultado = new HashSet<Localizacion>();
		ShortestPathAlgorithm<Localizacion,Trayecto> dijkstra = new DijkstraShortestPath<Localizacion,Trayecto>(g);
		
		for(Localizacion ciudad : g.vertexSet()) {
			
			// Si la duración del camino no supera a limiteDeMinutosXDesplazamiento:
			if (dijkstra.getPath(localizacion, ciudad).getEdgeWeight() <= limiteDeMinutosXDesplazamiento) {
				
				// Si el atractivo es mayor que cero:
				if (ciudad.getAtractivo() > 0) {
					
					// Si hay camas disponibles:
					if (ciudad.getHayCamasDisponibles()) {
						
						// Y si no es la misma ciudad:
						if (ciudad != localizacion) {
							
							// Entonces se añade:
							resultado.add(ciudad);
							
						}
		
					}
				}
				
			}
			
		}
		
		return resultado;
		
	}
	
	// 4. Devuelve el recubrimiento mínimo de trayectos necesarios para acceder a todas las localizaciones
	// del mapa minimizando las horas de viaje.
	public static Set<Trayecto> getRedDeRecubrimiento() {
		
		//SpanningTreeAlgorithm<Trayecto> kruskal = new KruskalMinimumSpanningTree<>(g);
		SpanningTree<Trayecto> kruskal = new KruskalMinimumSpanningTree<>(g);
		
		SpanningTree<Trayecto> arbol = kruskal.getSpanningTree();
		
		// Devolver el set de Trayectos del arbol:
		return arbol.getEdges();
				
	}
	
	// 5. Devuelve la duración en horas de una travesía turística.
	public static Double getDuracionDeTravesia(List<Localizacion> travesia) {
	
		int i = 0;
		Double sumatorio = 0.0;
		
		while(i < travesia.size() - 1) {
			
			sumatorio += (Double) g.getEdge(travesia.get(i), travesia.get(i+1)).getDuracionEnMinutos();
			i++;
			
		}
		
		return sumatorio;
		
	}
	
}
