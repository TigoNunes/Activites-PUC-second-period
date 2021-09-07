import java.util.*;

public class Guia2Q4 {
    public static int binarioPraDecimal(String bin) {
        int dec = 0, base = 1;
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1') {
                dec += base;
            }
            base *= 2;
        }
        return dec;
    }
    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String binario;

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite um numero binario inteiro\n>> ");
            binario = leitor.nextLine();
            System.out.print(binarioPraDecimal(binario) + "\n");
        }
        leitor.close();
    }
}