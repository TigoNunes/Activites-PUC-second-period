import java.net.URL;
import java.util.Scanner;   

public class TP01Q08 {

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isLink(String frase){
        try{
            URL url = new URL(frase);
            url.toURI();
            return true;
        } catch(Exception exception){
            return false;
        }
    }

    public static void printResult(String link) {
        String verifica;
        verifica = ExemploURL.getHtml(link);
        int a = 0, e = 0, i = 0, o = 0, u = 0, á = 0, é = 0, í = 0, ó = 0, ú = 0, à = 0, è = 0, ì = 0, ò = 0, ù = 0, ã = 0, õ = 0, â = 0, ê = 0, î = 0, ô = 0, û = 0, consoante = 0, br = 0, table = 0;

        for (int k = 0; k < verifica.length(); k++) {
            if(verifica.charAt(k) == 'a'){
                a++;
             } else if(verifica.charAt(k) == 'e'){
                e++;
            }else if(verifica.charAt(k) == 'i'){
                i++;
            }else if(verifica.charAt(k) == 'o'){
                o++;
            }else if(verifica.charAt(k) == 'u'){
                u++;
            }else if(verifica.charAt(k) == 'á'){
                á++;
            }else if(verifica.charAt(k) == 'é'){
                é++;
            }else if(verifica.charAt(k) == 'í'){
                í++;
            }else if(verifica.charAt(k) == 'ó'){
                ó++;
            }else if(verifica.charAt(k) == 'ú'){
                ú++;
            }else if(verifica.charAt(k) == 'à'){
                à++;
            }else if(verifica.charAt(k) == 'è'){
                è++;
            }else if(verifica.charAt(k) == 'ì'){
                ì++;
            }else if(verifica.charAt(k) == 'ò'){
                ò++;
            }else if(verifica.charAt(k) == 'ù'){
                ù++;
            }else if(verifica.charAt(k) == 'ã'){
                ã++;
            }else if(verifica.charAt(k) == 'õ'){
                õ++;
            }else if(verifica.charAt(k) == 'â'){
                â++;
            }else if(verifica.charAt(k) == 'ê'){
                ê++;
            }else if(verifica.charAt(k) == 'î'){
                î++;
            }else if(verifica.charAt(k) == 'ô'){
                ô++;
            }else if(verifica.charAt(k) == 'û'){
                û++;
            }else if(verifica.charAt(k) > 'a' && verifica.charAt(k) <= 'z'){
                consoante++;
            }else if(verifica.charAt(k) == '<' && verifica.charAt(k+1) == 'b' && verifica.charAt(k+2) == 'r' && verifica.charAt(k+3) == '>'){
                br++;
                k+=3;
            }else if(verifica.charAt(k) == '<' && verifica.charAt(k+1) == 't' && verifica.charAt(k+2) == 'a' && verifica.charAt(k+3) == 'b' && verifica.charAt(k+4) == 'l' && verifica.charAt(k+5) == 'e' && verifica.charAt(k+6) == '>'){
                table++;
                k+=6;
            }
        }

        System.out.println("a(" + a +") e(" + e +") i(" + i +") o(" + o +") u(" + u +") á(" +á +") é(" +é +") í(" +í +") ó(" +ó+") ú("+ú+") à("+à+") è("+è+") ì("+ì+") ò("+ò+") ù("+ù+") ã("+ã+") õ("+õ+") â("+â+") ê("+ê+") î("+î+") ô("+6+") û("+û+") consoante("+consoante+") <br>("+br+") <table>("+table+")");
    }

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        String[] frase = new String[1000];
        int numFrases = 0;
        
        do{

            frase[numFrases] = entrada.nextLine();

        }while(isFim(frase[numFrases++]) == false);

        numFrases--;

        for (int i = 0; i < numFrases; i++) {
            if (isLink(frase[i]) == true) {
                printResult(frase[i]);
            }
        }


        entrada.close();
    }
    
}