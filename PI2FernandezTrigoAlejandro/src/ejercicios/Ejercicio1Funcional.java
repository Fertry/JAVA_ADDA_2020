package ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.flujossecuenciales.StreamsS;

public class Ejercicio1Funcional {

	public static List<List<String>> leeDatosEjercicio1Funcional(String fichero) {
		
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
			
		return Stream.of(lista.spliterator("#"))
			

	
		return null;
		
	}
	
	
}
