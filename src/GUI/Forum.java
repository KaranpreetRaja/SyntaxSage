package GUI;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Forum extends JPanel {

    private DefaultListModel<String> discussionListModel;
    private JList<String> discussionList;
    private JButton postQuestionButton;
    private JButton postAnswerButton;

    public Forum() {
        setLayout(new BorderLayout());

        initComponents();
        loadData(); // Load existing data
        addComponentsToPanel();
    }
    
    private void saveData() {
        try {
            FileOutputStream fos = new FileOutputStream("forum_data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(discussionListModel);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        File file = new File("forum_data.ser");
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                discussionListModel = (DefaultListModel<String>) ois.readObject();
                discussionList.setModel(discussionListModel);
                ois.close();
                fis.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }



    private void initComponents() {
        discussionListModel = new DefaultListModel<>();
        discussionList = new JList<>(discussionListModel);
        discussionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        postQuestionButton = new JButton("Post Question");
        postQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String question = JOptionPane.showInputDialog("Enter your question:");
                if (question != null && !question.trim().isEmpty()) {
                    discussionListModel.addElement("Q: " + question);
                    saveData(); // Save data after a new question is added
                }
                
            }
        });

        postAnswerButton = new JButton("Post Answer");
        postAnswerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = discussionList.getSelectedIndex();
                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a question to answer.");
                    return;
                }

                String answer = JOptionPane.showInputDialog("Enter your answer:");
                if (answer != null && !answer.trim().isEmpty()) {
                    // Find the index of the last answer under the selected question
                    int lastAnswerIndex = selectedIndex + 1;
                    while (lastAnswerIndex < discussionListModel.size() &&
                            !discussionListModel.getElementAt(lastAnswerIndex).startsWith("Q: ")) {
                        lastAnswerIndex++;
                        
                    }

                    // Insert the new answer under the selected question
                    discussionListModel.add(lastAnswerIndex, "    A: " + answer);
                    saveData(); // Save data after a new answer is added
                }
            }
        });

    }

    private void addComponentsToPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(postQuestionButton);
        buttonPanel.add(postAnswerButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(discussionList), BorderLayout.CENTER);
    }
}
