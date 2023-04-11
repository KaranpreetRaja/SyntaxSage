package integration_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import GUI.SyntaxDoc;
import org.junit.Before;
import org.junit.Test;

public class SyntaxDocTest {

    private SyntaxDoc syntaxDoc;

    @Before
    public void setUp() throws Exception {
        syntaxDoc = new SyntaxDoc(SyntaxDoc.HOME_URL);
    }

    @Test
    public void testEditorPaneNotNull() {
        assertNotNull(syntaxDoc.editorPane);
    }

    @Test
    public void testLoadPage() {
        syntaxDoc.loadPage(SyntaxDoc.HOME_URL);
        assertNotNull(syntaxDoc.editorPane.getText());
    }

    @Test
    public void testLoadNonexistentPage() {
        syntaxDoc.loadPage("https://www.example.com/nonexistent");
        assertEquals("<html>\n" +
                "  <head>\n" +
                "    \n" +
                "  </head>\n" +
                "  <body>\n" +
                "    Error loading page: 404 Not Found\n" +
                "  </body>\n" +
                "</html>\n", syntaxDoc.editorPane.getText());
    }

    @Test
    public void testLoadUnsupportedPage() {
        syntaxDoc.loadPage("https://www.google.com/");
        assertEquals("<html>\n" +
                "  <head>\n" +
                "\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <pre></pre>\n" +
                "  </body>\n" +
                "</html>\n", syntaxDoc.editorPane.getText());
    }
}
