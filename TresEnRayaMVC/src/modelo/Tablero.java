package modelo;

import vista.Coordenada;

public class Tablero {
	public int tablero[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	public int getValorPosicion(Coordenada coordenada) {
		return this.tablero[coordenada.getX()][coordenada.getY()];
	}

	public void setValorPosicion(Coordenada coordenada, int i) {
		this.tablero[coordenada.getX()][coordenada.getY()]=i;
		
	}
	/**
	 * Mirar las filas del tablero
	 * 
	 * @return true si hay tres fichas de la misma clase en una fila
	 */
	private boolean compruebaFila() {
		for (int x = 0; x < 3; x++)
			if (this.tablero[x][0] == this.tablero[x][1] && this.tablero[x][1] == this.tablero[x][2] && this.tablero[x][1] != 0)
				return true;
		return false;
	}
	
	/**
	 * Mira las columnas del tablero
	 * 
	 * @return true si tres fichas de la misma clase en una columna
	 */
	private boolean compruebaColumna() {
		for (int y = 0; y < 3; y++)
			if (this.tablero[0][y] == this.tablero[1][y] && this.tablero[1][y] == this.tablero[2][y] && this.tablero[1][y] != 0)
				return true;
		return false;
	}

	/**
	 * Comprueba si alguna diagonal tiene tres en raya No hace falta comparar si
	 * est�n vacias, no puede ocurrir
	 * 
	 * @return true si se da la circunstancia
	 */
	private boolean compruebaDiagonal() {
		if (this.tablero[0][0] == this.tablero[1][1] && this.tablero[1][1] == this.tablero[2][2])
			return true;
		if (this.tablero[0][2] == this.tablero[1][1] && this.tablero[1][1] == this.tablero[2][0])
			return true;
		return false;
	}

	/**
	 * Se encarga de llamar a los metodos que comprueban las tres en raya
	 * 
	 * @return true si se han conseguida tres en raya
	 */
	public int[] comprobarVictoria (int turno) {
		int i;
		int j;
		for (i = 0; i < 3; i++) {
			int[] cont = new int[4];
			int k=2;
			if(this.tablero[i][i]==turno) {
				for(j=0; j<3; j++) {
					if(this.tablero[i][j]==turno) cont[0]++;
					if(this.tablero[j][i]==turno) cont[1]++;
					if(i==1) {
						if(this.tablero[j][j]==turno) cont[2]++;
						if(this.tablero[j][k]==turno) cont[3]++;
					}
					k--;
				}
			}
			for(j=0; j<4; j++) {
				if(cont[j]==3) {
					int[] victoria = {i,j};
					return victoria;
				}
			}
		}
		return null;
	}
	
	/**
	 * Si en la casilla determinada por las coordenadas x e y se encuentra con un
	 * cero seignifica que la casilla est� libre
	 * 
	 * @param coordenada de fila
	 * @param coordenada de columna
	 * @return verdadero si la casilla esta libre y falso en caso contrario
	 */
	public boolean mirarCasillaLibre(Coordenada coordenada) {
		return getValorPosicion(coordenada)  == 0;
	}
	/**
	 * Comprueba si la casilla origen esta ocupada por una ficha de la propiedad del
	 * turno actual
	 * 
	 * @return true si casilla pertenece al turno actual o false en caso contrario
	 */
	public boolean comprobarPropiedad(Coordenada coordenada, int turno) {
		return getValorPosicion(coordenada) ==turno;
	}
	

	/**
	 * casilla libre adyacente libre
	 * 
	 * @return true si encuentra al menos una casilla libre contigua false si la
	 *         pieza est� bloqueada
	 */
	public boolean comprobarBloqueada(Coordenada coordenada) {
		for (int x = coordenada.getX() - 1; x <= coordenada.getX() + 1; x++)
			for (int y = coordenada.getY() - 1; y <= coordenada.getY() + 1; y++)
				if (x > -1 && x < 3 && y > -1 && y < 3)
					if (getValorPosicion(new Coordenada(x, y))  == 0)
						return true;
		return false;
	}
	
	public boolean comprobarContigua(Coordenada lastCoordenada, Coordenada first) {
		
		
		return false;
	}
	public void showGame() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(this.tablero[i][j] + "|");
			}
			System.out.println();
		}
		System.out.println();
	}
}
