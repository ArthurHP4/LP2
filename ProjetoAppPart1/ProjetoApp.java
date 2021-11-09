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
import java.io.*;

class ProjetoApp{
	public static void main (String[] args){
		ProjetoFrame frame = new ProjetoFrame();
		frame.setVisible(true);
	}
	
}

@SuppressWarnings("unchecked")
class ProjetoFrame extends JFrame{
	private ArrayList<Figure> figs = new ArrayList<Figure>();
	private ArrayList<Button> buts = new ArrayList<Button>();

    Random rand = new Random();
	Figure focus = null;
	Point pontaMouse = null;
	Button buttonSelected = null;

    private int x,y, w,h;

	public ProjetoFrame (){
		buts.add(new Button(0, new Rect(0,0, 0,0, Color.GRAY,Color.LIGHT_GRAY)));
        buts.add(new Button(1, new Ellipse(0,0, 0,0, Color.GRAY, Color.LIGHT_GRAY)));
        buts.add(new Button(2, new Triangulo(0,0, 0,0,Color.GRAY, Color.LIGHT_GRAY)));
        buts.add(new Button(3, new Pentagono(0,0, 0, 0, Color.GRAY,Color.LIGHT_GRAY )));
		
		try {
            FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            this.figs = (ArrayList<Figure>) o.readObject();
            o.close();
        } catch (Exception x) {
            System.out.println("ERRO!!! <Em abrir o arquivo>");
        }
        

        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    try {
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    } catch (Exception x) {
                    }
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
					pontaMouse = evt.getPoint();
                    focus = null;
                    for (Figure fig: figs) {
                        if (fig.clicked(pontaMouse.x, pontaMouse.y)) {
                            focus = fig;
                        }
                    }
                    if (focus != null) {
                        figs.remove(focus);
                        figs.add(focus); 
                    }
                    repaint();
                    for (Button but: buts) {
                        if (but.clicked(pontaMouse.x, pontaMouse.y)) {
                            buttonSelected = but;
                        }
                    }
					
					if(pontaMouse.x > 70 || pontaMouse.y > 200){
						if ((focus == null) && (buttonSelected != null)){
								if (buttonSelected == buts.get(0)) {
									Figure fig = new Rect(pontaMouse.x,pontaMouse.y, 80,50,Color.black,Color.white); 																                                                    
									figs.add(fig); 
									focus = fig;
									buttonSelected = null;
								}
								else if (buttonSelected == buts.get(1)) {
									Figure fig = new Ellipse(pontaMouse.x,pontaMouse.y, 80,50,Color.black,Color.white); 
									figs.add(fig);
									focus = fig;
									buttonSelected = null;
								}
								else if (buttonSelected == buts.get(2)) {
									Figure fig = new Triangulo(pontaMouse.x,pontaMouse.y, 80,50,Color.black,Color.white);
									figs.add(fig); 
									focus = fig;
									buttonSelected = null;
								}
								else if (buttonSelected == buts.get(3)) {
									Figure fig = new Pentagono(pontaMouse.x,pontaMouse.y, 80,50, Color.black,Color.white);
									figs.add(fig); 
									focus = fig;
									buttonSelected = null;
								}
						}			
					}
					repaint();
				} 
            }
			);	
			
		this.addMouseMotionListener(
			new MouseMotionAdapter(){
				public void mouseDragged (MouseEvent evt) {
				if (focus != null) {
                        int dx = evt.getX() - pontaMouse.x;
                        int dy = evt.getY() - pontaMouse.y;
                        focus.drag(dx, dy);
                        repaint();
                    }
                    pontaMouse = evt.getPoint();				
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
            fig.paint(g,false);			
            if (fig ==  focus){
                Graphics2D g2d = (Graphics2D) g;
				fig.paint(g,true);	
             }
        }		
        for (Button but: this.buts) {
            but.paint(g,false);
			if (but ==  buttonSelected){
                Graphics2D g2d = (Graphics2D) g;
				but.paint(g,true);
             }
        }
    }
		
	
}
