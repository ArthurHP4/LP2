package figures;
import java.io.Serializable;
import java.awt.*;
import ivisible.IVisible;

public abstract class Figure implements IVisible, Serializable{ 
	public int x, y;
	public int w,h;
    public Color cor1;
	public Color cor2;
	public Figure (int x,int y,int w,int h,Color c1,Color c2) {
		this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;    
		cor1 = c1;
		cor2 = c2;

    }
    
    public void setColor(Color c1, Color c2) {
    	cor1 = c1;
		cor2 = c2;
    }
	
    public abstract void paint (Graphics g);   
	
    public void drag (int distanceX, int distanceY) {
        this.x += distanceX;
        this.y += distanceY;
    }
    
    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
}
