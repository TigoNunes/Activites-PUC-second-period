import java.util.Scanner;

public class TP01Q03 {

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    // public static String padronizandoUTF8(String fraseCrip){
    //     byte[] bytes = fraseCrip.getBytes(StandardCharsets.UTF_8);
    //     String padronizado = new String(bytes, StandardCharsets.UTF_8);
    //     // assertEquals()

    //     return padronizado;
    // }

    public static String criptografaFrase(String crip){ 
        String criptografia = "";
        for (int i = 0; i < crip.length(); i++) {
            criptografia +=  (char) (crip.charAt(i) + 3);   
        }

        return criptografia;
        //return padronizandoUTF8(criptografia);
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
            System.out.println(criptografaFrase(frases[i]));            
        }

        entrada.close();
    }
}