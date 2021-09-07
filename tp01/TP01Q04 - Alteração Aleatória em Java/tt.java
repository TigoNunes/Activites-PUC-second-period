import java.util.Random;

public class tt {
    public static void main(String[] args) {
        Random x = new Random();
        x.setSeed(4);
        int i = x.nextInt(11);

        System.out.println(i);
    }
}
