import java.util.*;

public class Guia2Q6 {
    public static String decialPraHex(int dec) {
        String[] str = new String[2];
        str[0] = "0123456789ABCDEF";
        str[1] = "";
        int div;
        
        while (dec > 0) {
            div = dec % 16;
            str[1]+= str[0].charAt(div);
            dec/=16;
        }
        return str[1];
    }

    public static void main(String[] args) {
        Scanner foo = new Scanner(System.in);
        int n;

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite um inteiro\n>> ");
            n = foo.nextInt();
            System.out.println(decialPraHex(n));
        }
        foo.close();
    }
}
