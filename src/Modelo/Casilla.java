package Modelo;

public class Casilla {

	public final static int vacia=0;
	public final static int jugador1=1;
	public final static int jugador2=2;

	private Ficha ficha;
	private int ocupadaPor;
	
	public Casilla() {
		ficha=null;
		ocupadaPor=vacia;
	}
	public void colocar(Ficha ficha) throws Exception{
		if(ocupadaPor==vacia) {
		if(ficha==null) {
			ocupadaPor=jugador1;
		}else {
			ocupadaPor=jugador2;
			
		}
		this.ficha=ficha;	
		}else {
			throw new Exception("esta ocupada");
		}
	}
	public void vaciarCasilla() {
		ficha=null;
		ocupadaPor=vacia;
	}
	public Ficha darFicha() {
		return ficha;
	}
	
}
