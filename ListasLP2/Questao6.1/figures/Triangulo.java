package figures;

import java.awt.*;

public class Triangulo extends Figure {
	
	int x1, y1; //Primeira vertice do triângulo
	int x2, y2; //Segunda vertice do triângulo
	int x3, y3; //Terceira vertice do triângulo
	
	

	public Triangulo (int x1, int y1, int x2, int y2, int x3, int y3,int rC, int gC, int bC){
		super(rC,gC,bC);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;

	}
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(this.rC, this.gC, this.bC));
		g2d.drawLine(this.x1,this.y1,this.x2,this.y2);
		g2d.drawLine(this.x2,this.y2,this.x3,this.y3);
		g2d.drawLine(this.x3,this.y3,this.x1,this.y1);

	}
}

