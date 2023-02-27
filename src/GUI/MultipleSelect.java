package GUI;

import CustomComponents.SelectionButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

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

        StringBuilder text = new StringBuilder();
        textArea.setText(text.toString());
        add(textArea, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 0, 0));
        add(buttonPanel, BorderLayout.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 20);
        Border border = BorderFactory.createEmptyBorder(50, 0, 50, 0);
        buttonPanel.setBorder(border);

        final SelectionButton button1 = new SelectionButton("Option 1");
        button1.setFont(font);
        buttonPanel.add(button1);

        final SelectionButton button2 = new SelectionButton("Option 2");
        button2.setFont(font);
        buttonPanel.add(button2);

        final SelectionButton button3 = new SelectionButton("Option 3");
        button3.setFont(font);
        buttonPanel.add(button3);

        final SelectionButton button4 = new SelectionButton("Option 4");
        button4.setFont(font);
        buttonPanel.add(button4);

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(SwingConstants.CENTER);
        submitButton.setAlignmentY(SwingConstants.CENTER);
        submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    StringBuilder selectedButtons = new StringBuilder();
			    if (button1.isSelected()) {
			        selectedButtons.append("Option 1 ");
			    }
			    if (button2.isSelected()) {
			        selectedButtons.append("Option 2 ");
			    }
			    if (button3.isSelected()) {
			        selectedButtons.append("Option 3 ");
			    }
			    if (button4.isSelected()) {
			        selectedButtons.append("Option 4 ");
			    }
			    System.out.println("Selected buttons: " + selectedButtons);
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
