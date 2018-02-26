package PokerSinObjetos;
import java.util.Arrays;

public class PokerSinObjetos {
	
	public static void main(String[] args) {
		int[] manoJugador = repartirCartas();
		// int[] manoJugador = { 3, 3, 3, 7, 5 };
		mostrarVector(manoJugador);
		Arrays.sort(manoJugador);
		mostrarVector(manoJugador);
		comprobarResultado(manoJugador);
	}

	private static void comprobarResultado(int[] mano) {
		if (comprobarPareja(mano) == 1) {
			System.out.println("Tienes Pareja");
		}
		if (comprobarPareja(mano) == 2) {
			System.out.println("Tienes doble pareja");
		}
		if (comprobarTrio(mano) == 1) {
			System.out.println("Tienes un trio");
		}
		if (comprobarPoker(mano) == 3) {
			System.out.println("Tienes un poker");
		}
		if (comprobarPoker(mano) == 0) {
			System.out.println("No tienes nada");
		}
	}

	private static int comprobarPareja(int[] mano) {
		int contadorPareja = 0;
		for (int i = 0; i < mano.length - 1; i++) {
			if (mano[i] == mano[i + 1]) {
				contadorPareja++;
				i++;
			}
		}
		return contadorPareja;
	}

	private static int comprobarTrio(int[] mano) {
		int contadorTrio = 0, contador = 0;
		for (int i = 0; i < mano.length - 1; i++) {
			if (mano[i] == mano[i + 1]) {
				contador++;
				if (contador == 2&&comprobarPareja(mano)!=2) {
					contadorTrio++;
				}
			}
		}
		return contadorTrio;
	}

	private static int comprobarPoker(int[] mano) {
		int contadorIguales = 0;
		for (int i = 0; i < mano.length - 1; i++) {
			if (mano[i] == mano[i + 1]) {
				contadorIguales++;
			}
		}
		return contadorIguales;
	}

	private static int[] repartirCartas() {
		int[] mano = new int[5];
		int max = 10, min = 1;
		int intervalo = max - min;
		for (int i = 0; i < mano.length; i++) {
			mano[i] = (int) (min + (Math.random() * (intervalo + 1)));
		}
		return mano;
	}

	public static void mostrarVector(int[] vector) {
		System.out.print("{");
		for (int i = 0; i < vector.length - 1; i++) {
			System.out.print(vector[i] + ",");
		}
		System.out.println(vector[vector.length - 1] + "}");
	}

}
