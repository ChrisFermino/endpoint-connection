import org.json.JSONObject;
import sensores.SensorGas;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {

        SensorGas gas = new SensorGas();

        gas.request();

        ManageFile file = new ManageFile();

        //file.CreateFile();
        file.WriteFile(gas.request());


    }
}
