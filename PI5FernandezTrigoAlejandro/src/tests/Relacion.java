package tests;

public class Relacion {
	
	// MÉTODOS DE LA CLASE
	public static Relacion of() {
		return new Relacion();
	}
	
	public static Relacion ofVertex(Persona p1, Persona p2) {
		return new Relacion(p1,p2);
	}
	
	public static Relacion ofFormat(Persona p1, Persona p2) {
		return new Relacion(p1,p2);
	}
	
	public static Relacion ofWeight(Persona p1, Persona p2) {
		return new Relacion(p1, p2);
	}
	
	public static Relacion reverse(Relacion r) {
		return new Relacion(r.target, r.source);
	}
	
	// ATRIBUTOS DE LA CLASE
	private Persona source;
	private Persona target;

	// CONSTRUCTORES DE LA CLASE
	private Relacion(Persona p1, Persona p2) {
		this.source = p1;
		this.target = p2;
	}
	
	private Relacion() {
		this.source = null;
		this.target = null;
	}

	// GETTERS Y SETTERS
	public Persona getSource() {
		return source;
	}

	public Persona getTarget() {
		return target;
	}

	// HASHCODE, EQUALS, TOSTRING
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		Relacion other = (Relacion) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Relacion [source=" + source + ", target=" + target + ", getSource()=" + getSource() + ", getTarget()="
				+ getTarget() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

}
