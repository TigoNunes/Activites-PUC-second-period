import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class Serie{
    String nome;
    String formato;
    String duracao;
    String pais;
    String idioma;
    String emissora;
    String transmissao;
    int numEps;
    int numTemps;
    
    public Serie(){
        
    }

    public Serie(String data[]) {
        this.nome = data[0];
        this.formato = data[1];
        this.duracao = data[2];
        this.pais = data[3];
        this.idioma = data[4];
        this.emissora = data[5];
        this.transmissao = data[6];
        this.numTemps = Integer.parseInt(data[7]);
        this.numEps = Integer.parseInt(data[8]);
    }

    public Serie clone(){
        Serie resp = new Serie();
        resp.nome = this.nome;
        resp.formato = this.formato;
        resp.duracao = this.duracao;
        resp.pais = this.pais;
        resp.idioma = this.idioma;
        resp.emissora = this.emissora;
        resp.transmissao = this.transmissao;
        resp.numTemps = this.numTemps;
        resp.numEps = this.numEps;

        return resp;
    }

    //Metodos get
    
    public String getName() {
        return nome;
    }

    public String getFormat() {
        return formato;
    }

    public String getDuration() {
        return duracao;
    }

    public String getInitialCountry() {
        return pais;
    }

    public String getBroadcasterInitial() {
        return emissora;
    }

    public int getNumberSeasons() {
        return numTemps;
    }

    public int getNumberEpisodes() {
        return numEps;
    }


    public void setName(String name) {
        this.nome = name;
    }

    public void setFormat(String format) {
        this.formato = format;
    }

    public void setDuration(String duration) {
        this.duracao = duration;
    }

    public void setInitialCountry(String initialCountry) {
        this.pais = initialCountry;
    }

    public void setBroadcasterInitial(String broadcasterInitial) {
        this.emissora = broadcasterInitial;
    }

    public void setNumberSeasons(int numberSeasons) {
        this.numTemps = numberSeasons;
    }

    public void setNumberEpisodes(int numberEpisodes) {
        this.numEps = numberEpisodes;
    }
    
    //Para conseguir o nome da serie, retira os caracteres nao desejados e o .html
    String removeHtml(String line){
        String[] newLine = line.split("/");
        String resp = newLine[newLine.length - 1];
        resp = resp.replace(".html", "").replaceAll("_", " ");
        return resp;
    }

    //Para garantir a informacao, remove as tags e os caracteres indesejados
    public String removeTags(String line) {
        String newLine = "";
        int i = 0;
        while (i < line.length()) {
            if (line.charAt(i) == '<') {
                i++;
                while (line.charAt(i) != '>')
                    i++;
            } else {
                newLine += line.charAt(i);
            }
            i++;
        }
        while (newLine.contains("&") && newLine.contains(";"))
            newLine = newLine.split(";")[1];

        return newLine;
    }
        
    
    public void read(String arquivo) throws Exception{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(arquivo));
        BufferedReader br = new BufferedReader(isr);

        this.nome = removeHtml(arquivo);

        while(!br.readLine().contains("Formato"));
        this.formato = removeTags(br.readLine());
        
        while(!br.readLine().contains("Duração"));
        this.duracao = removeTags(br.readLine());

        while(!br.readLine().contains("País de origem"));
        this.pais = removeTags(br.readLine());

        while(!br.readLine().contains("Idioma original"));
        this.idioma = removeTags(br.readLine());

        while(!br.readLine().contains("Emissora de televisão original"));
        this.emissora = removeTags(br.readLine());
        
        while(!br.readLine().contains("Transmissão original"));
        this.transmissao = removeTags(br.readLine());
        this.transmissao = this.transmissao.contains("&#160;")?this.transmissao.replace("&#160;", ""):this.transmissao;

        while(!br.readLine().contains("N.º de temporadas"));
        this.numTemps = Integer.parseInt(removeTags(br.readLine()).split(" ")[0]);

        while(!br.readLine().contains("N.º de episódios"));
        this.numEps = Integer.parseInt(removeTags(br.readLine()).split(" ")[0]);

        //System.out.println(this.nome + ' ' + this.formato + ' ' + this.duracao + ' ' + this.pais + ' ' + this.idioma + ' ' + this.emissora + ' ' + this.transmissao + ' ' + this.numTemps + ' ' + this.numEps);

        br.close();
    }

    public void print(){
        String out = this.nome + ' ' + this.formato + ' ' + this.duracao + ' ' + this.pais + ' ' + this.idioma + ' ' + this.emissora + ' ' + this.transmissao + ' ' + this.numTemps + ' ' + this.numEps;
        out = out.replaceAll("  ", " ");
        System.out.println(out);
    }
}


public class TP02Q03 {

    public static boolean isFim(String veri) {
        if(veri.length()  == 3 && veri.charAt(0) == 'F' && veri.charAt(1) == 'I' && veri.charAt(2) == 'M'){
            return true;
        }
        return false;
    }

    public static String verifySearch(String search,String name[], int numSearchs){
        for (int i = 0; i < numSearchs; i++) {
            if (search.equals(name[i])) {
                return "SIM";
            }
        }
        return "NÃO";

    }

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        Serie serie = new Serie();
        String[] code = new String[1000];
        String[] name = new String[1000];
        String[] search = new String[1000];
        int numCodes = 0; 
        int numSearchs = 0;
        do {
            code[numCodes] = entry.nextLine();
        } while(isFim(code[numCodes++]) == false);

        numCodes--;

        String fielPath;

        for(int i = 0; i < numCodes; i++){
            try {
                fielPath = "/tmp/series/" + code[i];
                // System.out.println(code[i] + ":\n");
                serie.read(fielPath);
                name[i] = serie.getName();
            } catch (Exception e) {
                
            }
        }

        do {
            search[numSearchs] = entry.nextLine();
        } while(isFim(search[numSearchs++]) == false);

        numSearchs--;

        for (int i = 0; i < numSearchs; i++) {
            System.out.println(verifySearch(search[i],name, numSearchs));
        }

        entry.close();
    }
    
}