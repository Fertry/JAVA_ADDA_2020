package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ejercicioUno.Alumno;
import ejercicioUno.DataAlumno;
import us.lsi.gurobi.GurobiLp;
import us.lsi.solve.AuxGrammar;
import us.lsi.solve.DataMochila;

public class Test {

	public static void main(String[] args) {


		// DataMochila.iniMochila();
		try {
			alumno();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void alumno() throws IOException {
		DataAlumno.iniAlumno();
		AuxGrammar.generate(DataAlumno.class, "ficheros/alumnos.lsi", "ficheros/alumno.lp");
		GurobiLp.solve("ficheros/alumno.lp");
	}

	public static void ejercicioUno() {

	}

	public static void ejercicioDos() {

	}

	public static void ejercicioTres() {

	}

	public static void ejercicioCuatro() {

	}

	public static void ejercicioCinco() {

	}

}
