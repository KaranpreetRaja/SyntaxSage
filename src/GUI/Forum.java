package GUI;

import CustomComponents.Account;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Forum extends JPanel {

    private DefaultListModel<String> discussionListModel;
    private JList<String> discussionList;
    private JButton postQuestionButton;
    private JButton postAnswerButton;
    private Connection connection;
    private Account acc;

    public Forum(Account acc) {
        this.acc = acc;
        setLayout(new BorderLayout());
        initComponents();
        establishConnection(); // Connect to the MySQL database
        loadData(); // Load existing data from the database
        addComponentsToPanel();
    }

    private void establishConnection() {
        String url = "jdbc:mysql://140.238.154.147:3306/project";
        String user = "user";
        String password = "Eecs2311!";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        try {
            // Start a transaction
            connection.setAutoCommit(false);

            // Insert each new question and answer as a single row
            int questionId = -1;
            for (int i = 0; i < discussionListModel.size(); i++) {
                String item = discussionListModel.get(i);
                if (item.startsWith("Q: ")) {
                    // Check if the question has already been added
                    if (i > 0 && discussionListModel.get(i - 1).startsWith("Q: ")) {
                        continue;
                    }
                    // Check if the question already exists in the database
                    PreparedStatement checkQuestion = connection.prepareStatement("SELECT id FROM discussion WHERE question = ?");
                    checkQuestion.setString(1, item.substring(3));
                    ResultSet rs = checkQuestion.executeQuery();
                    if (rs.next()) {
                        questionId = rs.getInt(1);
                    } else {
                        // Insert the new question
                        PreparedStatement insertQuestion = connection.prepareStatement("INSERT INTO discussion (question) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                        insertQuestion.setString(1, item.substring(3));
                        insertQuestion.executeUpdate();

                        // Get the ID of the newly-inserted question
                        ResultSet keys = insertQuestion.getGeneratedKeys();
                        if (keys.next()) {
                            questionId = keys.getInt(1);
                        }
                    }
                } else if (item.startsWith("    A: ")) {
                    if (questionId != -1) {
                        // Check if the answer has already been added
                        if (discussionListModel.get(i - 1).startsWith("    A: ")) {
                            continue;
                        }
                        // Insert the new answer for the current question
                        PreparedStatement insertAnswer = connection.prepareStatement("UPDATE discussion SET answer = ? WHERE id = ?");
                        insertAnswer.setString(1, item.substring(6));
                        insertAnswer.setInt(2, questionId);
                        insertAnswer.executeUpdate();
                    }
                }
            }

            // Commit the transaction
            connection.commit();
        } catch (SQLException e) {
            // Roll back the transaction on error
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }



    private void loadData() {
        discussionListModel = new DefaultListModel<>();
        discussionList.setModel(discussionListModel);

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM discussion ORDER BY id");

            int currentQuestionId = -1;
            String currentQuestion = null;
            String currentAnswer = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String question = resultSet.getString("question");
                String answer = resultSet.getString("answer");

                if (question != null) {
                    if (currentQuestionId != -1) {
                        // Add the previous question and answer pair to the list model
                        discussionListModel.addElement("Q: " + currentQuestion);
                        if (currentAnswer != null) {
                            discussionListModel.addElement("    A: " + currentAnswer);
                        }
                    }
                    // Start a new question and answer pair
                    currentQuestionId = id;
                    currentQuestion = question;
                    currentAnswer = answer;
                } else if (answer != null && currentQuestionId == id) {
                    // Add an additional answer to the current question
                    if (currentAnswer == null) {
                        currentAnswer = answer;
                    } else {
                        currentAnswer += "\n" + answer;
                    }
                }
            }

            // Add the last question and answer pair to the list model
            if (currentQuestionId != -1) {
                discussionListModel.addElement("Q: " + currentQuestion);
                if (currentAnswer != null) {
                    discussionListModel.addElement("    A: " + currentAnswer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void initComponents() {
        discussionList = new JList<>();
        discussionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        postQuestionButton = new JButton("Post Question");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = currentDate.format(formatter);
        postQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String question = JOptionPane.showInputDialog("Enter your question:");
                if (question != null && !question.trim().isEmpty()) {
                    discussionListModel.addElement("Q: " + question + " (Posted by " + acc.getUsername() + ", " + formattedDate + ")");
                    saveData(); // Save data to the database after a new question is added
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

                // Check if the selected question already has an answer
                boolean hasAnswer = false;
                int i = selectedIndex + 1;
                while (i < discussionListModel.size() && !discussionListModel.getElementAt(i).startsWith("Q: ")) {
                    if (discussionListModel.getElementAt(i).startsWith("    A: ")) {
                        hasAnswer = true;
                        break;
                    }
                    i++;
                }

                if (hasAnswer) {
                    JOptionPane.showMessageDialog(null, "This question has already been answered.");
                    return;
                }

                String answer = JOptionPane.showInputDialog("Enter your answer:");
                if (answer != null && !answer.trim().isEmpty()) {
                    // Find the index of the last answer under the selected question
                    int lastAnswerIndex = selectedIndex + 1;
                    while (lastAnswerIndex < discussionListModel.size() && !discussionListModel.getElementAt(lastAnswerIndex).startsWith("Q: ")) {
                        lastAnswerIndex++;

                    }

                    // Insert the new answer under the selected question
                    discussionListModel.add(lastAnswerIndex, "    A: " + answer + " (Posted by " + acc.getUsername() + ", " + formattedDate + ")");
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
