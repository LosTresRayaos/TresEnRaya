package modelo;

import vista.Coordenada;
import vista.MyButton;

public class GestionDatos {
	private Tablero tablero = new Tablero();
	private int numerojugada = 0;  
	private int turno;

	public int getTurno() {
		return turno;
	}
	public MyButton[] proceso(MyButton lastButton) {
		if(numerojugada<6) {
			if(lastButton.getText().equals("")) {
				this.turno = calculaTurno();
			}
			MyButton[] buttons = {lastButton,null};
			return buttons;
		}
		return null;
		
	}
	
	public int calculaTurno() {
		if (numerojugada % 2 == 0) {
			this.numerojugada++;
			return 2;
		}
		this.numerojugada++;
		return 1;
	}
	public void update(MyButton[] button) {
		int x = button[0].getCoordenada().getX();
		int y = button[0].getCoordenada().getY();
		tablero.tablero[x][y]=this.turno;
		x=button[1].getCoordenada().getX();
		y=button[1].getCoordenada().getY();
		tablero.tablero[x][y]=0;
		tablero.showGame();
	}
	
	public void update(MyButton button) {
		int x = button.getCoordenada().getX();
		int y = button.getCoordenada().getY();
		tablero.tablero[x][y]=this.turno;
		tablero.showGame();
		
	}
	
	public Coordenada[] victoria() {
		int[] result = tablero.comprobarVictoria(this.turno);
		Coordenada[] coordenadaVictoria= {null,null,null};
		if(result!=null) {
			if(result[1]==0) {
				for(int i=0; i<coordenadaVictoria.length; i++) {
					coordenadaVictoria[i] = new Coordenada(result[0], i);
				}
			}
			if(result[1]==1) {
				for (int i = 0; i < coordenadaVictoria.length; i++) {
					coordenadaVictoria[i] = new Coordenada(i, result[0]);
				}
			}
			if(result[1]==2) {
				for (int i = 0; i < coordenadaVictoria.length; i++) {
					coordenadaVictoria[i] = new Coordenada(i,i);
				}
			}
			if(result[1]==3) {
				for (int i = 0,j = 2; i < coordenadaVictoria.length; i++, j--) {
					coordenadaVictoria[i] = new Coordenada(i, j);
				}
			}
		}
		return coordenadaVictoria;
	}
}
