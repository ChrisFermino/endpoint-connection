import interfaces.Sensor;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class main {

    public static JFrame frame = new JFrame();

    public static void main(String[] args) throws IOException {
        frame.setBounds(100, 100, 1500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startLeituraSensores();
    }

    public static void startLeituraSensores() throws IOException {

        int ciclos = 0;
        int atualizasensores = 2;
        ManageFile manageFile = new ManageFile();

        LinkedList<Sensor> sensores = new LinkedList<>();

        while (true) {
            if (ciclos % atualizasensores == 0) {
                System.out.println("TESTE CICLOS" + " - " + ciclos);

                sensores = new LinkedList<>();

                FileReader f = new FileReader("./src/sensores.txt");
                BufferedReader br = new BufferedReader(f);

                String line;
                while ((line = br.readLine()) != null) {
                    String[] driversensor = line.split(":");
                    Sensor s = null;
                    try {
                        s = (Sensor) Class.forName(driversensor[2]).newInstance();
                    } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    s.setId(driversensor[0]);
                    s.setName(driversensor[1]);

                    sensores.add(s);
                    System.out.println(line);
                }
                f.close();
            }

            System.out.println("----Leitura dos sensores: ciclo " + ciclos + "----");
            frame.getContentPane().removeAll();
            Box sensoresPanel = Box.createHorizontalBox();

            for (Sensor s : sensores) {
                manageFile.WriteFile(s.toString());
                sensoresPanel.add(s.getPanel());
            }
            frame.setLayout(new BorderLayout());
            frame.getContentPane().add(sensoresPanel, BorderLayout.CENTER);
            frame.setVisible(true);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ciclos++;
        }
    }


}
