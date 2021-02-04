/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes17_18;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio3DivideYVenceras {
	
	/*
	 * Utilice tipos genéricos para implementar la función cuentaXRep(t, x) dicha función
	 * cuenta el número de veces que el elemento x se repite en el árbol t.
	 * 
	 * Las siguientes llamadas a la función cuentaXRep devolverían:
     *  cuentaXRep(t,0)=1
	 *  cuentaXRep(t,1)=0
	 *	cuentaXRep(t,2)=3
	 * 	cuentaXRep(t,3)=2
	 *	cuentaXRep(t,4)=2
	 *	cuentaXRep(t,5)=2
	 */

	public static <E> Integer cuentaXRep(Tree<E> arbol, E x) {
		
		int resultado = 0;
		
		switch(arbol.getType()) {
		
		case Empty:
			
			resultado = 0;
			break;
			
		case Leaf:
			
			if (arbol.getLabel().equals(x)) {
				
				resultado += 1;
				
			}
			break;
			
		case Nary:
			
			for (int i = 0; i < arbol.getNumOfChildren(); i++) {
				
				resultado += resultado + cuentaXRep(arbol.getChild(i), x);
				
			}
			
		}
		
		return resultado;
		
	}
	
}
