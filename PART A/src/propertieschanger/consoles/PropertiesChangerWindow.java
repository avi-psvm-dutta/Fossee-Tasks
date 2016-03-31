package propertieschanger.consoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/*
 Class info:
 The window to change the Properties of a label
 */

public class PropertiesChangerWindow extends Console
{
    private JButton textChangerButton, backgroundColourChangerButton, fontColourChangerButton;
    private JTextField textChangerField, backgroundColourChangerField, fontColourChangerField;
    //button and text field definitions, named accordingly

    public PropertiesChangerWindow()
    {
        super("Properties"); //set the title Properties

        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //this is not our main window, so override the EXIT_ON_CLOSE, from super
        setLayout(new GridLayout(3, 2, 5, 5)); //grid layout with 3 rows and two columns, spacing of 5 es between each row and each column

        textChangerField = new JTextField();
        backgroundColourChangerField = new JTextField();
        fontColourChangerField = new JTextField();
        //initialize the text fields

        //add the text field and button pairs
        addPair(textChangerButton, textChangerField, "Change Text", MainWindow.label.getText(),
                e -> MainWindow.label.setText(getText(textChangerField)));
        addPair(backgroundColourChangerButton, backgroundColourChangerField, "Change Background Colour", getHex(MainWindow.label.getBackground()),
                e -> MainWindow.label.setBackground(getColour(getText(backgroundColourChangerField))));
        addPair(fontColourChangerButton, fontColourChangerField, "Change Font Colour", getHex(MainWindow.label.getForeground()),
                e -> MainWindow.label.setForeground(getColour(getText(fontColourChangerField))));

        pack();
        //set the size of the window, accordingly
    }

    /***
     * Function to add a textfield and button pair.
     * @param button: The button
     * @param textField: The text field
     * @param buttonDefaultText: The text to be displayed on the button
     * @param textFieldDefaultText: The text to be displayed in the text field as default text (usually, the label's current value)
     * @param actionListener: The action listener for the button click
     */
    private void addPair(JButton button, JTextField textField, String buttonDefaultText, String textFieldDefaultText, ActionListener actionListener)
    {
        button = new JButton(buttonDefaultText);

        textField.setText(textFieldDefaultText);

        button.addActionListener(actionListener);

        add(textField);
        add(button);
    }

    /***
     * Converts a string of the form #rrggbbaa into an actual rgba colour
     * @param hrgb The hexadecimal string
     * @return The actual Colour
     */
    private Color getColour(String hrgb)
    {
        Pattern pattern = Pattern.compile("#[a-f0-9]{8}"); //regex
        if(!pattern.matcher(hrgb).matches()) //the inputted string does match the regex
        {
            JOptionPane.showMessageDialog(this, "Check your input format [#rrggbbaa]", "Colour parser error", 0); //show an error dialog
            return null;
        }
        return new Color(Integer.parseInt(hrgb.substring(1, 3), 16), Integer.parseInt(hrgb.substring(3, 5), 16), Integer.parseInt(hrgb.substring(5, 7), 16), Integer.parseInt(hrgb.substring(7, 9), 16));
    }

    /***
     * Converts a colour to an rgba hex string of the form #rrggbbaa
     * @param color The colour
     * @return An Rgba string
     */
    private String getHex(Color color)
    {
        return "#" + Integer.toHexString(color.getRed()) + Integer.toHexString(color.getGreen()) + Integer.toHexString(color.getBlue()) + Integer.toHexString(color.getAlpha());
    }

    /***
     * gets the text from a text field (Why? To avoid null pointer exceptions from lambda functions)
     * @param k - the text field
     * @return - The text
     */
    private String getText(JTextField k)
    {
        return k.getText();
    }
}