package figures;

import java.awt.*;


public class Rect extends Figure{
	int x,y;
	int w, h;
	int rF, gF, bF;

	public Rect (int x, int y, int w, int h, int rC, int gC, int bC, int rF, int gF, int bF){
		super(rC,gC,bC);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rF = rF; this.gF = gF; this.bF = bF; //cores RGB do fundo
		
	}
	
	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(this.rC, this.gC, this.bC));
		g2d.fillRect(this.x,this.y,this.w,this.h);
		g2d.setColor(new Color(this.rF, this.gF, this.bF));
		g2d.drawRect(this.x,this.y,this.w,this.h);

	}
}
