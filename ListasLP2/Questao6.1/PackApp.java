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
	
	ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
	
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
						int x1 = rand.nextInt(350);
						int y1 = rand.nextInt(350);
						int x2 = rand.nextInt(50);
						int y2 = rand.nextInt(50);
						int x3 = rand.nextInt(250);
						int y3 = rand.nextInt(250);
					
					if(evt.getKeyChar() == 'r') {	
                        figs.add(new Rect(x,y, w,h,rC,gC,bC,rF,gF,bF));
					}
					else if(evt.getKeyChar() == 'e') {	
                        figs.add(new Ellipse(x,y, w,h,rC,gC,bC,rF,gF,bF));
					}
					else if(evt.getKeyChar() == 't') {		
						figs.add(new Triangulo(x1,y1, x2,y2,x3,y3,rC,gC,bC));
					}	
					repaint();
				}
			}
		);													
		this.setTitle("Java Packages");
		this.setSize(350,350);		
	}
	
	public void paint (Graphics g){
		super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
	}
}
