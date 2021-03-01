/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio3;

import java.util.ArrayList;
import java.util.List;

/*
Un plan de estudios está estructurado para que los alumnos no puedan matricularse
libremente de las asignaturas que deseen. Existen asignaturas que deben haberse
cursado (y aprobado) anteriormente para que un alumno se pueda matricular de una
asignatura dada. Así, los prerrequisitos de una asignatura pueden ser 0 o más
asignaturas.

a. Implemente un método que devuelva una lista con todas las asignaturas en un
orden que cumpla con los prerrequisitos indicados.

b. Implemente un método que devuelva el conjunto de asignaturas que se pueden
cursar sin tener ninguna aprobada previamente. Muestre el grafo configurando
su apariencia de forma que se resalten dichas asignaturas.

c. Implemente un método que, dado un conjunto de asignaturas que un alumno
tiene aprobadas, devuelva un conjunto con las asignaturas que puede cursar el
próximo año. Muestre el grafo configurando su apariencia de forma que se
resalten las asignaturas de ambos conjuntos con 2 colores diferentes.
*/

public class Ejercicio3 {

	/*
	 * Lectura de datos; devuelve una lista de listas de.....
	 */
	public static List<String> lecturaDatosEjercicio3(String fichero) {

		List<String> resultado = new ArrayList<String>();

		return resultado;

	}
	
	/*
	 * Apartado A): Devuelve una lista con todas las asignaturas del fichero de entrada ordenadas en 
	 * base a: unas asignaturas deben cursarse/aprobarse ANTES de poder acceder a la siguiente (Ej: Asignatura_06
	 * necesita cursar/aprobar Asignatura_01 ANTES de poder seleccionarla). 
	 */
	
	/*
	 * Apartado B.1): Devuelve un conjunto de asiugnaturas que pueden ser cursadas/aprobadas SIN necesidad de 
	 * cursar/aprobar NINGUNA asignatura previamente. 
	 */
	
	/*
	 * Apartado B.2): Muestra el grafo resultante del método ....() coloreando aquellas asignaturas que cumplen
	 * la condición del apartado B.1). 
	 */
	
	/*
	 * Apartado C.1): Devuelve un conjunto de asignaturas que pueden ser cursadas/aprobadas, dado un 
	 * conjunto de asignaturas que ya han sido cursadas/aprobadas previamente. 
	 */
	
	/*
	 * Apartado C.2): Muestra el grafo resultante del método ....() coloreando las asignaturas que pueden cursarse
	 * de un color y las que no de otro distinto. 
	 */
	
}
