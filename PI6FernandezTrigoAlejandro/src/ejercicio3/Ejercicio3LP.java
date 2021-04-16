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

public class Ejercicio3LP {
	
	/*
	 * Variables de la clase necesarias para ser accedidas por la clase
	 * PL que resuelve el ejercicio. 
	*/
	public static List<String> nombres;
	public static List<Double> precios;
	public static List<Integer> requisitos;
	public static List<List<Integer>> funcionalidades;
	
	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro usando Collectors y el m�todo StreamsS proporcionado por la librer�a.
	 * Se acceder� a los datos desde la clase PL que resuelve el ejercicio.
	*/
	public static void iniDatos(String fichero) {
		
		// Inicializar las variables de la clase Ejercicio3:
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
        
        // Los requisitos vienen especificados en la 1� l�nea de fichero:
		String primeraLinea = lista.get(0);
		String[] primerLineaString = primeraLinea.split(":");
		String[] requisitosString = primerLineaString[1].trim().split(",");
		
		// Se castea a entero para que el resolvedor reciba un n�:
		for(String requisito : requisitosString){
			
			requisitos.add(Integer.parseInt(requisito.replace("F", "")));
			
		}

	}
	
	/*
	 * M�todos auxiliares para definir las restricciones del problema. Son invocados
	 * en el fichero .lsi para generar el modelo .lp. 
	*/
	
	// Obtiene el precio de un producto dado un indice:
	public static Double getPrecio(Integer i) {
		
		return precios.get(i);
		
	}
	
	// Obtiene el n� de productos: 
	public static Integer getNProductos() {
		
		return nombres.size();
		
	}
	
	// Obtiene el n� de funcionalidades, que es el n� de requisitos
	public static Integer getNFuncionalidades() {
		
		return requisitos.size();
		
	}

	// Comprueba si un producto cubre una funcionalidad dada, siendo i el producto y j la funcionalidad:
	public static Boolean contiene(Integer i, Integer j) {
		
		return funcionalidades.get(i).contains(requisitos.get(j));
		
	}
	
	/*
	 * M�todos auxiliares para ser accedidos por las clases de Solucion; solo son
	 * usados para el formateo de la salida y no est�n involucrados en la soluci�n del
	 * ejercicio por PL.
	*/
	
	// Devuelve las funcionalidades de un producto:
	public static List<String> funcionalidadesPorProducto(Integer i) {
		
		List<String> resultado = new ArrayList<String>();
		
		for (Integer funcionalidad : funcionalidades.get(i)) {
			
			resultado.add("F" + funcionalidad);
			
		}
		
		return resultado;
		
	}
	
	// Devuelve la lista de requisitos:
	public static List<String> requisitos() {
		
		List<String> resultado = new ArrayList<String>();
		
		for (Integer requisito : requisitos) {
			
			resultado.add("F" + requisito);
			
		}
		
		return resultado;
		
	}
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	*/
	public static void ejercicio3LP(String fichero) {
		
		// Soluci�n por Programaci�n Lineal:
		try {

			LP3.ejercicio3LP(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la soluci�n mediante Programaci�n Lineal ");
			System.out.println("para el fichero: " + fichero + ".\n");
			// e.printStackTrace();

		}

	}

}
