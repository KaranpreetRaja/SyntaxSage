package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import CustomComponents.*;

public class SignUpPage extends JFrame{

    private static final long serialVersionUID = -6538973670938329066L;

	public SignUpPage(final ArrayList<Account> accountList) {
        // Frame:
        final JFrame signUpFrame = new JFrame("Signup Page");
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panels:
        JPanel signupBox = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        // Buttons:
        JButton signUpBut = new JButton();
        JButton backBut = new JButton();

        // DropDown Menu
        String[] options = { "Python", "Java", "Javascript", "Ruby", "C++" };
        final JList<String> dropdownMenu = new JList<>(options);
        dropdownMenu.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane selectCoures = new JScrollPane(dropdownMenu);
        JScrollPane selectCourses = new JScrollPane(dropdownMenu);

        // Labels:
        JLabel label = new JLabel("Sign Up");
        JLabel label2 = new JLabel("Select Courses:");

        // JTextField
        final JTextField inputUser = new JTextField("Username");
        final JTextField inputPassword = new JTextField("Password");

        // Set Up Label
        Dimension labelSize = new Dimension(100, 50);
        label.setPreferredSize(labelSize);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setPreferredSize(labelSize);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        signupBox.add(label2);
        signupBox.add(selectCoures);
        signupBox.add(selectCourses);
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
                ArrayList<String> courses = (ArrayList<String>) dropdownMenu.getSelectedValuesList();

                try {
                    // Check if username already exists in database
                    String url = "jdbc:mysql://140.238.154.147:3306/project";
                    String sqlUsername = "user";
                    String sqlPassword = "Eecs2311!";
                    Connection connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM account WHERE username = ?");
                    statement.setString(1, username);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        // Username already exists
                        JOptionPane.showMessageDialog(null, "User already exists.", "Error!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Username doesn't exist, create new account in database
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                        String date = LocalDate.now().format(formatter);
                        statement = connection.prepareStatement("INSERT INTO account (username, password, classes, experience, accountCreateDate) VALUES (?, ?, ?, ?, ?)");
                        statement.setString(1, username);
                        statement.setString(2, password);
                        statement.setString(3, String.join(",", courses));
                        statement.setString(4, "Beginner");
                        statement.setString(5, date);

                        statement.executeUpdate();
                        Account myAccount = new Account(username, password, courses.get(0), "Beginner", date);
                        DashBoard dashboard = new DashBoard(myAccount);
                        signUpFrame.setVisible(false);
                        dashboard.setVisible(true);
                    }
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        });

    }

}