import java.util.Scanner;
public class TP01Q15 {

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String somenteVogais(String frase, int cont) {
        if (cont < frase.length()) {
            if (frase.charAt(cont) != 'a' && frase.charAt(cont) != 'e' && frase.charAt(cont) != 'i' && frase.charAt(cont) != 'o' && frase.charAt(cont) != 'u' && 
                frase.charAt(cont) != 'A' && frase.charAt(cont) != 'E' && frase.charAt(cont) != 'I' && frase.charAt(cont) != 'O' && frase.charAt(cont) != 'U') {
                return "NAO";
            }else{
                return somenteVogais(frase, cont + 1);
            }
        } else {
            return "SIM";
        }
    }

    public static String somenteConsoaten(String frase, int cont) {
        if (cont < frase.length()) {
            if (frase.charAt(cont) == 'a' || frase.charAt(cont) == 'e' || frase.charAt(cont) == 'i' || frase.charAt(cont) == 'o' || frase.charAt(cont) == 'u' || 
            frase.charAt(cont) == 'A' || frase.charAt(cont) == 'E' || frase.charAt(cont) == 'I' || frase.charAt(cont) == 'O' || frase.charAt(cont) == 'U' ||
            (frase.charAt(cont) < 'a' && frase.charAt(cont) > 'Z') || frase.charAt(cont) < 'A' || frase.charAt(cont) > 'z') { // esse trecho é para evitar números ou outros caracteres
                return "NAO";
            }else{
                return somenteConsoaten(frase, cont + 1);
            }
        } else {
            return "SIM";
        }
    }

    public static String somenteNumeroInteiro(String frase, int cont) {
        if (cont < frase.length()) {
            if (frase.charAt(cont) - 48 < 0 || frase.charAt(cont) - 48 > 9) { 
                return "NAO";
            }else{
                return somenteNumeroInteiro(frase, cont + 1);
            }
        } else {
            return "SIM";
        }
    }

    public static String somenteNumeroReal(String frase, int cont) {
        float teste;
        String veri;
        if(cont < frase.length()){
            teste =frase.charAt(cont) - 48;
            veri = ((Object)teste).getClass().getSimpleName();
            if(teste >= 0 && teste <= 9 )    
                if(veri != "Integer")
                    return "SIM";
            
        }else{
            return somenteNumeroReal(frase, cont + 1);
        }

        return "NAO";
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
            System.out.println(somenteVogais(frases[i], 0) + " " + somenteConsoaten(frases[i], 0) + " " + somenteNumeroInteiro(frases[i], 0) + " " + somenteNumeroReal(frases[i], 0));
        }

        entrada.close();
    }
    
}