
import sensores.SensorGas;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class main {


    public static void main(String[] args) throws IOException {

//        Class cls = Class.forName("sensores.SensorGas");
//
//        cls.getMethod("request");



        SensorGas gas = new SensorGas();
        gas.request();
        ManageFile file = new ManageFile();
//        file.CreateFile();
        file.WriteFile(gas.request());

        System.out.println(gas.safeLow());
        System.out.println(gas.standard());
        System.out.println(gas.fastest());
        System.out.println(gas.currentBaseFee());
        System.out.println(gas.recommendedBaseFee());


    }
}
