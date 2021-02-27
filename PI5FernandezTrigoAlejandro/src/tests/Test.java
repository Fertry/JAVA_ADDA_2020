/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package tests;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import ejercicio1.Persona;
import ejercicio1.Relacion;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class Test {

	public static void main(String[] args) {

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
		
		System.out.println("#############################################################");
		System.out.println("#############################################################");
		Graph<Persona,Relacion> redSocial = GraphsReader.newGraph("ficheros/PI5Ej1DatosEntrada.txt",
				Persona::ofFormat,
				Relacion::ofFormat,
                Graphs2::simpleWeightedGraph,
                Relacion::getId);
		
		/*
		 * Cambiando en la clase el atributo id por entero y eliminando el getter de Id, se escribe como:
		 * 
		 * Graph<Persona,Relacion> redSocial = GraphsReader.newGraph("ficheros/PI5Ej1DatosEntrada.txt",
		 * Persona::ofFormat,
		 * Relacion::ofFormat,
         * Graphs2::simpleGraph);
		*/
		
		System.out.println(redSocial);
		Graphs2.toDot(redSocial, "salida/redSocial.gv");
		System.out.println("#############################################################");
		System.out.println("#############################################################\n");
		
	}

}
