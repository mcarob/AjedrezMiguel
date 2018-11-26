package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Modelo.Ajedrez;
import Vista.VistaPrincipal;

public class Controlador implements ActionListener{

	public static final String VERIFICAR = "VERIFICAR";
	public static final String ALFIL = "ALFIL";
	public static final String REY = "REY";
	public static final String NUEVO = "NUEVO";
	private Ajedrez juego;
	private VistaPrincipal vista;
	public boolean ficha;
	public int referenciaVerificar;
	
	public Controlador() {
	juego= new Ajedrez();
	vista= new VistaPrincipal(this);
	vista.setVisible(true);
	referenciaVerificar=0;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String evento=e.getActionCommand();
		if(evento.equalsIgnoreCase(VERIFICAR)) {
			boolean r=juego.verificarReyAlfil();
			if(r) {
				vista.mostrarRespuesta("el Rey se encuentra en jaque");
			}else {
				vista.mostrarRespuesta("el Rey  no se encuentra en jaque");
			}
		}else if(evento.equalsIgnoreCase(ALFIL))
		{
			ficha=false;
		vista.activarBotonesTablero();
		}else if(evento.equalsIgnoreCase(REY)){

			ficha=true;
			vista.activarBotonesTablero();	
			}
		else if(evento.equalsIgnoreCase(NUEVO)){
			vista.Nueva();
			juego.nuevoTablero();
			referenciaVerificar=0;
		}
		else {
			if(!ficha) {
				try {
					juego.UbicarAlfil(Integer.parseInt(evento.split(",")[0]), Integer.parseInt(evento.split(",")[1]), false);
				ficha=true;
				vista.activarMatriz(juego.getTablero());
				vista.desactivarBotonAlfil();
				vista.desactivarBotonesTablero();
				referenciaVerificar++;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					vista.mostrarError(e1.getMessage());
				}
			}else {
				try {
					juego.UbicarRey(Integer.parseInt(evento.split(",")[0]), Integer.parseInt(evento.split(",")[1]), true);
					ficha=false;
					vista.activarMatriz(juego.getTablero());
					vista.desactivarBotonRey();
					vista.desactivarBotonesTablero();
					referenciaVerificar++;
				} catch (Exception e2) {
					vista.mostrarError(e2.getMessage());
				}
			}
			
		if(referenciaVerificar==2) {
			vista.activarBotonVerificar();
		}
		}
		
	}

}
