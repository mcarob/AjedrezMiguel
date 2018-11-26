package Modelo;

import Modelo.Ficha.Tipo;

public class Ajedrez {

	public final static int TAMANO = 8;
	private Casilla[][] tablero;
	private String posicionRey;
	private String posicionAlfil;

	public Ajedrez() {
		tablero = new Casilla[TAMANO][TAMANO];
		inicializarTablero();
		posicionRey = "";
		posicionAlfil = "";
	}

	public void nuevoTablero() {
		inicializarTablero();
	}
	private void inicializarTablero() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tablero[i][j]= new Casilla();
			}
		}
		
	}

	public void UbicarAlfil(int fila, int columna, boolean jugador) throws Exception {
		System.out.println("numeros son "+fila +"   "+ columna);
		Ficha ficha = new Ficha(jugador, Tipo.alfil);
		try {
			tablero[fila][columna].colocar(ficha);
			posicionAlfil = fila + "," + columna;
			System.out.println(posicionAlfil);
		} catch (Exception e) {
			throw new Exception("esta casilla ya se encuentra ocupada");
		}
	}

	public void UbicarRey(int fila, int columna, boolean jugador) throws Exception {

		Ficha ficha = new Ficha(jugador, Tipo.rey);
		try {
			tablero[fila][columna].colocar(ficha);
			posicionRey = fila + "," + columna;
		} catch (Exception e) {
			throw new Exception("esta casilla ya se encuentra ocupada");
		}
	}

	public void UbicarReina(int fila, int columna, boolean jugador) throws Exception {

		Ficha ficha = new Ficha(jugador, Tipo.reina);
		try {
			tablero[fila][columna].colocar(ficha);
		} catch (Exception e) {
			throw new Exception("esta casilla ya se encuentra ocupada");
		}
	}

	public void UbicarPeon(int fila, int columna, boolean jugador) throws Exception {
		Ficha ficha = new Ficha(jugador, Tipo.peon);
		try {
			tablero[fila][columna].colocar(ficha);
		} catch (Exception e) {
			throw new Exception("esta casilla ya se encuentra ocupada");
		}
	}

	public void UbicarCaballo(int fila, int columna, boolean jugador) throws Exception {
		Ficha ficha = new Ficha(jugador, Tipo.caballo);
		try {
			tablero[fila][columna].colocar(ficha);
		} catch (Exception e) {
			throw new Exception("esta casilla ya se encuentra ocupada");
		}
	}

	public void UbicarTorre(int fila, int columna, boolean jugador) throws Exception {
		Ficha ficha = new Ficha(jugador, Tipo.torre);
		try {
			tablero[fila][columna].colocar(ficha);
		} catch (Exception e) {
			throw new Exception("esta casilla ya se encuentra ocupada");
		}
	}

	public Casilla[][] getTablero() {
		return tablero;
	}

	public void setTablero(Casilla[][] tablero) {
		this.tablero = tablero;
	}

	public boolean verificarReyAlfil() {
		int posicion1 = Integer.parseInt(posicionAlfil.split(",")[0]);
		int posicion2 = Integer.parseInt(posicionAlfil.split(",")[1]);
		boolean r = encontrar(posicion1, posicion2);

		return r;
	}

	private boolean encontrar(int fila, int columna) {
		boolean encontrado = false;
		// abajo
System.out.println("la fila es "+fila+" la columna es "+columna);
		for (int f = fila, CAumenta = columna, CDisminuye = columna; f >= 0; f--, CAumenta++, CDisminuye--) {
			if (CAumenta < 8) {
				if ( tablero[f][CAumenta].darFicha()!=null && tablero[f][CAumenta].darFicha().getTipo() == Tipo.rey) {
					encontrado = true;
				}
			}
			if (CDisminuye >= 0) {
				if (tablero[f][CDisminuye].darFicha()!=null && tablero[f][CDisminuye].darFicha().getTipo() == Tipo.rey) {
					encontrado = true;
				}
			}
		}
		System.out.println("esta en el metodo encontrar");
		System.out.println("la fila es "+fila+" la columna es "+columna);
		// arriba
		for (int f = fila, CAumenta = columna, CDisminuye = columna; f < 8; f++, CAumenta++, CDisminuye--) {
			System.out.println("la fila es "+f+" la columna es "+CAumenta);
			System.out.println("la fila es "+f+" la columna es "+CDisminuye);
			if (CAumenta < 8) {
				if (tablero[f][CAumenta].darFicha()!=null && tablero[f][CAumenta].darFicha().getTipo() == Tipo.rey) {
					encontrado = true;
					System.out.println("la fila es "+f+" la columna es "+CAumenta);
				}
			}
			if (CDisminuye >= 0) {
				if (tablero[f][CDisminuye].darFicha()!=null && tablero[f][CDisminuye].darFicha().getTipo() == Tipo.rey) {
					encontrado = true;
					System.out.println("la fila es "+f+" la columna es "+CDisminuye);
				}
			}

		}
		return encontrado;
	}

}
