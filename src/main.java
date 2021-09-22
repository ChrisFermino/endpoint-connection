import interfaces.Sensor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class main {

    public static void main(String[] args) throws IOException {

        int ciclos = 0;
        int atualizasensores = 10;
        ManageFile manageFile = new ManageFile();

        LinkedList<Sensor> sensores = new LinkedList<>();
        while (true) {
            if (ciclos % atualizasensores == 0) {
                System.out.println("TESTE CICLOS" + " - " + ciclos);

                sensores = new LinkedList<>();

                FileReader f = new FileReader("./src/sensores.txt");
                BufferedReader br = new BufferedReader(f);

                String line = null;
                while ((line = br.readLine()) != null) {
                    String dsensor[] = line.split(":");
                    Sensor s = null;
                    try {
                        s = (Sensor) Class.forName(dsensor[2]).newInstance();
                    } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    s.setId(dsensor[0]);
                    s.setName(dsensor[1]);

                    sensores.add(s);
                    System.out.println(line);
                }
                f.close();
            }

            System.out.println("----Leitura dos sensores: ciclo " + ciclos + "----");
            for (Sensor s : sensores) {
                manageFile.WriteFile(s.toString());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ciclos++;
        }

    }
}
