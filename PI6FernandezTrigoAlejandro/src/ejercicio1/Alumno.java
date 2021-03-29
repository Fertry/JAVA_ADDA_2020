/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio1;

import java.util.ArrayList;
import java.util.List;

//Clase alumno para parsear la entrada por fichero del ejercicio creando objetos de clase Alumno con 
//sus respectivos atributos: Nombre y Lista de afinidades.
public class Alumno {
	
	// MÉTODOS DE LA CLASE
	public static Alumno of() {

		return new Alumno();

	}

	public static Alumno ofDatos(String nombre, List<Integer> afinidades) {

		return new Alumno(nombre, afinidades);

	}

	public static Alumno ofLinea(String linea) {

		return new Alumno(linea);

	}
	
	/*
	 * Método auxiliar para, dado un entero que corresponde a un grupo
	 * (posición) y un Alumno, devuelve la afinidad de dicho a alumno a 
	 * ese grupo o devuelve null si no existe dicho grupo.
	 */
	public static Integer getAfinidadAGrupo(Alumno alumno, Integer grupo) {
		
		Integer resultado = null;
		Integer numeroGrupos = Alumno.getAfinidades().size();
		
		if (grupo > numeroGrupos || grupo < numeroGrupos) {
			
			resultado = null;
			
		} else {
			
			resultado = Alumno.getAfinidades().get(grupo);
			
		}
		
		return resultado;
		
	}

	// ATRIBUTOS DE LA CLASE INMUTABLES
	private static Integer n = 0;
	public static Integer id;
	public static String nombre;
	public static List<Integer> afinidades;

	// CONSTRUCTORES DE LA CLASE
	public Alumno() {
			
		Alumno.id = null;
		Alumno.nombre = null;
		Alumno.afinidades = null;
		
	}
	
	private Alumno(String nombre, List<Integer> afinidades) {
		
		super();
		Alumno.id = n;
		Alumno.nombre = nombre;
		Alumno.afinidades = afinidades;
		n++;
		
	}

	private Alumno(String datos) {
		
		super();
		List<Integer> listaAfinidades = new ArrayList<Integer>();
		
		// Secuencia de trims y splits:
		// Alumno_08: 5,3,2,0
		// Alumno_08
		// 5,3,2,0

		// ********************************************************************************************
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
		// ********************************************************************************************

		Alumno.id = n;
		Alumno.nombre = nombre;
		Alumno.afinidades = listaAfinidades;
		n++;
		
	}

	// GETTTERS DE LA CLASE
	public static Integer getId() {
		
		return id;
				
	}
	
	public static String getNombre() {
		
		return nombre;
		
	}

	public static List<Integer> getAfinidades() {
		
		return afinidades;
		
	}
	
	public static Integer getNumeroGrupos() {
		
		return afinidades.size();
		
	}

	// TO_STRING DE LA CLASE	
	@Override
	public String toString() {
		
		return "Alumno [Nombre = " + nombre + ", Afinidades = " + afinidades + "]";
		
	}

}
