import javax.swing.*;

class gui {
    public static void main(String args[]) {
        JFrame f = new JFrame("Base Template");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // f.setUndecorated(true); // enables full screen mode
        JButton button = new JButton("Press me");

        f.getContentPane().add(button); // Adds Button to content pane of frame
        f.setVisible(true); // Needed to make sure abdi can see the frame
    }
}