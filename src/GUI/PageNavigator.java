import javax.swing.*;
import java.awt.*;

public class PageNavigator extends JPanel{
    public PageNavigator(int tabs, Tabs[] tabs){

        super(new GridLayout(1, 1));
        JTabbedPane tabbedPlane = new JTabbedPane();

        for (int i =0; i < tabs, i++){
            tabbedPlane.addTab(tabs[i].name, tabs[i].icon, tabs[i].pannel, tabs[i].discription);
        }
        


        

    }
}

