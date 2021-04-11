/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
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
	de funcionalidades (el mismo producto puede tener más de una funcionalidad). Se
	desea diseñar un lote con una selección de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
	
	Se piden soluciones por Programación Lineal y Algoritmos Genéticos
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
	 * Método inicial para la lectura de datos del fichero que se pasa como
	 * parámetro usando Collectors y el método StreamsS proporcionado por la librería.
	 * Se accederá a los datos desde las clases PL y AG que resuelven el ejercicio.
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
        
        // Los requisitos vienen especificados en la 1º línea de fichero:
		String linea_1 = lista.get(0);
		String[] linea_1_1 = linea_1.split(":");
		String[] requisitos_string = linea_1_1[1].trim().split(",");
		
		// Se castea a entero para que el resolvedor reciba un nº:
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
	 * Métodos auxiliares para definir las restricciones del problema. Son invocados
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
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio3(String fichero) {
		
		// Solución por Programación Lineal:
		try {

			LP3.ejercicio3LP(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la solución mediante Programación Lineal ");
			System.out.println("para el fichero: " + fichero + ".\n");
			// e.printStackTrace();

		}

		// Solución por Algoritmos Genéticos:
//		try {
//
//			PL.ejercicio1LP();
//
//		} catch (IOException e) {
//
//			System.out.println("No se ha podido calcular la solución mediante Algoritmos Genéticos ");
//			System.out.println("para el fichero: " + fichero + ".\n");
//			e.printStackTrace();
//
//		}

	}

}
