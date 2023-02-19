package control;

import modelo.GestionDatos;
import modelo.Tablero;
import vista.Coordenada;
import vista.MyButton;
import vista.PanelBotonera;

public class Controlador {
	private GestionDatos gestion = new GestionDatos();
	
	public void buttonPressed(MyButton button) {
		MyButton[] buttonsToChange = gestion.proceso(button);
		if(buttonsToChange[0] != null && buttonsToChange[1] != null) {
			makeChange(buttonsToChange);
			searchVictory();
		}
		else if(buttonsToChange[0] != null) {
			makeChange(buttonsToChange[0]);
			searchVictory();
		}

	}
	
	public void searchVictory() {
		Coordenada[] victoryLine = gestion.victoria();
		if(victoryLine[0]!=null) {
			System.out.println("victoria");
			//PanelBotonera.setVictoria(result);		Acceder al objeto no a la clase
		}
	}
	
	public void makeChange(MyButton[] buttonsToChange) {
		//gestion.update(buttonsToChange);
		
	}
	
	public void makeChange(MyButton buttonToChange) {
		gestion.update(buttonToChange);
		if(gestion.getTurno()==1) {
			buttonToChange.setText("O");
		}
		if(gestion.getTurno()==2) {
			buttonToChange.setText("X");
		}
	}

}
