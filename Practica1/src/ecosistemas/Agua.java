package ecosistemas;


import java.awt.*;


import clases.ElementoEcosistema;

public class Agua extends ElementoEcosistema{
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




	@Override
	public String toString() {
		return "Agua -" + titulo + "-" + cantidad ;
	}




	@Override
	public void evolucionar(int dias) {
		
		
	}




	@Override
	public void getPanel() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
