package ejercicios;

public class Ejercicio2Iterativa {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 2 - ITERATIVO				##################
	// ###################################################################################
	// ###################################################################################
		
	//
	public static boolean esMultiploIterativo(Integer a, Integer b) {
		
		boolean resultado = true;
		boolean verdadero = true;
		
		while (a > 0) {
			
			if (a == 0 && verdadero) {
				
				resultado = true;
				verdadero = false;
				
			} else if (a > 0 && b > a) {
				
				resultado = false;
				verdadero = false;
				
			} else if (a >= b) {
				
				a = a - b;
				verdadero = false;
				
			}
			
		}
		
		return resultado;

	}

}
