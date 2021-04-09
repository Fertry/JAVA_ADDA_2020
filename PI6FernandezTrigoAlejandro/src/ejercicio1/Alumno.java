/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio1;

import java.util.ArrayList;
import java.util.List;

// Clase alumno para parsear la entrada por fichero del ejercicio creando objetos de clase Alumno con 
// sus respectivos atributos: Nombre y Lista de afinidades.
public class Alumno {
	
	// MÉTODOS DE LA CLASE
	public static Alumno of() {

		return new Alumno();

	}

	public static Alumno ofLinea(String linea) {

		return new Alumno(linea);

	}
	
	// ATRIBUTOS DE LA CLASE INMUTABLES
	public static String nombre;
	public static List<Integer> afinidades;

	// CONSTRUCTORES DE LA CLASE
	public Alumno() {
			
		Alumno.nombre = null;
		Alumno.afinidades = null;
		
	}

	// Este constructor representa el constructor principal de la clase encargado de parsear cada línea de fichero:
	private Alumno(String datos) {
		
		super();
		List<Integer> listaAfinidades = new ArrayList<Integer>();
		
		// Secuencia de trims y splits:
		// Alumno_08: 5,3,2,0
		// Alumno_08
		// 5,3,2,0

		// Hacer split en base a los dos puntos y quedarnos con la parte izquierda
		// que representa al nombre, hacer split nuevamente en base a
		// la coma (en la derecha) para quedarnos con la lista de afinidades:
		String[] contenido = datos.split(": ");
		String nombre = contenido[0];
		String[] numeros = contenido[1].split(",");
		
		// Casteo los strings de "numeros" a entero para meterlos en la lista:
		for (String numero : numeros) {
			
			listaAfinidades.add(Integer.parseInt(numero));
			
		}

		Alumno.nombre = nombre;
		Alumno.afinidades = listaAfinidades;

	}

	// GETTTERS DE LA CLASE
	// Devuelve el nombre de un Alumno:
	public String getNombre() {
		
		return nombre;
		
	}

	// Devuelve la lista de afinidades de un Alumno:
	public List<Integer> getAfinidades() {
		
		return afinidades;
		
	}
	
	// Devuelve el nº de afinidades de un alumno:
	public Integer getNumeroAfinidades() {
		
		return afinidades.size();
		
	}
	
	// Devuelve la afinidad i de un alumno:
	public Integer getAfinidad(Integer i) {
		
		return afinidades.get(i);
		
	}
	
	// TO_STRING DE LA CLASE	
	@Override
	public String toString() {
		
		return "Alumno [Nombre = " + nombre + ", Afinidades = " + afinidades + "]";
		
	}

}
