#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int isFim(char frase[], int tam){
    if (tam == 3 && frase[0] == 'F' && frase[1] == 'I' && frase[2] == 'M')
    {
        return 1;
    }
    return 2;
}

int  onlyVogal(char frase[],int tam){
    for (int i = 0; i < tam; i++)
    {
        if (frase[i] != 'a' && frase[i] != 'e' && frase[i] != 'i' && frase[i] != 'o' && frase[i] != 'u' && 
            frase[i] != 'A' && frase[i] != 'E' && frase[i] != 'I' && frase[i] != 'O' && frase[i] != 'U'){
            return 0;
        }
        
    }
    return 1;    
}

int  onlyConsoante(char frase[],int tam){
    for (int i = 0; i < tam; i++)
    {
        if (frase[i] == 'a' || frase[i] == 'e' || frase[i] == 'i' || frase[i] == 'o' || frase[i] == 'u' || 
            frase[i] == 'A' || frase[i] == 'E' || frase[i] == 'I' || frase[i] == 'O' || frase[i] == 'U' ||
            frase[i] < 'A' || frase[i] > 'z'){
            return 0;
        }
        
    }
    return 1;    
}

int  onlyInt(char frase[],int tam){
    int teste;
    for (int i = 0; i < tam; i++)
    {
        teste = frase[i] - 48;
        if(teste < 0 || teste > 9)
            return 0;
    }
    return 1;
      
}

int  onlyReal(char frase[],int tam){
    bool result = false;
    int counter = 0;


    for(int i = 0; i < tam - 1; i++){
        if(frase[i] > 47 && frase[i] < 58  || frase[i] == 46 || frase[i] == 44){
            if (frase[i] == 46 || frase[i] == 44){
                counter++;
            }
            result = true;
        }
        else{
            result = false;
            break;
        }
    }

    if (counter == 0)
        result = false;
    else if(counter > 1){
        result = false;
    }
    return result;    
      
}

void verificatipo(char frase[],int tam){
    onlyVogal(frase, tam) == 1? printf("SIM "): printf("NAO ");
    onlyConsoante(frase, tam) == 1? printf("SIM "): printf("NAO ");
    onlyInt(frase, tam) == 1? printf("SIM "): printf("NAO ");
    onlyReal(frase, tam) == true? printf("SIM\n"): printf("NAO\n");
}


int main(void){
    char frases[1000];
    int cont = 0;
    int veri;
    do
    {
        fgets(frases, sizeof(frases), stdin);
        cont = strlen(frases) - 1;
        veri = isFim(frases, cont);

        if (veri == 2)
        {
            verificatipo(frases, cont);
        }
        
    } while (veri == 2);

    return 0;
}