/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ejemplos practicos del 1º cuatrimestre de ADDA
 */

package ejercicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.lsi.geometria.Punto2D;

public class Puntos {
	
	// Para el parseo de tipo Punto2D de Miguel, como se ve en el fichero de LecturasDeDatos.java
	// se emplea el método Punto2D.create(coordenadaX.parseo(tipoRequerido), coordenadaY.parseo(tipoRequerido):
	String puntoX = "14.02";
	String puntoY = "-17.12";
	Punto2D puntoCreado = Punto2D.create(Double.parseDouble(puntoX), Double.parseDouble(puntoY));
	
	// #######################################################################################
	// #######################################################################################
	
	/*
	 * Función que suma valores de las coordenadas de puntos dados en una lista. También emplea un 
	 * Map para guardar dichas sumas por cuadrantes, siendo estos PRIMERCUADRANTE, SEGUNDOCUADRANTE, 
	 * TERCERCUADRANTE, CUARTOCUADRANTE. 
	 */
	public static Map<Punto2D.Cuadrante, Double> sumaPorCuadrantes(List<Punto2D> lista) {

		int i = 0;
		// Map de resultado correspondiente al cuadrante (tipo enumerado) y 
		// al valor de la suma: 
		Map<Punto2D.Cuadrante, Double> resultado = new HashMap<Punto2D.Cuadrante, Double>();

		while (i < lista.size()) {

			// Se reseta a 0 en cada iteración!
			Double valorPunto = 0.0;
			// Se chequea que NO sea nulo primero!
			if (resultado.get(lista.get(i).getCuadrante()) != null) {
				// Se obtiene el valor numérico del punto:
				valorPunto = resultado.get(lista.get(i).getCuadrante());
			}
			
			// Calculo de la suma por coordenada, en este caso para la coordenada X (similar para la Y):
			Double suma = valorPunto + lista.get(i).getX();
			// Añadir un elemento a un Map en base a la clave (siendo esta el cuadrante del elemento leido):
			resultado.put(lista.get(i).getCuadrante(), suma);
			i++;

		}

		return resultado;

	}


}
