package GUI;

import javax.swing.*;

import CustomComponents.Account;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SessionFrame extends javax.swing.JFrame {

    /**
     * Creates new form SessionFrame
     */
    public SessionFrame() {
        initComponents();
    }
    
    public SessionFrame(Account acc) {
    	initComponents(acc);
        
    }
    
    public void initComponents(Account acc) {
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        MultipleChoice q = new MultipleChoice(acc, 0); // show question
        jTabbedPane1.addTab("Question", q);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        // start session in the center of the screen
        setLocationRelativeTo(null);

        pack();
        setMinimumSize(new java.awt.Dimension(700, 450));
    } 

    public void initComponents() {

        JTabbedPane jTabbedPane1 = new JTabbedPane();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        MultipleChoice q = new MultipleChoice(); // show question
        jTabbedPane1.addTab("Question", q);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        // start session in the center of the screen
        setLocationRelativeTo(null);

        pack();
        setMinimumSize(new java.awt.Dimension(700, 450));
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(SessionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SessionFrame().setVisible(true);
                
            }
        });
    }
}
