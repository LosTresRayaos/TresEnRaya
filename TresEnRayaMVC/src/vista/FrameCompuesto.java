package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.GridLayout;

public class FrameCompuesto extends JFrame{

	private JPanel contentPane;
	protected PanelBotonera botonera;
	
	public FrameCompuesto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		botonera = new PanelBotonera();
		contentPane.add(botonera);
		botonera.setLayout(new GridLayout(3, 3, 0, 0));
	}

	protected PanelBotonera getPanel() {
		return botonera;
	}

	public MyButton getBoton(int i, int j) {
		return botonera.getBoton(i, j);
	}
}
