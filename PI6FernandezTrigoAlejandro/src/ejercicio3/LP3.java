/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio3;

import java.io.IOException;

import us.lsi.gurobi.GurobiLp;
import us.lsi.gurobi.GurobiSolution;
import us.lsi.solve.AuxGrammar;

//Programación Lineal
public class LP3 {
	
	/*
	 * Resolvedor de Gurobi: Se reciben los datos del fichero de entrada .txt y genera el fichero 
	 * LP con la entrada de los datos leidos en la clase Ejercicio3 y las restricciones 
	 * especificadas en Producto.lsi. Vuelca todo el Producto.lp que se pasa a la clase GurobiSolution encargada
	 * de calcular la solución.
	*/
	public static void ejercicio3LP(String fichero) throws IOException {
		
		// Para que el método sea reutilizable edito el string correspondiente al nombre:
		String ruta = "modelosLP/Producto" + fichero.replace("ficheros/PI6Ej3DatosEntrada", "").replace(".txt", "") +  ".lp";
		
		// Inicializada la lectura del fichero ahora obtiene los datos de Ejercicio3.java:
		Ejercicio3LP.iniDatos(fichero);
		AuxGrammar.dataClass = Ejercicio3LP.class;
		
		// Genera el fichero LP que se pasa al resolvedor de Gurobi:
		AuxGrammar.generate(Ejercicio3LP.class, "modelosLSI/Producto.lsi", ruta);
		GurobiSolution solution = GurobiLp.gurobi(ruta);
		
		// Vuelca la salida "sin formatear" por consola:
		// System.out.println(solution.toString((s, d) -> d > 0));
		
		// En su lugar, llamo a la clase Solucion3 para formatear la salida:
		// solo se toman los valores seleccionados (d > 0):
		Solucion3.solucionLP3(fichero, solution.toString((s, d) -> d > 0));
		
	}

}
