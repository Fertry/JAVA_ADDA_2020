/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio3;

/*
	Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
	de funcionalidades (el mismo producto puede tener más de una funcionalidad). Se
	desea diseñar un lote con una selección de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
	
	Solución por Backtracking manual.
*/

public class Ejercicio3BTManual {
	
	public static void EjecutaEjercicio3BTManual(String entrada) {
		
		// VARIABLES ESTÁTICAS PARA EL ALGORITMO DE BACKTRACKING MANUAL
		public static MochilaProblem start;
		public static StateMochila estado;
		public static Integer maxValue;
		public static Set<SolucionMochila> soluciones;
		
		// MÉTODO BACKTRACKING MANUAL 

		
		public static void btm(Integer capacidadInicial) {
			MochilaBT.start = MochilaProblem.of(0,capacidadInicial);
			MochilaBT.estado = StateMochila.of(start);
			MochilaBT.maxValue = Integer.MIN_VALUE;
			MochilaBT.soluciones = new HashSet<>();
			btm();
		}
		
		public static void btm(Integer capacidadInicial, Integer maxValue, SolucionMochila s) {
			MochilaBT.start = MochilaProblem.of(0,capacidadInicial);
			MochilaBT.estado = StateMochila.of(start);
			MochilaBT.maxValue = maxValue;
			MochilaBT.soluciones = new HashSet<>();
			MochilaBT.soluciones.add(s);
			btm();
		}
		
		public static void btm() {
			if(MochilaBT.estado.getVertice().index() == DatosMochila.n) {
				Integer value = estado.getValorAcumulado();
				if(value > MochilaBT.maxValue) {
					MochilaBT.maxValue = value;
					MochilaBT.soluciones.add(MochilaBT.estado.solucion());
				}
			} else {
				List<Integer> alternativas = MochilaBT.estado.getVertice().acciones();
				for(Integer a:alternativas) {	
					Double cota = MochilaBT.estado.getValorAcumulado()+Heuristica.cota(MochilaBT.estado.getVertice(),a);
					if(cota < MochilaBT.maxValue) continue;
					MochilaBT.estado = MochilaBT.estado.forward(a);
					btm();  
					MochilaBT.estado = MochilaBT.estado.back(a);
				}
			}
		}
		
		

		
	}
	
	public static void test() {
		Locale.setDefault(new Locale("en", "US"));
		DatosMochila.iniDatos("ficheros/objetosMochila.txt");
		DatosMochila.capacidadInicial = 78;
		MochilaProblem v1 = MochilaProblem.of(0, DatosMochila.capacidadInicial);
		SolucionMochila s = Heuristica.solucionVoraz(v1);
		long startTime = System.nanoTime();
		MochilaBT.btm(78);	
		long endTime = System.nanoTime() - startTime;
		System.out.println("1 = "+endTime);
		System.out.println(MochilaBT.soluciones);
	    startTime = System.nanoTime();
		MochilaBT.btm(78,s.getValor(),s);
		long endTime2 = System.nanoTime() - startTime;
		System.out.println("2 = "+1.*endTime2/endTime);
		System.out.println(MochilaBT.soluciones);

	}

}
