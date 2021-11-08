package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {
	
    public Ellipse(int x, int y, int w, int h, Color cor1, Color cor2) {
		super(x,y,w,h,cor1,cor2);
    }
   
	public void paint(Graphics g,boolean focus) {
		Graphics2D g2d = (Graphics2D) g;
		if(focus == false){		
			g2d.setColor(cor1);
			g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
			g2d.setColor(cor2);
			g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
		}
		else{
			 g2d.setPaint(Color.red);
			 g2d.drawRect(this.x-2, this.y-2, this.w+4,this.h+4);							
             g2d.setPaint(Color.black);
		}
    }
}


