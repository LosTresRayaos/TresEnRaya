package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.FrameCompuesto;
import vista.MyButton;

public class ParaFrameCompuesto extends FrameCompuesto {
	private Controlador control = new Controlador(panel);
	private ActionListener actionListener;
	private MouseListener hover;
	private MouseListener noHover;
	private boolean victoria=false;
	
	public ParaFrameCompuesto() {
		super();
		createActionListener();
		addActionListener();
	}
	
	private void createActionListener() {
		actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!victoria) {
					victoria=control.buttonPressed((MyButton)e.getSource());
				}
				if(victoria) {
					//TODO set linea victoria AQUI
				}
			}
		};
		hover = (new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!victoria) {
					((MyButton)e.getSource()).setBackgroundToHover();
				}
			}
		});
		
		noHover = (new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(!victoria) {
					((MyButton)e.getSource()).setBackgroundToBase();
				}
			}
		});
	}
	
	private void addActionListener() {
		Component component[][]=new Component[3][3];
		for (int i = 0; i < component.length; i++) {
			for (int j = 0; j < component[0].length; j++) {
				component[i][j]=(Component)this.panel.getBoton(i, j);
				
				((MyButton) component[i][j]).addActionListener(this.actionListener);
				
				((MyButton) component[i][j]).addMouseListener(this.hover);
				
				((MyButton) component[i][j]).addMouseListener(this.noHover);
				
			}
		}
	}
}
