package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import modelo.GestionDatos;
import modelo.GestionDeFormato;
import vista.FrameCompuesto;
import vista.MyButton;

public class ParaFrameCompuesto extends FrameCompuesto{
	private Controlador control = new Controlador(botonera);
	private GestionDeFormato gestionFormato = new GestionDeFormato();
	private ActionListener actionListener;
	private MouseListener hover;
	private MouseListener noHover;
	private KeyListener cPressed;
	private boolean victoria=false;
	private boolean seleccionado=false;
	private boolean cambioHecho=false;
	private boolean[] respuesta = {victoria,seleccionado,cambioHecho};
	private MyButton botonSeleccionado;
	private MyButton botonActual;
	private ComponentAdapter windowReSized;
	
	public ParaFrameCompuesto() {
		super();
		setFocusable(true);
		createEvents();
		addEvents();
		setSavedColor();
	}
	


	private void createEvents() {
		actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				botonActual = (MyButton)e.getSource();
				if(!victoria) {
					respuesta=control.buttonPressed(botonActual);
					victoria=respuesta[0];
					seleccionado=respuesta[1];
					cambioHecho=respuesta[2];
					if(seleccionado) {
						
						if(botonSeleccionado != null) addHover(botonSeleccionado);
						removeHover(botonActual);
						botonera.setBackgroundToHoverColor(botonActual);
						botonSeleccionado=botonActual;
					}
					
					if(cambioHecho && botonSeleccionado!=null) {
						addHover(botonSeleccionado);
						botonSeleccionado=null;
					}
				}
				
				if(victoria) {
					removeEvents();
				}
			}
		};
		hover = (new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonera.setBackgroundToHoverColor(((MyButton)e.getSource()));
			}
		});
		
		noHover = (new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				botonera.setBackgroundToBaseColor(((MyButton)e.getSource()));
			}
		});
		windowReSized = (new ComponentAdapter() {
			@Override
            public void componentResized(ComponentEvent e) {
            	int width = ((Component)e.getSource()).getWidth();
            	int height = ((Component)e.getSource()).getHeight();
            	if(width<height) {
            		botonera.changeDimension(width);
            	}
            	else {
            		botonera.changeDimension(height);
            	}
            }
        });
		cPressed = (new KeyListener() {
			public void keyPressed(KeyEvent e) {
                char letra = e.getKeyChar();
                if(letra=='c') {
                	botonera.changeColor();
                	try {
						gestionFormato.saveColor(botonera.getPosColor());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                }
                
                
            }
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}
		});

		

	}
	
	private void addEvents() {
		Component component[][]=new Component[3][3];
		for (int i = 0; i < component.length; i++) {
			for (int j = 0; j < component[0].length; j++) {
				component[i][j]=(Component)this.botonera.getBoton(i, j);
				
				((MyButton)component[i][j]).addActionListener(this.actionListener);
				
				
				addHover(((MyButton) component[i][j]));
			}
		}
		((MyButton)component[0][0]).addComponentListener(windowReSized);
		
		addKeyListener(cPressed);  //Para cambiar de color los botones en panel botonera pulsa c
	}
	
	private void removeEvents() {
		Component component[][]=new Component[3][3];
		for (int i = 0; i < component.length; i++) {
			for (int j = 0; j < component[0].length; j++) {
				component[i][j]=(Component)this.botonera.getBoton(i, j);
				
				((MyButton)component[i][j]).removeActionListener(this.actionListener);
								
				removeHover(((MyButton) component[i][j]));
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
		botonera.setBackgroundToBaseColor(buttonSelected);
	}
	
	private void setSavedColor() {
		try {
			botonera.loadColor(gestionFormato.getColor());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
