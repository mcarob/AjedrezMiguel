package Vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controlador.Controlador;
import Modelo.Casilla;

public class VistaPrincipal extends JFrame  {

	private boolean rey;
	private boolean alfil;
	private JButton verificar;
	private JButton AgregarAlfil;
	private JButton AgregarRey;
	private JButton nuevo;
	private Matriz matriz;
	public VistaPrincipal(Controlador c) {
		setLayout(new BorderLayout());
		matriz= new Matriz(c);
		JPanel botones= new JPanel();
		botones.setLayout(new GridLayout(1, 4));
		verificar= new JButton("Verificar");
		verificar.addActionListener(c);
		verificar.setActionCommand(Controlador.VERIFICAR);
		AgregarAlfil= new JButton("Agregar Alfil");
		AgregarAlfil.addActionListener(c);
		AgregarAlfil.setActionCommand(Controlador.ALFIL);
		AgregarRey= new JButton("Agregar Rey");
		AgregarRey.addActionListener(c);
		AgregarRey.setActionCommand(Controlador.REY);
		nuevo= new JButton("Nueva");
		nuevo.addActionListener(c);
		nuevo.setActionCommand(Controlador.NUEVO);
		setTitle("Ajedrez");
		setSize(500, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		add(matriz,BorderLayout.CENTER);
		botones.add(verificar);
		botones.add(AgregarAlfil);
		botones.add(AgregarRey);
		botones.add(nuevo);
		desactivarBotonVerificar();
		botones.setBorder(BorderFactory.createTitledBorder("Acciones"));
		add(botones,BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public void desactivarBotonRey() {
		AgregarRey.setEnabled(false);
	}
	public void desactivarBotonVerificar() {
		verificar.setEnabled(false);
	}
	public void activarBotonVerificar() {
		verificar.setEnabled(true);
	}
	public void desactivarBotonAlfil() {
		AgregarAlfil.setEnabled(false);
	}

	public void activarBotonRey() {
		AgregarRey.setEnabled(true);
	}
	public void activarBotonAlfil() {
		AgregarAlfil.setEnabled(true);
	}
	public void Nueva() {
		AgregarRey.setEnabled(true);
		AgregarAlfil.setEnabled(true);
		desactivarBotonVerificar();
		matriz.nuevaMalla();
}
	public void activarMatriz(Casilla[][] tablero) {
		matriz.modificarTablero(tablero);
	}
	public void activarBotonesTablero() {
		matriz.activarBotones();
	}
	public void desactivarBotonesTablero() {
		matriz.desactivarBotones();
	}

	public void mostrarError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
		
	}

	public void mostrarRespuesta(String string) {
		JOptionPane.showMessageDialog(null, string, "Error", JOptionPane.INFORMATION_MESSAGE);
		
	}
	

	
	
}
