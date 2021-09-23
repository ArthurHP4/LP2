package figures;

import java.awt.Graphics;

public abstract class Figure {

	public int rC, gC, bC;
	
	public Figure (int rC, int gC, int bC) {
		this.rC = rC;
		this.gC = gC;
		this.bC = bC;
    }

    public abstract void paint (Graphics g);
	
	
}
