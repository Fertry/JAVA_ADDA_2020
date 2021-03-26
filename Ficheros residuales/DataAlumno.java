package ejercicioUno;

import java.util.List;

import us.lsi.mochila.datos.DatosMochila;
import us.lsi.solve.AuxGrammar;
import us.lsi.solve.DataMochila;

public class DataAlumno {

	public static List<Alumno> alumnos;
	public static int n;

	public static Integer getN() {
		return n;
	}

	public static String getNombre(Integer i) {
		return alumnos.get(i).getNombre();
	}

	public static List<Integer> getAfinidades(Integer i) {
		return alumnos.get(i).getAfinidades();
	}

	public static Integer getNA(Integer i) {
		return alumnos.get(i).getNumeroAfinidades();
	}

	public static Integer s(Integer a, Integer b, Integer c) {
		return a + b + c;
	}

	public static void iniAlumno() {
		AuxGrammar.dataClass = DataAlumno.class;
		DatosAlumno.iniDatos("ficheros/PI6Ej1DatosEntrada1.txt");
		DataAlumno.alumnos = DatosAlumno.getAlumnos();
		System.out.println(DataAlumno.alumnos.toString());
		DataAlumno.n = DataAlumno.alumnos.size();
	}
}
