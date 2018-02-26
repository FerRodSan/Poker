package pokerObjetos;

public class Poker {

	private Jugador jugador=new Jugador("Fernando", 1);
	private Baraja baraja = new Baraja();
	private Baza baza = new Baza();

	
	/**
	 * Este metodo ejecuta el juego por partes
	 */
	public void play() {
		System.out.println("VAMOS A JUGAR AL POKER");
		baraja.crearBaraja();
		baraja.barajar();
		baza.repartirBaza(baraja, jugador);
	}
}
