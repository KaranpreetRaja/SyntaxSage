package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import CustomComponents.Account;

public class BadgeGUI extends JPanel {
    private static final long serialVersionUID = 6098546007197585733L;
    private JLabel label;
    private JButton updateBadgesButton;
    private ImageIcon[] badges;

    public BadgeGUI(Account acc) {
        super(new BorderLayout());
        this.acc = acc;

        label = new JLabel("Badges");
        label.setHorizontalAlignment(JLabel.CENTER);

        JPanel badgesPanel = new JPanel(new GridLayout(1, 3));
        badgesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if (acc.getExperience().equals("Master")) {
            badges = new ImageIcon[3];
            badges[0] = new ImageIcon(new File("Assets/PythonBadge-1.png").getAbsolutePath());
            badges[1] = new ImageIcon(new File("Assets/PythonBadge-2.png").getAbsolutePath());
            badges[2] = new ImageIcon(new File("Assets/PythonBadge-3.png").getAbsolutePath());

            for (int i = 0; i < badges.length; i++) {
                JLabel badgeLabel = new JLabel(badges[i]);
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
                    badges[0] = new ImageIcon(new File("Assets/PythonBadge-1.png").getAbsolutePath());
                    badges[1] = new ImageIcon(new File("Assets/PythonBadge-2.png").getAbsolutePath());
                    badges[2] = new ImageIcon(new File("Assets/PythonBadge-3.png").getAbsolutePath());

                    for (int i = 0; i < badges.length; i++) {
                        JLabel badgeLabel = new JLabel(badges[i]);
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
