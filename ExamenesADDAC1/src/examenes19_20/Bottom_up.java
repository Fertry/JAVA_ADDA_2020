package examenes19_20;

import java.util.ArrayList;
import java.util.List;

public class Bottom_up {
	
	// Algoritmo original:
	public static long exam1(int n, int k) {
		if (k <= 2) {
			return n + k;
		} else {
			long p = 0;
			for (int i = 1; i <= k; i++) {
				p += n;
			}
			return p + exam1(n, k / 2) - exam1(n, k / 3);
		}
	}
	
	/*
	 * Se pide transformar el algoritmo anterior a iterativo
	 * mediante el esquema bottom-up:
	 */
	
	// Algoritmo bottom-up:
	public static long exam1BottomUp(int n, int k) {
		
		List<Long> lista = new ArrayList<Long>();

		// Ciclo de i=0 a k:
		for (int i = 0; i <= k; i++) {
			
			// "Caso base": 
			if (i <= 2) {
				
				lista.add(i, (long) (n + i));
			
		    // "Caso recursivo":
			} else {
				
				// exam1(n, k / 2) - exam1(n, k / 3);
				// Donde n*i es n*k:
				lista.add(i, n*i + (lista.get(i/2)  - lista.get(i/3)));
				
			}
			
		}

		return lista.get(k);
		
	}
	
}
