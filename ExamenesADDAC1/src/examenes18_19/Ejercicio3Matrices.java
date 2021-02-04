/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes18_19;

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
	
	private static boolean coincidenSumasMatrizPrivado(int[][] matriz, int i, int j, int size) {
		
		boolean resultado = false;
		
		
		
		return resultado;
		
	}
	
}
