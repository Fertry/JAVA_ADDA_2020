/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Files2;
import us.lsi.flujossecuenciales.StreamsS;

/*
 * Clase solución que pretende parsear la salida del resolvedor Gurobi y la salida
 * de algoritmos genéticos para mostrar los resultados acordes al fichero de resultados.
 */
public class Solucion3 {
	
	// Función que dado una solución de LP desde Gurobi escribe el resultado a fichero para parsearlo:
	public static void solucionLP3(String fichero, String entrada) {

		try {
			
			// Escribe el resultado a fichero para tratarlo a continuación:
			Files2.toFile(entrada.trim(), "volcado/salidaPLEj3DatosEntrada" + fichero.replace("ficheros/PI6Ej3DatosEntrada", ""));
			
			// Con el fichero creado, se llama a la función que lo parsea:
			formateoPL("volcado/salidaPLEj3DatosEntrada" + fichero.replace("ficheros/PI6Ej3DatosEntrada", ""), fichero);

		// Si algo falla, mostramos el contenido de forma directa: 
		} catch (Exception e) {
			
			System.out.println("No se ha podido formatear la salida así que se vuelca el ");
			System.out.println("resultado directamente por consola.\n");
			System.out.println(entrada + "\n");
			// e.printStackTrace();
			
		}
				
	}
	
	// Función que dado una solución de Algoritmos Genéticos parsea la solución:
	public static void solucionAG3(String fichero, List<Integer> entrada) {
		
		// La lista incluye como indice a los productos, cada indice representa
		// a un producto y el valor en dicha posición indica de forma binaria si es seleccionado o no:
		// Ej: [0, 0, 0, 1, 1, 0, 0, 1, 0, 0]
		// Se mantiene una lista formada por los productos:

		List<Integer> seleccion = new ArrayList<Integer>();
		
		int i = 0;
		while(i < entrada.size()) {
			
			if (entrada.get(i) != 0) {
				
				seleccion.add(i + 1);
				
			}
			
			i++;
			
		}
		
		// Con la lista creada, se llama a la función que lo parsea:
		formateoAG(fichero, seleccion);
		
	}
	
	// Función que parsea el fichero generado por solucionLP3 para mostrar el resultado por pantalla:
	private static void formateoPL(String fichero, String nombre) {
		
		// La primera línea representa el valor objetivo.
		// La segunda línea es descartable.
		// A partir de la tercera línea comienzan los datos.
		// El formato de cada línea es: 
		// x_n == 1 dónde n es el producto.
		
		int i = 2;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		List<Integer> seleccion = new ArrayList<Integer>();		
		while (i < lista.size()) {
			
			String linea = lista.get(i).trim();
			String[] datos = linea.trim().split("==");
			
			// El contenido a la derecha queda descartado dado que siempre es 1
			// A la izquierda, tras hacer split nos quedan dos valores:
			// Una x (se descarta) y el producto.
			String[] valores = datos[0].trim().split("_");
			
			// Añadir los valores a la lista:
			seleccion.add(Integer.parseInt(valores[1]) + 1);
			
			i++;
			
		}
		
		// Funcionalidades y precios totales:
		Double precio = 0.0;
		List<String> funcionalidades = new ArrayList<String>();
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~PROGRAMACIÓN LINEAL~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");	
		System.out.println("Funcionalidades a cubrir: " + Ejercicio3LP.requisitos());
		System.out.println("Composición del lote seleccionado: ");
		for (Integer producto : seleccion) {
			
			System.out.println("P" + producto + " (" + Ejercicio3LP.getPrecio(producto - 1) + " euros) " + "=> " + Ejercicio3LP.funcionalidadesPorProducto(producto - 1));
			
			for (String funcionalidad : Ejercicio3LP.funcionalidadesPorProducto(producto - 1)) {
				
				funcionalidades.add(funcionalidad);
				
			}
			
			precio += Ejercicio3LP.getPrecio(producto - 1);
			
		}
		System.out.println("Funcionalidades de la selección: " + funcionalidades);
		System.out.println("Precio total del lote seleccionado: " + Math.round(precio) + " euros");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	}
	
	// Función que parsea la salida de solucionAG1 para mostrar el resultado por pantalla:
	private static void formateoAG(String nombre, List<Integer> seleccion) {
		
		// Funcionalidades y precios totales:
		Double precio = 0.0;
		List<String> funcionalidades = new ArrayList<String>();
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ALGORITMOS GENÉTICOS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");	
		System.out.println("Funcionalidades a cubrir: " + Ejercicio3AG.requisitos());
		System.out.println("Composición del lote seleccionado: ");
		for (Integer producto : seleccion) {
			
			System.out.println("P" + producto + " (" + Ejercicio3AG.getPrecio(producto - 1) + " euros) " + "=> " + Ejercicio3AG.funcionalidadesPorProducto(producto - 1));
			
			for (String funcionalidad : Ejercicio3AG.funcionalidadesPorProducto(producto - 1)) {
				
				funcionalidades.add(funcionalidad);
				
			}
			
			precio += Ejercicio3AG.getPrecio(producto - 1);
			
		}
		System.out.println("Funcionalidades de la selección: " + funcionalidades);
		System.out.println("Precio total del lote seleccionado: " + Math.round(precio) + " euros");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	}

}
