/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.ag.agchromosomes.ValuesInRangeChromosome;

/*
	Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
	de funcionalidades (el mismo producto puede tener más de una funcionalidad). Se
	desea diseñar un lote con una selección de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
	
	Se piden soluciones por Programación Lineal y Algoritmos Genéticos
*/

public class Ejercicio3AG implements ValuesInRangeProblemAG<Integer, List<Integer>> {

	/*
	 * Variables de la clase necesarias para ser accedidas por la clase
	 * AG que resuelve el ejercicio. 
	*/
	public static List<String> nombres;
	public static List<Double> precios;
	public static List<Integer> requisitos;
	public static List<List<Integer>> funcionalidades;
	
	/*
	 * Métodos inicializadores de la clase AG.
	*/
	public Ejercicio3AG(String fichero) {
		
		Ejercicio3AG.iniDatos(fichero);
		
	}
	
	public static Ejercicio3AG AG(String fichero) {
		
		return new Ejercicio3AG(fichero);
		
	}

	/*
	 * Método inicial para la lectura de datos del fichero que se pasa como
	 * parámetro usando Collectors y el método StreamsS proporcionado por la librería.
	 * Se accederá a los datos desde la clase AG que resuelve el ejercicio.
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
	 * Métodos auxiliares para definir las restricciones del problema y métodos para ser usados
	 * por el algoritmo de resolución. Son invocados en la clase AG3. 
	*/	

	// Obtiene el precio de un producto dado un indice:
	public static Double getPrecio(Integer i) {

		return precios.get(i);

	}

	// Obtiene el nº de productos:
	public static Integer getNProductos() {

		return nombres.size();

	}

	// Obtiene el nº de funcionalidades, que es el nº de requisitos
	public static Integer getNFuncionalidades() {

		return requisitos.size();

	}
	
	// Obtiene las funcionalidades de un producto por índice:
	public static List<Integer> funcionalidadesPorIndice(Integer i) {
		
		return funcionalidades.get(i);
		
	}

	// Comprueba si un producto cubre una funcionalidad dada, siendo i el producto y
	// j la funcionalidad:
	public static Boolean contiene(Integer i, Integer j) {

		return funcionalidades.get(i).contains(requisitos.get(j));

	}
	
	// Define el tipo de cromosoma que usa el problema: 
	@Override
	public ChromosomeType getType() {

		return ChromosomeType.Binary;
		
	}

	// Define el nº de elementos del problema: Nº de productos:
	@Override
	public Integer getCellsNumber() {

		return getNProductos();
		
	}

	// Define el límite superior del problema: Nº de funcionalidades que cubrir:
	@Override
	public Integer getMax(Integer i) {

		return getNFuncionalidades();
				
	}

	// Devuelve el límite inferior del problema: siempre 0:
	@Override
	public Integer getMin(Integer i) {
		
		return 0;
		
	}
	
	/*
	 * Métodos de Algoritmos Genéticos para determinar la recompensa / penalización del cromosoma
	 * seleccionado.
	*/
	
	// Función de fitness que define el problema: 
	@Override
	public Double fitnessFunction(ValuesInRangeChromosome<Integer> cromosoma) {

		List<Integer> cromosomas = cromosoma.decode();
		
		return recompensa(cromosomas) - penalizacion(cromosomas);
		
	}

	// Función decode:
	@Override
	public List<Integer> getSolucion(ValuesInRangeChromosome<Integer> cromosoma) {

		return cromosoma.decode();
		
	}
	
	/*
	 * Método objetivo o recompensa para recompensar cromosomas que cumplan las restricciones.
	*/
	public Double recompensa(List<Integer> cromosomas) {
		
		Double recompensa = 0.0;
		
		int i = 0;
		while (i < cromosomas.size()) {
			
			recompensa += Ejercicio3AG.getPrecio(i) * cromosomas.get(i);
			i++;
			
		}
		
		// Minimizar un problema es = -(maximizar):
		return -(recompensa);
		
	}
	
	/*
	 * Método de "castigo" o penalización para cromosomas que no cumplen las restricciones.
	*/
	public Double penalizacion(List<Integer> cromosomas) {
		
		Double penalizacion = 0.0;

		Set<Integer> funcionalidades = new HashSet<Integer>();
		for (int i = 0; i < cromosomas.size(); i++) {
			if (cromosomas.get(i) == 1) {
				funcionalidades.addAll(Ejercicio3AG.funcionalidades.get(i));
			}
		}
		for (int i : Ejercicio3AG.requisitos) {
			if (!funcionalidades.contains(i)) {
				penalizacion++;
			}
		}
		
		// Valor de penalización: 100000, 120000, 150000, 80000, etc.
		return penalizacion * 120000;
		
	}

	/*
	 * Métodos auxiliares para ser accedidos por las clases de Solucion; solo son
	 * usados para el formateo de la salida y no están involucrados en la solución
	 * del ejercicio por AG.
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
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	*/
	public static void ejercicio3AG(String fichero) {
		
		// Solución por Algoritmos Genéticos - Cromosoma de rango:
		try {

			AG3.ejercicio3AG(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la solución mediante Algoritmos Genéticos ");
			System.out.println("para el fichero: " + fichero + ".\n");
			// e.printStackTrace();

		}
		
	}
	
}
