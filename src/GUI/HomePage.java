package GUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class HomePage {

    public HomePage() {
        Box contentPane = Box.createVerticalBox();
        contentPane.setBackground(new Color(0, 255, 255));
        contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        JLabel lblNewLabel = new JLabel("Syntax Sage");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBackground(SystemColor.inactiveCaption);
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("Magneto", Font.BOLD, 86));
        contentPane.add(lblNewLabel, BorderLayout.NORTH);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

        JButton btnNewButton_1 = new JButton("Toggle Database");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        btnNewButton_1.setForeground(new Color(255, 128, 128));
        btnNewButton_1.setBackground(new Color(255, 128, 128));
        btnNewButton_1.setMaximumSize(new Dimension(400, 60));

        JButton btnNewButton = new JButton("Get Started");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        btnNewButton.setForeground(new Color(255, 128, 128));
        btnNewButton.setBackground(new Color(255, 128, 128));
        btnNewButton.setMaximumSize(new Dimension(400, 60)); // set maximum width and height
        panel1.add(btnNewButton);
        panel1.add(btnNewButton_1);
        contentPane.add(panel1, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        contentPane.add(panel);
    }

}
