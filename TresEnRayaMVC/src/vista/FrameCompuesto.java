package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.GestionDatos;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;

public class FrameCompuesto extends JFrame {

	private JPanel contentPane;
	protected PanelBotonera panel;

	

	/**
	 * Create the frame.
	 */
	public FrameCompuesto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TIC TAC TOE");
		lblNewLabel.setBounds(194, 10, 72, 16);
		contentPane.add(lblNewLabel);
		
		panel = new PanelBotonera();

		panel.setBounds(0, 76, 434, 185);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
	}

	protected PanelBotonera getPanel() {
		return panel;
	}

	public MyButton getBoton(int i, int j) {
		return panel.getBoton(i, j);
	}
}
