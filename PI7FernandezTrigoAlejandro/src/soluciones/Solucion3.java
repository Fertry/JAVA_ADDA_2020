/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package soluciones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import aristas.AristaProducto;
import ejercicio3.Ejercicio3;

public class Solucion3 {
	
	/*
	 * M�todo p�blico para recibir la lista de aristas resultantes de la ejecuci�n de los algoritmos y operar sobre dicha lista.
	*/
	public static void solucion(List<AristaProducto> entrada, String ruta) {

		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		System.out.println(entrada);
		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		
		int i = 0;
		Set<String> productosSeleccionados = new HashSet<String>();
		Map<Integer, Integer> reparto = new HashMap<Integer, Integer>();
		
		while (i < entrada.size()) {
			
			// Obtener el par de valores Producto/Seleccionado de cada arista:
			String arista = entrada.get(i).toString();
			String[] parDeValores = arista.trim().split(",");
			
			// Obtener el producto:
			Integer producto = Integer.parseInt(parDeValores[0].replace("(", "").trim());
		
			// Obtener el valor binario que indica si se selecciona o no:
			Integer seleccionado = Integer.parseInt(parDeValores[1].replace(")", "").trim());
			
			// A�adir al mapa el producto con su valor binario:
			reparto.put(producto, seleccionado);
			
			i++;
			
		}
		
		// Recorro el mapa generado, a�ado al Set<> final solo los productos seleccionados:
		for (Integer producto : reparto.keySet()) {
			
			// Si el valor asociado a dicha clave es 1:
			if (reparto.get(producto) == 1) {
				
				// A�ado el producto al Set<> c�mo String:
				// Sumo 1 para que comience a contar desde 1 y no 0:
				productosSeleccionados.add("P" + (producto + 1));
				
			}
			
		}
		
		// Calculo del precio total y funcionalidades totales:
		Double sumatorioPrecio = 0.0;
		Set<String> sumatorioFuncionalidades = new HashSet<String>();
		
		// Mostrar los datos finales por pantalla:
		System.out.println(ruta.replace("ficheros/", "") + ":" + "\n");	
		System.out.println("Funcionalidades a cubrir: " + Ejercicio3.getRequisitos());
		System.out.println("Composici�n del lote seleccionado: ");
		for (String productoString : productosSeleccionados) {

			// Obtengo el producto como entero tambi�n para calcular sus propiedades derivadas:
			Integer productoInteger = Integer.parseInt(productoString.replace("P", "")) - 1;
			System.out.println("	" + productoString + " (" + Ejercicio3.getPrecio(productoInteger) + " euros) => " + Ejercicio3.getFuncionalidades(productoInteger));	
			
			sumatorioPrecio += Ejercicio3.getPrecio(productoInteger);
			sumatorioFuncionalidades.add(productoString);
			
		}
		System.out.println("Funcionalidades de lote seleccionado: " + sumatorioFuncionalidades);
		System.out.println("Precio total del lote seleccionado: " + Math.round(sumatorioPrecio) + " euros.");
		
	}
	
}
