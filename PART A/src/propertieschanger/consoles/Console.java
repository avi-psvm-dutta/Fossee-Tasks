package propertieschanger.consoles;

import javax.swing.*;
import java.awt.*;

/*
Class info:
A general template for all Consoles.
 */

public class Console extends JFrame
{
    public Console(String title)
    {
        setTitle(title);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
    }
}
