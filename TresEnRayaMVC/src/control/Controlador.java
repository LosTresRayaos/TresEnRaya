package control;

import java.awt.Color;

import modelo.GestionDatos;
import modelo.Tablero;
import vista.Coordenada;
import vista.MyButton;
import vista.PanelBotonera;

public class Controlador {
	private GestionDatos gestion = new GestionDatos();
	private PanelBotonera botonera;
	
	public Controlador(PanelBotonera botonera) {
		super();
		this.botonera=botonera;
	}
	
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
			Color victoryColor = new Color(200,255,200);
			for (int i = 0; i < victoryLine.length; i++) {
				botonera.getBoton(victoryLine[i].getX(),victoryLine[i].getY()).setBackground(victoryColor);
			}
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
