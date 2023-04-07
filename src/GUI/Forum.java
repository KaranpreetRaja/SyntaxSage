package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Forum extends JFrame {

    private JTextArea questionArea;
    private JTextArea answerArea;
    private JButton postQuestionButton;
    private JButton postAnswerButton;

    public Forum() {
        setTitle("Q&A Discussion Board");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initComponents();
        addComponentsToFrame();
    }

    private void initComponents() {
        questionArea = new JTextArea(10, 50);
        questionArea.setEditable(false);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);

        answerArea = new JTextArea(10, 50);
        answerArea.setLineWrap(true);
        answerArea.setWrapStyleWord(true);

        postQuestionButton = new JButton("Post Question");
        postQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String question = JOptionPane.showInputDialog("Enter your question:");
                if (question != null && !question.trim().isEmpty()) {
                    questionArea.append("Q: " + question + "\n");
                }
            }
        });

        postAnswerButton = new JButton("Post Answer");
        postAnswerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = JOptionPane.showInputDialog("Enter your answer:");
                if (answer != null && !answer.trim().isEmpty()) {
                    answerArea.append("A: " + answer + "\n");
                }
            }
        });
    }

    private void addComponentsToFrame() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(postQuestionButton);
        buttonPanel.add(postAnswerButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(questionArea), BorderLayout.CENTER);
        add(new JScrollPane(answerArea), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Forum frame = new Forum();
                frame.setVisible(true);
            }
        });
    }
}
