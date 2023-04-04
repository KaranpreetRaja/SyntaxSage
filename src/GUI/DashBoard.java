package GUI;

import CustomComponents.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

public class DashBoard extends javax.swing.JFrame {
    private Account acc;

    public DashBoard(Account acc) throws SQLException {
        this.acc = acc;
        initComponents();
    }

    public DashBoard() throws SQLException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() throws SQLException {

        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton(); // documentation button
        JPanel progressPanel = new JPanel();
        ProgressGUI progressBar = new ProgressGUI(acc);
        progressPanel.add(progressBar);
        jPanel3 = new javax.swing.JPanel();
        JLabel badgeLabel = new JLabel("Badges:");
        BadgeGUI badgeGUI = new BadgeGUI(acc);
        JPanel badgePanel = new JPanel();
        badgePanel.add(badgeLabel);
        badgePanel.add(badgeGUI);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Python", "Java", "C++"}));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);
        jComboBox1.setSelectedItem(acc.currentCourse());

        jLabel1.setText("Lesson 1");
        jButton1.setText("Start Lesson");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("View Docs");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jPanel2.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        // Add the jLabel1 to jPanel2
        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanel2.add(jLabel1, gbc);

        // Add some horizontal space
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 10); // 10 pixels of padding on the left and right
        jPanel2.add(Box.createHorizontalStrut(10), gbc);

        // Add the jButton1 to jPanel2
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10); // 10 pixels of padding on the right
        jPanel2.add(jButton1, gbc);

        // Add the progressPanel to jPanel2
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 0, 0, 0);
        jPanel2.add(progressPanel, gbc);


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );


        jTabbedPane1.addTab("Learning", jPanel1);

        jLabel2.setText(String.format("Username: %s", acc.getUsername()));

        jLabel3.setText(String.format("Account Creation Date: %s", acc.getCreationDate()));

        jLabel4.setText(String.format("Account ID: %s", acc.getUsername()));

        jLabel5.setText(String.format("Courses: %s", acc.currentCourse()));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(badgePanel)) // Add badgePanel to jPanel3
                                .addContainerGap(560, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(badgePanel) // Add badgePanel to jPanel3
                                .addContainerGap(229, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Account", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane1)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane1)
                                .addContainerGap())
        );

        pack();
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Get the selected item from the combo box
            String selectedClass = Objects.requireNonNull(jComboBox1.getSelectedItem()).toString();
            if (!Objects.equals(selectedClass, acc.currentCourse())) {

                // Get the current username from the getUsername method
                String currentUsername = acc.getUsername();
                Connection con = DriverManager.getConnection("jdbc:mysql://140.238.154.147:3306/project", "user", "Eecs2311!");
                PreparedStatement ps = con.prepareStatement("UPDATE account SET classes = ? WHERE username = ?");

                ps.setString(1, selectedClass);
                ps.setString(2, currentUsername);
                ps.executeUpdate();
                System.out.println(currentUsername + " " + selectedClass);
                System.out.println("Updated the database successfully!");
                System.out.println(acc.currentCourse());
                jLabel5.setText(String.format("Courses: %s", selectedClass));

                ps.close();
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        SessionFrame sf = new SessionFrame(acc);
        sf.setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        new GUI.SyntaxDoc("https://raw.githubusercontent.com/Fechin/reference/main/source/_posts/python.md");
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                 InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DashBoard().setVisible(true);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


    // Ignore for now, this will be used in future iterations
    public void createSession() {
        Question q1 = new Question("prompt 1", Arrays.asList("Option 1", "Option 2 (ans)", "Option 3", "Option 4 (ans)"), Arrays.asList("Option 2 (ans)", "Option 4 (ans)"));
        Question q2 = new Question("prompt 2", Arrays.asList("Option 1", "Option 2 (ans)", "Option 3 (ans)", "Option 4"), Arrays.asList("Option 2 (ans)", "Option 3 (ans)"));
        Question[] qes = new Question[]{q1, q2};
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration                   
}
