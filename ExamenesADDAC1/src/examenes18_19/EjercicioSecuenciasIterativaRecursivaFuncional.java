package examenes18_19;

import java.util.stream.IntStream;

public class EjercicioSecuenciasIterativaRecursivaFuncional {

	/*
	 * Iterativa:
	 */
	public static boolean secuencia(String letras) {

		boolean resultado = true;

		int i = 0;
		int j = letras.length() - 2;

		while (i <= j && resultado) {

			resultado = letras.charAt(i) == letras.charAt(i + 1);
			i += 2;

		}

		return resultado;

	}

	/*
	 * Recursiva final:
	 */
	public static boolean secuenciaRecursivaPublica(String letras) {

		return secuenciaRecursiva(letras, 0, letras.length() - 2, true);

	}

	private static boolean secuenciaRecursiva(String letras, int i, int j, boolean resultado) {

		if (i <= j && resultado) {

			// Final: TODOS los parametros dentro de la llamada:
			boolean booleano = letras.charAt(i) == letras.charAt(i + 1);
			resultado = secuenciaRecursiva(letras, i + 2, j, booleano);

		} else {

			return resultado;

		}

		return resultado;

	}

	/*
	 * Recursiva NO final:
	 */
	public static boolean secuenciaRecursivaPublicaNoFinal(String letras) {

		return secuenciaRecursivaNoFinal(letras, 0, letras.length() - 2);

	}

	private static boolean secuenciaRecursivaNoFinal(String letras, int i, int j) {

		if (i <= j) {

			// NO Final: el operando ocurre FUERA de la llamada:
			boolean booleano = letras.charAt(i) == letras.charAt(i + 1);
			return booleano && secuenciaRecursivaNoFinal(letras, i + 2, j);

		} else {

			return true;

		}

	}

	/*
	 * Funcional:
	 */
	public static boolean secuenciaFuncional(String letras) {

		return IntStream.rangeClosed(0, letras.length() - 1).filter(x -> x % 2 == 0)
				.allMatch(x -> letras.charAt(x) == letras.charAt(x + 1));

	}
	
}
