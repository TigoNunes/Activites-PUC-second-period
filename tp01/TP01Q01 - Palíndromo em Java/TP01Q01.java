public class TP01Q01 {

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String inverteFrase(String a){
        String inverte = "";
        for(int i = a.length() - 1; i >= 0; i--){
            inverte = inverte + Character.toString(a.charAt(i));
        }

        return inverte;
    }

    public static void main(String[] args) {
        String[] frase = new String[1000];
        String[] fraseInvertida = new String[1000];
        int numFrase = 0;
        
        do{
            frase[numFrase] = MyIO.readLine();
            fraseInvertida[numFrase] = inverteFrase(frase[numFrase]);
        }while(isFim(frase[numFrase++]) == false);

        numFrase--;

        for (int i = 0; i < numFrase; i++) {
            if(frase[i].compareTo(fraseInvertida[i]) == 0){
                MyIO.println("SIM");
            } else{
                MyIO.println("NAO");
            }
        }
        
    }
}
