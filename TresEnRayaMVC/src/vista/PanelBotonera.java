package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Controlador;

public class PanelBotonera extends JPanel {

	private MyButton botonera[][]=new MyButton[3][3];
	private Controlador control = new Controlador();
	
	public PanelBotonera() {
		crearBotones();
	
	}

	private void crearBotones() {
		for (int i = 0; i < 3; i++) {
			for (int j= 0; j < 3; j++) {
				botonera[i][j] = new MyButton(new Coordenada(i, j));
				botonera[i][j] .addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				control.getCasilla((MyButton)e.getSource());
				}
			});
			this.add(botonera[i][j] );
			}
		}
		
	}

	public MyButton getBoton(int i, int j) {
		return botonera[i][j];
	}

	
}
