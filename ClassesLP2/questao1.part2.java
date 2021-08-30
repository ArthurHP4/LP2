public class TriangApp{
	public static void main (String [] args) {
		Triang t1 = new Triang(1,10, 10,10, 1,5);
		t1.print();
	}
}

class Triang{
	int x1, y1;
	int x2, y2;
	int x3, y3;
	Triang ( int x1, int y1, int x2, int y2, int x3, int y3){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}
	
	void print () {
		System.out.format("Triangulo de tamanho (%d,%d,%d) na posicao (%d,%d,%d).\n",
		this.y1,this.y2,this.y3,this.x1,this.x2,this.x3);
	}
}
