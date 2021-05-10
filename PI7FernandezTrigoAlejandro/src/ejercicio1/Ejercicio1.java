/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import clases.Alumno;
import clases.Grupo;
import us.lsi.flujossecuenciales.StreamsS;

/*
	Una academia de inglés tiene n alumnos a ser repartidos en m grupos (n múltiplo
	de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
	afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
	rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
	todos los grupos deben tener el mismo número de alumnos, maximizando la
	afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no está
	permitido asignar un alumno a un grupo para el que presente afinidad 0.
*/

public class Ejercicio1 {
	
	/*
	 * Variables de la clase necesarias para resolver el ejercicio. 
	*/
	//private static List<String> nombres;
	//private static List<List<Integer>> afinidades;
	private static List<Grupo> grupos;
	private static List<Alumno> alumnos;
	
	/*
	 * Método inicial para la lectura de datos del fichero que se pasa como
	 * parámetro usando Collectors y el método StreamsS proporcionado por la librería.
	*/
//	public static void iniDatos(String fichero) {
//		
//		// Inicializar las variables de la clase Ejercicio1A:
//		nombres = new ArrayList<String>();
//		afinidades = new ArrayList<List<Integer>>();
//		
//		int i = 0;
//        List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
//
//        while (i < lista.size()) {
//        	
//            String linea = lista.get(i);            
//            
//            // Creo un objeto de tipo Alumno del cual extraer sus propieades:
//            Alumno alumno = Alumno.ofLinea(linea);
//            
//            nombres.add(alumno.getNombre());
//            
//            List<Integer> auxiliar = new ArrayList<Integer>();
//            for (Integer afinidad : alumno.getAfinidades()) {
//            	
//            	auxiliar.add(afinidad);
//            	
//            }
//            
//            afinidades.add(auxiliar);
//            
//            i++;
//            
//        }
//
//	}
	
	public static void iniDatos(String fichero) {
		
		// Inicializar las variables de la clase Ejercicio1:
		grupos = new ArrayList<Grupo>();
		alumnos = new ArrayList<Alumno>();
		
		int i = 0;
        List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());

        while (i < lista.size()) {
        	
            String linea = lista.get(i);            
            
            // Creo un objeto de tipo Alumno:
            Alumno alumno = Alumno.ofLinea(linea);
            
            // Creo un objeto de tipo Grupo:
            Grupo grupo = Grupo.create(alumno.getAfinidades().size());
            
            // Añadirlo todo a las variables de la clase:
            grupos.add(grupo);
            alumnos.add(alumno);
            
            i++;
            
        }

	}

	/*
	 * Métodos auxiliares para resolver el problema. 
	*/	
	
	public static Integer getNAlumnos() {
		
		return alumnos.size();
		
	}
	
	public static Integer getNGrupos() {
		
		return alumnos.get(0).getAfinidades().size();
		
	}
	
	public static Integer getReparto() {
		
		return getNAlumnos() / getNGrupos();
		
	}
	
	public static Integer getAfinidadPorIndice(Integer i, Integer j) {
		
		return alumnos.get(i).getAfinidades().get(j);
		
	}
	
	public static List<Integer> getListaAnchuras() {
		
		return IntStream.range(0, getNGrupos()).map(i -> i = getNAlumnos()).boxed().collect(Collectors.toList());
		//return IntStream.range(0, getNumeroEstantes()).map(i -> i = getAnchuraEstante()).boxed().collect(Collectors.toList());
	}
	
//	// Obtiene el nº de alumnos:
//	public static Integer getNAlumnos() { 
//		
//		return nombres.size();
//		
//	}
//	
//	// Obtiene el nº de afinidades:
//	public static Integer getNGrupos() { 
//		
//		return afinidades.get(0).size();
//		
//	}
//	
//	// Obtiene el tamaño del reparto: alumnos / afinidades (grupos) = tamaño grupos
//	public static Integer getReparto() {
//		
//		return getNAlumnos() / getNGrupos();
//		
//	}
//	
//	// Obtiene la lista de listas de afinidaes
//	public static List<List<Integer>> getAfinidades() {
//		
//		return afinidades;
//		
//	}
//
//	// Obtiene la afinidad de un alumno dado el alumno (i) para el grupo (j):
//	public static Integer afinidadPorIndice(Integer i, Integer j) {
//
//		return afinidades.get(i).get(j);
//		
//	}
	
}
