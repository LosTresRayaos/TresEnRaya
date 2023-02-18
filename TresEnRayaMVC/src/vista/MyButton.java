package vista;

import java.awt.Color;

import javax.swing.JButton;

public class MyButton extends JButton {
	private Coordenada coordenada;
	private Color baseColor = new Color(255,255,255); //TODO manage values below 50
	private Color hoverColor;

	public MyButton(Coordenada coordenada) {
		super("");
		this.coordenada = coordenada;
		setBackground(baseColor);
		this.hoverColor = new Color(baseColor.getRed()-50,baseColor.getGreen()-50,baseColor.getBlue()-50);
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	public void setBackgroundToBase() {
		setBackground(baseColor);
	}
	
	public void setBackgroundToHover() {
		setBackground(hoverColor);
	}
	
	
}
