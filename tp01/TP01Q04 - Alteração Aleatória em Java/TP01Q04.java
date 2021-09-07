import java.util.Random;

public class TP01Q04 {   

    public static String alteracaoAleatoria(Random aleatorio, String s) {
        char substituir = (char) ('a' + (Math.abs(aleatorio.nextInt()) % 26));
        char subistituto = (char) ('a' + (Math.abs(aleatorio.nextInt()) % 26));
        String novaString = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == substituir)
                novaString += subistituto;
            else
                novaString += s.charAt(i);
        }
        return novaString;
    }

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        Random aleatorio = new Random();
        aleatorio.setSeed(4);
        String[] frase = new String[1000];
        int numFrase = 0;
        do{
            frase[numFrase] = MyIO.readLine();
        }while(isFim(frase[numFrase++]) == false);

        numFrase--;

        for (int i = 0; i < numFrase; i++) {
           MyIO.println(alteracaoAleatoria(aleatorio, frase[i]));
        }
    }
}