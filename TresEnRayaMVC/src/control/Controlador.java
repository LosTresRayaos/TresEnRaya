package control;

import java.awt.Color;

import modelo.GestionDatos;
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
		Coordenada[] coordenadasToChange = gestion.proceso(button.getCoordenada());
		boolean cambioRealizado=false;
		if(coordenadasToChange[0] != null && coordenadasToChange[1] != null) {
			makeChange(coordenadasToChange);
			searchVictory();
			cambioRealizado=true;
		}
		else if(coordenadasToChange[0] != null) {
			makeChange(coordenadasToChange[0]);
			searchVictory();
			cambioRealizado=true;
		}
		
		if(cambioRealizado) gestion.aumentaJugada();
		
		

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
	
	public void makeChange(Coordenada[] coordenada) {
		gestion.update(coordenada);
		if(gestion.getTurno()==1) {
			botonera.getBoton(coordenada[0].getX(), coordenada[0].getY()).setText("O");
		}
		if(gestion.getTurno()==2) {
			botonera.getBoton(coordenada[0].getX(), coordenada[0].getY()).setText("X");;
		}
		botonera.getBoton(coordenada[1].getX(), coordenada[1].getY()).setText("");;
	}
	
	public void makeChange(Coordenada coordenada) {
		gestion.update(coordenada);
		if(gestion.getTurno()==1) {
			botonera.getBoton(coordenada.getX(), coordenada.getY()).setText("O");
		}
		if(gestion.getTurno()==2) {
			botonera.getBoton(coordenada.getX(), coordenada.getY()).setText("X");;
		}
	}

}
