package pokerObjetos;

public class Carta {

	private int numero;
	private String palo;

	public static final String[] PALOS = { "Diamantes", "Picas", "Rombos", "Corazones" };
	public static final int tamanoCartaPalo=10;

	public Carta(int numero, String palo) {
		super();
		this.numero = numero;
		this.palo = palo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String toString() {
		return numero + " de " + palo;
	}

}
