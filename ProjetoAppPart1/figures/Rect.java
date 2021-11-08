package figures;

import java.awt.*;

public class Rect extends Figure{
    public Rect(int x, int y, int w, int h, Color cor1, Color cor2) {
		super(x,y,w,h,cor1,cor2);
    }
   
    public void paint(Graphics g,boolean focus) {
		Graphics2D g2d = (Graphics2D) g;
		if(focus == false){
			g2d.setColor(cor1);
			g2d.fillRect(x, y, w, h);  
			g2d.setColor(cor2);
			g2d.drawRect(x, y, w, h);
		}
		else{
			 g2d.setPaint(Color.red);
			 g2d.drawRect(this.x-2, this.y-2, this.w+4,this.h+4);							
             g2d.setPaint(Color.black);
		}
    }
}
