/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import aristas.AristaConjunto;
import ejercicio4.Ejercicio4;
import us.lsi.common.Lists2;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase v�rtice conjunto para representar v�rtices del grafo de un tipo definido.
 * 
 * Interpretaci�n: Encontrar a qu� subconjunto pertenece cada elemento, desde indice hasta el final,
 * que minimice el n�mero de elementos de uno de los subconjuntos.
*/
public class VerticeConjunto extends ActionVirtualVertex <VerticeConjunto, AristaConjunto, Integer> {
	
	// M�TODOS DE LA CLASE
	public static VerticeConjunto of(Integer indice, List<Integer> conjunto) {

		return new VerticeConjunto(indice, conjunto);

	}

	// ATRIBUTOS DE LA CLASE

	// Variables b�sicas:
	private Integer indice;
	private List<Integer> conjunto;

	// Variables compartidas (Extraidas de clase general donde se inicializan los datos):
	private static Integer N = Ejercicio4.getSumatorio();
	private static Integer elementos = Ejercicio4.getSizeConjunto();
	
	// CONSTRUCTORES DE LA CLASE
	public VerticeConjunto(Integer indice, List<Integer> conjunto) {
			
			super();
			
			this.indice = indice;
			this.conjunto = conjunto;
		
		}

	// GETTERS DE LA CLASE

	// Devuelve el �ndice del v�rtice:
	public Integer getIndice() {

		return indice;

	}
	
	// Devuelve la lista de elementos (conjunto):
	public List<Integer> getConjunto() {
		
		return conjunto;
		
	}

	// M�TODOS PARA TRABAJAR CON GRAFOS VIRTUALES

	// M�todo que verifica si alcanzamos el objetivo o no: el �ndice alcanze el n� de elementos:
	public static Predicate<VerticeConjunto> objetivo() {

		return (VerticeConjunto vertice) -> vertice.getIndice() == VerticeConjunto.elementos;

	}

	// Definir un v�rtice de comienzo d�nde el estado inicial sea (0, [N,N,N]):
	public static VerticeConjunto verticeInicial() {

		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();

		while (i < 3) {

			auxiliar.add(N);
			i++;

		}

		VerticeConjunto resultado = VerticeConjunto.of(0, auxiliar);
		return resultado;

	}

	// M�TODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acci�n aplicada a un v�rtice (por donde se desplaza):
	public AristaConjunto edge(Integer accion) {

		AristaConjunto resultado = AristaConjunto.of(this, neighbor(accion), accion);

		return resultado;

	}

	@Override
	// Comprueba la validez de un v�rtice dado, esto es: se encuentra dentro del intervalo cerrado [0, n]
	// y adem�s, cuenta con espacio disponible, vr[i]>0 para i, donde i [0..2]:
	public Boolean isValid() {

		int i = 0;
		Boolean valido = false;

		// Si NO es el v�rtice inicial NI el final:
		if (this.indice >= 0 && this.indice <= elementos) {

			// Mientras que vr[i] >= 0: 
			while (i < 3) {
			
				if (this.conjunto.get(i) >= 0) {
					
					valido = true;
					
				}
			
				i++;
				
			}
			
		}
		
		return valido;

	}

	@Override
	// Devuelve el v�rtice "vecino" que corresponde a la acci�n tomada:
	// i+1,vr' donde vr'[a]=vr[a]-ei
	public VerticeConjunto neighbor(Integer accion) {

		// 1� obtener el siguiente indice:
		Integer siguiente = this.indice + 1;

		// 2� copiar el conjunto actual:
		List<Integer> auxiliar = this.conjunto;
		
		// 3� modificar el valor de auxiliar para el �ndice dado:
		auxiliar.set(accion, (this.conjunto.get(accion) - this.indice)); 

		VerticeConjunto resultado = VerticeConjunto.of(siguiente, auxiliar);

		return resultado;

	}

	@Override
	// Devuelve la lista de acciones (movimientos en el grafo) posibles en base a
	// las restricciones:
	public List<Integer> actions() {

		List<Integer> acciones = this.conjunto;
		
		// Caso i = n-1:
		if (this.indice == elementos - 1) {
			
			int a = 0;
			while (a < 3) {

				// Caso vr[i] = 0, i != a,
				if (this.conjunto.get(this.indice) == 0 && this.indice != a) {

					acciones = this.conjunto;
					acciones.set(a, (this.conjunto.get(a) - this.indice));
					a++;
					return acciones;

				// En otro caso:
				} else {

					a++;
					return Lists2.of();

				}

			}

		// Caso general:
		} else {
			
			acciones = this.conjunto;
			//acciones.set(a, (this.conjunto.get(a) - this.indice));
			return acciones;
	
		}
		
		return acciones;
		
	}

	// HASHCODE Y EQUALS DE LA CLASE EN BASE A INDICE Y CONJUNTO
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conjunto == null) ? 0 : conjunto.hashCode());
		result = prime * result + ((indice == null) ? 0 : indice.hashCode());
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
		VerticeConjunto other = (VerticeConjunto) obj;
		if (conjunto == null) {
			if (other.conjunto != null)
				return false;
		} else if (!conjunto.equals(other.conjunto))
			return false;
		if (indice == null) {
			if (other.indice != null)
				return false;
		} else if (!indice.equals(other.indice))
			return false;
		return true;
		
	}	
	
	// TO_STRING DE LA CLASE
	@Override
	public String toString() {

		return this.conjunto + "\n";

	}
		
}
