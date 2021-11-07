import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import figures.*;
import ivisible.*;

class ProjetoApp{
	public static void main (String[] args){
		ProjetoFrame frame = new ProjetoFrame();
		frame.setVisible(true);
	}
	
}

class ProjetoFrame extends JFrame{
	private ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
	Figure focus = null;
	Point pontaMouse = null;
    private int x,y, w,h;

	public ProjetoFrame (){
		this.addWindowListener(
			new WindowAdapter(){
				public void windowClosing (WindowEvent e){
					System.exit(0);
				}
			}
		);
		
		this.addKeyListener(
			new KeyAdapter(){
				public void keyPressed (KeyEvent evt) {
					
					//INICIO CORES
					if(focus != null){
						if(evt.getKeyChar() == '6'){
							focus.cor1 =  Color.decode("#800080");
						}
						else if(evt.getKeyChar() == '5') {	
							focus.cor1 = Color.decode("#800000");
						}
						else if(evt.getKeyChar() == '4') {	
							focus.cor1 = Color.decode("#ffff00");

						}
						else if(evt.getKeyChar() == '3') {	
							focus.cor2 = Color.decode("#800080");
						}
						else if(evt.getKeyChar() == '2') {	
							focus.cor2 = Color.decode("#800000");
						}
						else if(evt.getKeyChar() == '1') {	
							focus.cor2 = Color.decode("#ffff00");
						}	
					}
					//FIM CORES*/
					
					//Determinar a criação das figuras tomando a ponta do mouse como referencia
					pontaMouse = getMousePosition();
					int x = pontaMouse.x;
					int y = pontaMouse.y;
					int w = 80;
					int h = 50;					
					//Inicio Eventos teclado
					if(evt.getKeyChar() == 'r') {	
                        figs.add(new Rect(x,y,w,h,Color.black,Color.white));
						focus=figs.get(figs.size() - 1);
					}
					else if(evt.getKeyChar() == 'e') {	
                        figs.add(new Ellipse(x,y,w,h,Color.black,Color.white));
						focus=figs.get(figs.size() - 1);
					}
					else if(evt.getKeyChar() == 'p') {		
						figs.add(new Pentagono(x,y,w,h,Color.black,Color.white));
						focus=figs.get(figs.size() - 1);
					}					
					else if(evt.getKeyChar() == 't') {	
						figs.add(new Triangulo(x,y,w,h,Color.black,Color.white));
						focus=figs.get(figs.size() - 1);
					}	
					//Inicia propriedade de aumento ou diminuição da figura foco
					if(evt.getKeyChar() == '+') {		
						if (focus != null){
							focus.w = focus.w + 10;
							focus.h = focus.h + 10;
						}
					}					
					else if(evt.getKeyChar() == '-') {		
						if(focus != null && (focus.w > 40 || focus.h > 40)){
							focus.w = focus.w - 10;
							focus.h = focus.h - 10;
						}
						
					}					
					
					//Inicia propriedade de movimentar a figura foco com as setas
					if(evt.getKeyCode() == 37){
						if (focus != null){
							focus.x-=10;
						}
                    }
                    else if(evt.getKeyCode() == 38){
						if (focus != null){
							focus.y-=10;
						}
                    }
                    else if(evt.getKeyCode() == 39){
						if (focus != null){
							focus.x+=10;
						}
                    }
                    else if(evt.getKeyCode() == 40){
						if (focus != null){
							focus.y+=10;
						}
                    }
					//Deleta a figura
					if(figs.size() != 0){
						if(evt.getKeyChar() == 'd') {	
							if(figs.size() != 0){						
								figs.remove(focus);
								repaint();
							}
						}
					}
					//Limpar o focus
					if(evt.getKeyChar() == 'c') {	
                        figs.add(focus);
						figs.remove(focus);
						focus = null;
					}
					//Muda o focus de figura
					if (evt.getKeyCode() == 10){
						
                        for( Figure fig: figs){
                            if ((focus == null) || (focus!=null)){
                                focus=fig;
								figs.add(focus);
								figs.remove(focus);
								repaint();
                                break;
                            }
							repaint();						
                        }
					}				
					//Fim Eventos teclado
					repaint();
				}
			}
		);				
		
		this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
					focus = null;
					int x = evt.getX();
					int y = evt.getY();
						
					for (Figure fig: figs){
						if (fig.clicked(x, y)){
							focus = fig;
							figs.remove(fig);
							figs.add(fig);
							repaint();
							break;
						}
						else{
							focus = null;
							repaint();
						}
					}
				} 
            }
			);	
			this.addMouseMotionListener(
			new MouseMotionAdapter(){
				public void mouseDragged (MouseEvent evt) {
					for (Figure fig: figs){
						if (focus == fig) { 
							focus.x = evt.getX() - focus.w/2;
							focus.y = evt.getY() - focus.h/2;
							repaint();								
						}
					}
				}				
			}
			);
		this.setTitle("Projeto App");
		this.setSize(550,550);	
		this.getContentPane().setBackground(Color.BLACK);		
	}
	
	public void paint (Graphics g){
		super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);	
			
            if (fig ==  focus){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(Color.red);
				g2d.drawRect(fig.x-2, fig.y-2, fig.w+4,fig.h+4);							
                g2d.setPaint(Color.black);
             }
        }
    }
		
	
}
