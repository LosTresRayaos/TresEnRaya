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
	private boolean seleccionada=false;
	private boolean[] respuesta = {victoria,seleccionada};
	private MyButton anterior;
	
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
					respuesta=control.buttonPressed((MyButton)e.getSource());
					victoria=respuesta[0];
					seleccionada=respuesta[1];
					
					if(anterior != null) {
						reAddHover(anterior);
					}
					
				}
				if(seleccionada) {
					removeHover((MyButton)e.getSource());
					((MyButton)e.getSource()).setBackgroundToHover();
					anterior=(MyButton)e.getSource();
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
				
				reAddHover(((MyButton) component[i][j]));
			}
		}
	}
	
	public void removeHover(MyButton buttonSelected) {
		buttonSelected.removeMouseListener(this.hover);
		buttonSelected.removeMouseListener(this.noHover);
	}
	
	public void reAddHover(MyButton buttonSelected) {
		buttonSelected.addMouseListener(this.hover);
		buttonSelected.addMouseListener(this.noHover);
		buttonSelected.setBackgroundToBase();
	}
}
