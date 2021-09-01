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
	Rect r1;
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
		this.r1 = new Rect(50,50,100,30);
	}
	
	public void paint (Graphics g){
		super.paint(g);
		this.r1.paint(g);
		this.r1.drag(50,50);
	}
}

class Rect{
	int x, y;
	int w, h;
	
	Rect (int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	void print(){
		System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e area (%d). \n", 
		this.w,this.h,this.x, this.y,area());
	}
	void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(this.x,this.y,this.w,this.h);
	}
	
	int area(){
		int areaRect;
		areaRect = this.w * this.h;
		return areaRect;
	}	
	
	void drag(int dx, int dy){
	this.x = this.x + dx;
	this.y = this.y + dy;
	}
}
