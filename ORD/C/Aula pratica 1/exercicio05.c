//
// Created by rafael on 01/04/15.
//

#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int readFile(FILE * fp, char * str);

int main() {
    FILE * output;
    char first[30], last[30], address[40], city[30], state[30], zip[10], field_aux[40], search_field[40];
    int aux;

    if ((output = fopen("texto.txt", "r+")) == NULL) {
        printf("Meça as tentativa de abrir seus arquivos Parça!");
        exit(1);
    }
    printf("Digite a pesquisa:");
    gets(search_field);

    aux = fgetc(output);
    int count = 0;
    int input_length = 0;
    while(aux != EOF){
        while(aux == '0' || aux == '|'){
            if(count==3){count=0;}
            aux = fgetc(output);
            count++;
        }
        input_length = 0;
        while(count<3){
            if(count==1){
                input_length = 10 * (aux-'0');
                aux = fgetc(output);
            }else if(count == 2){
                input_length += (aux-'0');
            }
            count++;
        }
        fgets(field_aux, input_length+1, output);
        if(strcmp(field_aux,search_field) == 0){
            puts(field_aux);
            break;
        }
        count=0;
        aux = fgetc(output);
    }
}
