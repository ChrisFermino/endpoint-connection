package sensores;

import interfaces.Sensor;

import javax.swing.*;
import java.util.Random;

public class SensorRand implements Sensor {

    private static final Random RND = new Random();
    protected String id;
    protected String name;
    protected double value = 0;

    @Override
    public JPanel getPanel() {

        JPanel panel = new JPanel();
        JTextField txtUsdUnited;
        JTextField txtTaxaDeCmbio;
        panel.setBounds(10, 11, 454, 279);
        panel.setLayout(null);

        txtTaxaDeCmbio = new JTextField();
        txtTaxaDeCmbio.setText("Sensor Rand");
        txtTaxaDeCmbio.setHorizontalAlignment(JTextField.CENTER);
        txtTaxaDeCmbio.setBounds(45, 16, 336, 41);
        panel.add(txtTaxaDeCmbio);
        txtTaxaDeCmbio.setColumns(10);

        txtUsdUnited = new JTextField();
        txtUsdUnited.setText(getValue().toString());
        txtUsdUnited.setHorizontalAlignment(JTextField.CENTER);
        txtUsdUnited.setBounds(133, 68, 163, 50);
        panel.add(txtUsdUnited);
        txtUsdUnited.setColumns(10);

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
    public Double getValue() {
        int soma = RND.nextInt() % 5;
        if (soma < 3) {
            this.value = Math.abs((this.value + RND.nextDouble() * 10) % 101);
        } else {
            this.value = Math.abs((this.value - RND.nextDouble() * 10) % 101);
        }
        return this.value;
    }

    @Override
    public Object getValue2() {
        return null;
    }

    @Override
    public Object getValue3() {
        return null;
    }

    @Override
    public Object getValue4() {
        return null;
    }

    @Override
    public Object getValue5() {
        return null;
    }

    @Override
    public Object getValue6() {
        return null;
    }

    @Override
    public String toString() {
        return "SensorRand{" + "id=" + id + ", name=" + name + ", RNDValue" + getValue() + '}';
    }

}
