package control;

import modelo.GestionDatos;
import vista.MyButton;

public class Controlador {
	private GestionDatos gestion = new GestionDatos();
	
	public void getCasilla(MyButton button) {
		gestion.proceso(button);
	}
	
	public void setCasilla(MyButton button, String turno) {
		
	}
}
