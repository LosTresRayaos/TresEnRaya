package control;

import modelo.Coordenada;
import modelo.GestionDatos;
import modelo.Tablero;
import vista.MyButton;
import vista.PanelBotonera;

public class Controlador {
	private GestionDatos gestion = new GestionDatos();
	private PanelBotonera botonera;
	
	public Controlador(PanelBotonera botonera) {
		super();
		this.botonera=botonera;
	}
	
	public boolean[] buttonPressed(MyButton button) {
		Coordenada coordenada = button.getCoordenada();
		Coordenada[] coordenadasToChange = gestion.proceso(coordenada);
		boolean[] respuesta = {false,false,false};
		boolean cambioRealizado=false;
		if(coordenadasToChange[0] != null && coordenadasToChange[1] != null) {
			cambioFichaLugar(coordenadasToChange);
			respuesta[0] = searchVictory();
			cambioRealizado=true;
			respuesta[2]=true;

		}
		else if(coordenadasToChange[0] != null) {
			colocarFicha(coordenadasToChange[0]);
			respuesta[0] = searchVictory();
			cambioRealizado=true;
		}
		else if(coordenadasToChange[1] != null) {
			respuesta[1]=true;
		}
		
		if(cambioRealizado) {
			gestion.aumentaJugada();
			cambiarColorLetraPorTurno();
		}

		return respuesta;
	}
	
	private void cambiarColorLetraPorTurno() {
		if(gestion.getNumerojugada()>=6) {
			if(gestion.getTurno()==1) botonera.setForegroundButton("X");
			else botonera.setForegroundButton("O");
		}
	}
	
	public boolean searchVictory() {
		Coordenada[] victoryLine = gestion.victoria();
		if(victoryLine[0]!=null) {
			botonera.victory(victoryLine);
			return true;
		}
		return false;
	}
	
	public void cambioFichaLugar(Coordenada[] coordenada) {
		gestion.update(coordenada);
		setLetraBoton(coordenada[0]);
		botonera.getBoton(coordenada[1]).setText("");
	}
	
	public void colocarFicha(Coordenada coordenada) {
		gestion.update(coordenada);
		setLetraBoton(coordenada);
	}
	
	private void setLetraBoton(Coordenada coordenada) {
		if(gestion.getTurno()==1) {
			botonera.getBoton(coordenada).setText("X");
		}
		if(gestion.getTurno()==2) {
			botonera.getBoton(coordenada).setText("O");;
		}
	}

	public Tablero getTablero() {
		return gestion.getTablero();
	}

}
