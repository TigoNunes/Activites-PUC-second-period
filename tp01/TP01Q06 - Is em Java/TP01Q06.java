import java.util.Scanner;

public class TP01Q06 {

    public static String somenteVogais(String frase){

        for(int i = 0; i < frase.length(); i++){
            if (frase.charAt(i) != 'a' && frase.charAt(i) != 'e' && frase.charAt(i) != 'i' && frase.charAt(i) != 'o' && frase.charAt(i) != 'u' && 
            frase.charAt(i) != 'A' && frase.charAt(i) != 'E' && frase.charAt(i) != 'I' && frase.charAt(i) != 'O' && frase.charAt(i) != 'U') {

                return "NAO";
            }            
        }

        return "SIM";
    }

    public static String somenteConsoatens(String frase){

        for(int i = 0; i < frase.length(); i++){
            if (frase.charAt(i) == 'a' || frase.charAt(i) == 'e' || frase.charAt(i) == 'i' || frase.charAt(i) == 'o' || frase.charAt(i) == 'u' || 
            frase.charAt(i) == 'A' || frase.charAt(i) == 'E' || frase.charAt(i) == 'I' || frase.charAt(i) == 'O' || frase.charAt(i) == 'U' ||
            frase.charAt(i) < 'a' || frase.charAt(i) > 'z' || frase.charAt(i) < 'A' || frase.charAt(i) > 'Z') {
                
                return "NAO";
            }            
        }

        return "SIM";
    }

    public static String somenteNumeroInteiro(String frase) {
        int teste;
        for (int i = 0; i < frase.length(); i++) {
            teste =frase.charAt(i) - 48;
            if(teste < 0 || teste > 9)
                return "NAO";
        }

        return "SIM";
    }

    public static String somenteNumeroReal(String frase) {
        float teste;
        String veri;
        for (int i = 0; i < frase.length(); i++) {
            teste =frase.charAt(i) - 48;
            veri = ((Object)teste).getClass().getSimpleName();
            if(teste >= 0 && teste <= 9 )    
                if(veri != "Integer")
                    return "SIM";
        }

        return "NAO";
    }

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
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
            System.out.println(somenteVogais(frases[i]) + " " + somenteConsoatens(frases[i]) + " " + somenteNumeroInteiro(frases[i]) + " " + somenteNumeroReal(frases[i]));
        }

        entrada.close();
    }
    
}