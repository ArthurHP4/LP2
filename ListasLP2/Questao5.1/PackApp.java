import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class PackApp{
	public static void main (String[] args){
		PackFrame frame = new PackFrame();
		frame.setVisible(true);
	}
}

class PackFrame extends JFrame{
	ArrayList<Rect> rs = new ArrayList<Rect>();
	Random rand = new Random();
	
	ArrayList<Ellipse> es = new ArrayList<Ellipse>();
	
	ArrayList<Triangulo> ts = new ArrayList<Triangulo>();
	
	public PackFrame (){
		this.addWindowListener(
			new WindowAdapter(){
				public void windowClosing (WindowEvent e){
					System.exit(0);
				}
			}
		);
		
		this.addKeyListener(
			new KeyAdapter(){
				public void keyPressed (KeyEvent evt) {
					if(evt.getKeyChar() == 'r') {
						int x = rand.nextInt(350);
						int y = rand.nextInt(350);
						int w = rand.nextInt(50);
						int h = rand.nextInt(50);
						int rC = rand.nextInt(250);
						int gC = rand.nextInt(250);
						int bC = rand.nextInt(250);
						int rF = rand.nextInt(250);
						int gF = rand.nextInt(250);
						int bF = rand.nextInt(250);
						rs.add(new Rect(x,y, w,h,rC,gC,bC,rF,gF,bF));
                        repaint();
					}
					if(evt.getKeyChar() == 'e') {
						int x = rand.nextInt(350);
						int y = rand.nextInt(350);
						int w = rand.nextInt(50);
						int h = rand.nextInt(50);
						int rc = rand.nextInt(250);
						int gc = rand.nextInt(250);
						int bc = rand.nextInt(250);
						int rf = rand.nextInt(250);
						int gf = rand.nextInt(250);
						int bf = rand.nextInt(250);
						es.add(new Ellipse(x,y, w,h,rc,gc,bc,rf,gf,bf));
                        repaint();
					}
					if(evt.getKeyChar() == 't') {
						int x1 = rand.nextInt(350);
						int y1 = rand.nextInt(350);
						int x2 = rand.nextInt(50);
						int y2 = rand.nextInt(50);
						int x3 = rand.nextInt(250);
						int y3 = rand.nextInt(250);
						int rc = rand.nextInt(250);
						int gc = rand.nextInt(250);
						int bc = rand.nextInt(250);
						
						ts.add(new Triangulo(x1,y1, x2,y2,x3,y3,rc,gc,bc));
                        repaint();
					}	
					
				}
			}
		);													
		this.setTitle("Java Packages");
		this.setSize(350,350);		
	}
	
	public void paint (Graphics g){
		super.paint(g);
        for (Rect r: this.rs) {
            r.paint(g);
        }
		
		for (Ellipse e: this.es) {
            e.paint(g);
        }
		
		for (Triangulo t: this.ts) {
            t.paint(g);
        }

	}
}
