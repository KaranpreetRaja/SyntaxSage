package GUI;

import java.awt.*;
import javax.swing.*;

import CustomComponents.*;

import java.awt.event.*;
import java.sql.SQLException;

import CustomComponents.Account;
import DB.Database;

public class Login extends JFrame{
    public JFrame loginFrame;
    public ArrayList<Account> accountList;
    public static void main(String[] args) {
        // Frame:
        JFrame loginFrame = new JFrame("Login Page");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panels:
        JPanel loginBox = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        // Buttons:
        JButton signInBut = new JButton();
        JButton registerBut = new JButton();

        // Labels:
        JLabel label = new JLabel("LOG IN");

        // JTextField
        JTextField inputUser = new JTextField("Username");
        JTextField inputPassword = new JTextField("Password");

        // Set Up Label
        Dimension labelSize = new Dimension(100, 50);
        label.setPreferredSize(labelSize);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        registerBut.setText("Register");
        buttonsPanel.add(signInBut);
        buttonsPanel.add(registerBut);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Dimension buttonSize = new Dimension(100, 50);
        signInBut.setPreferredSize(buttonSize);
        registerBut.setPreferredSize(buttonSize);
        signInBut.setBackground(Color.yellow);
        registerBut.setBackground(Color.yellow);

        // Set Up LoginBox
        loginBox.add(label);
        loginBox.add(inputPanel);
        loginBox.add(buttonsPanel);
        loginBox.setLayout(new BoxLayout(loginBox, BoxLayout.PAGE_AXIS));
        loginBox.setBorder(BorderFactory.createLineBorder(Color.black));

        // Set Up Inputs
        inputPanel.add(inputUser);
        inputPanel.add(inputPassword);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));

        // Stub Database
        this.accountList = new ArrayList<Account>();
        this.accountList.add(Account.createAccount("John", "password", "Java,", "", "2022-12-29"));
        this.accountList.add(Account.createAccount("Admin", "Admin", "Java,Python,", "", "2020-01-01"));

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

        // Check Account Details and Sign In
        signInBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = inputUser.getText();
                String password = inputPassword.getText();
                int check = 0;
                try {
                    check = Account.signIn(username, password, accountList);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                if (check == -1) {
                    JLabel message = new JLabel("Wrong Username or Password");
                    loginFrame.add(message);
                } else {
                    Account myAccount = accountList.get(check);
                    DashBoard db = new DashBoard(myAccount);
                    loginFrame.setVisible(false);
                    db.setVisible(true);
                }

                // Switch to Register Panel
                registerBut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SignUpPage registerPage = new SignUpPage(accountList);
                        loginFrame.setVisible(false);
                        registerPage.setVisible(true);
                    }
                });
            }
        });
    }
    public JFrame getLoginFrame() {
        return loginFrame;
    }
}
