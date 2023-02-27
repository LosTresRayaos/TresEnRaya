package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import modelo.Coordenada;

public class PanelBotonera extends JPanel {
	private MyButton botonera[][]=new MyButton[3][3];
	private Color black = new Color(0,0,0);
	private Color blockedColor = new Color(150,150,150);
	private Font baseFont;
	private String fontStyle = "Arial";
	private Color[] baseColor = {new Color(255,255,255), new Color(230,255,255), new Color(255,190,130), new Color(255,225,255), new Color(200,200,255)}; //Avoid values below 50
	private Color hoverColor;
	private int posColor;

	
	public PanelBotonera() {
		crearBotones();
	}

	private void crearBotones() {
		for (int i = 0; i < 3; i++) {
			for (int j= 0; j < 3; j++) {
				botonera[i][j] = new MyButton(new Coordenada(i, j));
				botonera[i][j].setFont(baseFont);
				this.add(botonera[i][j] );
				botonera[i][j].setBorder(BorderFactory.createBevelBorder(0));
				botonera[i][j].setFocusable(false);

			}
		}
		setBackground(baseColor[posColor]);
		changeHoverColor(baseColor[posColor]);
	}
	
	public void changeHoverColor(Color base) {
		this.hoverColor = new Color(base.getRed()-50,base.getGreen()-50,base.getBlue()-50);
	}
	public MyButton getBoton(int i, int j) {
		return botonera[i][j];
	}
	
	public MyButton getBoton(Coordenada coordenada) {
		return botonera[coordenada.getX()][coordenada.getY()];
	}

	public MyButton[][] getBotonera() {
		return botonera;
	}
	
	public void changeDimension(int value) {
		int scaleFactor = 2;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.baseFont=new Font(getFontStyle(), Font.CENTER_BASELINE, (value/scaleFactor));
				this.botonera[i][j].setFont(baseFont);
			}
		}
	}
	
	
	public void setForegroundButton(String turno) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(this.botonera[i][j].getText().equals(turno)) {
					this.botonera[i][j].setForeground(black);
				}
				else {
					this.botonera[i][j].setForeground(blockedColor);
				}
			}
		}
	}
	
	public void victory(Coordenada[] victory) {
		for (int i = 0; i < victory.length; i++) {
			getBoton(victory[i]).setBackground(hoverColor);
		}
	}
	
	public void setBackgroundToBaseColor(MyButton button) {
		button.setBackground(baseColor[posColor]);
	}
	
	public void setBackgroundToHoverColor(MyButton button) {
		button.setBackground(hoverColor);
	}
	

	public void changeColor() {
		Color oldBase = baseColor[posColor];
		Color oldHover = this.hoverColor;
		if(posColor<this.baseColor.length-1) this.posColor++;
		else this.posColor=0;
		
		changeHoverColor(baseColor[posColor]);
		
		for (int i = 0; i < botonera.length; i++) {
			for (int j = 0; j < botonera[0].length; j++) {
				Color buttonColor = botonera[i][j].getBackground();
				if(buttonColor.equals(oldBase)) {
					botonera[i][j].setBackground(this.baseColor[posColor]);
				}
				else if(buttonColor.equals(oldHover)){
					botonera[i][j].setBackground(this.hoverColor);
				}
			}
		}
		
		
		
	}

	public int getPosColor() {
		return posColor;
	}
	
	public void loadColor(int pos) {
		if(pos==-1)posColor=0;
		else posColor=pos;
		for (int i = 0; i < botonera.length; i++) {
			for (int j = 0; j < botonera[0].length; j++) {
				botonera[i][j].setBackground(this.baseColor[this.posColor]);
				changeHoverColor(baseColor[posColor]);
			}
		}
		
	}
	public String getFontStyle() {
		return fontStyle;
	}
	
}
