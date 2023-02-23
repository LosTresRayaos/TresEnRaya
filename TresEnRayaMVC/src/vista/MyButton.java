package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import modelo.Coordenada;

public class MyButton extends JButton {
	private Coordenada coordenada;
	private Color baseColor = new Color(255,255,255); //Avoid values below 50
	private Color hoverColor;
	private Font baseFont = new Font("Arial", Font.PLAIN, 25);

	public MyButton(Coordenada coordenada) {
		super("");
		this.coordenada = coordenada;
		setBackground(baseColor);
		this.hoverColor = new Color(baseColor.getRed()-50,baseColor.getGreen()-50,baseColor.getBlue()-50);
		setFont(baseFont);
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	public void setBackgroundToBaseColor() {
		setBackground(baseColor);
	}
	
	public void setBackgroundToHoverColor() {
		setBackground(hoverColor);
	}
	
	
}
