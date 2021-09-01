import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class PaintApp {
	public static void main (String[] args){
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
		
	}
}

class PaintFrame extends JFrame{
	Rect r1, r2, r3;
	
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
	
		this.r1 = new Rect(50,50,100,30,
							0, 250, 0  ,
						    10, 100, 30);
		this.r2 = new Rect(100,50,40,100,
							250, 50, 250  ,
							250, 10, 250);
		this.r3 = new Rect(200,50,180,20,
							100, 250, 0  ,
							10, 10, 30);						   
	}
	
	public void paint (Graphics g){
		super.paint(g);
		this.r1.paint(g);
		this.r2.paint(g);
		this.r3.paint(g);
	}
}

class Rect{
	int x, y;
	int w, h;
	int rC, gC, bC;
	int rF, gF, bF;
	Rect (int x, int y, int w, int h, int rC, int gC, int bC, int rF, int gF, int bF){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rC = rC; this.gC = gC; this.bC = bC; // cores RGB do contorno
		this.rF = rF; this.gF = gF; this.bF = bF; //cores RGB do fundo
	}
	
	
	void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(this.rC, this.gC, this.bC));
		g2d.drawRect(this.x,this.y,this.w,this.h);
		g2d.setColor(new Color(this.rF, this.gF, this.bF));
		g2d.fillRect(this.x,this.y,this.w,this.h);

	}

}
