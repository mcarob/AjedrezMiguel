package Vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.Controlador;
import Modelo.Casilla;
import Modelo.Ficha;

public class Matriz extends JPanel {
public JButton[][] botones;
	
	public Matriz (Controlador c) {
		setLayout(new GridLayout(8, 8,10,10));
		botones= new JButton[8][8];
		inicializarbotones(c);
		setBorder(BorderFactory.createTitledBorder("Tablero"));
		desactivarBotones();
	}



	private void inicializarbotones(Controlador c) {
	for (int i = 0; i < botones.length; i++) {
		for (int j = 0; j < botones.length; j++) {
			botones[i][j]= new JButton();
			botones[i][j].addActionListener(c);
			botones[i][j].setActionCommand(i+","+j);
			botones[i][j].setBackground(Color.WHITE);
			add(botones[i][j]);
		}
	}
	}
	public void desactivarBotones() {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[i][j].setEnabled(false);
			}
		}
	}
	public void activarBotones() {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[i][j].setEnabled(true);
			}
		}
	}
	public void nuevaMalla() {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[i][j].setBackground(Color.WHITE);
				botones[i][j].setText("");
				desactivarBotones();
			}
		}
	}



	public void modificarTablero(Casilla[][] tabler) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				try {
					if(tabler[i][j].darFicha().getTipo()==Ficha.Tipo.alfil) {
						botones[i][j].setBackground(Color.red);
						botones[i][j].setText("A");
					}else if(tabler[i][j].darFicha().getTipo()==Ficha.Tipo.rey){
						botones[i][j].setBackground(Color.blue);
						botones[i][j].setText("R");
					}	
				} catch (Exception e) {
				
				}
			}
		}	
	}
}
