import java.util.*;
public class Guia2Q2{

    public static String intToBinary(int n){
        String sus = "";
        while (n > 0) {
            sus = ((n % 2) == 0 ? "0" : "1") + sus; 
            n /= 2;
        }
        return sus;
    }
    

    public static void main(String[] args){
        Scanner sr = new Scanner(System.in);
        int n;
        String str;

        for (int i = 0; i < 5; i++){
            System.out.print("Entre com um número inteiro\n>> ");
            n = sr.nextInt();
            str = intToBinary(n);
            System.out.println(str);
        }

        sr.close();
    }
}
