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
	private boolean seleccionado=false;
	private boolean cambioHecho=false;
	private boolean[] respuesta = {victoria,seleccionado,cambioHecho};
	private MyButton botonSeleccionado;
	private MyButton botonActual;
	
	public ParaFrameCompuesto() {
		super();
		createActionListener();
		addActionListener();
	}
	
	private void createActionListener() {
		actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				botonActual = (MyButton)e.getSource();
				if(!victoria) {
					respuesta=control.buttonPressed((MyButton)e.getSource());
					victoria=respuesta[0];
					seleccionado=respuesta[1];
					cambioHecho=respuesta[2];
					if(seleccionado) {
						
						if(botonSeleccionado != null) addHover(botonSeleccionado);
						removeHover(botonActual);
						botonActual.setBackgroundToHoverColor();
						botonSeleccionado=botonActual;
					}
					
					if(cambioHecho && botonSeleccionado!=null) {
						addHover(botonSeleccionado);
						botonSeleccionado=null;
					}
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
					((MyButton)e.getSource()).setBackgroundToHoverColor();
				}
			}
		});
		
		noHover = (new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(!victoria) {
					((MyButton)e.getSource()).setBackgroundToBaseColor();
				}
			}
		});
	}
	
	private void addActionListener() {
		Component component[][]=new Component[3][3];
		for (int i = 0; i < component.length; i++) {
			for (int j = 0; j < component[0].length; j++) {
				component[i][j]=(Component)this.panel.getBoton(i, j);
				
				((MyButton)component[i][j]).addActionListener(this.actionListener);
				
				addHover(((MyButton) component[i][j]));
			}
		}
	}
	
	public void removeHover(MyButton buttonSelected) {
		buttonSelected.removeMouseListener(this.hover);
		buttonSelected.removeMouseListener(this.noHover);
	}
	
	public void addHover(MyButton buttonSelected) {
		buttonSelected.addMouseListener(this.hover);
		buttonSelected.addMouseListener(this.noHover);
		buttonSelected.setBackgroundToBaseColor();
	}
}
