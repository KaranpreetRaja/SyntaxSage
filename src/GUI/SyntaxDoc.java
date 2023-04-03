package GUI;
import java.awt.*;
import java.io.*;
import java.net.URL;
import javax.swing.*;

public class SyntaxDoc extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String HOME_URL = "https://quickref.me/";
    private static final String[] LANGUAGES = {"HTML", "CSS", "CPP", "Python", "Java"};
    private static final String[] LANGUAGE_URLS = {
        "https://quickref.me/html",
        "https://quickref.me/css",
        "https://quickref.me/cpp",
        "https://quickref.me/python",
        "https://quickref.me/java"
    };

    private JEditorPane editorPane;
    private JPanel navPanel;

    public SyntaxDoc(String language) {
        super("SyntaxDoc");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setMinimumSize(new java.awt.Dimension(700, 450));

        editorPane = new JEditorPane();
        editorPane.setEditable(false);
        editorPane.setContentType("text/html"); // Enable proper content rendering
        loadPage(language);

        JScrollPane scrollPane = new JScrollPane(editorPane);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panel);

        navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        navPanel.setPreferredSize(new Dimension(200, 0));
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 0; i < LANGUAGES.length; i++) {
            JButton button = new JButton(LANGUAGES[i]);
            final int index = i;
            button.addActionListener(event -> loadPage(LANGUAGE_URLS[index]));
            navPanel.add(button);
        }
        getContentPane().add(navPanel, BorderLayout.WEST);

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Open in full-screen mode
        setVisible(true);
    }

    private void loadPage(String url) {
        if (editorPane == null) {
            System.err.println("Editor pane is null");
            return;
        }

        try {
            editorPane.setPage(new URL(url));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading " + url + ": " + e);
            editorPane.setText("Error loading page.");
        }
    }

    public static void main(String[] args) {
        new SyntaxDoc("https://quickref.me/html"); // Pass the correct initial URL
    }
}
