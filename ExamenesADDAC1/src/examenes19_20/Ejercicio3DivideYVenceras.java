/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ex�menes del 1� cuatrimestre de ADDA
 */

package examenes19_20;

import java.util.List;

import us.lsi.common.Tuple2;

public class Ejercicio3DivideYVenceras {
	
	/*
	 * 	Se tienen n monedas de igual tama�o. Se sospecha que una de ellas es falsa. Para
	 *	detectarlo, se sabe que todas las monedas deber�an tener el mismo peso, y que la falsa
	 *	tendr�a un peso diferente (mayor o menor). Considere que dispone de una lista que
	 *	almacena los objetos de tipo Moneda y de un m�todo, de complejidad constante, que
	 *	permite hacer una pesada de las monedas:
	 *
	 *  int pesada (List<Moneda> lm, int i_izq, int j_izq, int i_der, int j_der)
	 *  
	 *  Este m�todo devuelve un n�mero positivo si las monedas en el intervalo [i_izq, j_izq)
	 *	pesan m�s que las del intervalo [i_der, j_der), cero si pesan igual ambos platos, y un
	 *	n�mero negativo en otro caso. Dise�ar una funci�n recursiva que determine, con el
	 *	m�nimo n�mero de pesadas posible, el �ndice en la lista de la moneda falsa si existe, o
	 *	-1 si no hay ninguna falsa, as� como si la moneda falsa es m�s o menos pesada (valor
	 *	negativo si es menos pesada, positivo si es m�s pesada, o 0 si no hay ninguna falsa). La
	 *	funci�n tendr� orden logar�tmico y la siguiente signatura:
	 *
	 *  Tuple2<Integer,Integer> monedaFalsa(List<Moneda> lm)
	 *  
	 *  Ejemplo: Para la lista de monedas [7,7,5,7,7,7,7,7,7], la soluci�n ser�a (2,-2).
	 *  
	 *  Notas:
	 *   Se aconseja formar 3 grupos con el mismo n�mero de monedas
	 *   n debe ser mayor que 2 y potencia de 3
	 *   sup�ngase implementado el m�todo necesario para determinar la soluci�n en el
	 *   caso base, con nombre �casoBase�
	 */
	
	// ##############################################
	// Se pide:
	//a) Dar una definici�n recursiva de la funci�n solicitada e implementarla en Java.
	//b) Sin necesidad de codificarlo, indique lo m�s detalladamente posible qu� debe realizar
	//el m�todo del caso base.
	//c) Justifique la complejidad del algoritmo mediante su c�lculo.
	//d) �Qu� modificaciones ser�an necesarias si n no fuera potencia de 3?
	// ##############################################
	
	// Apartado a): definici�n recursiva de la funci�n e implementaci�n:
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
			
			// El caso base ya est� implementado de acorde al enunciado:
			resultado = casoBase(monedas, i, j);

		// Caso recursivo:
		} else {
			
			// Dividir el problema en tres partes con el �ndice k:
			int k = (j - i) / 3;
			
			// Llamamos al m�todo pesada() que recibe los limites de la lista por la izq/drch y la lista de monedas:
			// Pesada1 -> corresponde a los subindices [i, i + k) y [i+k, 2*k) osea el primero y el segundo son iguales: 
			int pesada1 = pesada(monedas, i, i + k, i + k, i + 2*k);
			// Pesada2 -> corresponde a los subindices [i, i + k) y [2*k, j) osea el primero y el tercero son iguales: 
			int pesada2 = pesada(monedas, i, i + k, i + 2*k, i + 3*k);
			
			// Comparamos los valores de las pesadas y llamamos recursivamente a la funci�n:
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
	
	// Este m�todo viene dado por el enunciado.
	private static Tuple2<Integer, Integer> casoBase(List<Integer> monedas, int i, int j) {
		return null;
	}

	// Este m�todo viene dado por el enunciado.
	private static int pesada(List<Integer> monedas, int i_izq, int j_izq, int i_der, int j_der) {
		return 0;
	}
	
	// Apartado b): Sin necesidad de codificarlo, indique lo m�s detalladamente posible qu� debe realizar el m�todo del caso base:
	/*
	 * Como entrada: lista de 3 monedas [a, b, c] e �ndices i, j. 
	 * Condici�n: Si todas las monedas son iguales, devolver -1. En caso contrario:
	 * 	Si a y b son iguales, c es falsa y se pesa para comprobar la diferencia de peso. 
	 *  Si a y b no son iguales, se toma la de mayor peso y se pesa con c:
	 *  	Si son iguales, la falsa es la que menos pese entre a y b.
	 *  	Si no son iguales, la falsa es la que mas pesa de la primera pesada.
	 */
	
	// Apartado c): Justifique la complejidad del algoritmo mediante su c�lculo.
	/*
	 * Tama�o del problema: n, donde n = j - i 
	 * Ec. recurrencia --> T(n): T(n/3) + k porque el tama�o se divide entre 3  
	 * Complejidad --> T(n): 0(log) -> Logar�tmico 
	 */
	
	// Apartado d): �Qu� modificaciones ser�an necesarias si n no fuera potencia de 3?
	/*
	 * Mientras que se llegue al caso base con exactamente 3 elementos, no hay que cambiar nada. 
	 * Sin embargo, si se llega al caso base con mas de 3 elementos, hay que volver a llamar al caso base, 
	 * de lo contrario, si es menor a 3, hay que a�adir una o dos monedas m�s al conjunto y llamar al caso base. 
	 */
	
}
