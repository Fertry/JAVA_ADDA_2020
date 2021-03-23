/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio3;

import java.util.ArrayList;
import java.util.List;

// Clase producto para parsear la entrada por fichero del ejercicio creando objetos de clase Producto con 
// sus respectivos atributos: Nombre, Precio y Lista de funcionalidades.
public class Producto {

	// M�TODOS DE LA CLASE
	public static Producto of() {

		return new Producto();

	}

	public static Producto ofDatos(String nombre, Double precio, List<String> funcionalidades) {

		return new Producto(nombre, precio, funcionalidades);

	}
	
	public static Producto ofLinea(String datos) {
		
		return new Producto(datos);
		
	}

	// ATRIBUTOS DE LA CLASE INMUTABLES
	private final String nombre;
	private final Double precio;
	private final List<String> funcionalidades;

	// CONSTRUCTORES DE LA CLASE
	private Producto() {
		
		this.nombre = null;
		this.precio = null;
		this.funcionalidades = null;
		
	}
	
	private Producto(String nombre, Double precio, List<String> funcionalidades) {
			
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.funcionalidades = funcionalidades;
			
	}
	
	private Producto(String datos) {
	
		super();
		List<String> listaFuncionalidades = new ArrayList<String>();
		
		// Secuencia de trims y splits: 
		// P01 (9.99 euros):  F1,F2
		// Primer paso: 
		// P01(9.99euros)
		// F1,F2
		// Segundo paso: 
		// P01
		// 9.99euros)
		// Replace final:
		// 9.99
		
		// ********************************************************************************************
		// Hacer split en base a los dos punts y eliminar los espacios; nos quedamos con la lista de funcionalidades
		// a un lado, y al otro, volvemos a splitear en base a la "(" qued�ndonos con el nombre y el precio que se
		// extrae eliminando los caracteres sobrantes y parseando a double:
		String[] primerpaso = datos.trim().split(":");
		String[] funcionalidades = primerpaso[1].trim().split(","); 
		String[] segundopaso = primerpaso[0].split("\\(");
		String nombre = segundopaso[0];
		Double precio = Double.parseDouble(segundopaso[1].replace("euros)", "")); 
		// ********************************************************************************************
		
		for (String funcion : funcionalidades) {
			
			listaFuncionalidades.add(funcion);
			
		}
		
		this.nombre = nombre;
		this.precio = precio;
		this.funcionalidades = listaFuncionalidades;
		
	}

	// GETTTERS DE LA CLASE
	public String getNombre() {
		
		return nombre;
		
	}

	public Double getPrecio() {
		
		return precio;
		
	}

	public List<String> getFuncionalidades() {
		
		return funcionalidades;
		
	}

	// HASHCODE, EQUALS, TOSTRING DE LA CLASE
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
	
	@Override
	public String toString() {
		
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", funcionalidades=" + funcionalidades + "]";
		
	}

}
