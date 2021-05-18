/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import ejercicio2.Ejercicio2;
import us.lsi.common.Lists2;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase v�rtice abogado para representar v�rtices del grafo de un tipo definido.
 * 
 * Interpretaci�n: Encontrar la asignaci�n de casos a abogados, desde indice hasta el final, que minimice
 * cargaMaxima, teniendo en cuenta las cargas ya acumuladas para los abogados.
*/
public class VerticeAbogado extends ActionVirtualVertex<VerticeAbogado,  ActionSimpleEdge<VerticeAbogado, Integer>, Integer> {

	// M�TODOS DE LA CLASE
	public static VerticeAbogado of(Integer indice, List<Integer> cargaAbogado) {
		
		return new VerticeAbogado(indice, cargaAbogado);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	
	// Variables b�sicas:
	private Integer indice;
	private List<Integer> cargaAbogado;
	
	// Variables compartidas (Extraidas de clase general donde se inicializan los datos):
	private static Integer casos = Ejercicio2.getNCasos();
	private static Integer abogados = Ejercicio2.getNAbogados();

	// Variables derivadas (calculadas en la propia clase):
	private static Integer cargaMinima = cargaMinima();
	private static Integer cargaMaxima = cargaMaxima();
	private static Integer abogadoMinimo = abogadoMinimaCarga();
	private static Integer abogadoMaximo = abogadoMaximaCarga();
	
	// CONSTRUCTORES DE LA CLASE
	public VerticeAbogado(Integer indice, List<Integer> cargaAbogado) {
		
		super();
		
		this.indice = indice;
		this.cargaAbogado = cargaAbogado;
	
	}
	
	// GETTERS DE LA CLASE

	// Devuelve el �ndice del v�rtice:
	public Integer getIndice() {
		
		return indice;
		
	}
	
	// Devuelve la lista de cargas de abogados:
	public List<Integer> getCargaAbogado() {
		
		return cargaAbogado;
		
	}
	
	// M�TODOS PARA SETEAR LAS VARIABLES DERIVADAS DE LA CLASE
	
	// Devuelve la menor carga de los abogados (caso menor duraci�n):
	private static Integer cargaMinima() {
		
		int i = 0;
		int j = 0;
		Integer minimo = Ejercicio2.tiempoPorIndice(0, 0);
		
		while (i < abogados) {
			while (j < casos) {
				
				Integer horas = Ejercicio2.tiempoPorIndice(i, j);
				if (horas < minimo) {
				
					minimo = horas;
					
				}
				
				j++;
				
			}
			
			i++;
			
		}

		return minimo;
		
	}
	
	// Devuelve la mayor carga de los abogados (caso mayor duraci�n):
	private static Integer cargaMaxima() {
		
		int i = 0;
		int j = 0;
		Integer maximo = Ejercicio2.tiempoPorIndice(0, 0);
		
		while (i < abogados) {
			while (j < casos) {
				
				Integer horas = Ejercicio2.tiempoPorIndice(i, j);
				if (horas > maximo) {
				
					maximo = horas;
					
				}
				
				j++;
				
			}
			
			i++;
			
		}

		return maximo;
		
	}

	// Devuelve el abogado menos cargado (menor n� horas):
	private static Integer abogadoMinimaCarga() {
		
		int i = 0;
		Integer abogado = 0;
		Integer suma = Ejercicio2.tiempoTotalPorIndice(0);
		
		while (i < abogados) {
			
			Integer horas = Ejercicio2.tiempoTotalPorIndice(i);
			if (horas < suma) {
				
				System.out.println("Abogado " + i + " tiene un total de " + horas + " asociadas.");
				abogado = i;
				
			}
			
			i++;

		}
		
		return abogado;
		
	}

	// Devuelve el abogado m�s cargado (mayor n� horas):
	private static Integer abogadoMaximaCarga() {
		
		int i = 0;
		Integer abogado = 0;
		Integer suma = Ejercicio2.tiempoTotalPorIndice(0);
		
		while (i < abogados) {
			
			Integer horas = Ejercicio2.tiempoTotalPorIndice(i);
			if (horas > suma) {
				
				abogado = i;
				
			}
			
			i++;

		}
		
		return abogado;
		
	}
	
	// M�TODOS PARA TRABAJAR CON GRAFOS VIRTUALES
	
	// M�todo que verifica si alcanzamos el objetivo o no: el �ndice alcanze el n� de casos:
	public static Predicate<VerticeAbogado> objetivo() {
		
		return (VerticeAbogado vertice) -> vertice.getIndice() == VerticeAbogado.casos;
		
	}
	
	// Definir un v�rtice de comienzo d�nde todas sus cargas est�n vac�as:
	public static VerticeAbogado verticeInicial() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < abogados) {
			
			auxiliar.add(0);
			i++;
			
		}
		
