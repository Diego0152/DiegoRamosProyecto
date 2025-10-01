#include <stdio.h>
#include <unistd.h>

int main() {
    printf("Soy el padre, por cojones y generaré 8 procesos en forma de árbol binario \n");
    fork(); //P0 o P1
    /**
    * 
    */
    fork(); //P0 - P2 . P1 - P5
    /**
    *
    */
    fork(); //P0 - P3 . P2 - P4 | P1 - P6 . P5 - P7 
    /**
    * 
    */
    printf("Soy padre o un hijo?? \n");
    return 0;
}