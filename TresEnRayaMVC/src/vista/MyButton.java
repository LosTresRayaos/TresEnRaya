package vista;

import java.awt.Color;
import javax.swing.JButton;

import modelo.Coordenada;

public class MyButton extends JButton {
	private Coordenada coordenada;
	private Color baseColor = new Color(230,245,255); //Avoid values below 50
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
	
	public void setBackgroundToBaseColor() {
		setBackground(baseColor);
	}
	
	public void setBackgroundToHoverColor() {
		setBackground(hoverColor);
	}
	
	
}
