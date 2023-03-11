package GUI;
import javax.swing.*;

import CustomComponents.Account;

import java.awt.*;
import java.awt.event.*;

public class ProgressGUI extends JPanel {
    private static final long serialVersionUID = 6098546007197585733L;
	private JProgressBar progressBar;
    private JButton updateProgressButton;
    private Timer timer;
    private int progressValue = 0;

    public ProgressGUI(Account acc) {
        super(new BorderLayout());

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        updateProgressButton = new JButton("Update Progress Bar Value");
        updateProgressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (acc.getExperience().equals("Master") && progressValue <=100) {	
	                	if (e.getSource() == updateProgressButton) {
	                		updateProgressButton.setEnabled(false);
	                        timer.start();
	                    } else if (e.getSource() == timer) {
	                        progressValue++;
	                        progressBar.setValue(progressValue);
	                        progressBar.setString(progressValue + "%");
	                    }
                	}
            	if (progressValue == 100) {
                    timer.stop();
                    updateProgressButton.setEnabled(true);
                }
                }}
        		);

        JPanel panel = new JPanel(new BorderLayout());
        
        // Adding gap before the elements
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panel.add(progressBar, BorderLayout.CENTER);
        panel.add(updateProgressButton, BorderLayout.PAGE_END);

        add(panel, BorderLayout.CENTER);

        timer = new Timer(50, updateProgressButton.getActionListeners()[0]);
        timer.setInitialDelay(0);
    }

}
