package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Controlador;

public class PanelBotonera extends JPanel {

	private MyButton botonera[][]=new MyButton[3][3];
	private Controlador control = new Controlador();
	
	public PanelBotonera() {
		crearBotones();
	
	}

	private void crearBotones() {
		for (int i = 0; i < 3; i++) {
			for (int j= 0; j < 3; j++) {
				botonera[i][j] = new MyButton(new Coordenada(i, j));
				Color white = new Color(255,255,255);
				botonera[i][j].setBackground(white);
				botonera[i][j] .addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				control.getCasilla((MyButton)e.getSource());
				}
			});
				botonera[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						Color gray = new Color(200,200,200);
						((MyButton) e.getSource()).setBackground(gray);
					}
				});
				
				botonera[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseExited(MouseEvent e) {
						Color white = new Color(255,255,255);
						((MyButton) e.getSource()).setBackground(white);
					}
				});


				
			this.add(botonera[i][j] );
			}
		}
		
	}

	public MyButton getBoton(int i, int j) {
		return botonera[i][j];
	}

	
}
