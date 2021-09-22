package interfaces;

import javax.swing.*;
import java.io.IOException;

public interface Sensor {

    public abstract String getId();
    public abstract void setId(String id);
    public abstract String getName();
    public abstract void setName(String name);
    public abstract Object getValue() throws IOException;
    public abstract Object getValue2() throws IOException;
    public abstract Object getValue3() throws IOException;
    public abstract Object getValue4() throws IOException;
    public abstract Object getValue5() throws IOException;
    public abstract Object getValue6() throws IOException;
    public abstract int getUpdateInterval();
    public abstract String toString();
    public abstract JPanel getPanel();
}
