package GUI;
import javax.swing.*;
// import java.awt.*;

class gui {
    public static void main(String args[]) {
        JFrame f = new JFrame("Base Template");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // f.setUndecorated(true); // enables full screen mode
        JButton b1 = new JButton("Press me");
        JButton b2 = new JButton("Press me more");

        f.getContentPane().add(b1); // Adds Button b1 to content pane of frame
        f.getContentPane().add(b2); // Adds Button b2 to content pane of frame
        f.setVisible(true); // Needed to make sure abdi can see the frame
    }
}
