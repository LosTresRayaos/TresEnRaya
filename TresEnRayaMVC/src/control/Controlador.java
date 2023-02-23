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
	
	//TODO poder cambiar ficha a cambiar	
	public boolean buttonPressed(MyButton button) {
		Coordenada[] coordenadasToChange = gestion.proceso(button.getCoordenada());
		boolean victoria=false;
		boolean cambioRealizado=false;
		if(coordenadasToChange[0] != null && coordenadasToChange[1] != null) {
			makeChange(coordenadasToChange);
			victoria = searchVictory();
			cambioRealizado=true;
		}
		else if(coordenadasToChange[0] != null) {
			makeChange(coordenadasToChange[0]);
			victoria = searchVictory();
			cambioRealizado=true;
		}
		
		if(cambioRealizado) gestion.aumentaJugada();
		return victoria;
		
		

	}
	
	public boolean searchVictory() {
		Coordenada[] victoryLine = gestion.victoria();
		if(victoryLine[0]!=null) {
			Color victoryColor = new Color(167,255,255);
			for (int i = 0; i < victoryLine.length; i++) {
				botonera.getBoton(victoryLine[i].getX(),victoryLine[i].getY()).setBackground(victoryColor);
			}
			return true;
		}
		return false;
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
