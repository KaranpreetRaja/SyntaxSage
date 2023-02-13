package CustomComponents;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
        JLabel label = new JLabel("LOG IN   ");

        // JTextField
        JTextField inputEmail = new JTextField("Email");
        JTextField inputPassword = new JTextField("Password");

        // Set Up Label
        Dimension labelSize = new Dimension(100, 50);
        label.setPreferredSize(labelSize);

        // Set Up Frame
        loginFrame.setVisible(true);
        loginFrame.setSize(500, 500);
        loginFrame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        loginFrame.add(loginBox, constraints);

        // Set Up ButtonsFrame
        signInBut.setText("Sign In");
        goBackBut.setText("Back");
        buttonsPanel.add(signInBut);
        buttonsPanel.add(goBackBut);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Dimension buttonSize = new Dimension(100, 50);
        signInBut.setPreferredSize(buttonSize);
        goBackBut.setPreferredSize(buttonSize);
        signInBut.setBackground(Color.BLUE);
        goBackBut.setBackground(Color.BLUE);

        // Set Up LoginBox
        loginBox.add(label);
        loginBox.add(inputPanel);
        loginBox.add(buttonsPanel);
        loginBox.setLayout(new BoxLayout(loginBox, BoxLayout.PAGE_AXIS));
        loginBox.setBorder(BorderFactory.createLineBorder(Color.black));

        // Set Up Inputs
        inputPanel.add(inputEmail);
        inputPanel.add(inputPassword);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        inputEmail.setToolTipText("Enter Email:");
        inputPassword.setToolTipText("Enter Password");

        // Event Listener for Inputs
        inputEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputEmail.getText().equals("Email")) {
                    inputEmail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputEmail.getText().isEmpty()) {
                    inputEmail.setText("Email");
                }
            }
        });

        inputPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputPassword.getText().equals("Password")) {
                    inputPassword.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputPassword.getText().isEmpty()) {
                    inputPassword.setText("Password");
                }
            }
        });

    }
}
