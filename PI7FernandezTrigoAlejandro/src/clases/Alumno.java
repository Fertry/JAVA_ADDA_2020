/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package clases;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Pair;

/*
 * Clase alumno para parsear la entrada por fichero del ejercicio creando objetos de clase Alumno con 
 * sus respectivos atributos: Nombre y Lista de afinidades. Implemento la clase como extensión de Pair.
*/
//public class Alumno extends Pair<String, List<Integer>> {

public class Alumno implements Comparable<Alumno> {
	
	// MÉTODOS DE LA CLASE
	public static Alumno ofLinea(String linea) {

		return new Alumno(linea);

	}
	
	public static Alumno create(Integer valor,Integer peso, Integer countMax) {
		return new Alumno(valor, peso, countMax);
	}
	
	// ATRIBUTOS DE LA CLASE
//	public static String nombre;
//	public static List<Integer> afinidades;
	
	private static Integer nCodigo = 0;
	private Integer codigo;
	private Integer valor;
	private Integer peso;
	private Integer numMaxDeUnidades;

	// CONSTRUCTORES DE LA CLASE
//	private Alumno(String datos) {
//		
//		super(nombre, afinidades);
//		List<Integer> listaAfinidades = new ArrayList<Integer>();
//		
//		// Alumno_08: 5,3,2,0
//		// Alumno_08
//		// 5,3,2,0
//
//		String[] contenido = datos.split(": ");
//		String nombre = contenido[0];
//		String[] numeros = contenido[1].split(",");
//		
//		// Casteo los strings de "numeros" a entero para meterlos en la lista:
//		for (String numero : numeros) {
//			
//			listaAfinidades.add(Integer.parseInt(numero));
//			
//		}
//
//		Alumno.nombre = nombre;
//		Alumno.afinidades = listaAfinidades;
//
//	}
	
	Alumno(String datos) {
		
		// Alumno_08: 5,3,2,0
		// Alumno_08
		// 5,3,2,0

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
	
	Alumno(Integer valor, Integer peso, Integer countMax) {
		
		this.codigo = nCodigo;
		nCodigo++;
		this.valor = valor;
		this.peso = peso;
		this.numMaxDeUnidades = countMax;

	}

	// GETTTERS DE LA CLASE
	
	// Devuelve el nombre de un Alumno:
//	public String getNombre() {
//		
//		return nombre;
//		
//	}
//
//	// Devuelve la lista de afinidades de un Alumno:
//	public List<Integer> getAfinidades() {
//		
//		return afinidades;
//		
//	}
	
	public Integer getPeso() {
		return peso;
	}
	public Integer getValor() {
		return valor;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public Integer getNumMaxDeUnidades() {
		return numMaxDeUnidades;
	}
		
	public Double getRatioValorPeso() {
		return ((double)valor)/peso;
	}
	
	// TO_STRING DE LA CLASE (SOLO PARA HACER DEBUG)
//	@Override
//	public String toString() {
//		
//		return "[Alumno_" + nombre + ", lista de afinidades: " + afinidades + "]";
//		
//	}
	
	public String toString() {
		return String.format("(%d,%d,%d,%.2f)",
				valor,peso,numMaxDeUnidades,getRatioValorPeso());
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public int compareTo(Alumno alumno) {
		return this.getRatioValorPeso().compareTo(alumno.getRatioValorPeso());
	}

}
