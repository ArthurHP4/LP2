package figures;

import java.awt.*;

public class Line extends Figure {
    public Line(int x, int y, int w,int h, Color cor1,Color cor2) {
		super(x,y,w,h,cor1,cor2);
		cor2 = cor1;
		cor1 = cor2;
    }
   
    public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(cor1);
        g2d.drawLine(x, y, w, h);
    }
  
}


