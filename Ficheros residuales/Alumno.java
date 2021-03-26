package ejercicioUno;

import java.util.ArrayList;
import java.util.List;

import us.lsi.mochila.datos.ObjetoMochila;

public class Alumno {

	private static Integer nCodigo = 0;

	public String nombre;
	public List<Integer> afinidades = new ArrayList<Integer>();
	public Integer numeroAfinidades;
	private Integer codigo;

	public static Alumno create(String nombre, List<Integer> afinidades, Integer numeroAfinidades) {
		return new Alumno(nombre, afinidades, numeroAfinidades);
	}

	public static Alumno create(String s) {
		return new Alumno(s);
	}

	Alumno(String nombre, List<Integer> afinidades, Integer numeroAfinidades) {
		this.codigo = nCodigo;
		nCodigo++;
		this.nombre = nombre;
		this.afinidades = afinidades;
		this.numeroAfinidades = numeroAfinidades;
	}

	Alumno(String s) {
		String[] contenido = s.split(": ");
		String nombre2 = contenido[0];
		String[] numeros = contenido[1].split(",");

		// String[] v = s.split("[ ,]");
		// Integer ne = contenido.length;

		// if (ne != 3) throw new IllegalArgumentException("Formato no adecuado en línea
		// " + s);
		// valor = Integer.parseInt(v[0].trim());
		// peso = Integer.parseInt(v[1].trim());
		// numMaxDeUnidades = Integer.parseInt(v[2]);

		// Casteo los strings de "numeros" a entero para meterlos en la lista:
		for (String numero : numeros) {
			afinidades.add(Integer.parseInt(numero));
		}
		numeroAfinidades = afinidades.size();
		nombre = nombre2;
		this.codigo = nCodigo;
		nCodigo++;
	}

	public Integer getAfinidad(Integer i) {
		return afinidades.get(i);
	}

	public String getNombre() {
		return nombre;
	}

	public List<Integer> getAfinidades() {
		return afinidades;
	}

	public Integer getNumeroAfinidades() {
		return afinidades.size();
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "; Afinidades: " + afinidades.toString() + "; Numero de afinidades: "
				+ numeroAfinidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((afinidades == null) ? 0 : afinidades.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroAfinidades == null) ? 0 : numeroAfinidades.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroAfinidades == null) {
			if (other.numeroAfinidades != null)
				return false;
		} else if (!numeroAfinidades.equals(other.numeroAfinidades))
			return false;
		return true;
	}
}
