/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package tests;

import java.util.List;

import org.jgrapht.Graph;
import ejercicio1.Ejercicio1;
import ejercicio1.Persona;
import ejercicio1.Relacion;
import ejercicio2.Ejercicio2;
import ejercicio3.Ejercicio3;
import us.lsi.graphs.Graphs2;

public class Test {

	public static void main(String[] args) {

		// Variables, lecturas, etc:
		Graph<Persona, Relacion> redSocial = Ejercicio1.lecturaDatosEjercicio1("ficheros/PI5Ej1DatosEntrada.txt");
		List<List<String>> listaGrupos = Ejercicio2.lecturaDatosEjercicio2("ficheros/PI5Ej2DatosEntrada.txt");
		List<List<String>> listaAsignaturas = Ejercicio3.lecturaDatosEjercicio3("ficheros/PI5Ej3DatosEntrada.txt");
		
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 1 - APARTADO A) ###################");
		// Mostrar datos por pantalla y volcar la salida en un fichero .gv
		System.out.println(redSocial);
		Graphs2.toDot(redSocial, "salida/redSocial.gv");
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 1 - APARTADO B) ###################");
		
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 1 - APARTADO C) ###################");
		
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 1 - APARTADO D) ###################");
		
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 2 - APARTADO A) ###################");
		System.out.println(listaGrupos);
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 2 - APARTADO B) ###################");
		
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 3 - APARTADO A) ###################");
		System.out.println(listaAsignaturas);
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 3 - APARTADO B) ###################");
		
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
		System.out.println("##################################################################");
		System.out.println("#################### EJERCICIO 3 - APARTADO C) ###################");
		
		System.out.println("##################################################################");
		System.out.println("##################################################################\n");
		
	}

}
