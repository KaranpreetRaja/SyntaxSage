package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import CustomComponents.Account;

public class BadgeGUI extends JPanel {
    private static final long serialVersionUID = 6098546007197585733L;
    private JLabel label;
    private JButton updateBadgesButton;
    private ImageIcon[] badges;
    private int badgeWidth = 100; // Set the initial width of the badge image
    private int badgeHeight = 100; // Set the initial height of the badge image

    public BadgeGUI(Account acc) {
        super(new BorderLayout());

        label = new JLabel("Badges");
        label.setHorizontalAlignment(JLabel.CENTER);

        JPanel badgesPanel = new JPanel(new GridLayout(1, 3));
        badgesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if (acc.getExperience().equals("Master")) {
            badges = new ImageIcon[3];
            try {
                Image img1 = ImageIO.read(new File("Assets/PythonBadge-1.png"));
                Image img2 = ImageIO.read(new File("Assets/PythonBadge-2.png"));
                Image img3 = ImageIO.read(new File("Assets/PythonBadge-3.png"));
                Image scaledImg1 = img1.getScaledInstance(badgeWidth, badgeHeight, Image.SCALE_SMOOTH);
                Image scaledImg2 = img2.getScaledInstance(badgeWidth, badgeHeight, Image.SCALE_SMOOTH);
                Image scaledImg3 = img3.getScaledInstance(badgeWidth, badgeHeight, Image.SCALE_SMOOTH);
                badges[0] = new ImageIcon(scaledImg1);
                badges[1] = new ImageIcon(scaledImg2);
                badges[2] = new ImageIcon(scaledImg3);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            for (ImageIcon badge : badges) {
                JLabel badgeLabel = new JLabel(badge);
                badgeLabel.setHorizontalAlignment(JLabel.CENTER);
                badgesPanel.add(badgeLabel);
            }
        }

        updateBadgesButton = new JButton("Update Badges");
        updateBadgesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (acc.getExperience().equals("Master")) {
                    badges = new ImageIcon[3];
                    try {
                        Image img1 = ImageIO.read(new File("Assets/PythonBadge-1.png"));
                        Image img2 = ImageIO.read(new File("Assets/PythonBadge-2.png"));
                        Image img3 = ImageIO.read(new File("Assets/PythonBadge-3.png"));
                        Image scaledImg1 = img1.getScaledInstance(badgeWidth, badgeHeight, Image.SCALE_SMOOTH);
                        Image scaledImg2 = img2.getScaledInstance(badgeWidth, badgeHeight, Image.SCALE_SMOOTH);
                        Image scaledImg3 = img3.getScaledInstance(badgeWidth, badgeHeight, Image.SCALE_SMOOTH);
                        badges[0] = new ImageIcon(scaledImg1);
                        badges[1] = new ImageIcon(scaledImg2);
                        badges[2] = new ImageIcon(scaledImg3);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    for (ImageIcon badge : badges) {
                        JLabel badgeLabel = new JLabel(badge);
                        badgeLabel.setHorizontalAlignment(JLabel.CENTER);
                        badgesPanel.removeAll();
                        badgesPanel.add(badgeLabel);
                        badgesPanel.revalidate();
                        badgesPanel.repaint();
                    }
                }
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(badgesPanel, BorderLayout.CENTER);
        panel.add(updateBadgesButton, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);
    }
}
