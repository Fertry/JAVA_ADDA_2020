package BT;

import java.util.List;

import us.lsi.common.Lists2;

public class DICIEMBRE_17_18 {
	
	public class HorarioVertex {
		
		public Integer index;
		public List<String> pi;
		public List<String> ci;
		
		public HorarioVertex of() {
			return null;
		}
		
		public Integer pref(Integer i, Integer j) {
			return null;
		}
		
		public Boolean inc(Integer i, Integer j) {		
			return null;
		}
		
		public HorarioVertex neighbor(Integer accion) {
			return null;
		}
		
		// Acciones
		public List<Integer> actions() {
			return null;
		}
		
	}
	
	public class HorarioEdge {
		
		public Double weight;
		
		public static HorarioEdge of(HorarioVertex origen, HorarioVertex destino, Integer accion) {
			return null;
		}
		
	}
	
	public class EstadoHorariosBT {
		
		// Propiedades: vertice estado, acumulado (preferencia) y acciones:
		public HorarioVertex vertice;
		public Double acumulado;
		public List<Integer> acciones;
		
		// Avanza
		public void forward(Integer accion) {
			
			// Añadir la nueva acción a la lista:
			this.acciones.add(accion);
			
			// Vertice origen:
			HorarioVertex old = this.vertice;
			
			// Nuevo vertice (indicado por vecinos dado una accion):
			this.vertice = this.vertice.neighbor(accion);
			
			// Obtener el peso de la arista entre origen y destino:
			this.acumulado += HorarioEdge.of(old, this.vertice, accion).weight;
			
		}
		
		// Retrocede
		public void back(Integer accion) {
			
			// Sacar la ultima accion de la lista:
			Lists2.removeLast(this.acciones);
			
			// Vertice origen:
			HorarioVertex old = this.vertice;
			
			// Modificar el vertice actual (el estado):
			Integer index = this.vertice.index;
			List<String> pi = this.vertice.pi;
			List<String> ci = this.vertice.ci;
			this.vertice = HorarioVertex.of(index, pi, ci);
			
			// Reducir del valor acumulado lo que se añadió previamente:
			this.acumulado -= HorarioEdge.of(this.vertice, old, accion).weight;
			
		}
		
		// Objetivo
		
		// Solucion
		
	}

}
