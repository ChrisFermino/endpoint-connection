import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManageFile {

    public void CreateFile() {
        try {
            File myObj = new File("teste.txt");
            if (myObj.createNewFile()) {
                System.out.println("Arquivo criado: " + myObj.getName());
            } else {
                System.out.println("O arquivo já existe");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro na criação do arquivo");
            e.printStackTrace();
        }
    }

    public void WriteFile(String text) {
        try {
            FileWriter myWriter = new FileWriter("teste.txt", true);
            BufferedWriter info = new BufferedWriter(myWriter);
            info.write(text);
            info.newLine();
            info.close();
            System.out.println("Escreveu com sucesso no arquivo");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro na escrita em arquivo");
        }
    }
}
