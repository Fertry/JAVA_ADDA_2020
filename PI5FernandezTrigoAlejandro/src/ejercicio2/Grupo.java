/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio2;

//Clase grupo que representan aristas que unen profesores (vértices)
public class Grupo {

	// MÉTODOS DE LA CLASE
	public static Grupo of() {

		return new Grupo();

	}

	public static Grupo ofVertex(Profesor p1, Profesor p2, String nombre) {

		return new Grupo(p1, p2, nombre);

	}
	
	public static Grupo ofFormat(Profesor p1, Profesor p2, String[] formato) {
		
		return new Grupo(p1, p2, formato);
		
	}

	// ATRIBUTOS DE LA CLASE
	private double id;
	private Profesor p1;
	private Profesor p2;
	private String nombre;
	private static double numero = 0.0;

	// CONSTRUCTORES DE LA CLASE
	private Grupo(Profesor p1, Profesor p2, String nombre) {

		super();
		this.p1 = p1;
		this.p2 = p2;
		this.nombre = nombre;
		this.id = numero;
		numero++;

	}
	
	private Grupo() {
		
		this.p1 = null;
		this.p2 = null;
		this.nombre = null;
		this.id = numero;
		numero++;
		
	}
	
	private Grupo(Profesor p1, Profesor p2, String[] formato) {
		
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.nombre = formato[0];
		this.id = numero;
		numero++;
		
	}

	// SETTERS/GETTTERS DE LA CLASE
	public Profesor getOrigen() {

		return p1;

	}

	public Profesor getDestino() {

		return p2;

	}

	public double getId() {

		return this.id;

	}
	
	public String getNombre() {
		
		return this.nombre;
		
	}

	// HASHCODE, EQUALS, TOSTRING DE LA CLASE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(id);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Grupo other = (Grupo) obj;
		if (Double.doubleToLongBits(id) != Double.doubleToLongBits(other.id))
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
		
		return this.nombre;
		
	}

}
