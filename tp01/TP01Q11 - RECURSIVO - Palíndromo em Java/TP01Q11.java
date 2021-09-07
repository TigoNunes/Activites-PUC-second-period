import java.util.Scanner;

public class TP01Q11 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String inverteFrase(String frase, int tamanhoFrase) {
        String invertido = "";
        if ((tamanhoFrase + 1) == frase.length()) {

            for(int i = tamanhoFrase; i >= 0; i--){
                invertido = invertido + Character.valueOf(frase.charAt(i));
            }
            return invertido;
        } else {
            return inverteFrase(frase, tamanhoFrase + 1);
        }
        
    }
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] frase = new String[1000];
        String[] fraseInvertida = new String[1000];
        int numFrase = 0;
        
        do{
            frase[numFrase] = entrada.nextLine();
            fraseInvertida[numFrase] = inverteFrase(frase[numFrase], 0);
        }while(isFim(frase[numFrase++]) == false);

        numFrase--;

        for (int i = 0; i < numFrase; i++) {
            // System.out.println(fraseInvertida[i] + " " + fraseInvertida[i].length());

            if(frase[i].compareTo(fraseInvertida[i]) == 0){
                MyIO.println("SIM");
            } else{
                MyIO.println("NAO");
            }
        }

        entrada.close();
    }
}
