/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import clases.Producto;
import us.lsi.flujossecuenciales.StreamsS;

/*
	Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
	de funcionalidades (el mismo producto puede tener más de una funcionalidad). Se
	desea diseñar un lote con una selección de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
*/

public class Ejercicio3 {
	
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
	public static Double getPrecio(Integer i) {
		
		return precios.get(i);
		
	}
	
	// Obtiene un Set<> de funcionalidades de un producto i:
	public static Set<Integer> getFuncionalidades(Integer i) {
		
		Set<Integer> resultado = new HashSet<Integer>();
		
		for (Integer funcionalidad : funcionalidades.get(i)) {
			
			resultado.add(funcionalidad);
			
		}
		
		return resultado;
			
	}
	
	// Obtiene un Set<> de funcionalides de un producto i cómo String:
	public static Set<String> getFuncionalidadesString(Integer i) {
		
		Set<String> resultado = new HashSet<String>();
		
		for (Integer funcionalidad : funcionalidades.get(i)) {
			
			resultado.add("P" + funcionalidad);
			
		}
		
		return resultado;
		
	}
	
	// Obtiene el nº de productos: 
	public static Integer getNProductos() {
		
		return nombres.size();
		
	}
	
	// Obtiene un Set<> de los requisitos:
	public static Set<Integer> getRequisitos() {
		
		Set<Integer> resultado = new HashSet<Integer>();
		
		for (Integer requisito : requisitos) {
			
			resultado.add(requisito);
			
		}
		
		return resultado;
		
	}
	
}
