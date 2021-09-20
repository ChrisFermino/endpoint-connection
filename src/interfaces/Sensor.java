package interfaces;

public interface Sensor {

    public abstract String getVendor();
    public abstract String getId();
    public abstract void setId(String id);
    public abstract String getName();
    public abstract void setName(String name);
    public abstract double getValue();
    public abstract int getUpdateInterval();
    public abstract String toString();
}
