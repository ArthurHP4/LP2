package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {	
	int largura, altura;
	Color cor2;
    public Ellipse(int x, int y, int l, int a, Color cor1, Color cor2) {
        super(x, y, cor1);
		this.cor2 = cor2;
        this.largura = l;
        this.altura = a;
    }
   
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(cor1);
		g2d.fill(new Ellipse2D.Double(this.x,this.y, this.largura,this.altura));
		g2d.setColor(cor2);
		g2d.draw(new Ellipse2D.Double(this.x,this.y, this.largura,this.altura));

    }
}


