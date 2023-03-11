package GUI;

import CustomComponents.Account;
import CustomComponents.MultipleChoiceButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class MultipleChoice extends JPanel {

    private static final long serialVersionUID = -7354864831882039913L;
    private MultipleChoiceButton selectedButton;
    private String correctAnswer;
    private boolean correct;
    
    public MultipleChoice(Account acc, int count) {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 50, 10, 50));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAlignmentX(SwingConstants.CENTER);
        textArea.setAlignmentY(SwingConstants.CENTER);

        String question = null;
        String correctAnswer = null;
        ArrayList<String> answers = new ArrayList<>();
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String username = "user";
            String password = "Eecs2311!";

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM questions ORDER BY RAND() LIMIT 1");

            if (resultSet.next()) {
                question = resultSet.getString("question");
                answers.add(resultSet.getString("correct_answer"));
                answers.add(resultSet.getString("wrong_answer_1"));
                answers.add(resultSet.getString("wrong_answer_2"));
                answers.add(resultSet.getString("wrong_answer_3"));
                correctAnswer = resultSet.getString("correct_answer");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Shuffle the answers
        Collections.shuffle(answers);

        textArea.setText(question + "\n\n");
        add(textArea, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 0, 0));
        add(buttonPanel, BorderLayout.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 20);
        Border border = BorderFactory.createEmptyBorder(50, 0, 50, 0);
        buttonPanel.setBorder(border);

        final MultipleChoiceButton button1 = new MultipleChoiceButton(answers.get(0));
        button1.setFont(font);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton == button1) {
                    return;
                }
                if (selectedButton != null) {
                    selectedButton.switchSelected();
                    selectedButton.repaint();
                }
                selectedButton = button1;
                button1.switchSelected();
            }
        });
        buttonPanel.add(button1);

        final MultipleChoiceButton button2 = new MultipleChoiceButton(answers.get(1));
        button2.setFont(font);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton == button2) {
                    return;
                }
                if (selectedButton != null) {
                    selectedButton.switchSelected();
                }
                selectedButton = button2;
                button2.switchSelected();
            }
        });
        buttonPanel.add(button2);

        final MultipleChoiceButton button3 = new MultipleChoiceButton(answers.get(2));
        button3.setFont(font);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton == button3) {
                    return;
                }
                if (selectedButton != null) {
                    selectedButton.switchSelected();
                }
                selectedButton = button3;
                button3.switchSelected();
            }
        });
        buttonPanel.add(button3);

        final MultipleChoiceButton button4 = new MultipleChoiceButton(answers.get(3));
        button4.setFont(font);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton == button4) {
                    return;
                }
                if (selectedButton != null) {
                    selectedButton.switchSelected();
                }
                selectedButton = button4;
                button4.switchSelected();
            }
        });
        buttonPanel.add(button4);

        JButton submitButton = new JButton("Submit");
        final String finalCorrectAnswer = correctAnswer;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton != null) {
                    String selectedAnswer = selectedButton.getText();
                    
                    if (selectedAnswer.equals(finalCorrectAnswer) && (count >=5)) {
                        System.out.println("Correct!");
                        correct = true;
                        if (acc.getExperience() == "Beginner") {
                        	acc.setExperience("Master");
                        }
                        MultipleSelect panel = new MultipleSelect(acc, count+1);
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MultipleChoice.this);
                        frame.setContentPane(panel);
                        frame.revalidate();

                    }

                    else if (selectedAnswer.equals(finalCorrectAnswer)) {
                        System.out.println("Correct!");
                        correct = true;
                        MultipleSelect panel = new MultipleSelect(acc, count+1);
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MultipleChoice.this);
                        frame.setContentPane(panel);
                        frame.revalidate();

                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect answer. Please try again.", "Incorrect", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        add(submitButton, BorderLayout.SOUTH);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public MultipleChoice() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 50, 10, 50));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAlignmentX(SwingConstants.CENTER);
        textArea.setAlignmentY(SwingConstants.CENTER);

        String question = null;
        String correctAnswer = null;
        ArrayList<String> answers = new ArrayList<>();
        try {
            String url = "jdbc:mysql://140.238.154.147:3306/project";
            String username = "user";
            String password = "Eecs2311!";

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM questions ORDER BY RAND() LIMIT 1");

            if (resultSet.next()) {
                question = resultSet.getString("question");
                answers.add(resultSet.getString("correct_answer"));
                answers.add(resultSet.getString("wrong_answer_1"));
                answers.add(resultSet.getString("wrong_answer_2"));
                answers.add(resultSet.getString("wrong_answer_3"));
                correctAnswer = resultSet.getString("correct_answer");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Shuffle the answers
        Collections.shuffle(answers);

        textArea.setText(question + "\n\n");
        add(textArea, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 0, 0));
        add(buttonPanel, BorderLayout.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 20);
        Border border = BorderFactory.createEmptyBorder(50, 0, 50, 0);
        buttonPanel.setBorder(border);

        final MultipleChoiceButton button1 = new MultipleChoiceButton(answers.get(0));
        button1.setFont(font);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton == button1) {
                    return;
                }
                if (selectedButton != null) {
                    selectedButton.switchSelected();
                    selectedButton.repaint();
                }
                selectedButton = button1;
                button1.switchSelected();
            }
        });
        buttonPanel.add(button1);

        final MultipleChoiceButton button2 = new MultipleChoiceButton(answers.get(1));
        button2.setFont(font);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton == button2) {
                    return;
                }
                if (selectedButton != null) {
                    selectedButton.switchSelected();
                }
                selectedButton = button2;
                button2.switchSelected();
            }
        });
        buttonPanel.add(button2);

        final MultipleChoiceButton button3 = new MultipleChoiceButton(answers.get(2));
        button3.setFont(font);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton == button3) {
                    return;
                }
                if (selectedButton != null) {
                    selectedButton.switchSelected();
                }
                selectedButton = button3;
                button3.switchSelected();
            }
        });
        buttonPanel.add(button3);

        final MultipleChoiceButton button4 = new MultipleChoiceButton(answers.get(3));
        button4.setFont(font);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton == button4) {
                    return;
                }
                if (selectedButton != null) {
                    selectedButton.switchSelected();
                }
                selectedButton = button4;
                button4.switchSelected();
            }
        });
        buttonPanel.add(button4);

        JButton submitButton = new JButton("Submit");
        final String finalCorrectAnswer = correctAnswer;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButton != null) {
                    String selectedAnswer = selectedButton.getText();

                    if (selectedAnswer.equals(finalCorrectAnswer)) {
                        System.out.println("Correct!");
                        correct = true;
                        MultipleSelect panel = new MultipleSelect();
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MultipleChoice.this);
                        frame.setContentPane(panel);
                        frame.revalidate();

                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect answer. Please try again.", "Incorrect", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        add(submitButton, BorderLayout.SOUTH);
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        MultipleChoice panel = new MultipleChoice();
        frame.add(panel);
        frame.setVisible(true);
    }

}
