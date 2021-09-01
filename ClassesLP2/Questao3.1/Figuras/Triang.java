package figures;

import java.awt.*;

class Triangulo {
        int x1, y1; //Primeira vertice do triângulo
        int x2, y2; //Segunda vertice do triângulo
        int x3, y3; //Terceira vertice do triângulo
        String lado; //Classificação quanto aos lados do triangulo;
        Double d1, d2, d3; //Tamanho das retas, sendo d1 do ponto 1 ao 2, d2 do ponto 2 ao 3 e d3 do ponto 3 ao 1

        Triangulo (int x1, int y1, int x2, int y2, int x3, int y3){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;

            this.d1 = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
            this.d2 = Math.sqrt(((x3 - x2) * (x3 - x2)) + ((y3 - y2) * (y3 - y2)));
            this.d3 = Math.sqrt(((x1 - x3) * (x1 - x3)) + ((y1 - y3) * (y1 - y3)));
            if (d1 == d2 && d1 == d3){
                lado = "Equilatero";
            }
            else if (d1 == d2  d1 == d3  d2 == d3 ){
                lado = "Isóceles";
            }
            else{
                lado =  "Escaleno";
            }
                
            
            public void paint (Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawLine(this.x1,this.x2);
                g2d.drawLine(this.x2,this.x3); 
                g2d.drawLine(this.x3,this.x1);     
            }
        }
        
        
