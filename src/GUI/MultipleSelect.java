package GUI;

import CustomComponents.SelectionButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class MultipleSelect extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7859316644755253568L;

	public MultipleSelect() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 50, 10, 50));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAlignmentX(SwingConstants.CENTER);
        textArea.setAlignmentY(SwingConstants.CENTER);

        String question = null;
        String correctAnswer1 = null;
        String correctAnswer2 = null;
        ArrayList<String> answers = new ArrayList<>();
        try {
            // Replace the following with your database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/project";
            String username = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM msquestions ORDER BY RAND() LIMIT 1");

            if (resultSet.next()) {
                question = resultSet.getString("msquestion");
                answers.add(resultSet.getString("correct_answer_1"));
                answers.add(resultSet.getString("correct_answer_2"));
                answers.add(resultSet.getString("wrong_answer_1"));
                answers.add(resultSet.getString("wrong_answer_2"));
                correctAnswer1 = resultSet.getString("correct_answer_1");
                correctAnswer2 = resultSet.getString("correct_answer_2");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Shuffle the answers
        Collections.shuffle(answers);

        StringBuilder text = new StringBuilder(question + "\n\n");
        textArea.setText(text.toString());
        add(textArea, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 0, 0));
        add(buttonPanel, BorderLayout.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 20);
        Border border = BorderFactory.createEmptyBorder(50, 0, 50, 0);
        buttonPanel.setBorder(border);

        final SelectionButton button1 = new SelectionButton(answers.get(0));
        button1.setFont(font);
        buttonPanel.add(button1);

        final SelectionButton button2 = new SelectionButton(answers.get(1));
        button2.setFont(font);
        buttonPanel.add(button2);

        final SelectionButton button3 = new SelectionButton(answers.get(2));
        button3.setFont(font);
        buttonPanel.add(button3);

        final SelectionButton button4 = new SelectionButton(answers.get(3));
        button4.setFont(font);
        buttonPanel.add(button4);

        JButton submitButton = new JButton("Submit");
        String finalCorrectAnswer1 = correctAnswer1;
        String finalCorrectAnswer2 = correctAnswer2;
        submitButton.setAlignmentX(SwingConstants.CENTER);
        submitButton.setAlignmentY(SwingConstants.CENTER);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int correctCount = 0;
                if (button1.isSelected() && button1.getText().equals(finalCorrectAnswer1) || button1.getText().equals(finalCorrectAnswer2)) {
                    correctCount++;
                }
                if (button2.isSelected() && button2.getText().equals(finalCorrectAnswer1) || button2.getText().equals(finalCorrectAnswer2)) {
                    correctCount++;
                }
                if (button3.isSelected() && button3.getText().equals(finalCorrectAnswer1) || button3.getText().equals(finalCorrectAnswer2)) {
                    correctCount++;
                }
                if (button4.isSelected() && button4.getText().equals(finalCorrectAnswer1) || button4.getText().equals(finalCorrectAnswer2)) {
                    correctCount++;
                }
                if (correctCount == 0) {
                    System.out.println("Incorrect");
                } else if (correctCount == 1) {
                    System.out.println("Partially correct");
                } else {
                    System.out.println("Correct");
                    MultipleChoice panel = new MultipleChoice();
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MultipleSelect.this);
                    frame.setContentPane(panel);
                    frame.revalidate();
                }
            }
        });
        add(submitButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        MultipleSelect panel = new MultipleSelect();
        frame.add(panel);

        frame.setVisible(true);
    }
}
