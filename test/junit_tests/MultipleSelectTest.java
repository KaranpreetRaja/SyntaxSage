package junit_tests;

import GUI.MultipleSelect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;

public class MultipleSelectTest {

    @Test
    void testPanelComponents() {
        MultipleSelect panel = new MultipleSelect();
        Component[] components = panel.getComponents();
        Assertions.assertEquals(3, components.length);
    }

    @Test
    void testTextArea() {
        MultipleSelect panel = new MultipleSelect();
        Component[] components = panel.getComponents();
        Assertions.assertTrue(components[0] instanceof JTextArea);
    }

    @Test
    void testJPanel() {
        MultipleSelect panel = new MultipleSelect();
        Component[] components = panel.getComponents();
        Assertions.assertTrue(components[1] instanceof JPanel);
    }

    @Test
    void testJButton() {
        MultipleSelect panel = new MultipleSelect();
        Component[] components = panel.getComponents();
        Assertions.assertTrue(components[2] instanceof JButton);
    }

    @Test
    void testButtonPanel() {
        MultipleSelect panel = new MultipleSelect();
        Component[] components = panel.getComponents();
        JPanel buttonPanel = null;
        for (Component component : components) {
            if (component instanceof JPanel) {
                buttonPanel = (JPanel) component;
                break;
            }
        }
        Assertions.assertNotNull(buttonPanel);
    }

    @Test
    void testCorrectAnswer() {
        MultipleSelect panel = new MultipleSelect();
        JButton submitButton = null;
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                submitButton = (JButton) component;
                break;
            }
        }
        assert submitButton != null;
        Assertions.assertEquals("Submit", submitButton.getText());
    }

}
