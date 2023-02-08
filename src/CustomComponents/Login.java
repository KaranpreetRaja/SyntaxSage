package CustomComponents;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
        JPanel inputPanel = new JPanel();

        // Buttons:
        JButton signInBut = new JButton();
        JButton goBackBut = new JButton();

        // Labels:
        JLabel label = new JLabel("LOG IN");

        // JTextField
        JTextField inputEmail = new JTextField("Email");
        JTextField inputPassword = new JTextField("Password");

        // Set Up Label
        Dimension labelSize = new Dimension(100, 50);
        label.setPreferredSize(labelSize);

        // Set Up Frame
        loginFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginFrame.setVisible(true);
        loginFrame.add(loginBox);
        loginFrame.setSize(500, 500);

        // Set Up ButtonsFrame
        signInBut.setText("Sign In");
        goBackBut.setText("Back");
        buttonsPanel.add(signInBut);
        buttonsPanel.add(goBackBut);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Dimension buttonSize = new Dimension(100, 50);
        signInBut.setPreferredSize(buttonSize);
        goBackBut.setPreferredSize(buttonSize);

        // Set Up LoginBox
        loginBox.add(label);
        loginBox.add(inputPanel);
        loginBox.add(buttonsPanel);
        loginBox.setLayout(new BoxLayout(loginBox, BoxLayout.PAGE_AXIS));

        // Set Up Inputs
        inputPanel.add(inputEmail);
        inputPanel.add(inputPassword);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        inputEmail.setToolTipText("Enter Email:");
        inputPassword.setToolTipText("Enter Password");
    }

}
