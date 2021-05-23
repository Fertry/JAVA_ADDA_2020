/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package tests;

import java.util.Locale;

import ejercicio1.Ejercicio1A;
import ejercicio1.Ejercicio1PD;
import ejercicio2.Ejercicio2A;
import ejercicio2.Ejercicio2PD;
import ejercicio3.Ejercicio3A;
import ejercicio3.Ejercicio3PD;
//import ejercicio4.Ejercicio4A;
//import ejercicio4.Ejercicio4PD;

public class Test {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("en", "US"));
		
		/*
		 *  Mostrar datos por pantalla formateados por las clases solución de todos los ejercicios.
		 *	Todos los ejercicios tienen una función pública que ejecuta los test de todas las funciones
		 *	implicadas. Ejecuto sólo el primer fichero de test de cada ejercicio. Para probar los demás
		 *  hay que descomentarlos pero comentar la línea que previamente se estaba ejecutando 
		 *  (por ej: para probar el fichero 2 en A* y PD para el ejercicio 1, descomentar las líneas
		 *  36 y 40 pero comentar las 35, 37, 39 y 41).
		*/
		System.out.println("######################### EJERCICIO 1 ############################");
			Ejercicio1A.EjecutaEjercicio1A("ficheros/PI7Ej1DatosEntrada1.txt");
			//Ejercicio1A.EjecutaEjercicio1A("ficheros/PI7Ej1DatosEntrada2.txt");
			//Ejercicio1A.EjecutaEjercicio1A("ficheros/PI7Ej1DatosEntrada3.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio1PD.EjecutaEjercicio1PD("ficheros/PI7Ej1DatosEntrada1.txt");
			//Ejercicio1PD.EjecutaEjercicio1PD("ficheros/PI7Ej1DatosEntrada2.txt");
			//Ejercicio1PD.EjecutaEjercicio1PD("ficheros/PI7Ej1DatosEntrada3.txt");
		System.out.println("##################################################################\n");
		
		System.out.println("######################### EJERCICIO 2 ############################");
			Ejercicio2A.EjecutaEjercicio2A("ficheros/PI7Ej2DatosEntrada1.txt");
			//Ejercicio2A.EjecutaEjercicio2A("ficheros/PI7Ej2DatosEntrada2.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio2PD.EjecutaEjercicio2PD("ficheros/PI7Ej2DatosEntrada1.txt");
			//Ejercicio2PD.EjecutaEjercicio2PD("ficheros/PI7Ej2DatosEntrada2.txt");
		System.out.println("##################################################################\n");
		
		System.out.println("######################### EJERCICIO 3 ############################");
			Ejercicio3A.EjecutaEjercicio3A("ficheros/PI7Ej3DatosEntrada1.txt");
			//Ejercicio3A.EjecutaEjercicio3A("ficheros/PI7Ej3DatosEntrada2.txt");
			//Ejercicio3A.EjecutaEjercicio3A("ficheros/PI7Ej3DatosEntrada3.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio3PD.EjecutaEjercicio3PD("ficheros/PI7Ej3DatosEntrada1.txt");	
			//Ejercicio3PD.EjecutaEjercicio3PD("ficheros/PI7Ej3DatosEntrada2.txt");
			//Ejercicio3PD.EjecutaEjercicio3PD("ficheros/PI7Ej3DatosEntrada3.txt");
		System.out.println("##################################################################\n");
		
		/*
		System.out.println("######################### EJERCICIO 4 ############################\n");
			Ejercicio4A.EjecutaEjercicio4A("ficheros/PI7Ej4DatosEntrada.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Ejercicio4PD.EjecutaEjercicio4PD("ficheros/PI7Ej4DatosEntrada.txt");
		System.out.println("##################################################################\n");
		*/
		
	}

}
