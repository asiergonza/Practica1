package clases;

import java.awt.*;
public abstract class Ecosistema {
	
	
	protected String titulo;
	protected Point punto;
	protected double x;
	protected double y;

	public Point getPunto() {
		return punto;
	}

	public void setPunto(Point punto) {
		this.punto = punto;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	

}
