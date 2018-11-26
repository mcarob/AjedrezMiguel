package Modelo;

public class Ficha {

	public enum Tipo{
		peon,rey,reina,alfil,torre,caballo
	}

	private boolean jugador;
	private Tipo tipo;
	public Ficha(boolean jugador, Tipo tipo) {
		this.jugador=jugador;
		this.tipo=tipo;
	}
	/**
	 * si es verdadero es el jugador 1, si es falso es el jugador 2
	 * @return
	 */
	public boolean isJugador() {
		return jugador;
	}
	public void setJugador(boolean jugador) {
		this.jugador = jugador;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}
