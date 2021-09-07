import java.util.Scanner;
public class TP01Q13 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //Verifica se a variavel tam chegou ao valor da quantidade de caracteres da frase desejada, caso chegue retorna a criptografia.
    public static String criptografaFrase(String crip, int tam){ 
        String criptografia = "";        
        
        if (tam == crip.length()) {
            for (int i = 0; i < tam; i++) {
                criptografia += (char) (crip.charAt(i) +3);
            }
            return criptografia;
        } else {
            tam++;
            return criptografaFrase(crip, tam++);
        }
    }    
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] frases = new String[1000];
        int numFrase = 0;

        do{
            frases[numFrase] = entrada.nextLine();
        }while(isFim(frases[numFrase++]) == false);

        numFrase--;

        for (int i = 0; i < numFrase; i++) {
            System.out.println(criptografaFrase(frases[i], 0));            
        }

        entrada.close();
    }
}
