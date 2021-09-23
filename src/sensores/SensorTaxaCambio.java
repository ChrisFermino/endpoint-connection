package sensores;

import interfaces.Sensor;
import org.json.JSONObject;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SensorTaxaCambio implements Sensor {

    protected String id;
    protected String name;
    protected JSONObject json;

    public SensorTaxaCambio() {
        this.request();
    }

    private void request() {
        try {
            URL url = new URL("https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=BRL&apikey=ZCKH058NVWR67WTW");
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
            System.out.println("Erro request SensorTaxaCambio");
        }
    }

    public JPanel getPanel() {

        JTextField txtUsdUnited;
        JTextField txtBrlBrazilian;
        JTextField textField_2;
        JTextField txtExchangeRate;
        JTextField txtTaxaDeCmbio;
        JTextField txtltimaAtualizao;
        JTextField txtLastRefreshed;

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 454, 279);
        panel.setLayout(null);

        txtUsdUnited = new JTextField();
        txtUsdUnited.setText("USD - United States Dollar");
        txtUsdUnited.setHorizontalAlignment(JTextField.CENTER);
        txtUsdUnited.setBounds(45, 68, 163, 50);
        panel.add(txtUsdUnited);
        txtUsdUnited.setColumns(10);

        txtBrlBrazilian = new JTextField();
        txtBrlBrazilian.setText("BRL - Brazilian Real");
        txtBrlBrazilian.setHorizontalAlignment(JTextField.CENTER);
        txtBrlBrazilian.setBounds(218, 68, 163, 50);
        panel.add(txtBrlBrazilian);
        txtBrlBrazilian.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setText("1");
        textField_2.setHorizontalAlignment(JTextField.CENTER);
        textField_2.setColumns(10);
        textField_2.setBounds(45, 129, 163, 20);
        panel.add(textField_2);

        txtExchangeRate = new JTextField();
        txtExchangeRate.setText(getValue3());
        txtExchangeRate.setHorizontalAlignment(JTextField.CENTER);
        txtExchangeRate.setColumns(10);
        txtExchangeRate.setBounds(218, 129, 163, 20);
        panel.add(txtExchangeRate);

        txtTaxaDeCmbio = new JTextField();
        txtTaxaDeCmbio.setText("Taxa de Câmbio USD / BRL");
        txtTaxaDeCmbio.setHorizontalAlignment(JTextField.CENTER);
        txtTaxaDeCmbio.setBounds(45, 16, 336, 41);
        panel.add(txtTaxaDeCmbio);
        txtTaxaDeCmbio.setColumns(10);

        txtltimaAtualizao = new JTextField();
        txtltimaAtualizao.setText("\u00DAltima atualiza\u00E7\u00E3o:");
        txtltimaAtualizao.setHorizontalAlignment(JTextField.CENTER);
        txtltimaAtualizao.setBounds(45, 160, 336, 20);
        panel.add(txtltimaAtualizao);
        txtltimaAtualizao.setColumns(10);

        txtLastRefreshed = new JTextField();
        txtLastRefreshed.setText(getValue4());
        txtLastRefreshed.setHorizontalAlignment(JTextField.CENTER);
        txtLastRefreshed.setBounds(45, 182, 336, 20);
        panel.add(txtLastRefreshed);
        txtLastRefreshed.setColumns(10);

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
        return "USD - United States Dollar";
    }

    @Override
    public String getValue2() {
        return "BRL - Brszilian Real";
    }

    @Override
    public String getValue3() {
        String jsonString = this.json.get("Realtime Currency Exchange Rate").toString();
        JSONObject json2 = new JSONObject(jsonString);
        return json2.get("5. Exchange Rate").toString();
    }

    @Override
    public String getValue4() {
        String jsonString = this.json.get("Realtime Currency Exchange Rate").toString();
        JSONObject json2 = new JSONObject(jsonString);
        return json2.get("6. Last Refreshed").toString();
    }

    @Override
    public String getValue5() {
        return " ";
    }

    @Override
    public String getValue6() {
        return " ";
    }

    @Override
    public String toString() {
        return getName() + ", ID: " + getId() + ", {From Currency: " + getValue() + ", To Currency: "
                + getValue2() + ", Exchange Rate: " + getValue3() + ", Last Refreshed" + getValue4();
    }
}
