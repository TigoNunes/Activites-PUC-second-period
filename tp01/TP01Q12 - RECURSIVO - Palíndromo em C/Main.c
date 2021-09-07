#include <stdio.h>
#include <string.h>

int isFim(char frase[], int tam){
    if (tam == 3 && frase[0] == 'F' && frase[1] == 'I' && frase[2] == 'M')
    {
        return 1;
    }
    return 2;
}

int conferePal(char frase[], char inverte[], int tam){
    static int i = 0;
    if (i < tam)
    {
        if (frase[i] != inverte[i])
        {
            return 0;
        }else{
            i++;
            return conferePal(frase, inverte, tam);
        }
        
    }
    return 1;
    
    
}

int inverteFrase(char frase[], int tam){
    char inverte[tam];
    int k = tam - 1;

    for (int i = 0; i < tam; i++)
    {
        inverte[k--] = frase[i];
    }

    return conferePal(frase, inverte, tam);
}

void verificaPalindromo(char frase[], int tam){
    inverteFrase(frase, tam) == 1? printf("SIM\n"): printf("NAO\n");    
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
            verificaPalindromo(frases, cont);
        }
        
    } while (veri == 2);

    
    return 0;
}