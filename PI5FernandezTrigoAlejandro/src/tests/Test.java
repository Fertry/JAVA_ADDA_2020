/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package tests;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class Test {

	public static void main(String[] args) {

		System.out.println("Práctica 5");
		
		Graph<String, DefaultEdge> grafo = new SimpleGraph(DefaultEdge.class);
		
		grafo.addVertex("Sevilla");
		grafo.addVertex("Huelva");
		grafo.addVertex("Cadiz");

		grafo.addEdge("Sevilla", "Huelva");
		grafo.addEdge("Sevilla", "Cadiz");
		
		System.out.println(grafo);
		
		Graphs2.toDot(grafo, "ficheros/grafo.gv");
		
		Graph<Persona,Relacion> andalucia = GraphsReader.newGraph("ficheros/andalucia.txt",
				Persona::ofFormat, 
				Relacion::ofFormat, 
				Graphs2::simpleGraph);
		
		System.out.println(andalucia);
		
	}

}
