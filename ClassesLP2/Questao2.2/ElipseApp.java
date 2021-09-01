import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;


class PaintApp {
	public static void main (String[] args){
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
		
	}
}

class PaintFrame extends JFrame{
	Ellipse e1, e2, e3;
	
	PaintFrame(){
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosing (WindowEvent e) {
					System.exit(0);
				}
			}
		);
		this.setTitle("Painting Figures");
		this.setSize(350,350);
	
		this.e1 = new Ellipse(50,50,100,30,
							0, 250, 0  ,
						    10, 100, 30);
		this.e2 = new Ellipse(100,50,40,100,
							250, 50, 250  ,
							250, 10, 250);
		this.e3 = new Ellipse(200,50,180,20,
							100, 250, 0  ,
							10, 10, 30);						   
	}
	
	public void paint (Graphics g){
		super.paint(g);
		this.e1.paint(g);
		this.e2.paint(g);
		this.e3.paint(g);
	}
}

class Ellipse{
	int x, y;
	int w, h;
	int rC, gC, bC;
	int rF, gF, bF;
	Ellipse (int x, int y, int w, int h, int rC, int gC, int bC, int rF, int gF, int bF){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rC = rC; this.gC = gC; this.bC = bC; // cores RGB do conrtorno
		this.rF = rF; this.gF = gF; this.bF = bF; //cores RGB do fundo
	}
	

	void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(this.rC, this.gC, this.bC));
		g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
		g2d.setColor(new Color(this.rF, this.gF, this.bF));
		g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
	}

}