		VerticeAbogado resultado = VerticeAbogado.of(0, auxiliar);
		return resultado;
	
	}

	// M�TODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acci�n aplicada a un v�rtice (por donde se desplaza):
	public ActionSimpleEdge<VerticeAbogado, Integer> edge(Integer accion) {
		
		ActionSimpleEdge<VerticeAbogado, Integer> resultado = ActionSimpleEdge.of(this, neighbor(accion), accion);
		
		return resultado;
		
	}
	
	@Override
	// Comprueba la validez de un v�rtice dado, esto es: se encuentra dentro del intervalo cerrado [0, m]:
	public Boolean isValid() {

		Boolean valido = false;
		
		// Si NO es el v�rtice inicial NI el final:
		if (this.indice >= 0 && this.indice <= casos) {
			
			valido = true;
			
		}
	
		return valido;
	
	}
	
	@Override
	// Devuelve el v�rtice "vecino" que corresponde a la acci�n tomada.
	// neighbor(a) = (i+1, ca') donde ca'[a] = ca[a]+c(a,i):
	public VerticeAbogado neighbor(Integer accion) {
		
		// 1� obtener el siguiente indice:
		Integer siguiente = this.indice + 1;
		
		// 2� copiar la lista de cargas actual:
		List<Integer> auxiliar = new ArrayList<>(this.cargaAbogado);
		
		// 3� alterar el valor de la lista: esto es, para la posici�n de la lista de cargas 
		// indicada por la acci�n sumarle la carga de tiempo dado la acci�n y el �ndice:
		auxiliar.set(accion, (this.cargaAbogado.get(accion) + Ejercicio2.tiempoPorIndice(accion, this.indice)));
		
		// 4� devolver el v�rtice nuevo:
		VerticeAbogado resultado = VerticeAbogado.of(siguiente, auxiliar);
		
		return resultado;
		
	}

	@Override
	// Devuelve la lista de acciones (movimientos en el grafo) posibles en base a las restricciones:
	public List<Integer> actions() {
		
//		int i = 0;
		//List<Integer> acciones = new ArrayList<Integer>();
		
		// De alcanzar el l�mite, no hay m�s acciones:
		if (this.indice == casos) {

			System.out.println("Lista vac�a: " + Lists2.of());
			return Lists2.of();
			
		}  else {
			
			System.out.println("Lista abogado minimo: " + Lists2.of(abogadoMinimo));
			return Lists2.of(abogadoMinimo);
			
		}
		
		// De no alcanzar el l�mite, devolver el abogado menos cargado (abogadoMinimo):
//		while (i < abogados) {
//
//			// Entonces es una acci�n posible de mejora:
//			acciones.add(abogadoMinimo);
//			i++;
//
//		}
			
		//return Lists2.of();
			
	}

	// HASHCODE Y EQUALS DE LA CLASE EN BASE A INDICE Y CARGA ABOGADO
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargaAbogado == null) ? 0 : cargaAbogado.hashCode());
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
		VerticeAbogado other = (VerticeAbogado) obj;
		if (cargaAbogado == null) {
			if (other.cargaAbogado != null)
				return false;
		} else if (!cargaAbogado.equals(other.cargaAbogado))
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
		
		return "Caso: " + this.indice + " - " + this.cargaAbogado + "\n";
		
	}

}
