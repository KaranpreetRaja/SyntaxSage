package GUI;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MultipleSelect {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 50, 10, 50));
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
        Border border = BorderFactory.createEmptyBorder(0, 130, 0, 0);
        buttonPanel.setBorder(border);

        JCheckBox button1 = new JCheckBox("Option 1");
        button1.setFont(font);
        buttonPanel.add(button1);

        JCheckBox button2 = new JCheckBox("Option 2");
        button2.setFont(font);
        buttonPanel.add(button2);

        JCheckBox button3 = new JCheckBox("Option 3");
        button3.setFont(font);
        buttonPanel.add(button3);

        JCheckBox button4 = new JCheckBox("Option 4");
        button4.setFont(font);
        buttonPanel.add(button4);

        // TODO: center submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(200, 50));
        submitButton.setBorder(new EmptyBorder(10, 10, 10, 10));
        submitButton.setFont(font);
        submitButton.setAlignmentX(SwingConstants.CENTER);
        submitButton.setAlignmentY(SwingConstants.CENTER);
        submitButton.addActionListener(e -> {
            String selected = "";
            if (button1.isSelected()) {
                selected += "Option 1 ";
            }
            if (button2.isSelected()) {
                selected += "Option 2 ";
            }
            if (button3.isSelected()) {
                selected += "Option 3 ";
            }
            if (button4.isSelected()) {
                selected += "Option 4 ";
            }
            System.out.println(selected + "selected");
        });
        buttonPanel.add(submitButton);

        frame.setVisible(true);
        frame.setResizable(true);
        frame.pack();
    }
}
