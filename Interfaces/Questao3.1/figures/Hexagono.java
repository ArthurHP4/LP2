package figures;

import java.awt.*;

public class Pentagono extends Figure{
	public Pentagono(int x,int y,int w,int h,Color cor1,Color cor2){
		super(x,y,w,h,cor1,cor2);
	}
	public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x1[] = {this.x,this.x+20,this.x+40,this.x+30,this.x+10};
        int y1[] = {this.y,this.y-15,this.y,this.y+20,this.y+20};
        g2d.setColor(this.cor1);
        g2d.fillPolygon(x1, y1, 5); 
        g2d.setColor(this.cor2);
        g2d.drawPolygon(x1, y1, 5);
    }

}