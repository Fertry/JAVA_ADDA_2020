/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio3;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Trio;

/* 
 * Clase producto para parsear la entrada por fichero del ejercicio creando objetos de clase Producto con 
 * sus respectivos atributos: Nombre, Precio y Lista de funcionalidades. Implemento la clase como extensión de Trio.
*/
public class Producto extends Trio<String, Double, List<String>>{

	// MÉTODOS DE LA CLASE
	public static Producto ofLinea(String datos) {
		
		return new Producto(datos);
		
	}

	// ATRIBUTOS DE LA CLASE
	public static String nombre;
	public static Double precio;
	public static List<String> funcionalidades;

	// CONSTRUCTORES DE LA CLASE
	private Producto(String datos) {
	
		super(nombre, precio, funcionalidades);
		List<String> listaFuncionalidades = new ArrayList<String>();
		
		// Secuencia de trims y splits: 
		// P01 (9.99 euros):  F1,F2
		// P01(9.99euros)
		// F1,F2 
		// P01
		// 9.99euros)
		// Replace final:
		// 9.99

		String[] contenido = datos.trim().split(":");
		
		String[] funcionalidades = contenido[1].trim().split(","); 
		String[] data = contenido[0].split("\\(");
		
		String nombre = data[0];
		Double precio = Double.parseDouble(data[1].replace("euros)", "")); 
		
		for (String funcion : funcionalidades) {
			
			listaFuncionalidades.add(funcion);
			
		}
		
		Producto.nombre = nombre;
		Producto.precio = precio;
		Producto.funcionalidades = listaFuncionalidades;
		
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

	// TO_STRING DE LA CLASE
	@Override
	public String toString() {
		
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", funcionalidades=" + funcionalidades + "]";
		
	}

}
