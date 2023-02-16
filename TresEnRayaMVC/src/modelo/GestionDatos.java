package modelo;

import vista.MyButton;

public class GestionDatos {
	private Tablero tablero=new Tablero();
	public int numerojugada = 0;
	/**
	 * Informa de quien es el turno actual
	 * 
	 * @return 1 o 0 dependiendo de quien sea el propietario del turno
	 */
	
	public void proceso(MyButton button) {
		
	}
	public int verTurno() {
		if (numerojugada % 2 == 0) {
			this.numerojugada++;
			return 2;
		}
		this.numerojugada++;
		return 1;

	}
}
