package figures;

import java.awt.*;

public class Rect extends Figure{
    public Rect(int x, int y, int w, int h, Color cor1, Color cor2) {
		super(x,y,w,h,cor1,cor2);
    }
   
    public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(cor1);
		g2d.fillRect(x, y, w, h);  
		g2d.setColor(cor2);
		g2d.drawRect(x, y, w, h);

    }
}
