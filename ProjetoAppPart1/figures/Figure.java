package figures;

import java.awt.*;

public abstract class Figure { 
	int x, y;
    Color cor1;
	
	public Figure (int x, int y, Color c1) {
		this.x = x;
        this.y = y;       
		cor1 = c1;

    }
    
    public void setColor(Color c1) {
    	cor1 = c1;
    }
	
    public abstract void paint (Graphics g);   
}