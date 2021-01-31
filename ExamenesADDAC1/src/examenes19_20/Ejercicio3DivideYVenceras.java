/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes19_20;

import java.util.List;

import us.lsi.common.Tuple2;

public class Ejercicio3DivideYVenceras {
	
	/*
	 * 	Se tienen n monedas de igual tamaño. Se sospecha que una de ellas es falsa. Para
	 *	detectarlo, se sabe que todas las monedas deberían tener el mismo peso, y que la falsa
	 *	tendría un peso diferente (mayor o menor). Considere que dispone de una lista que
	 *	almacena los objetos de tipo Moneda y de un método, de complejidad constante, que
	 *	permite hacer una pesada de las monedas:
	 *
	 *  int pesada (List<Moneda> lm, int i_izq, int j_izq, int i_der, int j_der)
	 *  
	 *  Este método devuelve un número positivo si las monedas en el intervalo [i_izq, j_izq)
	 *	pesan más que las del intervalo [i_der, j_der), cero si pesan igual ambos platos, y un
	 *	número negativo en otro caso. Diseñar una función recursiva que determine, con el
	 *	mínimo número de pesadas posible, el índice en la lista de la moneda falsa si existe, o
	 *	-1 si no hay ninguna falsa, así como si la moneda falsa es más o menos pesada (valor
	 *	negativo si es menos pesada, positivo si es más pesada, o 0 si no hay ninguna falsa). La
	 *	función tendrá orden logarítmico y la siguiente signatura:
	 *
	 *  Tuple2<Integer,Integer> monedaFalsa(List<Moneda> lm)
	 *  
	 *  Ejemplo: Para la lista de monedas [7,7,5,7,7,7,7,7,7], la solución sería (2,-2).
	 *  
	 *  Notas:
	 *   Se aconseja formar 3 grupos con el mismo número de monedas
	 *   n debe ser mayor que 2 y potencia de 3
	 *   supóngase implementado el método necesario para determinar la solución en el
	 *   caso base, con nombre “casoBase”
	 */
	
	// ##############################################
	// Se pide:
	//a) Dar una definición recursiva de la función solicitada e implementarla en Java.
	//b) Sin necesidad de codificarlo, indique lo más detalladamente posible qué debe realizar
	//el método del caso base.
	//c) Justifique la complejidad del algoritmo mediante su cálculo.
	//d) ¿Qué modificaciones serían necesarias si n no fuera potencia de 3?
	// ##############################################
	
	// Apartado a): definición recursiva de la función e implementación:
	public static Tuple2<Integer, Integer> monedaFalsa(List<Integer> monedas) {
		
		return monedaFalsaPrivado(monedas, 0, monedas.size());
		
	}
	
	/*
	 * Si partimos el problema en 3 grupos de la forma:
	 * | -------- | -------- | ------- | 
	 *    [i, i+k)  [i+k, 2*k)   [2*k, j)
	 * Si el primero y el segundo son iguales, debe estar en el tercero
	 * Si el primero y el tercero son iguales, debe estar en el segundo
	 * Si el segundo y el tercero son iguales, debe estar en el primero
	 * 
	 * Es una busqueda binaria pero partiendo el problema en tres partes.
	 * Tenemos un caso base (ya hecho) y tres casos recursivos. 
	 * 
	 */
	private static Tuple2<Integer, Integer> monedaFalsaPrivado(List<Integer> monedas, int i, int j) {
		
		Tuple2<Integer, Integer> resultado = null;
		
		// Caso base:
		if (j - i <= 3) {
			
			// El caso base ya está implementado de acorde al enunciado:
			resultado = casoBase(monedas, i, j);

		// Caso recursivo:
		} else {
			
			// Dividir el problema en tres partes con el índice k:
			int k = (j - i) / 3;
			
			// Llamamos al método pesada() que recibe los limites de la lista por la izq/drch y la lista de monedas:
			// Pesada1 -> corresponde a los subindices [i, i + k) y [i+k, 2*k) osea el primero y el segundo son iguales: 
			int pesada1 = pesada(monedas, i, i + k, i + k, i + 2*k);
			// Pesada2 -> corresponde a los subindices [i, i + k) y [2*k, j) osea el primero y el tercero son iguales: 
			int pesada2 = pesada(monedas, i, i + k, i + 2*k, i + 3*k);
			
			// Comparamos los valores de las pesadas y llamamos recursivamente a la función:
			// Si la primera y la segunda son iguales, entonces:
			if (pesada1 == 0) {
				resultado = monedaFalsaPrivado(monedas, i + 2*k, j);
			// Si la primera y la tercera son iguales, entonces:
			} else if (pesada2 == 0) {
				resultado = monedaFalsaPrivado(monedas, i + k, i + 2*k);
	        // Si la segunda y la tercera son iguales, entonces:
			} else {
				resultado = monedaFalsaPrivado(monedas, i, i + k);
			}
			
		}
		
		return resultado;
		
	}
	
	// Este método viene dado por el enunciado.
	private static Tuple2<Integer, Integer> casoBase(List<Integer> monedas, int i, int j) {
		return null;
	}

	// Este método viene dado por el enunciado.
	private static int pesada(List<Integer> monedas, int i_izq, int j_izq, int i_der, int j_der) {
		return 0;
	}
	
	// Apartado b): Sin necesidad de codificarlo, indique lo más detalladamente posible qué debe realizar el método del caso base:
	/*
	 * Como entrada: lista de 3 monedas [a, b, c] e índices i, j. 
	 * Condición: Si todas las monedas son iguales, devolver -1. En caso contrario:
	 * 	Si a y b son iguales, c es falsa y se pesa para comprobar la diferencia de peso. 
	 *  Si a y b no son iguales, se toma la de mayor peso y se pesa con c:
	 *  	Si son iguales, la falsa es la que menos pese entre a y b.
	 *  	Si no son iguales, la falsa es la que mas pesa de la primera pesada.
	 */
	
	// Apartado c): Justifique la complejidad del algoritmo mediante su cálculo.
	/*
	 * Tamaño del problema: n, donde n = j - i 
	 * Ec. recurrencia --> T(n): T(n/3) + k porque el tamaño se divide entre 3  
	 * Complejidad --> T(n): 0(log) -> Logarítmico 
	 */
	
	// Apartado d): ¿Qué modificaciones serían necesarias si n no fuera potencia de 3?
	/*
	 * Mientras que se llegue al caso base con exactamente 3 elementos, no hay que cambiar nada. 
	 * Sin embargo, si se llega al caso base con mas de 3 elementos, hay que volver a llamar al caso base, 
	 * de lo contrario, si es menor a 3, hay que añadir una o dos monedas más al conjunto y llamar al caso base. 
	 */
	
}
