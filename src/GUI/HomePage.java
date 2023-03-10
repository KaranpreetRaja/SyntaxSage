package GUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JPanel {
	private static boolean isStubDatabase = false;

		public static void main(String[] args) {
			
        JFrame frame = new JFrame("Syntax Sage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setForeground(new Color(0, 0, 0));
        frame.setBackground(new Color(0, 0, 0));
        frame.pack();
        frame.setMinimumSize(new Dimension(1300, 600));
        frame.setVisible(true);
        JLabel title = new JLabel("Syntax Sage");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(new Color(0, 0, 0));
        title.setForeground(new Color(255, 0, 0));
        title.setFont(new Font("Magneto", Font.BOLD, 86));
        frame.add(title, BorderLayout.NORTH);
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(255, 128, 128));

        JButton btnToggleDB = new JButton("Real Database (Click to toggle)");
        btnToggleDB.setFont(new Font("Tahoma", Font.PLAIN, 35));
        btnToggleDB.setForeground(new Color(255, 128, 128));
        btnToggleDB.setBackground(new Color(255, 128, 128));
        btnToggleDB.setMaximumSize(new Dimension(400, 60));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnStart = new JButton("Get Started");
        btnStart.setFont(new Font("Tahoma", Font.PLAIN, 35));
        btnStart.setForeground(new Color(255, 128, 128));
        btnStart.setBackground(new Color(255, 128, 128));
        btnStart.setMaximumSize(new Dimension(400, 60));
        btnStart.setForeground(Color.WHITE);
        btnToggleDB.setForeground(Color.WHITE);
        panel1.add(btnStart);
        panel1.add(btnToggleDB);
        frame.add(panel1, BorderLayout.CENTER);
        
        

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame homeFrame = (JFrame) SwingUtilities.getWindowAncestor(btnStart);
                homeFrame.setVisible(false);
                try {
					Login login = new Login(isStubDatabase);
					login.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

            }
        });
        btnToggleDB.addActionListener(new ActionListener() {
            boolean isStubDatabase = false;

            public void actionPerformed(ActionEvent e) {
                if (isStubDatabase) {
                    btnToggleDB.setText("Real Database (Click to toggle)");
                    isStubDatabase = false;
                } else {
                    btnToggleDB.setText("Stub Database (Click to toggle)");
                    isStubDatabase = true;
                }
            }
        });
    }
}
