package sensores;

import com.sun.tools.javac.Main;
import interfaces.Sensor;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.util.Random;


public class SensorTaxaCambio extends JFrame implements Sensor{

    protected String id;
    protected String name;
    protected int updateInterval = 10;
    protected JSONObject json;

    private static final Random RND = new Random();

    private JPanel contentPane;
    private JTextField txtRecommendedbasefee;
    private JTextField txtCurrentbasefee;
    private JTextField txtSafelow;
    private JTextField txtFast_1;
    private JTextField txtStandard;
    private JTextField txtFastest;
    private JTextField txtCurrentBaseFee;
    private JTextField txtSuggestedMaxFee;
    private JTextField txtBaseFee;
    private JTextField txtFast;
    private JTextField txtFastestconfirmsIn;
    private JTextField txtSaveLow;
    private JTextField txtNormal;

    public SensorTaxaCambio() {
        this.request();
    }

    private void request() {
        try {
            URL url = new URL("https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=JPY&apikey=ZCKH058NVWR67WTW");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            con.setRequestProperty("Content-Type", "application/json");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            this.json = new JSONObject(content.toString());

            in.close();
            con.disconnect();

        }catch (IOException e) {
            System.out.println("Erro request SensorTaxaCambio");
        }
    }

    public JPanel getPanel() {

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 454, 279);
        panel.setLayout(null);

        txtRecommendedbasefee = new JTextField(this.getValue2());
        txtRecommendedbasefee.setBounds(235, 53, 209, 31);
        txtRecommendedbasefee.setHorizontalAlignment(JTextField.CENTER);
        panel.add(txtRecommendedbasefee);
        txtRecommendedbasefee.setColumns(10);

        txtCurrentbasefee = new JTextField();
        txtCurrentbasefee.setText(this.getValue().toString());
        txtCurrentbasefee.setColumns(10);
        txtCurrentbasefee.setBounds(10, 53, 209, 31);
        txtCurrentbasefee.setHorizontalAlignment(JTextField.CENTER);
        panel.add(txtCurrentbasefee);

        txtSafelow = new JTextField();
        txtSafelow.setText(this.getValue3());
        txtSafelow.setColumns(10);
        txtSafelow.setBounds(10, 118, 209, 31);
        txtSafelow.setHorizontalAlignment(JTextField.CENTER);
        panel.add(txtSafelow);

        txtFast_1 = new JTextField();
        txtFast_1.setText(this.getValue6());
        txtFast_1.setColumns(10);
        txtFast_1.setBounds(10, 190, 209, 31);
        txtFast_1.setHorizontalAlignment(JTextField.CENTER);
        panel.add(txtFast_1);

        txtStandard = new JTextField();
        txtStandard.setText(this.getValue4());
        txtStandard.setColumns(10);
        txtStandard.setBounds(235, 118, 209, 31);
        txtStandard.setHorizontalAlignment(JTextField.CENTER);
        panel.add(txtStandard);

        txtFastest = new JTextField();
        txtFastest.setText(this.getValue5());
        txtFastest.setColumns(10);
        txtFastest.setBounds(235, 190, 209, 31);
        txtFastest.setHorizontalAlignment(JTextField.CENTER);
        panel.add(txtFastest);

        txtCurrentBaseFee = new JTextField("Current base fee");
        txtCurrentBaseFee.setColumns(10);
        txtCurrentBaseFee.setBounds(10, 34, 209, 20);
        txtCurrentBaseFee.setHorizontalAlignment(JTextField.CENTER);
        panel.add(txtCurrentBaseFee);

        txtSuggestedMaxFee = new JTextField();
        txtSuggestedMaxFee.setText("Suggested max. fee");
        txtSuggestedMaxFee.setColumns(10);
        txtSuggestedMaxFee.setBounds(235, 34, 209, 20);
        txtSuggestedMaxFee.setHorizontalAlignment(JTextField.CENTER);
        panel.add(txtSuggestedMaxFee);

        txtBaseFee = new JTextField();
        txtBaseFee.setForeground(Color.BLACK);
        txtBaseFee.setText("Base fee");
        txtBaseFee.setBounds(184, 11, 86, 20);
        txtBaseFee.setHorizontalAlignment(JTextField.CENTER);
        panel.add(txtBaseFee);
        txtBaseFee.setColumns(10);

        txtFast = new JTextField();
        txtFast.setText("Fast (<1-2mins to confirm)");
        txtFast.setHorizontalAlignment(SwingConstants.CENTER);
        txtFast.setColumns(10);
        txtFast.setBounds(10, 171, 209, 20);
        panel.add(txtFast);

        txtFastestconfirmsIn = new JTextField();
        txtFastestconfirmsIn.setText("Fastest (Confirms in 1-2 blocks)");
        txtFastestconfirmsIn.setHorizontalAlignment(SwingConstants.CENTER);
        txtFastestconfirmsIn.setColumns(10);
        txtFastestconfirmsIn.setBounds(235, 171, 209, 20);
        panel.add(txtFastestconfirmsIn);

        txtSaveLow = new JTextField();
        txtSaveLow.setText("Save low (<30mins to confirm)");
        txtSaveLow.setHorizontalAlignment(SwingConstants.CENTER);
        txtSaveLow.setColumns(10);
        txtSaveLow.setBounds(10, 102, 209, 20);
        panel.add(txtSaveLow);

        txtNormal = new JTextField();
        txtNormal.setText("Normal (<5mins to confirm)");
        txtNormal.setHorizontalAlignment(SwingConstants.CENTER);
        txtNormal.setColumns(10);
        txtNormal.setBounds(235, 102, 209, 20);
        panel.add(txtNormal);

        return panel;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getValue(){
        int soma = RND.nextInt() % 5;
        double value = 0;
        if (soma < 3){
            value = Math.abs((value + RND.nextDouble()*10) % 101);
        } else {
            value = Math.abs((value - RND.nextDouble()*10) % 101);
        }
        return value;
    }

    @Override
    public String getValue2()  {
        return this.json.get("1. From_Currency Code").toString();
    }

    @Override
    public String getValue3()  {
        return this.json.get("3. To_Currency Code").toString();
    }

    @Override
    public String getValue4()  {
        return this.json.get("5. Exchange Rate").toString();
    }

    @Override
    public String getValue5()  {
        return this.json.get("6. Last Refreshed").toString();
    }

    @Override
    public String getValue6()  {
        return this.json.get("7. Time Zone").toString();
    }

    @Override
    public int getUpdateInterval() {
        return this.updateInterval;
    }

    @Override
    public String toString() {
        return "SensorTaxaCambio{" +
                "id='" + id + '\'' + ", name='" + name + '\'' + ", safelow" + getValue3() + '}';
    }
}
