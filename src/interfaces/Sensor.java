package interfaces;

import java.io.IOException;

public interface Sensor {

    public abstract String getId();
    public abstract void setId(String id);
    public abstract String getName();
    public abstract void setName(String name);
    public abstract Object getValue() throws IOException;
    public abstract Object getValue2() throws IOException;
    public abstract int getUpdateInterval();
    public abstract String toString();
}
