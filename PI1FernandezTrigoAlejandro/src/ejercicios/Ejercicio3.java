/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 1
 */

package ejercicios;

//Librerias:
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.geometria.Punto2D;

public class Ejercicio3 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 3					 #################
	// ###################################################################################
	// ###################################################################################

	// Funcion que lee una lista de puntos del formato (coordenadaX, coordenadaY) y
	// devuelve una lista de Punto2D formada por los puntos del fichero:
	public static List<Punto2D> leeDatosEjercicio3(String fichero) {

		int i = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List<Punto2D> resultado = new ArrayList<Punto2D>();

		while (i < lista.size()) {

			String fila = lista.get(i);
			String[] punto = fila.split(", ");
			String puntoX = punto[0].replace("(", "");
			String puntoY = punto[1].replace(")", "");

			Punto2D puntoCreado = Punto2D.create(Double.parseDouble(puntoX), Double.parseDouble(puntoY));
			resultado.add(puntoCreado);
			i++;

		}

		return resultado;

	}

	// Dado una lista de puntos, devuelve una colección de tipo Map con la suma de
	// sus coordenadas X por cada cuadrante:
	public static Map<Punto2D.Cuadrante, Double> sumaPorCuadrantes(List<Punto2D> lista) {

		int i = 0;
		Map<Punto2D.Cuadrante, Double> resultado = new HashMap<Punto2D.Cuadrante, Double>();

		while (i < lista.size()) {

			Double valorPunto = 0.0;
			if (resultado.get(lista.get(i).getCuadrante()) != null) {

				valorPunto = resultado.get(lista.get(i).getCuadrante());

			}
			
			Double suma = valorPunto + lista.get(i).getX();
			resultado.put(lista.get(i).getCuadrante(), suma);
			i++;

		}

		return resultado;

	}

}
