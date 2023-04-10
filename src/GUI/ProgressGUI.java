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
    private static final int PROGRESS_MIN = 0;
    private static final int PROGRESS_MAX = 100;
    private Account acc; // Add acc as a field of ProgressGUI

    public ProgressGUI(Account acc) {
        super(new BorderLayout());
        this.acc = acc; // Initialize acc field with parameter value

        // Initialize progress bar
        progressBar = new JProgressBar(PROGRESS_MIN, PROGRESS_MAX);
        progressBar.setValue(PROGRESS_MIN);
        progressBar.setStringPainted(true);

        // Initialize update progress button
        updateProgressButton = new JButton("Update Progress Bar Value");
        updateProgressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProgress();
            }
        });

        // Create panel to hold progress bar and button
        JPanel panel = new JPanel(new BorderLayout());

        // Add margin before the elements
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(progressBar, BorderLayout.CENTER);
        panel.add(updateProgressButton, BorderLayout.PAGE_END);

        add(panel, BorderLayout.CENTER);

        // Initialize timer for progress bar updates
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressValue++;
                progressBar.setValue(progressValue);
                progressBar.setString(progressValue + "%");
                if (progressValue == PROGRESS_MAX) {
                    timer.stop();
                    updateProgressButton.setEnabled(true);
                }
            }
        });
        timer.setInitialDelay(0);
    }

    /**
     * Updates progress bar value and starts timer to animate progress bar.
     */
    private void updateProgress() {
        if (progressValue == PROGRESS_MAX || !acc.getExperience().equals("Master")) {
            return;
        }
        updateProgressButton.setEnabled(false);
        timer.start();
    }
}
