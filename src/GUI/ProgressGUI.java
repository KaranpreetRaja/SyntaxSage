package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgressGUI extends JPanel implements ActionListener {
    private static final long serialVersionUID = 6098546007197585733L;
	private JProgressBar progressBar;
    private JButton startButton;
    private Timer timer;
    private int progressValue = 0;

    public ProgressGUI() {
        super(new BorderLayout());

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        startButton = new JButton("Start");
        startButton.addActionListener(this);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(progressBar, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.PAGE_END);

        add(panel, BorderLayout.CENTER);

        timer = new Timer(50, this);
        timer.setInitialDelay(0);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startButton.setEnabled(false);
            timer.start();
        } else if (e.getSource() == timer) {
            progressValue++;
            progressBar.setValue(progressValue);
            progressBar.setString(progressValue + "%");

            if (progressValue == 100) {
                timer.stop();
                startButton.setEnabled(true);
            }
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("ProgressBarDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new ProgressGUI();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
