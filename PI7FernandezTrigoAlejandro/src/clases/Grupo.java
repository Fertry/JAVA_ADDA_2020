/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package clases;

/*
 * Clase grupo para representar grupos de alumnos creando objetos de clase Grupo con 
 * sus respectivos atributos.
*/
public class Grupo {
	
	// MÉTODOS DE LA CLASE
	public static Grupo create(Integer size) {
		
		return new Grupo(size);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	private Integer id;
	private Integer size;
	private static Integer n = 0;
	
	// CONSTRUCTORES DE LA CLASE
	private Grupo(Integer size) {
		
		super();
		
		this.id = n;
		this.size = size;
		n++;
		
	}
	
	// GETTTERS DE LA CLASE
	public Integer getId() {
		
		return id;
		
	}

	public Integer getSize() {
		
		return size;
		
	}

	// HASHCODE Y EQUALS DE LA CLASE
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
		
	}

	// TO_STRING DE LA CLASE (SOLO PARA HACER DEBUG)
	@Override
	public String toString() {
		
		return "[Grupo: " + id + ", tamaño: " + size + "]";
		
	}
	
}
