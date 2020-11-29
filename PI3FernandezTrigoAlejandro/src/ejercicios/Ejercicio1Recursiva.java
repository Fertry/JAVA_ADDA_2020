/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

public class Ejercicio1Recursiva {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 1 				 #################
	// ###################################################################################
	// ###################################################################################
	
	// Funcion que dada una matriz calcula primero si sus elementos en las cuatro
	// esquinas son distintos, si no es así devuelve false, de lo contrario, 
	// parte la matriz en cuatro (las matrices siempre son cuadradas) y repite el proceso:
	public static Boolean ejercicio1Recursivo(Integer [][] matriz) {
		
		// Si los extremos de la matriz de entrada son iguales, hemos acabado;
		// si no, entramos en la funcion recursiva privada:
		if (extremosDistintosONo(matriz) == true) {
			
			return ejercicio1RecursivoPrivado(matriz);
			
		} else {
			
			return false;
			
		}

	}
	
	// Funcion privada recursiva que se llama a si misma para reducir la matriz una vez
	// comprobado que sus cuatro esquinas iniciales son distintas. Hace uso de la funcion
	// extremosDistintosONo() y calculaMatrizPartidaEnCuatro() tantas veces como sea 
	// necesario hasta que la matriz sea 2x2 o no se cumpla el requerimiento de que 
	// sus cuatro esquinas difieran:
	private static Boolean ejercicio1RecursivoPrivado(Integer [][] matriz) {
		
		Boolean resultado = false;
		
		// Condicion de parada para una matriz cuadrada
		// de dimension 2x2:
		if (matriz.length == 2) {
			
			resultado = extremosDistintosONo(matriz);
			
		} else {
			
			if (extremosDistintosONo(matriz) == true) {
			
				Boolean primerCuadrante = ejercicio1RecursivoPrivado(calculaMatrizPartidaEnCuatro(matriz, 0, 0));
				Boolean segundoCuadrante = ejercicio1RecursivoPrivado(calculaMatrizPartidaEnCuatro(matriz, 0, matriz.length));
				Boolean tercerCuadrante = ejercicio1RecursivoPrivado(calculaMatrizPartidaEnCuatro(matriz, matriz.length, 0));
				Boolean cuartoCuadrante = ejercicio1RecursivoPrivado(calculaMatrizPartidaEnCuatro(matriz, matriz.length, matriz.length));
				
				resultado = (primerCuadrante && segundoCuadrante && tercerCuadrante && cuartoCuadrante);
				
			} else {
				
				resultado =  false;
				
			}
			
		}
		
		return resultado;
		
	}
	
	// Funcion privada que dada una matriz y la fila/columna desde la que partir, corta la matriz de entrada en una matriz 
	// mas pequeña:
	private static Integer [][] calculaMatrizPartidaEnCuatro(Integer [][] matriz, int filaDePartida, int columnaDePartida) {
		
        int fila = 0;
        int columna = 0;
        int ultimaFila = 0;
        int primeraFila = 0;      
        int ultimaColumna = 0;
        int primeraColumna = 0;        
        Integer[][] resultado = new Integer [matriz.length / 2][matriz.length / 2];

        if (filaDePartida < matriz.length) {
        	
        	primeraFila = 0;
        	ultimaFila = matriz.length / 2;
            
        } else {
        	
        	primeraFila = matriz.length / 2;
        	ultimaFila = matriz.length;
            
        }
        
        if (columnaDePartida < matriz.length) {
        	
        	primeraColumna = 0;
        	ultimaColumna = matriz.length / 2;
            
        } else {
        	
        	primeraColumna = matriz.length / 2;
        	ultimaColumna = matriz.length;
            
        }
        
        while (primeraFila < ultimaFila) {
        	
            while (primeraColumna < ultimaColumna) {
            	
                resultado [fila][columna] = matriz [primeraFila][primeraColumna];
                
                columna++;
                primeraColumna++;
                
            }
            
            columna = 0;
            
            if (columnaDePartida < matriz.length) {
            	
            	primeraColumna = 0;
                
            } else {
            	
            	primeraColumna = matriz.length / 2;
                
            }
            
            fila++;
            primeraFila++;
  
        }
        
        return resultado;
        
    }	
	
	// Posiciones de la matriz:
	/*
	 * A00 = [0][0]										Esquina superior izquierda
	 * A0n = [0][matriz.length - 1]						Esquina superior derecha	
	 * An0 = [matriz.length - 1][0]						Esquina inferior izquierda
	 * Ann = [matriz.length - 1][matriz.length - 1]		Esquina inferior derecha
	 */
	
	// Funcion privada que dada una matriz cuadrada n*n calcula si sus valores
	// localizados en las 4 esquinas son distintos o no:
	private static Boolean extremosDistintosONo(Integer [][] matriz) {
		
		Boolean IzqSupIgualADrcSup = matriz [0][0] != matriz [0][matriz.length - 1];
		Boolean IzqSupIgualAIzqInf = matriz [0][0] != matriz [matriz.length - 1][0];
		Boolean IzqSupIgualADrcInf = matriz [0][0] != matriz [matriz.length - 1][matriz.length - 1];
		Boolean DrcSupIgualAIzqInf = matriz [0][matriz.length - 1] != matriz [matriz.length - 1][0];
		Boolean DrcSupIgualADrcInf = matriz [0][matriz.length - 1] != matriz [matriz.length - 1][matriz.length - 1];
		Boolean IzqInfIgualADrcInf = matriz [matriz.length - 1][0] != matriz [matriz.length - 1][matriz.length - 1];
		
		return (IzqSupIgualADrcSup && IzqSupIgualAIzqInf && IzqSupIgualADrcInf && DrcSupIgualAIzqInf && DrcSupIgualADrcInf && IzqInfIgualADrcInf);
		
	}
	
}
