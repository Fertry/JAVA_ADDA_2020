/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio1;

import java.io.IOException;

import us.lsi.gurobi.GurobiLp;
import us.lsi.gurobi.GurobiSolution;
import us.lsi.solve.AuxGrammar;

public class LP1 {
	
	/*
	 * Resolvedor de Gurobi: Se reciben los datos del fichero de entrada .txt y genera el fichero 
	 * LP con la entrada de los datos leidos en la clase Ejercicio1 y las restricciones 
	 * especificadas en Alumno.lsi. Vuelca todo el Alumno.lp que se pasa a la clase GurobiSolution encargada
	 * de calcular la solución.
	 */
	public static void ejercicio1LP(String fichero) throws IOException {
		
		// Para que el método sea reutilizable edito el string correspondiente al nombre:
		String ruta = "modelosLP/Alumno" + fichero.replace("ficheros/PI6Ej1DatosEntrada", "").replace(".txt", "") +  ".lp";
		
		// Inicializada la lectura del fichero ahora obtiene los datos de Ejercicio1.java:
		Ejercicio1.iniDatos(fichero);
		AuxGrammar.dataClass = Ejercicio1.class;
		
		// Genera el fichero LP que se pasa al resolvedor de Gurobi:
		AuxGrammar.generate(Ejercicio1.class, "modelosLSI/Alumno.lsi", ruta);
		GurobiSolution solution = GurobiLp.gurobi(ruta);
		
		// Vuelca la salida "sin formatear" por consola:
		// System.out.println(solution.toString((s, d) -> d > 0));
		
		// En su lugar, llamo a la clase Solucion1 para formatear la salida:
		// solo se toman los valores seleccionados (d > 0):
		Solucion1.solucionLP1(fichero, solution.toString((s, d) -> d > 0), solution.objVal);
		
	}

}
