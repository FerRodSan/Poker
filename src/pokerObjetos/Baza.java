package pokerObjetos;
import java.util.Arrays;

public class Baza {

	public static final int tamanoBaza = 5;
	private Carta[] carta;

	/**
	 * Se reparte una baza(mano) de 5 cartas de las primeras cinco cartas de la baraja barajada
	 * @param baraja
	 * @param jugador
	 */
	void repartirBaza(Baraja baraja, Jugador jugador) {
		carta = new Carta[tamanoBaza];
		for (int i = 0; i < Baza.tamanoBaza; i++) {
			carta[i] = baraja.carta[i];
		}
		muestraBaza(carta);
		comprobarBaza(carta, jugador);
	}

	private void muestraBaza(Carta[] carta) {
		System.out.print("Tu mano es : ");
		System.out.print("{  ");
		for (int i = 0; i < carta.length - 1; i++) {
			System.out.print(carta[i] + ",");
		}
		System.out.println(carta[carta.length - 1] + "  }");

	}

	
	/**
	 * Comprobamos que combinacion se puede hacer con las cartas de la baza
	 * creamos un array nuevo solo con los numeros de las cartas sin sus palos
	 * @param carta
	 * @param jugador
	 */
	private void comprobarBaza(Carta[] carta, Jugador jugador) {
		Carta cartita = null;
		int numerito;
		int arrayNumeros[] = new int[carta.length];
		for (int i = 0; i < carta.length; i++) {
			cartita = carta[i];
			numerito = cartita.getNumero();
			arrayNumeros[i] = numerito;
		}
		Arrays.sort(arrayNumeros);
		Utiles.mostrarVector(arrayNumeros);
		comprobarNumero(arrayNumeros, jugador);
		// comprobarPalo(carta);
	}

	/**
	 * al ser la version 1 no necesito comprobar los palos por una posible escalera de color
	 * @param carta
	 */
	private void comprobarPalo(Carta[] carta) {
		// TODO Auto-generated method stub

	}

	private void comprobarNumero(int[] arrayNumeros, Jugador jugador) {
		boolean poker = false, trio = false;

		if (comprobarPoker(arrayNumeros) == 3) {
			poker = true;
			System.out.println(jugador.getNombre() + " Tienes un poker");
		}
		if (comprobarTrio(arrayNumeros) == 1) {
			trio = true;
			System.out.println(jugador.getNombre() + " Tienes un trio");
		}
		if (comprobarPareja(arrayNumeros) == 1 && trio==false) {
			System.out.println(jugador.getNombre() + " Tienes Pareja");
		}
		if (comprobarPareja(arrayNumeros) == 2 && poker==false) {
			System.out.println(jugador.getNombre() + " Tienes doble pareja");
		}
		if (comprobarPoker(arrayNumeros) == 0) {
			System.out.println(jugador.getNombre() + " No tienes nada");
		}
	}

	private static int comprobarPareja(int[] arrayNumeros) {
		int contadorPareja = 0;
		for (int i = 0; i < arrayNumeros.length - 1; i++) {
			if (arrayNumeros[i] == arrayNumeros[i + 1]) {
				contadorPareja++;
				i++;
			}
		}
		return contadorPareja;
	}

	private static int comprobarTrio(int[] arrayNumeros) {
		int contadorTrio = 0, contador = 0;
		for (int i = 0; i < arrayNumeros.length - 1; i++) {
			if (arrayNumeros[i] == arrayNumeros[i + 1]) {
				contador++;
				if (contador == 2 && comprobarPareja(arrayNumeros) != 2) {
					contadorTrio++;
				}
			}
		}
		return contadorTrio;
	}

	private static int comprobarPoker(int[] arrayNumeros) {
		int contadorIguales = 0;
		for (int i = 0; i < arrayNumeros.length - 1; i++) {
			if (arrayNumeros[i] == arrayNumeros[i + 1]) {
				contadorIguales++;
			}
		}
		return contadorIguales;
	}


}
