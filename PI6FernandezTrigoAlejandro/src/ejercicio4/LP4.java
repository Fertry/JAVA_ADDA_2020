/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio4;

import java.io.IOException;

import us.lsi.gurobi.GurobiLp;
import us.lsi.gurobi.GurobiSolution;
import us.lsi.solve.AuxGrammar;

public class LP4 {

	/*
	 * Resolvedor de Gurobi: Se reciben los datos del fichero de entrada .txt y genera el fichero 
	 * LP con la entrada de los datos leidos en la clase Ejercicio4 y las restricciones 
	 * especificadas en Conjunto.lsi. Vuelca todo el Conjunto.lp que se pasa a la clase GurobiSolution encargada
	 * de calcular la soluci�n.
	 */
	public static void ejercicio4LP(String fichero, Integer indice) throws IOException {
		
		// Para que el m�todo sea reutilizable edito el string correspondiente al nombre:
		String ruta = "modelosLP/Conjunto" + (indice + 1) + ".lp";
		
		// Inicializada la lectura del fichero ahora obtiene los datos de Ejercicio2.java:
		Ejercicio4.iniDatos(fichero, indice);
		AuxGrammar.dataClass = Ejercicio4.class;
		
		// Genera el fichero LP que se pasa al resolvedor de Gurobi:
		AuxGrammar.generate(Ejercicio4.class, "modelosLSI/Conjunto.lsi", ruta);
		GurobiSolution solution = GurobiLp.gurobi(ruta);
		
		// Vuelca la salida "sin formatear" por consola:
		// System.out.println(solution.toString((s, d) -> d > 0));
	
		// En su lugar, llamo a la clase Solucion2 para formatear la salida;
		// solo se toman los valores seleccionados (d > 0):
		Solucion4.solucionLP4(fichero, solution.toString((s, d) -> d > 0), indice);
		
	}
}
