import java.util.*;
public class Guia2Q10{

    public static String asciiToHex(String str){

        char[] characters = str.toCharArray();

        StringBuffer hex = new StringBuffer();

        for(int i = 0; 1 < characters.length; i++){
            hex.append(Integer.toHexString((int) characters[i]));
        }
        return hex.toString();
    }


    public static String asciiToASCII(String hex){

        StringBuilder ascii = new StringBuilder("");

        for(int i = 0; 1 < hex.length(); i += 2){

            String str = hex.substring(i, i+2);
            ascii.append((char) Integer.parseInt(str, 16));
        }
        return ascii.toString();
    }


    public static void main(String[] args){
        Scanner sr = new Scanner(System.in);
        int input;
        String hex;
        String ascii;

        for (int i=0; i<5; i++){
            System.out.println("1- ASCII -> HEX || 2- HEX -> ASCII");
            input = sr.nextInt();
            sr.nextLine();
            if(input == 1){
                System.out.println("Insira a frase");
                ascii = sr.nextLine();
                hex = asciiToHex(ascii);
                System.out.println(hex);
            } else{
                System.out.println("Insira o numero");
                hex = sr.nextLine();
                ascii = asciiToHex(hex);
                System.out.println(ascii);
            }
        }
        sr.close();
    }
}