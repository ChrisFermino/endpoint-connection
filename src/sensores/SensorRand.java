package sensores;

import interfaces.Sensor;

import java.util.Random;

public class SensorRand implements Sensor {

    protected String id;
    protected String name;
    protected double value = 0;
    protected int updateInterval = 10;
    private static final Random RND = new Random();

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getValue() {
        int soma = RND.nextInt() % 5;
        if (soma < 3){
            this.value = Math.abs((this.value + RND.nextDouble()*10) % 101);        
        } else {
            this.value = Math.abs((this.value - RND.nextDouble()*10) % 101);        
        }
        return this.value;
        
    }

    @Override
    public Object getValue2() {
        return 0;
    }

    @Override
    public int getUpdateInterval() {
        return this.updateInterval;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }    

    @Override
    public String toString() {
        return "SensorRand{" + "id=" + id + ", name=" + name + "value=" + getValue() + '}';
    }
    
}
