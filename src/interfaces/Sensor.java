package interfaces;

import javax.swing.*;
import java.io.IOException;

public interface Sensor {

    String getId();
    void setId(String id);
    String getName();
    void setName(String name);
    Object getValue();
    Object getValue2();
    Object getValue3();
    Object getValue4();
    Object getValue5();
    Object getValue6();
    String toString();
    JPanel getPanel();
}
