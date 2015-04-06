//
// Created by rafael on 01/04/15.
//
#include <string.h>
#include <stdio.h>
#include <stdlib.h>



int readFile(FILE * fp, char * str);

int main() {
    FILE * output;
    char field_aux[40];
    int aux;

    if ((output = fopen("texto.txt", "r+")) == NULL) {
        printf("Meça as tentativa de abrir seus arquivos Parça!");
        exit(1);
    }


    do{
        aux = menuOption();
        menuSwicth(output, aux);
    }while(aux != 3);

}

int menuOption(){
    int aux;

    printf("Arquivo texto opções:\n");
    printf(" 1- Busca\n 2- Escrita\n 3- Sair\n");
    printf("Escolha:");
    scanf("%i", &aux);
    getchar();

    return aux;
}

void menuSwicth(FILE *fp, int aux){
    char x='f';
    switch (aux){
        case 1:
            buscaArquivo(fp);
            break;
        case 2:
            escreveArquivo(fp);
            break;
        case 3:
            printf("Fim de execução");
            break;
        default:
            printf("Opção invalida");
    }
}

void buscaArquivo(FILE *fp){
    int aux;
    char search_field[40], field_aux[40];

    rewind(fp);
    printf("Digite a pesquisa:");
    gets(search_field);

    aux = fgetc(fp);
    int count = 0;
    int input_length = 0;
    int flag = 0;
    while(aux != EOF){
        while(aux == '0' || aux == '|'){
            if(count==3){count=0;}
            aux = fgetc(fp);
            count++;
        }
        input_length = 0;
        while(count<3){
            if(count==1){
                input_length = 10 * (aux-'0');
                aux = fgetc(fp);
            }else if(count == 2){
                input_length += (aux-'0');
            }
            count++;
        }
        fgets(field_aux, input_length+1, fp);
        if(strcmp(field_aux,search_field) == 0){
            printf("Achou ");
            puts(field_aux);
            flag =1;
            break;
        }
        count=0;
        aux = fgetc(fp);
    }
    if(flag == 0){
        printf("Não achou ");
        puts(search_field);
    }
}

void escreveArquivo(FILE *fp){
    fseek(fp, 0, SEEK_END);
    char a = fgetc(fp);
    char first[30], last[30], address[40], city[30], state[30], zip[10];
    int aux;
    do{
        printf("Digite o nome:");
        gets(first);
        printf("Digite o sobrenome:");
        gets(last);
        printf("Digite o endereço:");
        gets(address);
        printf("Digite a cidade:");
        gets(city);
        printf("Digite o estado:");
        gets(state);
        printf("Digite o CEP:");
        gets(zip);

        printf("Deseja salvar? [sim = 1 | não = 0]");
        scanf("%i", &aux);
        getchar();
        if(aux == 1){
            saveField(first, fp);
            saveField(last, fp);
            saveField(address, fp);
            saveField(city, fp);
            saveField(state, fp);
            saveField(zip, fp);
        }

        printf("Deseja continuar cadastrando? [sim = 1 | não = 0]");
        scanf("%i", &aux);

    } while(aux == 1);

}

void saveField(char* str, FILE * fp){
    char aux[3];
    int x = strlen(str);
    if(x < 10){
        sprintf(aux,"0%i", x);
    }else{
        sprintf(aux,"%i", strlen(str));
    }
    fputs("|", fp);
    fputs(aux, fp);
    fputs(str, fp);

}

