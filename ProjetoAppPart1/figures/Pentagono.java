package figures;

import java.awt.*;

public class Pentagono extends Figure{
	private int x1[], y1[];
	public Pentagono(int x,int y,int w,int h,Color cor1,Color cor2){
		super(x,y,w,h,cor1,cor2);
		
	}
	public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x1[] = {this.x, this.x + this.w/2, this.x + this.w, this.x + (int)(this.w * 0.75), this.x + this.w/4};
        int y1[] = {this.y + this.h /2, this.y, this.y + this.h/2, this.y + this.h, this.y + this.h};

        g2d.setColor(cor1);
        g2d.fillPolygon(x1, y1, 5); 
        g2d.setColor(cor2);
        g2d.drawPolygon(x1, y1, 5);
    }

}
