/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.common.Files2;
import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.gurobi.GurobiLp;
import us.lsi.solve.AuxGrammar;

/*
	Una academia de inglés tiene n alumnos a ser repartidos en m grupos (n múltiplo
	de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
	afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
	rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
	todos los grupos deben tener el mismo número de alumnos, maximizando la
	afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no está
	permitido asignar un alumno a un grupo para el que presente afinidad 0.
	
	Se piden soluciones por Programación Lineal y Algoritmos Genéticos
*/

public class Ejercicio1 {
	
	/*
	 * Lectura de datos; devuelve un mapa de tipo <String, List<Integer> que se corresponde a los 
	 * alumnos (claves) junto a la lista de afinidad de pertenencia a los respectivos grupos (valores).
	 */
	private static Map<String, List<Integer>> lecturaDatosEjercicio1(String fichero) {
		
		int i = 0;	
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		Map<String, List<Integer>> resultado = new HashMap<String, List<Integer>>();
		
		while (i < lista.size()) {

			String linea = lista.get(i);
			// Hacer split en base a los dos puntos y quedarnos con la parte izquierda
			// que representa a los alumnos, hacer split nuevamente en base a
			// la coma (en la derecha) para quedarnos con la lista de grupos:
			String[] contenido = linea.split(": ");
			String alumno = contenido[0];
			String[] grupos = contenido[1].split(",");
			
			// En cada iteración reinicio la lista:
			List<Integer> listaAfinidades = new ArrayList<>();
			
			// Casteo los strings de "grupos" a entero para meterlos en la lista que se almacena en el mapa:
			for (String numero : grupos) {
				
				listaAfinidades.add(Integer.parseInt(numero));
				
			}
			
			// Para cada alumno, añadimos al mapa su nombre (String) y como valor asociado 
			// a dicha clave, la lista de afinidades:
			resultado.put(alumno, listaAfinidades);

			// Pasa a la siguiente línea del fichero:
			i++;

		}
		
		return resultado;
		
	}
	
	private static List<Alumno> lecturaDatosEjercicio1_Test(String fichero) {
		
		int i = 0;	
		List<Alumno> resultado = new ArrayList<Alumno>();
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {

			String linea = lista.get(i);
			Alumno alumno = Alumno.ofLinea(linea);
			resultado.add(alumno);
			
			// Pasa a la siguiente línea del fichero:
			i++;

		}
		
		return resultado;
		
	}
	
	/*
	 * Repartir a los alumnos en base a su afinidad a pertenecer a cada uno de los 5 grupos (siempre
	 * que no sea 0) de forma que se maximize la afinidad total del grupo y que todos los grupos 
	 * contengan el mismo nº de alumnos. Realizar mediante Programación Lineal (PL).
	 */
	private static void ejercicio1ProgramacionLineal(Map<String, List<Integer>> entrada) {
		
		int i = 0;
		Set<String> alumnos = entrada.keySet();

		for (String alumno : alumnos) {
			int aux = entrada.get(alumno).size();
			while (i < aux) {
				
				System.out.println("Afinidad " + alumno + " grupo " + i + ": " + entrada.get(alumno).get(i).toString());
				i++;
			}
			i=0;
			
		}
		
	}
	
	/*
	 * Repartir a los alumnos en base a su afinidad a pertenecer a cada uno de los 5 grupos (siempre
	 * que no sea 0) de forma que se maximize la afinidad total del grupo y que todos los grupos 
	 * contengan el mismo nº de alumnos. Realizar mediante Algoritmos Genéticos (GA).
	 */
	private static void ejercicio1AlgoritmosGeneticos() {
		
		//TO-DO
		
	}
	
	public static void resolvedor() throws IOException {
		
		AuxGrammar.dataClass = Ejercicio1.class;
		Ejercicio1.iniDatos("ficheros/PI6Ej1DatosEntrada1.txt");
		AuxGrammar.generate(Ejercicio1.class, "src/ejercicio1/Alumno.lsi", "salida/alumno.lp");
		GurobiLp.solve("salida/alumno.lp");
		
	}
	
