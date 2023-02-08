package CustomComponents;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Tabs {
    public String name;
    public ImageIcon icon;
    public JComponent pannel;
    public String discription;

    public Tabs(String name, ImageIcon icon, JComponent pannel, String discription) {
        this.name = name;
        this.icon = icon;
        this.pannel = pannel;
        this.discription = discription;
    }

}
