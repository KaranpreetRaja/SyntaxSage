package GUI;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class MultipleChoice {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(50, 50, 50, 50));
        panel.setLayout(new GridLayout(2, 1, 0, 0));
        frame.add(panel);

        // TODO: fix title (set rows to 3 first)
        /*
        JLabel title = new JLabel("Title");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(20.0f));
        panel.add(title, BorderLayout.NORTH);*/

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAlignmentX(SwingConstants.CENTER);
        textArea.setAlignmentY(SwingConstants.CENTER);

        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("code.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error reading text file");
            e.printStackTrace();
        }
        textArea.setText(text.toString());
        panel.add(textArea);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 0, 0));
        panel.add(buttonPanel);

        Font font = new Font("Arial", Font.PLAIN, 18);
        Border border = BorderFactory.createEmptyBorder(25, 130, 0, 0);
        ButtonGroup group = new ButtonGroup();
        buttonPanel.setBorder(border);

        JRadioButton button1 = new JRadioButton("Option 1");
        button1.setFont(font);
        buttonPanel.add(button1);
        group.add(button1);

        JRadioButton button2 = new JRadioButton("Option 2");
        button2.setFont(font);
        buttonPanel.add(button2);
        group.add(button2);

        JRadioButton button3 = new JRadioButton("Option 3");
        button3.setFont(font);
        buttonPanel.add(button3);
        group.add(button3);

        JRadioButton button4 = new JRadioButton("Option 4");
        button4.setFont(font);
        buttonPanel.add(button4);
        group.add(button4);

        // TODO: center submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(200, 50));
        submitButton.setBorder(new EmptyBorder(10, 10, 10, 10));
        submitButton.setFont(font);
        submitButton.setAlignmentX(SwingConstants.CENTER);
        submitButton.setAlignmentY(SwingConstants.CENTER);
        submitButton.addActionListener(e -> {
            if (button1.isSelected()) {
                System.out.println("Option 1 selected");
            } else if (button2.isSelected()) {
                System.out.println("Option 2 selected");
            } else if (button3.isSelected()) {
                System.out.println("Option 3 selected");
            } else if (button4.isSelected()) {
                System.out.println("Option 4 selected");
            }
        });
        buttonPanel.add(submitButton);

        frame.setVisible(true);
        frame.setResizable(true);
        frame.pack();
    }
}
