package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JPanel;

import modelo.Coordenada;

public class PanelBotonera extends JPanel {
	private MyButton botonera[][]=new MyButton[3][3];
	private Color black = new Color(0,0,0);
	private Color blockedColor = new Color(150,150,150);
	private Color victoryColor = new Color(230,255,240);
	private Font baseFont = new Font("Arial", Font.PLAIN, 25);
	private Color baseColor = new Color(255,255,255); //Avoid values below 50
	private Color hoverColor;

	
	public PanelBotonera() {
		crearBotones();
	}

	private void crearBotones() {
		for (int i = 0; i < 3; i++) {
			for (int j= 0; j < 3; j++) {
				botonera[i][j] = new MyButton(new Coordenada(i, j));
				botonera[i][j].setFont(baseFont);
				this.add(botonera[i][j] );
				setBackground(baseColor);
				this.hoverColor = new Color(baseColor.getRed()-50,baseColor.getGreen()-50,baseColor.getBlue()-50);
			}
		}
	}
	public MyButton getBoton(int i, int j) {
		return botonera[i][j];
	}
	
	public MyButton getBoton(Coordenada coordenada) {
		return botonera[coordenada.getX()][coordenada.getY()];
	}

	public MyButton[][] getBotonera() {
		return botonera;
	}
	
	public void setForegroundButton(String turno) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(this.botonera[i][j].getText().equals(turno)) {
					this.botonera[i][j].setForeground(black);
				}
				else {
					this.botonera[i][j].setForeground(blockedColor);
				}
			}
		}
	}
	
	public void victory(Coordenada[] victory) {
		for (int i = 0; i < victory.length; i++) {
			getBoton(victory[i]).setBackground(victoryColor);
		}
	}
	
	public void setBackgroundToBaseColor(MyButton button) {
		button.setBackground(baseColor);
	}
	
	public void setBackgroundToHoverColor(MyButton button) {
		button.setBackground(hoverColor);
	}
	
	

	
}
