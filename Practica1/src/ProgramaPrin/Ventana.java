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
	int c = 0;
	boolean sigue = true;
	ArrayList<JPanel> listaPanelesVida;

	/**
	 * Aqui crearemos el mouse listener que es lo que hara mover y crear nuestros elementos,
	 * esta sera la parte mas dificil. 
	 */
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
					sigue = true;
					hilo.start();
					b1.setText("Parar");
					//p1.repaint();

				}
				else {
					b1.setText("Vida");
					sigue = false;

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
				System.out.println(restay);
				long superficie = (long) ((restax * restay)/100);
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

					if(mover == true) {
						for( ElementoEcosistema ee: Ecosistema.getMundo().listaEEs) {
							double x = ee.getPunto().getX();
							double y = ee.getPunto().getY();
							double xFinal = x + ee.getX();
							double yFinal = y + ee.getY();
							double restaX = p.getX() - e.getX();
							double restaY = p.getY() - e.getY();
							if(x < p.getX() && p.getX() < xFinal) {
								System.out.println("llego al primero");
								if(y < p.getY() && p.getY() < yFinal) {
									System.out.println("llego al seg");
									int localizacionNuevaX = (int) (x + restax);
									int localizacionNuevaY = (int) (y + restay);
									Point pFinal = new Point(localizacionNuevaX,localizacionNuevaY);
									ee.setPunto(pFinal);

									ee.getPanel().setLocation(localizacionNuevaX,localizacionNuevaY);
									p1.revalidate();
									System.out.println("llego");
									p1.repaint();


								}



							}





						}






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
			while(sigue) {
				c = c +1;

				int size = Ecosistema.getMundo().listaEEs.size();
				for(int i = 0; i < size ; i++) {
					Ecosistema.getMundo().listaEEs.get(i).evolucionar(c);
					//System.out.println(Ecosistema.getMundo().listaEEs.get(i));
					JLabel jl = (JLabel)Ecosistema.getMundo().listaEEs.get(i).getPanel().getComponent(1);
					//jl.setText("holaaaaa");
					if(Ecosistema.getMundo().listaEEs.get(i) instanceof ColoniaAbejas){

						ColoniaAbejas ca = (ColoniaAbejas)Ecosistema.getMundo().listaEEs.get(i);
						//ca.getPoblacion();
						jl.setText(""+ ca.getPoblacion());


					}
					if(Ecosistema.getMundo().listaEEs.get(i) instanceof PlantacionFlores){
						PlantacionFlores fl = (PlantacionFlores)Ecosistema.getMundo().listaEEs.get(i);
						jl.setText(""+ fl.getCantidad());


					}

					//p1.revalidate();
					p1.repaint();



				}





				p1.repaint();

				try {
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



			}


		}
	};




}
