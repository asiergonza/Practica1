package ecosistemas;


import java.awt.*;

import clases.Ecosistema;

public class Agua extends Ecosistema{
	protected long cantidad;
	
	
	
	public Agua(String nom, Point p, Double x, Double y, Long c) {
		
		cantidad = c;
		super.punto = p;
		super.titulo = nom;
		super.x = x;
		super.y = y;
		
	}
	
	
	

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
