#include <stdio.h>
#include <stdlib.h>

typedef struct{
	int x1, int y1;//Primeiro vertice de baixo do triangulo
	int x2, int y2;//Segundo vertice de baixo do triangulo
	int x3, int y3;// Vertice de cima do triangulo
	
} Triang;

void print(Triang* t){
	printf("O triangulo tem os lados de tamanho (%d,%d,%d) nas posiçoes (%d,%d,%d).\n",t->y1,t->y2,t->x3,t->x1,t->x2,t->y3);
}

void main (void){
	Triang t1 = { 1,10, 10,10, 5, 1};
	print(&t1);
}

