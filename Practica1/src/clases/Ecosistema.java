package clases;

import java.util.*;

public class Ecosistema {
	
	public ArrayList<ElementoEcosistema> listaEEs;
	
	
	public static Ecosistema ec = new Ecosistema();
	public Ecosistema() {
		
		listaEEs = new ArrayList<>();
	}
	
	public ArrayList<ElementoEcosistema> getElementos() {
		return listaEEs;
	}
	
	public static Ecosistema getMundo() {
		
		return ec;
		
	}
	
	public static double distancia(ElementoEcosistema ee, ElementoEcosistema ee1) {
		
		double x = ee.getPunto().getX() - ee1.getPunto().getX();
		double y = ee.getPunto().getY() - ee1.getPunto().getY();
		double sumaCuadrados = x*x  + y*y;
		double dis = Math.sqrt(sumaCuadrados);
		return dis;
		
	}
	
	
}
