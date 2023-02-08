package CustomComponents;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Login {
    public static void main(String args[]) {
        // Frame:
        JFrame loginFrame = new JFrame("Login Page");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panels:
        JPanel loginBox = new JPanel();
        JPanel buttonsPanel = new JPanel();

        // Buttons:
        JButton signInBut = new JButton();
        JButton goBackBut = new JButton();

        // Labels:
        JLabel label = new JLabel("LOG IN");

        // Button Style
        signInBut.setText("Sign In");
        goBackBut.setText("Back");

        // Set Up Frame
        loginFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginFrame.setVisible(true);
        loginFrame.add(loginBox);
        loginFrame.setSize(500, 500);

        // Set Up ButtonsFrame
        buttonsPanel.add(signInBut);
        buttonsPanel.add(goBackBut);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        signInBut.setSize(10, 10);
        goBackBut.setSize(10, 10);

        // Set Up LoginBox
        loginBox.add(label);
        loginBox.add(buttonsPanel);
        loginBox.setLayout(new BoxLayout(loginBox, BoxLayout.PAGE_AXIS));
        loginBox.setBounds(100, 100, 100, 100);

        // Sizing & Positioning

    }

}
