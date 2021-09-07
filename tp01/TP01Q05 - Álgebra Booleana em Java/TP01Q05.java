import java.util.Scanner;

public class TP01Q05 {

    public static boolean startZero(String frase){
        return (frase.charAt(0) == '0');
    }

    public static String trueOrNot(String frase){
        boolean trueFalse = Boolean.parseBoolean(frase);
        if (trueFalse == true) {
            return "SIM";
        } else {
            return "NAO";
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] frases = new String[1000];
        int numFrase = 0;

        do{
            frases[numFrase] = entrada.nextLine();

        }while(startZero(frases[numFrase++]) == false);

        numFrase--;

        for (int i = 0; i < numFrase; i++) {
            System.out.println(trueOrNot(frases[i]));
        }

        entrada.close();
    }

    
}