package pokerObjetos;
import java.util.Scanner;

public class Utiles {

	public static void mostrarVector(int[] vector) {
		System.out.print("{");
		for (int i = 0; i < vector.length - 1; i++) {
			System.out.print(vector[i] + ",");
		}
		System.out.println(vector[vector.length - 1] + "}");
	}

	public static int generaNumeroAleatorio(int minimo, int maximo) {

		int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
		return num;
	}

	public static String pedirCadena() {
		return new Scanner(System.in).nextLine();
	}

	public static int pedirNumero() {
		Scanner leer = new Scanner(System.in);
		int valor = leer.nextInt();
		leer.close();
		return valor;
	}

}
