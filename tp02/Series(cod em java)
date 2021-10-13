import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.print.attribute.SetOfIntegerSyntax;

public class Series {

    private String name;
    private String format;
    private String duration;
    private String initialCountry;
    private String originalLang;
    private String broadcasterInitial;
    private String streamingInitial;
    private int numberSeasons;
    private int numberEpisodes;

    public Series() {

    }

    public Series(String data[]) {
        this.name = data[0];
        this.format = data[1];
        this.duration = data[2];
        this.initialCountry = data[3];
        this.originalLang = data[4];
        this.broadcasterInitial = data[5];
        this.streamingInitial = data[6];
        this.numberSeasons = Integer.parseInt(data[7]);
        this.numberEpisodes = Integer.parseInt(data[8]);
    }

    /** Getters */

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public String getDuration() {
        return duration;
    }

    public String getInitialCountry() {
        return initialCountry;
    }

    public String getBroadcasterInitial() {
        return broadcasterInitial;
    }

    public int getNumberSeasons() {
        return numberSeasons;
    }

    public int getNumberEpisodes() {
        return numberEpisodes;
    }

    /** Setters */

    public void setName(String name) {
        this.name = name;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setInitialCountry(String initialCountry) {
        this.initialCountry = initialCountry;
    }

    public void setBroadcasterInitial(String broadcasterInitial) {
        this.broadcasterInitial = broadcasterInitial;
    }

    public void setNumberSeasons(int numberSeasons) {
        this.numberSeasons = numberSeasons;
    }

    public void setNumberEpisodes(int numberEpisodes) {
        this.numberEpisodes = numberEpisodes;
    }

    /** Print in screen all data from class */
    public void print() {
        String out = this.name + ' ' + this.format + ' ' + this.duration + ' ' + this.initialCountry + ' '
                + this.originalLang + ' ' + this.broadcasterInitial + ' ' + this.streamingInitial + ' '
                + this.numberSeasons + ' ' + this.numberEpisodes;
        out = out.replaceAll("  ", " ");
        System.out.println(out);
    }

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

    public void readData(String fileName) throws Exception {
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

        String[] tmp = fileName.split("/");
        this.name = tmp[tmp.length - 1];
        this.name = this.name.replace(".html", "").replaceAll("_", " ");

        while (!reader.readLine().contains("Formato"))
            ;
        this.format = this.removeTags(reader.readLine());

        while (!reader.readLine().contains("Duração"))
            ;
        this.duration = this.removeTags(reader.readLine());

        while (!reader.readLine().contains("País de origem"))
            ;
        this.initialCountry = this.removeTags(reader.readLine());
        // if (this.initialCountry.contains(";"))
        // this.initialCountry = this.initialCountry.split(";")[0];

        while (!reader.readLine().contains("Idioma original"))
            ;
        this.originalLang = this.removeTags(reader.readLine());

        while (!reader.readLine().contains("Emissora de televisão original"))
            ;
        this.broadcasterInitial = this.removeTags(reader.readLine());

        while (!reader.readLine().contains("Transmissão original"))
            ;
        this.streamingInitial = this.removeTags(reader.readLine());
        if (this.streamingInitial.contains("&#160;"))
            this.streamingInitial.replace("&#160;", "");

        while (!reader.readLine().contains("temporadas"))
            ;
        this.numberSeasons = Integer.parseInt(this.removeTags(reader.readLine()).split(" ")[0]);

        while (!reader.readLine().contains("episódios"))
            ;
        this.numberEpisodes = Integer.parseInt(this.removeTags(reader.readLine()).split(" ")[0]);

        reader.close();
    }

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        String[] seriesList = new String[200];
        int count = 0;
        while (true) {
            String line = s.nextLine();

            if (line.equals("FIM"))
                break;

            seriesList[count] = line;
            count++;
        }

        Series serie = new Series();

        for (int i = 0; i < count; i++) {
            String file = seriesList[i];
            String filePath = "/tmp/series/" + file;
            serie.readData(filePath);
            serie.print();
        }
    }

}