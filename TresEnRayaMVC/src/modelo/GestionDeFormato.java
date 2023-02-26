package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GestionDeFormato {
	private String file = "colorTablero";
	
	public GestionDeFormato(){

		
	}
	
	public void saveColor(int color) throws IOException {
		FileOutputStream out = new FileOutputStream(file);
		out.write(color);
		out.close();
	}
	
	public int getColor() throws IOException {
		FileInputStream in = new FileInputStream(file);
		int data = in.read();
		in.close();
		return data;
	}
}
