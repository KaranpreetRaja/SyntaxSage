package CustomComponents;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUpPage extends Login {

    public SignUpPage() {
        // Frame:
        JFrame signUpFrame = new JFrame("Signup Page");
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panels:
        JPanel signupBox = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        // Buttons:
        JButton signUpBut = new JButton();
        JButton backBut = new JButton();

        // Labels:
        JLabel label = new JLabel("Sign Up");

        // JTextField
        JTextField inputUser = new JTextField("Username");
        JTextField inputPassword = new JTextField("Password");

        // Set Up Label
        Dimension labelSize = new Dimension(100, 50);
        label.setPreferredSize(labelSize);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set Up Frame
        signUpFrame.setVisible(true);
        signUpFrame.setSize(500, 500);
        signUpFrame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        signUpFrame.add(signupBox, constraints);

        // Set Up ButtonsFrame
        signUpBut.setText("Sign Up");
        backBut.setText("Back");
        buttonsPanel.add(signUpBut);
        buttonsPanel.add(backBut);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Dimension buttonSize = new Dimension(100, 50);
        signUpBut.setPreferredSize(buttonSize);
        backBut.setPreferredSize(buttonSize);
        signUpBut.setBackground(Color.pink);
        backBut.setBackground(Color.pink);

        // Set Up SignUpBox
        signupBox.add(label);
        signupBox.add(inputPanel);
        signupBox.add(buttonsPanel);
        signupBox.setLayout(new BoxLayout(signupBox, BoxLayout.PAGE_AXIS));
        signupBox.setBorder(BorderFactory.createLineBorder(Color.black));

        // Set Up Inputs
        inputPanel.add(inputUser);
        inputPanel.add(inputPassword);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));

        // Event Listener for Inputs
        inputUser.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputUser.getText().equals("Username")) {
                    inputUser.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputUser.getText().isEmpty()) {
                    inputUser.setText("Username");
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

        // Add Account Details and Register User
        signUpBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = inputUser.getText();
                String password = inputPassword.getText();
                ArrayList<Account> accountList = extractAccount();
                accountSignUp(username, password, accountList);

                // TODO: add code to go back to the login Page.
            }
        });

    }

}
