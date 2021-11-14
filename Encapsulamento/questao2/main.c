#include <stdlib.h>
#include "rect.h"

void main (void) {
    Rect* r1 = rect_new(30,30, 100,50);
    rect_print(r1);
    
    Rect* r2 = rect_new(30,30, 100,50);
    rect_drag(r2, 10, 100);
    rect_print(r2);
    
    free(r1);
    free(r2);
}