package figures;

import java.awt.*;


public class Triangulo extends Figure{
	public Triangulo(int x, int y, int w, int h,Color cor1,Color cor2) {
		super(x,y,w,h,cor1,cor2);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(cor1);
		int xPoints[] = {this.x, ((this.w)/2) + (this.x), (this.w) + (this.x)};
        int yPoints[] = {this.y + h, (this.y + h) - (this.h), this.y + h};
		g2d.fillPolygon(xPoints, yPoints, 3);
		g2d.setColor(cor2);
		
		g2d.drawPolygon(xPoints, yPoints, 3);
	}

	
	
}