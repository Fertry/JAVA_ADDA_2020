/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package vertices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import aristas.AristaProducto;
import ejercicio3.Ejercicio3;
import us.lsi.graphs.virtual.ActionVirtualVertex;

/*
 * Clase v�rtice producto para representar v�rtices del grafo de un tipo definido.
 * 
 * Interpretaci�n: Encontrar la elecci�n adecuada de productos, desde indice hasta el final, que
 * minimicen el precio total y cubran todas las funcionalidades deseadas.
*/
public class VerticeProducto extends ActionVirtualVertex <VerticeProducto, AristaProducto, Integer> {

	// M�TODOS DE LA CLASE
	public static VerticeProducto of(Integer indice, List<Integer> plazasRestantes) {
		
		return new VerticeProducto(indice, plazasRestantes);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	
	// Variables b�sicas:
	private Integer indice;
	private Set<Integer> funcionalidadesPorCubrir;
	
	// Variables compartidas (Extraidas de clase general donde se inicializan los datos):
	private static Integer productos = Ejercicio3.getNProductos();
	private static Set<Integer> funcionalidadesDeseadas = Ejercicio3.;
	
	// CONSTRUCTORES DE LA CLASE
	public VerticeProducto(Integer indice, List<Integer> plazasRestantes) {
		
		super();
		
		this.indice = indice;
		this.plazasRestantes = plazasRestantes;
	
	}
	
	// GETTERS DE LA CLASE

	// Devuelve el �ndice del v�rtice:
	public Integer getIndice() {
		
		return indice;
		
	}
	
	// M�TODOS PARA TRABAJAR CON GRAFOS VIRTUALES
	
	// M�todo que verifica si alcanzamos el objetivo o no: el �ndice alcanze el n� de alumnos:
	public static Predicate<VerticeProducto> objetivo() {
		
		return (VerticeProducto vertice) -> vertice.getIndice() == VerticeProducto.alumnos;
		
	}
	
	// Definir un v�rtice de comienzo d�nde todas sus plazas est�n "vac�as",
	// esto es, sus capacidades son m�ximas (alumnos / grupos):
	public static VerticeProducto verticeInicial() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			auxiliar.add(reparto);
			i++;
			
		}
		
		VerticeProducto resultado = VerticeProducto.of(0, auxiliar);
		return resultado;
	
	}

	// Definir un v�rtice de destino d�nde todas sus plazas est�n "llenas", 
	// esto es, sus capacidades son cero:
	public static VerticeProducto verticeFinal() {
		
		int i = 0;
		List<Integer> auxiliar = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			auxiliar.add(0);
			i++;
			
		}
		
		VerticeProducto resultado = VerticeProducto.of(alumnos, auxiliar);
		return resultado;
			
	}
	
	// M�todo para copiar v�rtices: devuelve una copia del v�rtice dado c�mo par�metro:
	public static VerticeProducto copiar(VerticeProducto vertice) {
		
		VerticeProducto resultado = VerticeProducto.of(vertice.indice, vertice.plazasRestantes);
		
		return resultado;
		
	}
	
	// M�TODOS HEREDADOS DE LA SUPERCLASE
	@Override
	// Devuelve la arista correspondiente a la acci�n aplicada a un v�rtice (por donde se desplaza):
	public AristaProducto edge(Integer accion) {
		
		// 1� obtener el v�rtice "vecino" correspondiente a la acci�n:
		VerticeProducto vertice = this.neighbor(accion);
		
		// 2� obtener la arista que los conecta (el camino): origen, destino, accion
		AristaProducto resultado = AristaProducto.of(this, vertice, accion);
		
		return resultado;
		
	}
	
	@Override
	// 
	public Boolean isValid() {
		
		int i = 0;
		Boolean valido = false;
		
		// Si NO es el v�rtice inicial NI el final:
		if (this.indice >= 0 && this.indice <= alumnos) {
			
			valido = true;
			
		}

		// Si el grupo i NO est� lleno (hay plazas):
		while (i < grupos) {
		
			if (this.plazasRestantes.get(i) > 0) {
				
				valido = true;
				
			}
			
			i++;
			
		}
				
		return valido;
	
	}
	
	@Override
	// Devuelve el v�rtice "vecino" que corresponde a la acci�n tomada:
	public VerticeProducto neighbor(Integer accion) {
		
		// 1� obtener el siguiente indice:
		Integer siguiente = this.indice + 1;
		
		// 2� copiar la lista de plazasRestantes actual:
		List<Integer> auxiliar = new ArrayList<>(this.plazasRestantes);
		
		// 3� alterar el valor de la lista: esto es, para la posici�n del grupo indicada por la acci�n
		// restarle uno indicando que hay una capacidad menos:
		auxiliar.set(accion, (this.plazasRestantes.get(accion) - 1));
		
		// 4� devolver el v�rtice nuevo:
		VerticeProducto resultado = VerticeProducto.of(siguiente, auxiliar);
		
		return resultado;
		
	}

	@Override
	// Devuelve la lista de acciones (movimientos en el grafo) posibles en base a las restricciones:
	public List<Integer> actions() {
		
		int i = 0;
		List<Integer> acciones = new ArrayList<Integer>();
		
		while (i < grupos) {
			
			// Si hay plazas disponibles en el grupo:
			if (this.plazasRestantes.get(i) > 0) {
				
				// Y si la afinidad para el movimiento NO es cero:
				if (Ejercicio3.getAfinidadPorIndice(this.indice, i) > 0) {
					
					// Entonces es una acci�n posible de mejora:
					acciones.add(i);
					
				}
			}
			
			i++;
			
		}
		
		return acciones;
			
	}

	// HASHCODE Y EQUALS DE LA CLASE EN BASE A INDICE Y FUNCIONALIDADES POR CUBRIR
	

	// TO_STRING DE LA CLASE (S�lo para debug)
	@Override
	public String toString() {
		
		return "[Indice: " + this.indice + ", cuenta con las plazas: " + this.plazasRestantes + "]";
		
	}
	
}
