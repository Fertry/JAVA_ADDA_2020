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

	public static Alumno ofLinea(String datos) {

		return new Alumno(datos);

	}
	
	/*
	 * Método auxiliar para, dado un entero que corresponde a un grupo
	 * (posición) y un Alumno, devuelve la afinidad de dicho a alumno a 
	 * ese grupo o devuelve null si no existe dicho grupo.
	 */
	public static Integer getAfinidadAGrupo(Alumno alumno, Integer grupo) {
		
		Integer resultado = null;
		Integer numeroGrupos = alumno.getAfinidades().size();
		
		if (grupo > numeroGrupos || grupo < numeroGrupos) {
			
			resultado = null;
			
		} else {
			
			resultado = alumno.getAfinidades().get(grupo);
			
		}
		
		return resultado;
		
	}

	// ATRIBUTOS DE LA CLASE INMUTABLES
	private final String nombre;
	private final List<Integer> afinidades;

	// CONSTRUCTORES DE LA CLASE
	private Alumno() {
			
		this.nombre = null;
		this.afinidades = null;
		
	}
	
	private Alumno(String nombre, List<Integer> afinidades) {
		
		super();
		this.nombre = nombre;
		this.afinidades = afinidades;
		
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

		this.nombre = nombre;
		this.afinidades = listaAfinidades;
		
	}

	// GETTTERS DE LA CLASE
	public String getNombre() {
		
		return nombre;
		
	}

	public List<Integer> getAfinidades() {
		
		return afinidades;
		
	}

	// HASHCODE, EQUALS, TOSTRING DE LA CLASE	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((afinidades == null) ? 0 : afinidades.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (afinidades == null) {
			if (other.afinidades != null)
				return false;
		} else if (!afinidades.equals(other.afinidades))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
		
	}

	@Override
	public String toString() {
		
		return "Alumno [nombre=" + nombre + ", afinidades=" + afinidades + "]";
		
	}

}
