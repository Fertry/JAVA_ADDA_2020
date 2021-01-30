/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ejemplos practicos del 1� cuatrimestre de ADDA
 */

package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Arrays2;
import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;
import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.geometria.Punto2D;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class LecturasDeDatos {

	/*
	 * Funci�n de lectura para n�meros separados por coma. Cuando un ficher tiene
	 * varias lineas y cada linea representa un conjunt de n�meros separados por 
	 * un token (, # @ etc). Se puede convertir a entero con parseInt() o dejar el 
	 * dato en tipo String, etc. 
	 * 
	 * Se devuelve el contenido como lista de listas (donde cada lista peque�a 
	 * representa una l�nea de fichero). 
	 */
	public static List<List<Integer>> leeDatosEjercicio1(String fichero) {

		int i = 0;
		int j = 0;
		// Lectura del fichero de entrada:
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		// Lista de resultado a devolver:
		List<List<Integer>> resultado = new ArrayList<>();

		// Bucle superior que lee la lista "grande":
		while (i < lista.size()) {

			String fila = lista.get(i);
			// Split: cambiar en funci�n del s�mbolo
			String[] numeros = fila.split(", ");
			List<Integer> miniLista = new ArrayList<>();

			while (j < numeros.length) {

				// Parseo: cambiar en funci�n del tipo de dato:
				miniLista.add(Integer.parseInt(numeros[j]));
				j++;

			}

			// A�ade la lista "peque�a" a la "grande" y resetea j lo
			// que hace que volvamos a leer desde el principio!
			resultado.add(miniLista);
			j = 0;
			i++;

		}

		return resultado;

	}
	
	// #######################################################################################
	// #######################################################################################

	/*
	 * Funci�n de lectura para extraer n�s o caracteres de una linea con 
	 * m�s elementos: Ejemplo--> numero=5. Se emplea replace() para eliminar
	 * los caracteres sobrantes. 
	 */
	public static List<Integer> leeDatosEjercicio2(String fichero) {

		// Lectura del fichero de entrada:
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		// Lista de resultado a devolver:
		List<Integer> resultado = new ArrayList<Integer>();
		int i = 0;

		// Se lee el ficher l�nea a l�nea:
		while (i < lista.size()) {

			String fila = lista.get(i);
			// Para cada linea se elimina lo que sobra "numero=":
			String numero = fila.replace("Limite: ", "");
			// Parseo: se puede cambiar a otros tipos de datos:
			resultado.add(Integer.parseInt(numero));
			i++;

		}

		return resultado;

	}
	
	// #######################################################################################
	// #######################################################################################

	/*
	 * Similar a la anterior pero usando split() y replace() en varias ocasiones para:
	 * 	1. Split() para separar los datos como se ha visto antes cuando vienen con comas
	 * 	2. Replace() usuando sub�ndices elemento[i] para eliminar caracteres a lo que queda
	 * 	   a la izquierda y derecha del split!
	 * 
	 *  Si usamos split sobre A,B de la forma split(",") nos queda que elemento[0] correspnde
	 *  a "A" y elemento[1] corresponde a "B".
	 */
	public static List<Punto2D> leeDatosEjercicio3(String fichero) {

		int i = 0;
		// Lectura del fichero de entrada:
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		// Lista de resultado a devolver:
		List<Punto2D> resultado = new ArrayList<Punto2D>();

		while (i < lista.size()) {

			String fila = lista.get(i);
			// Split en base al regex ", ":
			String[] punto = fila.split(", ");
			// Replace a al contenido de la izquierda/derecha del resultado del split:
			String puntoX = punto[0].replace("(", "");
			String puntoY = punto[1].replace(")", "");

			// Casteo espec�fico del tipo Punto2D de Miguel:
			Punto2D puntoCreado = Punto2D.create(Double.parseDouble(puntoX), Double.parseDouble(puntoY));
			resultado.add(puntoCreado);
			i++;

		}

		return resultado;

	}
	
	// #######################################################################################
	// #######################################################################################

	/*
	 * Funci�n de lectura espec�fica para matrices bidimensionales. Esto es, usa el tipo
	 * multiArray() de Miguel. Cuando se quiere leer un fichero que representa una matriz
	 * de dimensi�n n*m se obtiene:
	 * 
	 * 	1. El rango de la matriz mediante el length() de la primera fila (por ej).
	 * 	2. El resultado a devolver es un entero de tipo Integer[] (propio de Java).
	 * 	3. Se lee fila a fila; por cada fila se hace split en funci�n del regex necesario
	 * 	   (en este caso un espacio) y se emplea un segundo bucle para a�adir a la fila 
	 *     actual, los n� de esa fila (sus columnas en el nivel actual). 
	 */
	public static Integer [][] leeDatosEjercicio4(String fichero) {
		
		int fila = 0;
		int columna = 0;
		int dimension = 0;
		// Lectura del fichero de entrada:
		List <String> filas = StreamsS.file(fichero).collect(Collectors.toList());
		// Calcular el largo de la fila, corresponde al rango de una matriz:
		int rango = filas.get(0).split(" ").length;
		// Array resultado de tipo bidimensional que se pasa al m�todo multiArray():
		Integer[] resultado = new Integer [rango * rango];
		
		// Empezamos en la fila 0 de la matriz:
		while (fila < filas.size()) {
			
			// El string numeros representa los n�s de ESA fila,
			// por eso arrancamos un string vac�o cada vez:
			String[] numeros = filas.get(fila).split(" ");
			
			// El segundo bucle recorre los n�s de esa fila (la columna del nivel fila):
			while (columna < numeros.length) {
				
				// A�adir al array los n�meros (parseados seg�n necesidad):
				resultado [dimension] = Integer.parseInt(numeros[columna]);
				
				// Saltamos al siguiente n�mero, esto es, siguiente columna 
				// del array y siguiente n� de la fila: 
				columna++;
				dimension++;
					
			}
			
			// Igual que visto antes, se reseta la columna (j) para empezar
			// a leer desde el principio: 
			fila++;
			columna = 0;
	
		}
		
		// Se devuelve el multiarray con el m�todo de Miguel que necesita el 
		// array bidimensional y, valga la redundancia, su dimensi�n (f x c): 
		return Arrays2.toMultiArray(resultado, rango, rango);
		
	}
	
	// #######################################################################################
	// #######################################################################################

	/*
	 * Funci�n de lectura espec�fica para �rboles de tipo binario. Se parsea mediante el 
	 * metodo de Miguel BinaryTree.parse() donde adem�s, se parsea el �rbol al tipo requerido.
	 */
	public static List <BinaryTree<Integer>> leeDatosEjercicio5(String fichero) {
		
		int i = 0;
		// Lectura del fichero de entrada:
		List <String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		// Lista de resultado a devolver:
		List <BinaryTree<Integer>> resultado = new ArrayList<BinaryTree<Integer>>();
		
		while (i < lista.size()) {
			
			// Parseo de una fila a tipo BinaryTree y casteo a entero: 
			BinaryTree<Integer> arbol = BinaryTree.parse(lista.get(i), s -> Integer.parseInt(s));
			// Se a�ade el �rbol a la lista resultado de tipo �rbol:
			resultado.add(arbol);
			i++;
			
		}
		
		return resultado;
		
	}
	
	// #######################################################################################
	// #######################################################################################

	/*
	 * Similar a las funciones anteriores pero mezclando dos lecturas distintas en una misma funci�n.
	 * Concretamente, si se quiere leer desde el mismo fichero dos tipos de datos separados por un 
	 * s�mbolo (en este caso un #), se usar� split() como anteriormente para separar ambos tipos de datos:
	 * 
	 * Ejemplo: leer de una misma fila, un arbol binario y una lista que est�n separadas por un # y devolver 
	 * ambas cosas, para esto, se usa una tupla que encapsula ambas cosas en un solo elemento de tipo 
	 * Tuple<ArbolBinario, Lista>. 
	 * 
	 * Pasos: 
	 * 	1. Primero hacemos el split() y nos quedamos con un contenido[0] (el arbol) y un contenido[1] (la lista)
	 * 	2. Ahora parseamos el arbol pasandole el contenido[0] al BinaryTree.parse() 
	 * 	3. Luego, nos encargamos de la lista (mas compleja) que requiere eliminar caracteres innecesarios con 
	 * 	   replace() y ya luego, hacer split en funci�n de los s�mbolos que separan los elementos de la lista. 
	 * 	4. Por �ltimo devolvemos los contenidos en una tuple con Tuple.create(). 
	 */
	public static List<Tuple2<BinaryTree<String>, List<String>>> leeDatosEjercicio6(String fichero) {

		int i = 0;
		int j = 0;
		// Lectura del fichero de entrada:
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		// Lista de resultado a devolver (de tipo Tuple2 de Miguel para <arboles, lista>):
		List<Tuple2<BinaryTree<String>, List<String>>> resultado = new ArrayList<Tuple2<BinaryTree<String>, List<String>>>();

		while (i < lista.size()) {

			// Hacer split el base al "#": 
			String fila = lista.get(i);
			String[] contenido = fila.split("#");
			
			// Parsear el contenido a la izquierda del split, 
			// correspondiente al arbol binario:
			List<String> letras = new ArrayList<String>();
			BinaryTree<String> arbol = BinaryTree.parse(contenido[0]);

			// Eliminar caracteres "[, ]" y hacer split en base a la coma:
			contenido[1] = contenido[1].replace("[", "");
			contenido[1] = contenido[1].replace("]", "");
			contenido[1] = contenido[1].replace("", "");
			String[] listaDeLetras = contenido[1].split(",");

			while (j < listaDeLetras.length) {

				letras.add(listaDeLetras[j]);
				j++;

			}

			j = 0;
			i++;

			resultado.add(Tuple.create(arbol, letras));

		}

		return resultado;

	}
	
	// #######################################################################################
	// #######################################################################################

	/*
	 * Funci�n de lectura gen�rica para arboles de tipo n-arios. Se puede devolver como
	 * arboles de tipo String cambiando el tipo E por String o usarlos como tipo gen�rico con
	 * el par�metro <E>. 
	 */
	// Supress para eliminar la advertencia del Tree.parse() que no pilla el tipo gen�rico. 
	@SuppressWarnings("unchecked")
	public static <E> List <Tree<E>> leeDatosEjercicio7(String fichero) {
		
		int i = 0;
		// Lista de resultado a devolver de tipo arbol gen�rico:
		// List <Tree<String>> resultado = new ArrayList<Tree<String>>();
		List<Tree<E>> resultado = new ArrayList<Tree<E>>();
		// Lectura del fichero de entrada:
		List <String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {
			
			String fila = lista.get(i);
			// Tree<String> arbol = Tree.parse(fila);
			Tree<E> arbol = (Tree<E>) Tree.parse(fila);
			resultado.add(arbol);
			i++;
			
		}
		
		return resultado;
		
	}
	
}
