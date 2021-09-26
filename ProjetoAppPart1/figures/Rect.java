package figures;

import java.awt.*;

public class Rect extends Figure{
	int largura, altura;
    Color cor2;
    public Rect(int x, int y, int l, int a, Color cor1,Color cor2) {
        super(x, y, cor1);
		this.cor2 = cor2;
        this.largura = l;
        this.altura = a;
    }
   
    public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(cor1);
		g2d.fillRect(x, y, largura, altura);  
		g2d.setColor(cor2);
		g2d.drawRect(x, y, largura, altura);

    }
}