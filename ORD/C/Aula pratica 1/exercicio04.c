//
// Created by rafael on 01/04/15.
//
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE * output;
    char buffer[500];
    short field_length;
    char aux;

    if ((output = fopen("texto.txt", "r+")) == NULL) {
        printf("Meça as tentativa de abrir seus arquivos Parça!");
        exit(1);
    }


    int i;
    do{
        fread(&field_length, 1, sizeof(field_length), output);
        for(i = 0; i < field_length; i++){
            aux = fgetc(output);
            if(aux == EOF){
                break;
            }else if (aux == '|'){
                printf("\n");
            }else{
                printf("%c", aux);
            }
        }
    } while(aux != EOF);
}
