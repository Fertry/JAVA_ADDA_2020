package ejercicioUno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;
import us.lsi.common.Tuple3;
import us.lsi.flujossecuenciales.StreamsS;

public class EjercicioUno {

	private static Map<String, List<Integer>> lecturaDatosEjercicio1(String fichero) {

		int i = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		Map<String, List<Integer>> resultado = new HashMap<String, List<Integer>>();

		while (i < lista.size()) {

			String fila = lista.get(i);
			// Hacer split en base a los dos puntos y quedarnos con la parte izquierda
			// que representa a los alumnos, hacer split nuevamente en base a
			// la coma (en la derecha) para quedarnos con la lista de grupos:
			String[] contenido = fila.split(": ");
			String alumno = contenido[0];
			String[] grupos = contenido[1].split(",");

			// En cada iteración reinicio la lista:
			List<Integer> listaAfinidades = new ArrayList<>();

			// Casteo los strings de "grupos" a entero para meterlos en la lista que se
			// almacena en el mapa:
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

	public static void realizarEjercicio() {

	}
}
