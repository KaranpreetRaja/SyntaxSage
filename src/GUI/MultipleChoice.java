package GUI;

import CustomComponents.MultipleChoiceButton;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MultipleChoice extends JPanel {

	private static final long serialVersionUID = -7354864831882039913L;
	private MultipleChoiceButton selectedButton;

    public MultipleChoice() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 50, 10, 50));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAlignmentX(SwingConstants.CENTER);
        textArea.setAlignmentY(SwingConstants.CENTER);

        StringBuilder text = new StringBuilder();
        textArea.setText(text.toString());
        add(textArea, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 0, 0));
        add(buttonPanel, BorderLayout.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 20);
        Border border = BorderFactory.createEmptyBorder(50, 0, 50, 0);
        buttonPanel.setBorder(border);

        MultipleChoiceButton button1 = new MultipleChoiceButton("Option 1");
        button1.setFont(font);
        button1.addActionListener(e -> {
            if (selectedButton == button1) {
                return;
            }
            if (selectedButton != null) {
                selectedButton.switchSelected();
                selectedButton.repaint();
            }
            selectedButton = button1;
            button1.switchSelected();
        });
        buttonPanel.add(button1);

        MultipleChoiceButton button2 = new MultipleChoiceButton("Option 2");
        button2.setFont(font);
        button2.addActionListener(e -> {
            if (selectedButton == button2) {
                return;
            }
            if (selectedButton != null) {
                selectedButton.switchSelected();
            }
            selectedButton = button2;
            button2.switchSelected();
        });
        buttonPanel.add(button2);

        MultipleChoiceButton button3 = new MultipleChoiceButton("Option 3");
        button3.setFont(font);
        button3.addActionListener(e -> {
            if (selectedButton == button3) {
                return;
            }
            if (selectedButton != null) {
                selectedButton.switchSelected();
            }
            selectedButton = button3;
            button3.switchSelected();
        });
        buttonPanel.add(button3);

        MultipleChoiceButton button4 = new MultipleChoiceButton("Option 4");
        button4.setFont(font);
        button4.addActionListener(e -> {
            if (selectedButton == button4) {
                return;
            }
            if (selectedButton != null) {
                selectedButton.switchSelected();
            }
            selectedButton = button4;
            button4.setSelected(true);
        });
        buttonPanel.add(button4);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            if (selectedButton != null) {
                System.out.println("Selected: " + selectedButton.getText());
            }
        });
        add(submitButton, BorderLayout.SOUTH);
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
