package examenes15_16;

public class ConvocatoriaDiciembre {
	
	/*
	 * Implementación recursiva no final:
	 */
	public static Integer recursivaNoFinal(int[] a, int i, int j) {
		
		if (j - i == 1) {
			
			return a[i];
			
		} else {
			
			int m = i + j / 2;
			return 2*(recursivaNoFinal(a, i, m)) - recursivaNoFinal(a, i, m) + a[m];
			
		}
		
	}
	
	/*
	 * Implementación con una sola llamada recursiva:
	 */
	public static Integer recursivaNoFinalOptimo(int[] a, int i, int j) {
		
		if (j - i == 1) {
			
			return a[i];
			
		} else {
			
			int m = i + j / 2;
			return (recursivaNoFinalOptimo(a, i, m)) + a[m];
			
		}
		
	}
	
	/*
	 * Implementación recursiva final:
	 */
	public static Integer recursivaFinal(int[] a, int i, int j, int m) {
		
		int resultado = -1;
		
		if (j - i == 1) {
			
			resultado =  a[i];
			
		} else {
			
			m = i + j / 2;
			resultado = recursivaFinal(a, i, m, resultado + m);
			
		}
		
		return resultado;
	
	}
	
	/*
	 * Implementación iterativa:
	 */
	public static Integer iterativa(int[] a, int i, int j) {
		
		int sumatorio = 0;
		while (j - i != 1) {
			
			int m = i + j / 2;
			sumatorio += a[m];
			j = m;
			
		}
		
		return sumatorio;
		
	}
	
	/*
	 * Calculo de complejidad: 
	 * 	Tamaño del problema: n = j - 1
	 * 	Caso mejor: caso base
	 *  Caso peor: caso contrario (e.o.c)
	 *  Tiempo de ejecución T(n) = 
	 *  	* Para el caso recursivo: 2T(n/2) + 1 ----> n
	 *  	* Para el caso optimo: T(n/2) + 1	  ----> log(n)
	 *  	* Para el iterativo: E(prog. geométrica 1-2) hasta n ----> log(n)
	 */
	
}
