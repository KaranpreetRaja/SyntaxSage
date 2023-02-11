package GUI;

import CustomComponents.Tabs;
import javax.swing.*;
import java.awt.*;

public class PageNavigator extends JPanel{
    public PageNavigator(Tabs[] tabs){

        super(new GridLayout(1, 1));
        JTabbedPane tabbedPlane = new JTabbedPane();

        for (Tabs tab : tabs) {
            tabbedPlane.addTab(tab.name, tab.icon, tab.panel, tab.description);
        }
        


        

    }
}

