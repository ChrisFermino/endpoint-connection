package sensores;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SensorGas {

    public String request() throws IOException {
        URL url = new URL("https://www.etherchain.org/api/gasPriceOracle");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        return content.toString();
    }

    public Object safeLow() throws IOException {
        JSONObject json = new JSONObject(request());
        return json.get("safeLow");
    }

    public Object standard() throws IOException {
        JSONObject json = new JSONObject(request());
        return json.get("standard");
    }
    public Object fastest() throws IOException {
        JSONObject json = new JSONObject(request());
        return json.get("fastest");
    }
    public Object currentBaseFee() throws IOException {
        JSONObject json = new JSONObject(request());
        return json.get("currentBaseFee");
    }
    public Object recommendedBaseFee() throws IOException {
        JSONObject json = new JSONObject(request());
        return json.get("recommendedBaseFee");
    }

}
