/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio3;

import java.util.ArrayList;
import java.util.List;

// Clase producto para parsear la entrada por fichero del ejercicio creando objetos de clase Producto con 
// sus respectivos atributos: Nombre, Precio y Lista de funcionalidades.
public class Producto {

	// MÉTODOS DE LA CLASE
	public static Producto of() {

		return new Producto();

	}

	public static Producto ofLinea(String datos) {
		
		return new Producto(datos);
		
	}

	// ATRIBUTOS DE LA CLASE
	public static String nombre;
	public static Double precio;
	public static List<String> funcionalidades;

	// CONSTRUCTORES DE LA CLASE
	private Producto() {
		
		Producto.nombre = null;
		Producto.precio = null;
		Producto.funcionalidades = null;
		
	}
	
	// Este constructor representa el constructor principal de la clase encargado de parsear cada línea de fichero:
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

		// Hacer split en base a los dos punts y eliminar los espacios; nos quedamos con la lista de funcionalidades
		// a un lado, y al otro, volvemos a splitear en base a la "(" quedándonos con el nombre y el precio que se
		// extrae eliminando los caracteres sobrantes y parseando a double:
		String[] primerpaso = datos.trim().split(":");
		String[] funcionalidades = primerpaso[1].trim().split(","); 
		String[] segundopaso = primerpaso[0].split("\\(");
		String nombre = segundopaso[0];
		Double precio = Double.parseDouble(segundopaso[1].replace("euros)", "")); 
		
		for (String funcion : funcionalidades) {
			
			listaFuncionalidades.add(funcion);
			
		}
		
		Producto.nombre = nombre;
		Producto.precio = precio;
		Producto.funcionalidades = listaFuncionalidades;
		
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

	// TO_STRING DE LA CLASE
	@Override
	public String toString() {
		
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", funcionalidades=" + funcionalidades + "]";
		
	}

}
