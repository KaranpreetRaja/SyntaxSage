package CustomComponents;
import javax.swing.*;


public class Tabs {
    public String name;
    public ImageIcon icon;
    public JComponent panel;
    public String description;


    public Tabs(String name, ImageIcon icon, JComponent panel, String description){
        this.name = name;
        this.icon = icon;
        this.panel = panel;
        this.description = description;
    }

}

