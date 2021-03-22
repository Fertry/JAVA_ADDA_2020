/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;
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
	 * Lectura de datos; devuelve un una tupla para encapsular, por un lado una lista con todas las funcionalidades
	 * requeridas y, por otro lado, una lista del tipo Producto que a su vez define los siguientes atributos (parseados
	 * en la propia clase) Nombre, Precio, Lista de funcionalidades cubiertas por el producto.
	 */
	private static Tuple2<List<String>, List<Producto>> lecturaDatosEjercicio3(String fichero)  {
		
		int i = 1;	
		List<Producto> listaProductos = new ArrayList<Producto>();
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {
			
			String fila = lista.get(i);

			// Crea el objeto producto a partir de los elementos de la linea leida y lo añade a la lista:
			Producto producto = Producto.ofDatos(fila);
			listaProductos.add(producto);

			i++;
			
		}
		
		/*
		 * Tratar la primera línea de fichero por separado, devolviendo una lista
		 * con las funcionalidades requeridas:
		 */
		String primeraFila = lista.get(0);
		List<String> funcionalidadesRequeridas = new ArrayList<String>();
		
		String[] primeraLineaSinParsear = primeraFila.split(": ");
		String[] primeraLineaParseada = primeraLineaSinParsear[1].split(",");
		
		for (String funcion : primeraLineaParseada) {
			funcionalidadesRequeridas.add(funcion);
		}
		
		// Meterlo todo en la tupla:
		Tuple2<List<String>, List<Producto>> resultado = Tuple.create(funcionalidadesRequeridas, listaProductos);

		return resultado;
		
	}
	
	/*
	 * Repartir los productos en lotes que por el menor precio (minimizar) tengan el mayor 
	 * número de funcionalides cubiertas. Realizar mediante Programación Lineal (PL).
	 */
	private static void ejercicio3ProgramacionLineal() {
		
		//TO-DO
		
	}
	
	/*
	 * Repartir los productos en lotes que por el menor precio (minimizar) tengan el mayor 
	 * número de funcionalides cubiertas. Realizar mediante Algoritmos Genéticos (GA).
	 */
	private static void ejercicio3AlgoritmosGeneticos() {
		
		//TO-DO
		
	}
	
	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio3(String fichero) {
		
		// Lectura de datos de entrada:
		Tuple2<List<String>, List<Producto>> tupla = lecturaDatosEjercicio3(fichero);

		// Salida de datos:
		ejercicio3ProgramacionLineal();
		ejercicio3AlgoritmosGeneticos();
		
		System.out.println(" Funcionalidades a cubrir: ");
		System.out.println(" Composición del lote seleccionado: ");
		System.out.println("  ");
		System.out.println(" Funcionalidades de la selección: ");
		System.out.println(" Precio total del lote seleccionado: " + " euros");
		System.out.println(" ");
		
		System.out.println(tupla);
		
	}

}
