/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

public class Ejercicio3Iterativa {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 3 - ITERATIVO				##################
	// ###################################################################################
	// ###################################################################################
			
	// Dados dos numeros 1 y 2, que son respectivamente, la base (Long) y el exponente (Integer)
	// se calcula a^n en base a las siguientes condiciones
	// Si exponente=0 --> 0, si exponente>0 --> en funcion del modulo:
	public static Long elevaAIterativo(Integer numero1, Integer numero2) {
		
		Long resultado = (long) 1;
		Long base = (long) numero1;
		Integer exponente = numero2;
		
		/*
		if (exponente == 0) {
			
			return resultado;
			
		} else {
			
			while () {
				
				
			}
			
		}
		*/
			
		return 1L;
		
	}

}


/*
public static Integer IterativoEj1(String cadena1, String cadena2) {
        int i = 0;
        int n = cadena1.length();
        int j = n;
        int k = cadena1.length()/2;
        while(j-i > 0 && !(cadena1.charAt(k)==cadena2.charAt(k))) {
            if(cadena1.charAt(k)==cadena2.charAt(k)) {
               j = k;
               k = (i + k) / 2;
            }else {
                i = k + 1;
                k = (k + 1 + j) / 2;
            }
        }
        if(j-i>0) {
            return k;
        }
        else {
            return -1;
        }
    }
 */


/*
public static Long elevaAIterativo(Integer numero1, Integer numero2) {

Long resultado = (long) 1;
Long base = (long) numero1;
Integer exponente = numero2;

while (exponente > 0) {
		
	if (exponente % 2 == 1) {
			
		//Si modulo == 1 ----> (a^(n/2))^2 * a
		resultado = (long) (base * (Math.pow((Math.pow(base, (exponente / 2))), 2)));
		return resultado;
								
	} else {
			
		//Si modulo == 0 ----> (a^(n/2))^2
		resultado = (long) (Math.pow((Math.pow(base, (exponente / 2))), 2));
		return resultado;
			
	}
		
}
	
return resultado;

}
*/