package vista;

import javax.swing.JPanel;

import modelo.Coordenada;

public class PanelBotonera extends JPanel {
	private MyButton botonera[][]=new MyButton[3][3];
	
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
	
	

	
}
