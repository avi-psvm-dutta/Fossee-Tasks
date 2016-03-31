package propertieschanger.consoles;

import javax.swing.*;
import java.awt.event.*;

public class MainWindow extends Console
{
    protected static JLabel label; //our label - which we're going to modify to the death

    protected JPopupMenu popupMenu; //what comes up when you right-click the label
    private JMenuItem[] menuItems = new JMenuItem[3]; //the different items on the PopupMenu

    public MainWindow()
    {
        super("Properties Changing"); //set the title

        label = new JLabel("Changing properties"); //initialize the label with the default text as per the question

        label.setOpaque(true); //otherwise we won't be able to see the background color, despite changing

        label.addMouseListener(new MouseAdapter() //a right click listener
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(e.getButton() == 3) //it has to be a right click!
                    popupMenu.show(label, e.getX(), e.getY()); //spawn the menu with the parent as the label and the coordinates as the mouse click coordinates
            }
        });

        add(label); //add the label to the main window

        initializeMenu(); //put everything on to the popup menu, and add on click lambda functions

        pack(); //set the size of the window, accordingly
    }

    private void initializeMenu()
    {
        popupMenu = new JPopupMenu();

        for(int index = 0; index < menuItems.length - 1; index++)
        {
            menuItems[index] = new JMenuItem("Option" + (index + 1)); //add some dummy options
            popupMenu.add(menuItems[index]); //add the menu item to the popup menu
        }

        menuItems[menuItems.length - 1] = new JMenuItem("Properties"); //initialize the last option as Properties
        popupMenu.add(menuItems[menuItems.length - 1]); //add the last option
        menuItems[menuItems.length - 1].addActionListener(e -> new PropertiesChangerWindow()); //spawn a Properties Changer Window when the properties menu is clicked.
    }
}