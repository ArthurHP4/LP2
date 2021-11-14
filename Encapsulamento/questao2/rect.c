#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int x, y;
    int width, height;
} Rect;

void rect_drag (Rect* this, int dx, int dy) {
	this->x += dx;
	this->y += dy;
}

float rect_area (Rect* this) {
    return (this->width * this->height);
}

void rect_print (Rect* this) {
    printf("Retangulo de tamanho (%d,%d) na nova posicao (%d,%d).\n", this->width, this->height, this->x, this->y);
    printf("Retangulo tem area (%.1f)\n\n", rect_area(this));
}

Rect* rect_new (int x, int y, int width, int height) {
    Rect* this = malloc(sizeof(Rect));
    this->x = x;
    this->y = y;
    this->width = width;
    this->height = height;
}
