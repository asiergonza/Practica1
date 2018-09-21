package clases;



import java.awt.*;

import javax.swing.*;
public abstract class ElementoEcosistema {
	
	
	protected String titulo;
	protected Point punto;
	protected Dimension d;
	protected double x;
	protected double y; 
	protected JPanel pan; 

	public Dimension getD() {
		return d;
	}

	public void setD(Dimension d) {
		this.d = d;
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

	public Point getPunto() {
		return punto;
	}

	public void setPunto(Point punto) {
		this.punto = punto;
	}

	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public abstract void evolucionar(int dias);
	
	
	abstract public void getPanel();
	
	
	

}
