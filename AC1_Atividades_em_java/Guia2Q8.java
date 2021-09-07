import java.util.*;

public class Guia2Q8 {
    public static int hexaPraDecimal(String entrada) {
        int dec = 0;
        String hexD = "0123456789ABCDEF", hex = entrada.toUpperCase();

        for (int i = 0; i < hex.length(); i++) {
            int num = hexD.indexOf(hex.charAt(i));
            dec = 16 * dec + num;
        }

        return dec;
    }

    public static void main(String[] args) {
        Scanner foo = new Scanner(System.in);
        String hex;

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite um numero hexadecimal\n>> ");
            hex = foo.nextLine();
            System.out.print(hexaPraDecimal(hex) + "\n");
        }

        foo.close();
    }
}
