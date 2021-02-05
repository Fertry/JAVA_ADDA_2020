/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes18_19;

import java.util.stream.IntStream;

public class Ejercicio3Matrices {

	/*
	 *  Dada una matriz cuadrada de n x n números enteros, siendo n una potencia de 2,
	 *	devolver cierto en caso de que la suma del valor de la casilla superior izquierda y el
	 *	valor de la casilla inferior derecha coincida con la suma del valor de la casilla
	 *	superior derecha y el valor de la casilla inferior izquierda. Además, cada una de las
	 *	4 submatrices de una matriz dada deben también cumplir dicha propiedad, y, a su
	 *	vez, las 4 submatrices de cada submatriz, etc…, hasta llegar a matrices de 1 única
	 *	casilla que siempre cumplen la propiedad.
	 *	Por ejemplo, la siguiente matriz cuadrada (n = 4):
	 *
	 *  17 23 12 30
	 *	37 43 4 22
	 *	20 63 5 10
	 *	8 51 16 21
	 *
	 *  SÍ cumple la propiedad, ya que la matriz completa lo cumple (17+21=30+8), y cada
	 *	una de sus 4 submatrices también (17+43=23+37, 12+22=30+4, 20+51=63+8,
	 *	5+21=10+16).
	 *	
	 *  SE PIDE: Implementar el siguiente método para que devuelva cierto en caso de
	 *	cumplirse lo indicado en el enunciado, y falso en caso contrario.
	 *	public static boolean coincidenSumasMatriz (int[][] matriz)
	 *	Puede implementar los métodos auxiliares que considere oportuno.
	 */
	
	
	  public static boolean coincidenSumasMatriz(int[][] matriz) {
	  
	  return coincidenSumasMatrizPrivado(matriz, 0, 0, matriz.length);
	  
	  }
	  
	  private static boolean coincidenSumasMatrizPrivado(int[][] matriz, int i, int
	  j, int size) {
	  
	  boolean resultado = false;
	  
	  
	  
	  return resultado;
	  
	  }
	 
	
	/*
	 * Iterativa:
	 */
	public static boolean secuencia(String letras) {
		
		boolean resultado = true;
		
		int i = 0;
		int j = letras.length() - 2;
		
		while (i <= j && resultado) {
			
			resultado = letras.charAt(i) == letras.charAt(i + 1);
			i += 2;
			
		}
		
		return resultado;
		
	}
	
	/*
	 * Recursiva final:
	 */
	public static boolean secuenciaRecursivaPublica(String letras) {

		return secuenciaRecursiva(letras, 0, letras.length() - 2, true);
		
	}
	
	private static boolean secuenciaRecursiva(String letras, int i, int j, boolean resultado) {
		
		if (i <= j && resultado) {
			
			// Final: TODOS los parametros dentro de la llamada:
			boolean booleano = letras.charAt(i) == letras.charAt(i + 1);
			resultado = secuenciaRecursiva(letras, i + 2, j, booleano);
			
		} else {
			
			return resultado;
			
		}
		
		return resultado;
		
	}
	
	/*
	 * Recursiva NO final:
	 */
	public static boolean secuenciaRecursivaPublicaNoFinal(String letras) {

		return secuenciaRecursivaNoFinal(letras, 0, letras.length() - 2);
		
	}
	
	private static boolean secuenciaRecursivaNoFinal(String letras, int i, int j) {

		if (i <= j ) {
			
			// NO Final: el operando ocurre FUERA de la llamada:
			boolean booleano = letras.charAt(i) == letras.charAt(i + 1);
			return booleano && secuenciaRecursivaNoFinal(letras, i + 2, j);
			
		} else {
			
			return true;
			
		}
		
	}
	
	/*
	 * Funcional:
	 */
	public static boolean secuenciaFuncional(String letras) {
		
		return IntStream.rangeClosed(0, letras.length() - 1).
				filter(x -> x % 2 == 0).
				allMatch(x -> letras.charAt(x) == letras.charAt(x + 1));
		
	}
	
}
