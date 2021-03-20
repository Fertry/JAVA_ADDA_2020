/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio3;

/*
	Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
	de funcionalidades (el mismo producto puede tener más de una funcionalidad). Se
	desea diseñar un lote con una selección de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
	
	Se piden soluciones por Programación Lineal y Algoritmos Genéticos
*/

public class Ejercicio3 {
	
	private static void lecturaDatosEjercicio3() {
		
		//TO-DO
		
	}
	
	/*
	    Funcionalidades a cubrir: F1,F2,F3,F4,F5,F7
		P01 (9.99 euros):  F1,F2
		P02 (9.95 euros):  F1,F5
		P03 (5.99 euros):  F6,F9
	 */
	
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
		lecturaDatosEjercicio3();
		
		// Salida de datos:
		ejercicio3ProgramacionLineal();
		ejercicio3AlgoritmosGeneticos();
		
		System.out.println(" Funcionalidades a cubrir: ");
		System.out.println(" Composición del lote seleccionado: ");
		System.out.println("  ");
		System.out.println(" Funcionalidades de la selección: ");
		System.out.println(" Precio total del lote seleccionado: " + " euros");
		System.out.println(" ");
		
		System.out.println("jaja saludos xd");
		
	}

}
