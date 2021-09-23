package sensores;

import interfaces.Sensor;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SensorGas extends JFrame implements Sensor {

    protected String id;
    protected String name;
    protected JSONObject json;

    public SensorGas() {
        this.request();
    }

    private void request() {
        try {
            URL url = new URL("https://www.etherchain.org/api/gasPriceOracle");
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

        } catch (IOException e) {
            System.out.println("Erro request SensorGas");
        }
    }

    public JPanel getPanel() {

        JTextField txtRecommendedbasefee;
        JTextField txtCurrentbasefee;
        JTextField txtSafelow;
        JTextField txtFast_1;
        JTextField txtStandard;
        JTextField txtFastest;
        JTextField txtCurrentBaseFee;
        JTextField txtSuggestedMaxFee;
        JTextField txtBaseFee;
        JTextField txtFast;
        JTextField txtFastestconfirmsIn;
        JTextField txtSaveLow;
        JTextField txtNormal;

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 454, 279);
        panel.setLayout(null);

        txtRecommendedbasefee = new JTextField(this.getValue2());
        txtRecommendedbasefee.setBounds(235, 53, 209, 31);
        txtRecommendedbasefee.setHorizontalAlignment(JTextField.CENTER);
        panel.add(txtRecommendedbasefee);
        txtRecommendedbasefee.setColumns(10);

        txtCurrentbasefee = new JTextField();
        txtCurrentbasefee.setText(this.getValue());
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
        txtCurrentBaseFee.setBounds(10, 33, 209, 20);
        txtCurrentBaseFee.setHorizontalAlignment(JTextField.CENTER);
        panel.add(txtCurrentBaseFee);

        txtSuggestedMaxFee = new JTextField();
        txtSuggestedMaxFee.setText("Suggested max. fee");
        txtSuggestedMaxFee.setColumns(10);
        txtSuggestedMaxFee.setBounds(235, 33, 209, 20);
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
        txtFast.setBounds(10, 170, 209, 20);
        panel.add(txtFast);

        txtFastestconfirmsIn = new JTextField();
        txtFastestconfirmsIn.setText("Fastest (Confirms in 1-2 blocks)");
        txtFastestconfirmsIn.setHorizontalAlignment(SwingConstants.CENTER);
        txtFastestconfirmsIn.setColumns(10);
        txtFastestconfirmsIn.setBounds(235, 170, 209, 20);
        panel.add(txtFastestconfirmsIn);

        txtSaveLow = new JTextField();
        txtSaveLow.setText("Safe low (<30mins to confirm)");
        txtSaveLow.setHorizontalAlignment(SwingConstants.CENTER);
        txtSaveLow.setColumns(10);
        txtSaveLow.setBounds(10, 98, 209, 20);
        panel.add(txtSaveLow);

        txtNormal = new JTextField();
        txtNormal.setText("Normal (<5mins to confirm)");
        txtNormal.setHorizontalAlignment(SwingConstants.CENTER);
        txtNormal.setColumns(10);
        txtNormal.setBounds(235, 98, 209, 20);
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
    public String getValue() {
        return this.json.get("currentBaseFee").toString();
    }

    @Override
    public String getValue2() {
        return this.json.get("recommendedBaseFee").toString();
    }

    @Override
    public String getValue3() {
        return this.json.get("safeLow").toString();
    }

    @Override
    public String getValue4() {
        return this.json.get("standard").toString();
    }

    @Override
    public String getValue5() {
        return this.json.get("fastest").toString();
    }

    @Override
    public String getValue6() {
        return this.json.get("fast").toString();
    }

    @Override
    public String toString() {
        return getName() + ", ID: " + getId() + ", " + json.toString();
    }
}
