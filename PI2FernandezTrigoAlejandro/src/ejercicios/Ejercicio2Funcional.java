/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import us.lsi.common.Streams2;

public class Ejercicio2Funcional {

	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 2 - FUNCIONAL				##################
	// ###################################################################################
	// ###################################################################################
		
	// Dado dos numeros a,b se calcula si a es múltiplo de b en base a las siguientes condiciones
	// Si a==0 --> true, si 0<a<b --> false y si a>=b --> a=a-b:
	public static boolean esMultiploFuncional(Integer numero1, Integer numero2) {
		
		boolean resultado = true;

		if (numero1 == 0) {
			
			return true;
			 
		} else if (0 < numero1 && numero2 > numero1) {
			
			return false;
			
		} else if (numero1 >= numero2) {
	
			return (boolean) IntStream.range(numero1, numero2).filter(e->e>b).;
			//return IntStream.iterate(numero1, numero2 -> numero1 >= numero2, numero1 -> numero1 - numero2);
			return false;

		}
		
		return resultado;
 		
	}
	
}

/*
List<User> users = userDao.getAllByCompanyId(companyId);
users.stream().filter(Objects::nonNull).forEach(user -> {
    if (user.isPresent()) {
        user.setRole("ABC");
    } else {
        user.setRole("XYZ");
    }
});
*/
