package figures;

import java.awt.*;

public class Line extends Figure {
	int a, l;
    public Line(int x, int y, int l,int a, Color cor1) {
        super(x, y, cor1);
		this.l = l;
		this.a = a;
    }
   
    public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(cor1);
        g2d.drawLine(x, y, l, a);
    }
  
}

