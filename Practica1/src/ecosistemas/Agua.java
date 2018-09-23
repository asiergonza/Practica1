package ecosistemas;


import java.awt.*;

import javax.swing.*;

import clases.ElementoEcosistema;

/**
 * @author asiergonzi
 *Generaremos agua, y su constructor
 */
public class Agua extends ElementoEcosistema{
	protected long cantidad;
	JPanel pc = null;
	
	
	
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




	@Override
	public String toString() {
		return "Agua -" + titulo + "-" + cantidad ;
	}




	@Override
	public void evolucionar(int dias) {
		
		
	}




	@Override
	public JPanel getPanel() {
		
		
		JLabel nombre = new JLabel("Agua", SwingConstants.CENTER);
		JLabel lp = new JLabel(Long.toString(cantidad), SwingConstants.CENTER);
		
		// TODO Auto-generated method stub
		if(pc == null) {
			pc = new JPanel();
			
			pc.setLayout(new GridLayout(2, 1));
			pc.add(nombre);
			pc.add(lp);
			
			pc.setLocation(punto);
			pc.setSize((int)x,(int)y);
			pc.setBackground(Color.BLUE);
			
			
		
	}
		return pc;
		
	}
	
	
	

}
