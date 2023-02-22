package modelo;

import vista.Coordenada;

public class GestionDatos {
	private Tablero tablero = new Tablero();
	private int numerojugada = 0;  
	private int turno;
	private Coordenada[] coordenadasGuardadas;

	public int getTurno() {
		return turno;
	}
	public Coordenada[] proceso(Coordenada lastCoordenada) {
		if(numerojugada<6) {
			this.coordenadasGuardadas = new Coordenada[2];
			int value=tablero.tablero[lastCoordenada.getX()][lastCoordenada.getY()];
			if(value==0) {
				this.turno = calculaTurno();
			}
			this.coordenadasGuardadas[0]=lastCoordenada;
			return this.coordenadasGuardadas;
		}
		if(numerojugada>=6) {
			this.coordenadasGuardadas[0]=null;
			if(this.coordenadasGuardadas[1]==null) {
				int value=tablero.tablero[lastCoordenada.getX()][lastCoordenada.getY()];
				if(value==this.turno && tablero.comprobarBloqueada(lastCoordenada)) {
					this.coordenadasGuardadas[1]=lastCoordenada;
					return coordenadasGuardadas;
				}
			}
			else {
				int value=tablero.tablero[lastCoordenada.getX()][lastCoordenada.getY()];
				if(value==0) {
					
				}
			}
			
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
	public void update(Coordenada[] coordenada) {
		tablero.tablero[coordenada[0].getX()][coordenada[0].getY()]=this.turno;
		tablero.tablero[coordenada[1].getX()][coordenada[1].getY()]=0;
		tablero.showGame();
	}
	
	public void update(Coordenada coordenada) {
		tablero.tablero[coordenada.getX()][coordenada.getY()]=this.turno;
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
