package vista;

import javax.swing.JButton;

public class MyButton extends JButton {
	private Coordenada coordenada;

	public MyButton(Coordenada coordenada) {
		super("");
		this.coordenada = coordenada;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	
}
