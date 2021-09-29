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

class ProjetoApp{
	public static void main (String[] args){
		ProjetoFrame frame = new ProjetoFrame();
		frame.setVisible(true);
	}
	
}

class ProjetoFrame extends JFrame{
	ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
	Figure focus = null;
	Point pontaMouse = null;

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
                        figs.add(new Rect(x,y,w,h,Color.white,Color.black));
					}
					else if(evt.getKeyChar() == 'e') {	
                        figs.add(new Ellipse(x,y,w,h,Color.white,Color.black));
					}
					else if(evt.getKeyChar() == 'l') {		
						figs.add(new Line(x,y,x+100,y+100,Color.white,Color.white));
					}					
					else if(evt.getKeyChar() == 't') {	
						figs.add(new Triangulo(x,y,w,h,Color.white,Color.black));
					}	
					//Inicia propriedade de aumento ou diminuição da figura foco
					if(evt.getKeyChar() == '+') {		
						focus.w = focus.w + 10;
						focus.h = focus.h + 10;
					}					
					else if(evt.getKeyChar() == '-') {		
						focus.w = focus.w - 10;
						focus.h = focus.h - 10;
					}					
					//Deleta a figura
					if(figs.size() != 0){
						if(evt.getKeyChar() == 'd') {	
							if(figs.size() != 0){						
								figs.remove(figs.size() - 1);
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
								focus.cor2 = Color.green;			
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
                    pontaMouse = getMousePosition();
					Color foc = Color.decode("#800000");
                    for (Figure fig: figs) {		
						if (fig.clicked(pontaMouse.x,pontaMouse.y)) {
							focus = fig;
							focus.cor2 = Color.green;
						}
						if(focus != null) {
							figs.add(focus);
							figs.remove(focus);	
						}
					}
				} 
            }
			);	
			this.addMouseMotionListener(
			new MouseMotionAdapter(){
				public void mouseDragged (MouseEvent evt) {
					pontaMouse = getMousePosition();
					if (focus != null) {  
						
                        figs.remove(focus);
						figs.add(focus);
						focus.x = pontaMouse.x - focus.w;
						focus.y = pontaMouse.y - focus.h;		
						repaint();				
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
        }
	}
}
