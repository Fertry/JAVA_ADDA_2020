package ejercicioUno;

import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Files2;
import us.lsi.mochila.datos.DatosMochila;
import us.lsi.mochila.datos.ObjetoMochila;

public class DatosAlumno {

	private static List<Alumno> alumnos;
	public static Integer numeroDeAlumnos;

	public static void iniDatos(String fichero) {
		alumnos = Files2.streamFromFile(fichero).<Alumno>map((String s) -> Alumno.create(s))
				.collect(Collectors.<Alumno>toList());
		numeroDeAlumnos = alumnos.size();
	}

	public static List<Alumno> getAlumnos() {
		return alumnos;
	}

	public static Alumno getAlumno(int index) {
		return DatosAlumno.getAlumnos().get(index);
	}

	public static String getNombre(int index) {
		return DatosAlumno.getAlumnos().get(index).getNombre();
	}

	public static List<Integer> getAfinidades(int index) {
		return DatosAlumno.getAlumnos().get(index).getAfinidades();
	}

	public static Integer getNumeroAfinidades(int index) {
		return DatosAlumno.getAlumnos().get(index).getNumeroAfinidades();
	}

	public static Boolean restricciones(Integer c) {
		return c >= 0;
	}
}