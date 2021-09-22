package sensores;

import interfaces.Sensor;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SensorGas implements Sensor{

    protected String id;
    protected String name;
    protected int updateInterval = 10;
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

        }catch (IOException e) {
            System.out.println("Erro request SensorGas");
        }
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
    public String getValue(){
        return this.json.get("currentBaseFee").toString();
    }

    @Override
    public String getValue2()  {
        return this.json.get("recommendedBaseFee").toString();
    }

    @Override
    public int getUpdateInterval() {
        return this.updateInterval;
    }

    @Override
    public String toString() {
        return "SensorGas{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value=" + getValue() +
                ", value2=" + getValue2() +
                ", updateInterval=" + updateInterval +
                '}';
    }
}
