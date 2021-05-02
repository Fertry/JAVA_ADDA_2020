/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
 */

package ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import clases.Producto;
import us.lsi.flujossecuenciales.StreamsS;

/*
	Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
	de funcionalidades (el mismo producto puede tener más de una funcionalidad). Se
	desea diseñar un lote con una selección de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
	
	Solución por A*.
*/

public class Ejercicio3A {
	
	/*
	 * Variables de la clase necesarias para resolver el ejercicio. 
	*/
	private static List<String> nombres;
	private static List<Double> precios;
	private static List<Integer> requisitos;
	private static List<List<Integer>> funcionalidades;
	
	/*
	 * Método inicial para la lectura de datos del fichero que se pasa como
	 * parámetro usando Collectors y el método StreamsS proporcionado por la librería.
	 * Se accederá a los datos desde la clase PL que resuelve el ejercicio.
	*/
	private static void iniDatos(String fichero) {
		
		// Inicializar las variables de la clase Ejercicio3A:
		nombres = new ArrayList<String>();
		precios = new ArrayList<Double>();
		requisitos = new ArrayList<Integer>();
		funcionalidades = new ArrayList<List<Integer>>();
		
		int i = 1;
        List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());

        while (i < lista.size()) {
        	
            String linea = lista.get(i);            
            
            // Creo un objeto de tipo Producto del cual extraer sus propiedades:
            Producto producto = Producto.ofLinea(linea);
            
            nombres.add(producto.getNombre());
            precios.add(producto.getPrecio());
            
            List<Integer> auxiliar = new ArrayList<Integer>();
            for (String funcionalidad : producto.getFuncionalidades()) {
				
            	auxiliar.add(Integer.parseInt(funcionalidad.replace("F", "")));
  
			}
            
            funcionalidades.add(auxiliar);
            
            i++;
            
        }
        
        // Los requisitos vienen especificados en la 1º línea de fichero:
		String primeraLinea = lista.get(0);
		String[] primerLineaString = primeraLinea.split(":");
		String[] requisitosString = primerLineaString[1].trim().split(",");
		
		// Se castea a entero para que el resolvedor reciba un nº:
		for(String requisito : requisitosString){
			
			requisitos.add(Integer.parseInt(requisito.replace("F", "")));
			
		}

	}
	
	/*
	 * Métodos auxiliares para resolver el problema.
	*/
	
	// Obtiene el precio de un producto dado un indice:
	private static Double getPrecio(Integer i) {
		
		return precios.get(i);
		
	}
	
	// Obtiene el nº de productos: 
	private static Integer getNProductos() {
		
		return nombres.size();
		
	}
	
	// Obtiene el nº de funcionalidades, que es el nº de requisitos
	private static Integer getNFuncionalidades() {
		
		return requisitos.size();
		
	}

	// Comprueba si un producto cubre una funcionalidad dada, siendo i el producto y j la funcionalidad:
	private static Boolean contiene(Integer i, Integer j) {
		
		return funcionalidades.get(i).contains(requisitos.get(j));
		
	}
	
	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	*/
	public static void ejercicio3A(String fichero) {
		
		
	}

}
