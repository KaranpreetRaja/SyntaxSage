package GUI;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.*;
import org.commonmark.node.*;
import org.commonmark.parser.*;
import org.commonmark.renderer.html.*;

public class SyntaxDoc extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String HOME_URL = "https://quickref.me/";
    private static final String[] LANGUAGES = {"HTML", "CSS", "CPP", "Python", "Java"};
    private static final String[] LANGUAGE_URLS = {
        "https://raw.githubusercontent.com/Fechin/reference/main/source/_posts/html.md",
        "https://raw.githubusercontent.com/Fechin/reference/main/source/_posts/css3.md",
        "https://raw.githubusercontent.com/Fechin/reference/main/source/_posts/cpp.md",
        "https://raw.githubusercontent.com/Fechin/reference/main/source/_posts/python.md",
        "https://raw.githubusercontent.com/Fechin/reference/main/source/_posts/java.md"
    };

    private JEditorPane editorPane;
    private JPanel navPanel;

    public SyntaxDoc(String language) {
        super("SyntaxDoc");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change to DISPOSE_ON_CLOSE

        setMinimumSize(new java.awt.Dimension(700, 450));

        editorPane = new JEditorPane();
        editorPane.setEditable(false);
        // enable content rendering for markdown files
        editorPane.setContentType("text/html");
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
            URL pageUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) pageUrl.openConnection();
            connection.setRequestProperty("http.agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");// Add this line to set the user agent string

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                    content.append(System.lineSeparator());
                }
                in.close();

                Parser parser = Parser.builder().build();
                Node document = parser.parse(content.toString());

                HtmlRenderer renderer = HtmlRenderer.builder().build();
                String html = renderer.render(document);

                editorPane.setText(html);
            } else {
                System.err.println("Error loading " + url + ": " + responseCode + " " + connection.getResponseMessage());
                editorPane.setText("Error loading page: " + responseCode + " " + connection.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading " + url + ": " + e);
            editorPane.setText("Error loading page: " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        new SyntaxDoc("https://raw.githubusercontent.com/Fechin/reference/main/source/_posts/html.md"); // Pass the correct initial URL
    }
}
