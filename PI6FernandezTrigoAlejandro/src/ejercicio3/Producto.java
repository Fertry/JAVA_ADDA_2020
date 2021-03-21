package ejercicio3;

import java.util.ArrayList;
import java.util.List;

// Clase producto
public class Producto {

	// MÉTODOS DE LA CLASE
	public static Producto of() {

		return new Producto();

	}

	public static Producto ofDetails(String nombre, Integer precio, List<String> funcionalidades) {

		return new Producto(nombre, precio, funcionalidades);

	}
	
	public static Producto ofDatos(String datos) {
		
		return new Producto(datos);
		
	}

	// ATRIBUTOS DE LA CLASE
	private String nombre;
	private Integer precio;
	private List<String> funcionalidades;

	// CONSTRUCTORES DE LA CLASE
	private Producto() {
		
		this.nombre = null;
		this.precio = null;
		this.funcionalidades = null;
		
	}
	
	private Producto(String nombre, Integer precio, List<String> funcionalidades) {
			
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.funcionalidades = funcionalidades;
			
	}
	
	private Producto(String datos) {
	
		super();
		List<String> listaFuncionalidades = new ArrayList<String>();
		
		// Secuencia de trims y split: 
		// Primer split:
		//P01 (9.99 euros):  F1,F2
		//P01
		//9.99 euros):  F1,F2
		// Segundo split:
		//9.99euros
		//F1,F2
		
		String[] primerSplit = datos.split(" (");
		String nombreProducto = primerSplit[0].trim();
		
		String[] segundoSplit = primerSplit[1].split("):  ");
		String[] funcionalidades = segundoSplit[1].split(",");
		
		String precioTexto = segundoSplit[0].replace(" euros", "");
		Integer precioProducto = Integer.parseInt(precioTexto);
		
		for (String funcion : funcionalidades) {
			
			listaFuncionalidades.add(funcion);
			
		}
		
		this.nombre = nombreProducto;
		this.precio = precioProducto;
		this.funcionalidades = listaFuncionalidades;
		
	}

	// SETTERS/GETTTERS DE LA CLASE
	public String getNombre() {
		return nombre;
	}

	public Integer getPrecio() {
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
