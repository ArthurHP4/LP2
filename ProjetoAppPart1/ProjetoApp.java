import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ProjetoApp{
	public static void main (String[] args){
		ProjetoFrame frame = new ProjetoFrame();
		frame.setVisible(true);
	}
	
}

class ProjetoFrame extends JFrame{
	
	ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
	
	public ProjetoFrame (){
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
					
					int x = rand.nextInt(550);
					int y = rand.nextInt(550);
					int l = rand.nextInt(250);
					int a = rand.nextInt(250);
					int c1 = rand.nextInt(4);
					int c2 = rand.nextInt(4);
					int x2 = rand.nextInt(350);
					int y2 = rand.nextInt(350);
					int x3 = rand.nextInt(350);
					int y3 = rand.nextInt(350);
					Color cor1;
					Color cor2;
			
					switch(c1){
						case (4):
							cor1 = Color.decode("#800080");
							break;
						case (3):
							cor1 = Color.decode("0x008000");
							break;
						case (2):
							cor1 = Color.decode("#800000");
							break;
						case (1):
							cor1 = Color.decode("#800080");
							break;
						default:
							cor1 = Color.decode("#00000000");
							break;
					}
					
					switch(c2){
						case 4:
							cor2 = Color.decode("#800080");
							break;
						case 3:
							cor2 = Color.decode("0x008000");
							break;
						case 2:
							cor2 = Color.decode("#800000");
							break;
						case 1:
							cor2 = Color.decode("#800080");
							break;
						default:
							cor2 = Color.decode("#00000000");
							break;
					}
					
					if(evt.getKeyChar() == 'r') {	
                        figs.add(new Rect(x,y,l,a,cor1,cor2));
					}
					else if(evt.getKeyChar() == 'e') {	
                        figs.add(new Ellipse(x,y,l,a,cor1,cor2));
					}
					else if(evt.getKeyChar() == 'l') {		
						figs.add(new Line(x,y,l,a,cor1));
					}					
					else if(evt.getKeyChar() == 't') {		
						figs.add(new Triangulo(x,y,x2,y2,x3,y3,cor1,cor2));
					}	
					
					repaint();
				}
			}
		);													
		this.setTitle("Projeto App");
		this.setSize(550,550);		
	}
	
	public void paint (Graphics g){
		super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
	}
}
