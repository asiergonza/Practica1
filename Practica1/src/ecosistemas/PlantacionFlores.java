package ecosistemas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.*;

import clases.Ecosistema;
import clases.ElementoEcosistema;
import clases.Evolucionar;

public class PlantacionFlores extends ElementoEcosistema implements Evolucionar{
	
	protected long cantidad;
	JPanel pa = null;
	
	public PlantacionFlores(String nom, Point p, Double x, Double y, Long c) {
		
		cantidad = c;
		super.punto = p;
		super.titulo = nom;
		super.x = x;
		super.y = y;
	}

	@Override
	public void evolucionar(int dias) {
		// TODO Auto-generated method stub
		double factorCrecimiento = 0.75;
		for (ElementoEcosistema ee : Ecosistema.getMundo().listaEEs) {
			int dist = (int)Ecosistema.distancia( this, ee );
			if (ee instanceof ColoniaAbejas) { // La cercanía de abejas beneficia
				if (dist < 500) factorCrecimiento = factorCrecimiento / dist * 500; } else if (ee instanceof Agua) { // La cercanía de agua beneficia
					if (dist < 500) factorCrecimiento = factorCrecimiento / dist * 500;
				}
		}
		cantidad = (long) (cantidad * factorCrecimiento * dias);
		//if (cantidad > 5000) cantidad = 5000;


	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	

	@Override
	public String toString() {
		return "Agua -" + titulo + "-" + cantidad ;
	}

	@Override
	public JPanel getPanel() {
		
		JLabel nombre = new JLabel("Flores", SwingConstants.CENTER);
		JLabel lp = new JLabel(Long.toString(cantidad), SwingConstants.CENTER);
		
		// TODO Auto-generated method stub
		if(pa == null) {
			pa = new JPanel();
			
			pa.setLayout(new GridLayout(2, 1));
			pa.add(nombre);
			pa.add(lp);
			
			pa.setLocation(punto);
			pa.setSize((int)x,(int)y);
			pa.setBackground(Color.GREEN);
			
			
		
	}
		return pa;
		
	}

	
	
	

}
