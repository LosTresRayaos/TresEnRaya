package control;

import modelo.GestionDatos;
import vista.MyButton;

public class Controlador {
	private GestionDatos gestion = new GestionDatos();
	
	public void buttonPressed(MyButton button) {
		gestion.proceso(button);
	}

}