	private static List<Alumno> alumnos;
	public static Integer numeroDeAlumnos;
	
	public static void iniDatos(String fichero) {
		
		alumnos = Files2.streamFromFile(fichero).<Alumno>map((String s) -> Alumno.ofLinea(s)).collect(Collectors.<Alumno>toList());
		
		numeroDeAlumnos = alumnos.size();
		
	}
	
	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio1(String fichero) {
		
		// Lectura de datos de entrada:
		//Map<String, List<Integer>> mapa = lecturaDatosEjercicio1(fichero);
		//List<Alumno> lista = lecturaDatosEjercicio1_Test(fichero);
		
		// Salida de datos:
		//ejercicio1ProgramacionLineal(mapa);
		//ejercicio1AlgoritmosGeneticos();
		
		//System.out.println(" Reparto obtenido: ");
		//System.out.println(" ");
		//System.out.println(" Afinidad media: ");
		//System.out.println(" ");
		
		try {
			
			resolvedor();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		

		//System.out.println(mapa);
		//System.out.println(lista);
		
	}
	
	
	// =================================================================================================================
	/*
package ejercicioUno;

import java.util.ArrayList;
import java.util.List;

import us.lsi.mochila.datos.ObjetoMochila;

public class Alumno {

	public static Integer nCodigo = 0;

	public static String nombre = "";
	public static List<Integer> afinidades = new ArrayList<Integer>();

	public final Integer numeroAfinidades;
	public final Integer codigo;

	public static Alumno create(String nombre, List<Integer> afinidades, Integer numeroAfinidades) {
		return new Alumno(nombre, afinidades, numeroAfinidades);
	}

	public static Alumno create(String s) {
		return new Alumno(s);
	}

	public Alumno(String nombre, List<Integer> afinidades, Integer numeroAfinidades) {
		this.codigo = nCodigo;
		nCodigo++;
		this.nombre = nombre;
		this.afinidades = afinidades;
		this.numeroAfinidades = numeroAfinidades;
	}

	public Alumno(String s) {
		String[] contenido = s.split(": ");
		String nombre2 = contenido[0];
		String[] numeros = contenido[1].split(",");

		// String[] v = s.split("[ ,]");
		// Integer ne = contenido.length;

		// if (ne != 3) throw new IllegalArgumentException("Formato no adecuado en  linea
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

	public static Integer getAfinidad(Integer i) {
		return afinidades.get(i);
	}

	public static String getNombre() {
		return nombre;
	}

	public static List<Integer> getAfinidades() {
		return afinidades;
	}

	public static Integer getNumeroAfinidades() {
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
	 */

	// =================================================================================================================
	/*
package ejercicioUno;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Files2;
import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.mochila.datos.DatosMochila;
import us.lsi.mochila.datos.ObjetoMochila;

public class DatosAlumno {
	
	public static List<String> nombres;
	public static List<List<Integer>> afinidades;
	
	public static Integer numeroDeAlumnos;

	public static void iniDatos(String fichero) {
		afinidades = new ArrayList<List<Integer>>();
		nombres = new ArrayList<String>();
		
		int i = 0;
        List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());

        while (i < lista.size()) {
            String linea = lista.get(i);            
            create(linea);
            i++;
        }
		
		// numeroDeAlumnos = alumnos.size();
	}
	
	public static void create(String s) {
		String[] contenido = s.split(": ");
		String nombre2 = contenido[0];
		String[] numeros = contenido[1].split(",");

		 List<Integer> afinidadesAux = new ArrayList<Integer>();
		
		for (String numero : numeros) {
			afinidadesAux.add(Integer.parseInt(numero));
		}
		// numeroAfinidades = afinidades.size();
		nombres.add(nombre2);
		afinidades.add(afinidadesAux);
	}
	
	public static Integer obtenerAfinidad(Integer i, Integer j) {


		return afinidades.get(i).get(j);
	}
	
	public static Integer alumnosEntreAfinidad() {
		return getNumeroAlumnos()/getNumeroAfinidades();
	}

	public static Integer getNumeroAfinidades() { // i
		return afinidades.get(0).size();
	}

	public static Integer getNumeroAlumnos() { // j
		return nombres.size();
	}
}
	 */
	
	// =================================================================================================================
	/*
	package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ejercicioDos.DatosAbogado;
import ejercicioTres.EjercicioTres;
import ejercicioTres.Producto;
import ejercicioUno.DatosAlumno;
import us.lsi.common.Tuple2;
import us.lsi.gurobi.GurobiLp;
import us.lsi.gurobi.GurobiSolution;
import us.lsi.solve.AuxGrammar;
import us.lsi.solve.DataMochila;

public class Test {

	public static void main(String[] args) {

		try {
			ejercicioUno();
			// ejercicioDos();
			// ejercicioTres();
			// ejercicioCuatro();
			// ejercicioCinco();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ejercicioUno() throws IOException {
		DatosAlumno.iniDatos("ficheros/PI6Ej1DatosEntrada1.txt");
		AuxGrammar.dataClass = DatosAlumno.class;
		AuxGrammar.generate(DatosAlumno.class, "models/academia.lsi", "ficheros/academia.lp");
		GurobiSolution solution = GurobiLp.gurobi("ficheros/academia.lp");
		// System.out.println("Reparto obtenido: ");
		// System.out.println(solution.toString((s, d) -> d > 0));
		// System.out.println(" Hello World " + solution.toString());
		// System.out.println("GAGAHAHAHAHAHAHAHAHAHAHHA\n\n\n: ");
		String solucion = solution.values.toString();
		String[] soluciones = solucion.split(", ");
		int intt = 0;
		for (String i : soluciones) {
			if (intt != 0) {
				// System.out.println(i);

				// System.out.println(i.split("=").toString());

				intt++;
			}
			intt++;
		}
	}

	public static void ejercicioDos() throws IOException {
		DatosAbogado.iniDatos("ficheros/PI6Ej2DatosEntrada1.txt");
		AuxGrammar.dataClass = DatosAbogado.class;
		System.out.println("");
		System.out.println("Numero de abogados: " + DatosAbogado.getNumeroAbogados());
		System.out.println("Numero de casos: " + DatosAbogado.getNumeroCasos());
		System.out.println("");
		AuxGrammar.generate(DatosAbogado.class, "models/abogados.lsi", "ficheros/abogados.lp");
		GurobiSolution solution = GurobiLp.gurobi("ficheros/abogados.lp");
		// System.out.println(solution.toString((s, d) -> d > 0));
	}

	public static void ejercicioTres() throws IOException {
		Tuple2<List<String>, List<Producto>> t = EjercicioTres.lectura("ficheros/PI6Ej3DatosEntrada1.txt");
		System.out.println(t.getV1().get(1).toString());
	}

	public static void ejercicioCuatro() throws IOException {

	}

	public static void ejercicioCinco() throws IOException {

	}

}

	 */
	
	// =================================================================================================================
	/*
	 
head section

Integer obtenerAfinidad(Integer i, Integer j)
Integer getNumeroAfinidades()
Integer getNumeroAlumnos()
Integer alumnosEntreAfinidad()
Integer afinidades = getNumeroAfinidades()
Integer alumnos = getNumeroAlumnos()
Integer alumnosEntreAfinidad = alumnosEntreAfinidad()

goal section

max  sum(obtenerAfinidad(i, j) x[i, j], i in 0 .. alumnos, j in 0 .. afinidades)

constraints section

sum(x[i, j], i in 0 .. alumnos | obtenerAfinidad(i, j) > 0) = alumnosEntreAfinidad, j in 0 .. afinidades 
sum(x[i, j], j in 0 .. afinidades ) = 1, i in 0 .. alumnos 

bin 

x[i, j], i in 0 .. alumnos, j in 0 .. afinidades

	 */
	
}
