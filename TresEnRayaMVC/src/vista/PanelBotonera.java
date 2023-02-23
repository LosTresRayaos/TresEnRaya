package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JPanel;

import modelo.Coordenada;

public class PanelBotonera extends JPanel {
	private MyButton botonera[][]=new MyButton[3][3];
	private Color turnColor = new Color(210,100,100);
	private Color black = new Color(0,0,0);
	
	public PanelBotonera() {
		crearBotones();
	}

	private void crearBotones() {
		for (int i = 0; i < 3; i++) {
			for (int j= 0; j < 3; j++) {
				botonera[i][j] = new MyButton(new Coordenada(i, j));
			this.add(botonera[i][j] );
			}
		}
	}
	public MyButton getBoton(int i, int j) {
		return botonera[i][j];
	}

	public MyButton[][] getBotonera() {
		return botonera;
	}
	
	public void setForegroundButton(String turno) {
		MyButton button = new MyButton(null);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(this.botonera[i][j].getText().equals(turno)) {
					this.botonera[i][j].setForeground(turnColor);
				}
				else {
					this.botonera[i][j].setForeground(black);
				}
			}
		}
	}
	
	

	
}
