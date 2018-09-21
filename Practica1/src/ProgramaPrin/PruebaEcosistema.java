package ProgramaPrin;

import clases.*;
import ecosistemas.*;
import java.awt.*;



public class PruebaEcosistema {

	public static void main(String[] args) {
		Point p = new Point(100,300);
		Point p2 = new Point(10,200);
		Point p1 = new Point(1000,1200);
		
		Agua ag = new Agua("aguita" ,p, 50.0,50.0,(long)2345 );
		ColoniaAbejas ab = new ColoniaAbejas("abejonejo", p2, 50.0,234.4, (long)21456);
		PlantacionFlores pl = new PlantacionFlores("guau que flores", p1, 45.6, 874.5, (long)172370);
		
		Ecosistema.ec.listaEEs.add(ag);
		Ecosistema.ec.listaEEs.add(ab);
		Ecosistema.ec.listaEEs.add(pl);
		
		for(int i = 0; i < 4; i++) {
			
			System.out.println(Ecosistema.ec.listaEEs.get(0));
			System.out.println(Ecosistema.ec.listaEEs.get(1));
			System.out.println(Ecosistema.ec.listaEEs.get(2));
			
			Ecosistema.ec.listaEEs.get(1).evolucionar(i);
			Ecosistema.ec.listaEEs.get(2).evolucionar(i);
			
			
		}
		

	}

}
