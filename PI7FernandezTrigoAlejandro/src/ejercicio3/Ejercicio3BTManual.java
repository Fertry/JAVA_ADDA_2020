/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio3;

/*
	Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
	de funcionalidades (el mismo producto puede tener m�s de una funcionalidad). Se
	desea dise�ar un lote con una selecci�n de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
	
	Soluci�n por Backtracking manual.
*/

public class Ejercicio3BTManual {
	
	public static void EjecutaEjercicio3BTManual(String entrada) {
	
		// Inicializa las variables de la clase Ejercicio3:
		Ejercicio3.iniDatos(entrada);
		
		// Invocar el algoritmo de Backtracking manual usando c�mo par�metro el Set<> de requisitos:
		System.out.println("$$$$$$$$$$$$$$$$$ BACKTRACKING MANUAL $$$$$$$$$$$$$$$$$$");
		ProductoBT.btm(Ejercicio3.getRequisitos());
		
		// DEBUG:
		System.out.println(ProductoBT.soluciones);
		
	}

}
