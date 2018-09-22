package ecosistemas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import clases.Ecosistema;
import clases.ElementoEcosistema;
import clases.Evolucionar;

public class ColoniaAbejas extends ElementoEcosistema implements Evolucionar{
	
	public long getPoblacion() {
		return poblacion;
	}



	public void setpoblacion(long poblacion) {
		this.poblacion = poblacion;
	}



	protected long poblacion;
	JPanel pb = null;

	
	
	public ColoniaAbejas(String nom, Point p, Double x, Double y, Long c) {
		poblacion = c;
		super.punto = p;
		super.titulo = nom;
		super.x = x;
		super.y = y;
		
	}



	@Override
	public void evolucionar(int dias) {
		// TODO Auto-generated method stub
		double factorCrecimiento = 1.0;
		int numFlores = 0;
		for (ElementoEcosistema ee : Ecosistema.getMundo().getElementos()) {
		int dist = (int) Ecosistema.distancia( this, ee );
		if (ee instanceof ColoniaAbejas && ee!=this) { // Otra colonia de abejas perjudica
		if (dist < 500) factorCrecimiento = factorCrecimiento * dist / 500;
		} else if (ee instanceof PlantacionFlores) { // La cercanía de flores beneficia
		if (dist < 500) factorCrecimiento = factorCrecimiento / dist * 500; numFlores += ((PlantacionFlores)ee).getCantidad();
		} }
		if (numFlores < 50) factorCrecimiento *= 0.1; // Insuficientes flores mata poblacion = (long) (poblacion * factorCrecimiento * dias);
		if (poblacion > 5000) poblacion = 5000; // Límite de población
		
	}
	

	@Override
	public String toString() {
		return "Agua -" + titulo + "-" + poblacion ;
	}



	@Override
	public JPanel getPanel() {
		
		JLabel nombre = new JLabel("Abejas", SwingConstants.CENTER);
		JLabel lp = new JLabel(Long.toString(poblacion), SwingConstants.CENTER);
		
		// TODO Auto-generated method stub
		if(pb == null) {
			pb = new JPanel();
			
			pb.setLayout(new GridLayout(2, 1));
			pb.add(nombre);
			pb.add(lp);
			
			pb.setLocation(punto);
			pb.setSize((int)x,(int)y);
			pb.setBackground(Color.YELLOW);
			
			
		
	}
		return pb;
}
}
