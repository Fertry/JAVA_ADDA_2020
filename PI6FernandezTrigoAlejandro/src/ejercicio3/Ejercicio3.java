/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

/*
	Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
	de funcionalidades (el mismo producto puede tener m�s de una funcionalidad). Se
	desea dise�ar un lote con una selecci�n de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
	
	Se piden soluciones por Programaci�n Lineal y Algoritmos Gen�ticos
*/

public class Ejercicio3 {
	
	/*
	 * Variables de la clase necesarias para ser accedidas por las clases
	 * PL y AG que resuelven el ejercicio. 
	*/
	public static List<Double> precios;
	public static List<String> productos;
	public static List<Integer> requisitos;
	public static List<List<Integer>> funcionalidades;
	
	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro usando Collectors y el m�todo StreamsS proporcionado por la librer�a.
	 * Se acceder� a los datos desde las clases PL y AG que resuelven el ejercicio.
	*/
	public static void iniDatos(String fichero) {
		
		precios = new ArrayList<Double>();
		productos = new ArrayList<String>();
		requisitos = new ArrayList<Integer>();
		funcionalidades = new ArrayList<List<Integer>>();
		
		int i = 1;
        List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());

        while (i < lista.size()) {
        	
            String linea = lista.get(i);            
            create(linea);
            i++;
            
        }
        
        // Los requisitos vienen especificados en la 1� l�nea de fichero:
		String linea_1 = lista.get(0);
		String[] linea_1_1 = linea_1.split(":");
		String[] requisitos_string = linea_1_1[1].trim().split(",");
		
		// Se castea a entero para que el resolvedor reciba un n�:
		for(String requisito : requisitos_string){
			
			requisitos.add(Integer.parseInt(requisito.replace("F", "")));
			
		}

	}
	
	public static void create(String s) {
		
		String[] productoResto = s.trim().split("\\(");
		// String[1] --> 9.99 euros): F1,F2

		String[] precioResto = productoResto[1].trim().split("euros\\):");
		// String[0] --> 9.99
		// String[1] --> F1,F2

		precios.add(Double.parseDouble(precioResto[0].trim()));

		String[] funcionalidadesProducto = precioResto[1].split(",");
		// String[0] --> F1
		// String[1] --> F2

		List<Integer> ls = new ArrayList<Integer>();
		for (int x = 0; x < funcionalidadesProducto.length; x++) {
			ls.add(Integer.parseInt(funcionalidadesProducto[x].replace("F", "").trim()));
		}
		funcionalidades.add(ls);
		ls = new ArrayList<Integer>();

	}
	
	/*
	 * M�todos auxiliares para definir las restricciones del problema. Son invocados
	 * en el fichero .lsi para generar el modelo .lp. 
	*/
	
	public static Double getPrecio(Integer i) {
		return precios.get(i);
	}
	
	public static Integer getNumeroProductos() {
		return precios.size();
	}
	
	public static Integer getNumeroFuncionalidades() {
		return requisitos.size();
	}

	public static List<Integer> getFuncionalidad(Integer i) {
		return funcionalidades.get(i);
	}

	public static Integer getFuncionalidades(Integer i) {
		return requisitos.size();
	}
	
	public static Boolean fi(Integer producto, Integer funcionalidad) {
		return funcionalidades.get(producto).contains(requisitos.get(funcionalidad));
	}
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio3(String fichero) {
		
		// Soluci�n por Programaci�n Lineal:
		try {

			LP3.ejercicio3LP(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la soluci�n mediante Programaci�n Lineal ");
			System.out.println("para el fichero: " + fichero + ".\n");
			// e.printStackTrace();

		}

		// Soluci�n por Algoritmos Gen�ticos:
//		try {
//
//			PL.ejercicio1LP();
//
//		} catch (IOException e) {
//
//			System.out.println("No se ha podido calcular la soluci�n mediante Algoritmos Gen�ticos ");
//			System.out.println("para el fichero: " + fichero + ".\n");
//			e.printStackTrace();
//
//		}

	}

}
