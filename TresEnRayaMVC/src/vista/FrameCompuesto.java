package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.GridLayout;

public class FrameCompuesto extends JFrame{

	private JPanel contentPane;
	protected PanelBotonera panel;
	
	public FrameCompuesto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new PanelBotonera();

		panel.setBounds(0, 0, 434, 261);
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
