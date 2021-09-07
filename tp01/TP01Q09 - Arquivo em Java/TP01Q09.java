import java.io.File;
import java.io.RandomAccessFile;

public class TP01Q09 {
   
    public static void main(String[] args) {
        int n = MyIO.readInt();

        try {
            //Criando um objeto do tipo File e chamando o construtor dele
            File arquivo = new File("arquivo.dat");

            //Verificando se o arquivo existe
            if (!arquivo.exists())
                arquivo.createNewFile();

            //Verificando se o arquivo consegue ser escrito
            if (!arquivo.canWrite())
                throw new Exception();

            //Criando um objeto do tipo RandomAccessFile e chamando o construtuor dele
            RandomAccessFile raf = new RandomAccessFile(arquivo, "rw");

            //Lendo a entrada padrao e a salvando no arquivo
            for (int i = 0; i < n; i++) {
                double numero = MyIO.readDouble();
                raf.writeDouble(numero);
            }

            //Fechando o arquivo
            raf.close();
        } catch (Exception e) {
            //Nenhum tratamento de excecao
        }

        //Lendo do arquivo
        try {
            //Criando um objeto do tipo File e chamando o construtor dele
            File arquivo = new File("arquivo.dat");

            //Verificando se o arquivo existe
            if (!arquivo.exists())
                throw new Exception();

            //Verificando se o arquivo consegue ser lido
            if (!arquivo.canRead())
                throw new Exception();

            //Criando um objeto do tipo RandomAccessFile e chamando o construtuor dele
            RandomAccessFile raf = new RandomAccessFile(arquivo, "r");

            //Imprimindo os dados do arquivo de ordem inversa na tela
            for (int i = 0; i < n; i++) {
                raf.seek((n - 1 - i) * 8);
                double numero = raf.readDouble();
                if (numero % 1 != 0)
                    MyIO.println(numero);
                else
                    MyIO.println((int) numero);

            }

            //Fechando o arquivo
            raf.close();

        } catch (Exception e) {
            //Nenhum tratamento de excecao
        }

    }
}