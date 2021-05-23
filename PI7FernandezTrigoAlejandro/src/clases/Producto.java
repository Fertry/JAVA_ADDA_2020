/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package clases;

import java.util.ArrayList;
import java.util.List;

/* 
 * Clase producto para parsear la entrada por fichero del ejercicio creando objetos de clase Producto con 
 * sus respectivos atributos: Nombre, Precio y Lista de funcionalidades.
*/
public class Producto {

	// MÉTODOS DE LA CLASE
	public static Producto ofLinea(String datos) {
		
		return new Producto(datos);
		
	}

	// ATRIBUTOS DE LA CLASE
	private String nombre;
	private Double precio;
	private List<String> funcionalidades;

	// CONSTRUCTORES DE LA CLASE
	private Producto() {
		
		super();
		
	}
	
	private Producto(String datos) {
	
		super();
		List<String> listaFuncionalidades = new ArrayList<String>();

		// P01 (9.99 euros):  F1,F2
		// P01(9.99euros)
		// F1,F2 
		// P01
		// 9.99euros)
		// 9.99

		String[] contenido = datos.trim().split(":");
		
		String[] funcionalidades = contenido[1].trim().split(","); 
		String[] data = contenido[0].split("\\(");
		
		String nombre = data[0];
		Double precio = Double.parseDouble(data[1].replace("euros)", "")); 
		
		for (String funcion : funcionalidades) {
			
			listaFuncionalidades.add(funcion);
			
		}
		
		this.nombre = nombre;
		this.precio = precio;
		this.funcionalidades = listaFuncionalidades;
		
	}

	// GETTTERS DE LA CLASE
	
	// Devuelve el nombre de un Producto:
	public String getNombre() {
		
		return nombre;
		
	}

	// Devuelve el precio de un Producto:
	public Double getPrecio() {
		
		return precio;
		
	}

	// Devuelve la lista de funcionalidades de un Producto:
	public List<String> getFuncionalidades() {
		
		return funcionalidades;
		
	}
	
	// HASHCODE Y EQUALS DE LA CLASE
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionalidades == null) ? 0 : funcionalidades.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		Producto other = (Producto) obj;
		if (funcionalidades == null) {
			if (other.funcionalidades != null)
				return false;
		} else if (!funcionalidades.equals(other.funcionalidades))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
		
	}	

	// TO_STRING DE LA CLASE (SOLO PARA HACER DEBUG)
	@Override
	public String toString() {
		
		return "[Producto_" + nombre + ", precio: " + precio + " euros, funcionalidades: " + funcionalidades + "]";
		
	}

}
