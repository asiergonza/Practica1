package ProgramaPrin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import clases.Ecosistema;
import clases.ElementoEcosistema;
import ecosistemas.Agua;
import ecosistemas.ColoniaAbejas;
import ecosistemas.PlantacionFlores;

public class Ventana extends JFrame{

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	String[] lis = { "Abejas", "Agua", "Flores" };
	JComboBox<String> c1 = new JComboBox<>(lis);
	JButton b1 = new JButton("Vida"); 
	JButton b12 = new JButton("Mover"); 
	JButton b3= new JButton("Crear"); 
	boolean crear = false;
	boolean mover = true; 
	int x1;
	int x2;
	int y1;
	int y2;
	Point p;
	int cuenta = 0;
	JPanel pp;
	int c = -1;
	ArrayList<JPanel> listaPanelesVida;
	
	public Ventana() {
		setSize(600, 600);
		setResizable(false);
		
		add(p1, BorderLayout.CENTER); 
		p2.add(b12);
		p2.add(b3);
		p2.add(c1);
		p2.add(b1);
		c1.setSelectedIndex(0);
		p1.setLayout(null);
		
		
		
		
		
		
		
		
		add(p2, BorderLayout.SOUTH); 
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(crear == false) {
					
					crear = true;
					mover = false;
				}
				
			
				
				
			}
		});

		b12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mover == false) {

					mover = true;
					crear = false;
				}

				

			}
		});
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(b1.getText() == "Vida") {
					hilo.start();
					b1.setText("Parar");
					p1.repaint();
					
				}
				else {
					b1.setText("Vida");
					p1.repaint();
					
					
				}
				

			}
		});
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();
				ElementoEcosistema ab = null;
				double restax = x2 - x1;
				double restay = y2 - y1;
				long superficie = (long) (restax * restay);
				if(restax >0 || restay > 0 ) {
				if(crear == true) {
					if(c1.getSelectedIndex() == 0) {
						//abejas
						
						ab = new ColoniaAbejas("abejas", p, restax,restay, (long)superficie);
						pp = ab.getPanel();
						
					
						

					}
					if(c1.getSelectedIndex() == 1) {
						//agua
						ab = new Agua("agua", p, restax,restay, (long)superficie);
						pp = ab.getPanel();
						
						
					}
					if(c1.getSelectedIndex() == 2) {
						//flores
						
						ab = new PlantacionFlores("flores", p, restax, restay, (long)superficie);
						pp = ab.getPanel();
						
						
					}
					if(ab !=  null) {
						
					
					Ecosistema.getMundo().listaEEs.add(ab);
					}
					
					p1.add(pp);
					pp.revalidate();
					p1.revalidate();
					
					
				}
				



				}
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
			
			
			p = new Point(x1, y1);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
	
	setVisible(true);	
	}
	
	
	Thread hilo = new Thread() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				c = c +1;
				
				int size = Ecosistema.getMundo().listaEEs.size();
				for(int i = 0; i < size ; i++) {
					Ecosistema.getMundo().listaEEs.get(i).evolucionar(c);
					//System.out.println(Ecosistema.getMundo().listaEEs.get(i));
					JLabel jl = (JLabel)Ecosistema.getMundo().listaEEs.get(i).getPanel().getComponent(1);
					
					
				}
				
				
				
				
				
				p1.repaint();
				
				try {
					sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			
			
		}
	};
}
