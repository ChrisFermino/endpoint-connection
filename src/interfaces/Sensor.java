package interfaces;

import javax.swing.*;
import java.io.IOException;

public interface Sensor {

    String getId();
    void setId(String id);
    String getName();
    void setName(String name);
    Object getValue() throws IOException;
    Object getValue2() throws IOException;
    Object getValue3() throws IOException;
    Object getValue4() throws IOException;
    Object getValue5() throws IOException;
    Object getValue6() throws IOException;
    String toString();
    JPanel getPanel();
}
