//
// Created by rafael on 01/04/15.
//

#include <string.h>
#include <stdio.h>

#include <stdlib.h>

int readFile(FILE * fp, char * str);

int main() {
    FILE * output;
    char first[30], last[30], address[40], city[30], state[30], zip[10], field_aux[40];
    int aux;

    if ((output = fopen("texto.txt", "r+")) == NULL) {
        printf("Meça as tentativa de abrir seus arquivos Parça!");
        exit(1);
    }


    aux = readFile(output, &field_aux);

    while(aux > 0){
    printf("%s -- %i\n", field_aux, strlen(field_aux));
        aux = readFile(output, field_aux);
    }


}

int readFile(FILE *fp, char str[]) {
    int i = 0;
    char ch = fgetc(fp);

    while(ch != EOF && ch !='|'){
        str[i] = ch;
        i++;
        ch = fgetc(fp);
    }
    str[i] = '\0';

    return i;

}
