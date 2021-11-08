package figures;

import java.awt.*;
import ivisible.*;


public class Triangulo extends Figure{
	private int xPoints[], yPoints[];
	public Triangulo(int x, int y, int w, int h,Color cor1,Color cor2) {
		super(x,y,w,h,cor1,cor2);
	}

	public void paint(Graphics g,boolean focus) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		if (focus == false){			
			g2d.setColor(cor1);
			int xPoints[] = {this.x, ((this.w)/2) + (this.x), (this.w) + (this.x)};
			int yPoints[] = {this.y + h, (this.y + h) - (this.h), this.y + h};
			g2d.fillPolygon(xPoints, yPoints, 3);
			g2d.setColor(cor2);	
			g2d.drawPolygon(xPoints, yPoints, 3);
		}
		else{
			 g2d.setPaint(Color.red);
			 g2d.drawRect(this.x-2, this.y-2, this.w+4,this.h+4);							
             g2d.setPaint(Color.black);
		}
	}

}
