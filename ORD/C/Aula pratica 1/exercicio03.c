#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(){

    FILE * output;
    char field[40], buffer[500];
    int aux = 0;
    short field_length;

    if((output=fopen("texto.txt","w+")) == NULL){
        printf("Meça as tentativa de abrir seus arquivos Parça!");
        exit(1);
    }
    do{
        buffer[0]='\0';
        printf("Digite o nome:");
        gets(field);
        strcat(buffer, field);
        strcat(buffoB, "|");
        printf("Digite o sobrenome:");
        gets(field);
        strcat(buffer, field);
        strcat(buffer, "|");
        printf("Digite o endereço:");
        gets(field);
        strcat(buffer, field);
        strcat(buffer, "|");
        printf("Digite a cidade:");
        gets(field);
        strcat(buffer, field);
        strcat(buffer, "|");
        printf("Digite o estado:");
        gets(field);
        strcat(buffer, field);
        strcat(buffer, "|");
        printf("Digite o CEP:");
        gets(field);
        strcat(buffer, field);
        strcat(buffer, "|");

        printf("Deseja salvar? [sim = 1 | não = 0]");
        scanf("%i", &aux);
        getchar();
        if(aux == 1){
            puts(buffer);
            field_length = strlen(buffer);
            fwrite(&field_length, 1, sizeof(field_length), output);
            fwrite(buffer, 1, field_length, output);
        }

        printf("Deseja continuar cadastrando? [sim = 1 | não = 0]");
        scanf("%i", &aux);
        getchar();

    } while(aux == 1);

    fclose(output);
}
