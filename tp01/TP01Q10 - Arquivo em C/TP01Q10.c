#include <stdio.h> 
#define boolean short
#define true 1
#define false 0

boolean ehNumero(char c)
{
    boolean ehNumeroSim=false;
    if(c>='0'&&c<='9')
        ehNumeroSim=true;
    return ehNumeroSim;
}

boolean ehPonto(char c)
{
    boolean ehPonto=false;
    if(c=='.')
        ehPonto=true;
    return ehPonto;
}

int main()
{
    //Obtendo a quantidade de numeros inteiros que serao lidos
    int n;
    scanf("%d",&n);

    //Criando um objeto do tipo FILE
    FILE *arquivo=fopen("arquivo.dat", "wb");

    //Gravando a entrada padrao no arquivo
    for(int i=0;i<n;i++)
    {
        double numero;
        scanf("%lf", &numero);
        fwrite(&numero, sizeof(double), 1, arquivo);
    }

    //Fechando o arquivo
    fclose (arquivo);

    //Reabrindo o arquivo
    arquivo=fopen("arquivo.dat", "rb");

    for(int i=0;i<n;i++)
    {
        double numero;
        fseek(arquivo,  (n-1-i)*8, SEEK_SET);
        fread(&numero, sizeof(double), 1, arquivo);
        int numeroInteiro;
        numeroInteiro=numero;
        if(numero-numeroInteiro!=0)
        {
            printf("%g\n", numero);
        }
        else
        {
            printf("%d\n", numeroInteiro);
        }
        
    }

    //Fechando o arquivo
    fclose(arquivo);
}