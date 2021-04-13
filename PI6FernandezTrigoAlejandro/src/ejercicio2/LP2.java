/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio2;

import java.io.IOException;

import us.lsi.gurobi.GurobiLp;
import us.lsi.gurobi.GurobiSolution;
import us.lsi.solve.AuxGrammar;

public class LP2 {
	
	/*
	 * Resolvedor de Gurobi: Se reciben los datos del fichero de entrada .txt y genera el fichero 
	 * LP con la entrada de los datos leidos en la clase Ejercicio2 y las restricciones 
	 * especificadas en Abogado.lsi. Vuelca todo el Abogado.lp que se pasa a la clase GurobiSolution encargada
	 * de calcular la solución.
	 */
	public static void ejercicio2LP(String fichero) throws IOException {
		
		// Para que el método sea reutilizable edito el string correspondiente al nombre:
		String ruta = "modelosLP/Abogado" + fichero.replace("ficheros/PI6Ej2DatosEntrada", "").replace(".txt", "") +  ".lp";
		
		// Inicializada la lectura del fichero ahora obtiene los datos de Ejercicio2.java:
		Ejercicio2.iniDatos(fichero);
		AuxGrammar.dataClass = Ejercicio2.class;
		
		// Genera el fichero LP que se pasa al resolvedor de Gurobi:
		AuxGrammar.generate(Ejercicio2.class, "modelosLSI/Abogado.lsi", ruta);
		GurobiSolution solution = GurobiLp.gurobi(ruta);
		
		// Vuelca la salida "sin formatear" por consola:
		// System.out.println(solution.toString((s, d) -> d > 0));
	
		// En su lugar, llamo a la clase Solucion2 para formatear la salida;
		// solo se toman los valores seleccionados (d > 0):
		Solucion2.solucionLP2(fichero, solution.toString((s, d) -> d > 0), solution.objVal);
		
	}

}
