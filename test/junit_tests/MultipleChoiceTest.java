package junit_tests;

import GUI.MultipleChoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;

public class MultipleChoiceTest {

    @Test
    void testPanelComponents() {
        MultipleChoice panel = new MultipleChoice();
        Component[] components = panel.getComponents();
        Assertions.assertEquals(3, components.length);
    }

    @Test
    void testTextArea() {
        MultipleChoice panel = new MultipleChoice();
        Component[] components = panel.getComponents();
        Assertions.assertTrue(components[0] instanceof JTextArea);
    }

    @Test
    void testJPanel() {
        MultipleChoice panel = new MultipleChoice();
        Component[] components = panel.getComponents();
        Assertions.assertTrue(components[1] instanceof JPanel);
    }

    @Test
    void testJButton() {
        MultipleChoice panel = new MultipleChoice();
        Component[] components = panel.getComponents();
        Assertions.assertTrue(components[2] instanceof JButton);
    }

    @Test
    void testButtonPanel() {
        MultipleChoice panel = new MultipleChoice();
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
    void testSubmitButtonNotNull() {
        MultipleChoice panel = new MultipleChoice();
        JButton submitButton = null;
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                submitButton = (JButton) component;
                break;
            }
        }
        Assertions.assertNotNull(submitButton);
    }
}
