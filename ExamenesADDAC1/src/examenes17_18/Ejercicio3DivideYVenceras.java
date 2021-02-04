/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ex�menes del 1� cuatrimestre de ADDA
 */

package examenes17_18;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio3DivideYVenceras {
	
	/*
	 * Utilice tipos gen�ricos para implementar la funci�n cuentaXRep(t, x) dicha funci�n
	 * cuenta el n�mero de veces que el elemento x se repite en el �rbol t.
	 * 
	 * Las siguientes llamadas a la funci�n cuentaXRep devolver�an:
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
