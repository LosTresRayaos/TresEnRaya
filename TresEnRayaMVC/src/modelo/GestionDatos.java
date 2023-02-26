package modelo;

public class GestionDatos {
	private Tablero tablero = new Tablero();
	private int numerojugada = 0;  
	private int turno=2;
	private Coordenada[] coordenadasGuardadas = {null, null};

	public int getTurno() {
		return turno;
	}
	public Coordenada[] proceso(Coordenada lastCoordenada) {
		int value=tablero.getValorPosicion(lastCoordenada);
		if(numerojugada<6) {
			jugadaMenor6(value, lastCoordenada);
			return this.coordenadasGuardadas;
			}

		
		else{
			return jugadaMayor6(value, lastCoordenada);
			
			
		}
		
	}
	private Coordenada[] jugadaMayor6(int value, Coordenada lastCoordenada) {
		this.coordenadasGuardadas[0]=null;
		if(value==this.turno && tablero.comprobarBloqueada(lastCoordenada)) {
			this.coordenadasGuardadas[1]=lastCoordenada;
			return this.coordenadasGuardadas;
		}
		else if(value==0 && coordenadasGuardadas[1]!=null && lastCoordenada.casillaContigua(coordenadasGuardadas[1])) { 
			this.coordenadasGuardadas[0]=lastCoordenada;
			Coordenada[] auxiliar = coordenadasGuardadas;
			coordenadasGuardadas = new Coordenada[2];
			return auxiliar;
		}
		Coordenada[] nula = {null,null};
		return nula;
		
	}
	public void jugadaMenor6(int value, Coordenada lastCoordenada) {
		this.coordenadasGuardadas = new Coordenada[2];
		if(value==0) {
			this.coordenadasGuardadas[0]=lastCoordenada;
		}
				
	}
	
	public void aumentaJugada() {
		numerojugada++;
		if(numerojugada%2==0) this.turno=2;
		else this.turno=1;
	}
	
	public void update(Coordenada[] coordenada) {
		tablero.setValorPosicion(coordenada[0], this.turno);
		tablero.setValorPosicion(coordenada[1], 0);
	}
	
	public void update(Coordenada coordenada) {
		tablero.setValorPosicion(coordenada, this.turno);
	}
	
	public Coordenada[] victoria() {
		int[] result = tablero.comprobarVictoria(this.turno);
		Coordenada[] coordenadasVictoria= {null,null,null};
		if(result!=null) {
			for (int i = 0, j = 2; i < coordenadasVictoria.length; i++, j--) {
				if(result[1]==0) {
					coordenadasVictoria[i] = new Coordenada(result[0], i);
				}
				if(result[1]==1) {
					coordenadasVictoria[i] = new Coordenada(i, result[0]);
				}
				if(result[1]==2) {
					coordenadasVictoria[i] = new Coordenada(i,i);
				}
				if(result[1]==3) {
					coordenadasVictoria[i] = new Coordenada(i, j);
				}
			}
		}
		return coordenadasVictoria;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public int getNumerojugada() {
		return numerojugada;
	}
}
