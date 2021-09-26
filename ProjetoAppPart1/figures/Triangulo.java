package figures;

import java.awt.*;


public class Triangulo extends Figure{
	int x2,y2;
	int x3,y3;
	Color cor2;
	public Triangulo(int x, int y, int x2, int y2, int x3, int y3, Color cor1,Color cor2) {
		super(x, y, cor1);
		this.cor2 = cor2;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(cor1);
		int xPoints[] = {x, x2, x3};
		int yPoints[] = {y, y2, y3};
		g2d.fillPolygon(xPoints, yPoints, 3);
		g2d.setColor(cor2);
		
		g2d.drawPolygon(xPoints, yPoints, 3);
	}

	
	public void contains(int x, int y) {
		int xPoints[] = {x, x2, x3};
		int yPoints[] = {y, y2, y3};
		Polygon p = new Polygon(xPoints, yPoints, 3);
	}
	
}