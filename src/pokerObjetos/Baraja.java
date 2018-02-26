package pokerObjetos;

public class Baraja {

	Carta carta[];

	public static final int tamano = 40;

	public Baraja() {
		this.carta = new Carta[tamano];
	}

	/**
	 * Crea diez cartas de cada palo de la baraja
	 */
	public void crearBaraja() {
		String[] palos = Carta.PALOS;
		for (int i = 0; i < palos.length; i++) {
			for (int j = 0; j < Carta.tamanoCartaPalo; j++) {
				carta[i * (Carta.tamanoCartaPalo) + j] = new Carta(j + 1, palos[i]);
			}
		}
	}
	
	/**
	 * Barajamos la baraja para cambiar de posicion todas las cartas
	 */
	
	public void barajar() {
		int posAleatoria=0;
		Carta cartita;
		for (int i = 0; i < carta.length; i++) {
			posAleatoria=Utiles.generaNumeroAleatorio(0, tamano-1);
			cartita=carta[i];
			carta[i]=carta[posAleatoria];
			carta[posAleatoria]=cartita;
		}
	}
}
