package integration_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import CustomComponents.Account;
import org.junit.Before;
import org.junit.Test;
import GUI.ProgressGUI;

public class ProgressTest {

    private ProgressGUI progressGUI;
    private Account acc;

    @Before
    public void setUp() {
        acc = new Account("test", "test", "Python", "Master", "March 10, 2023");
        progressGUI = new ProgressGUI(acc);
    }

    @Test
    public void testProgressBarMinValue() {
        assertEquals(0, progressGUI.progressBar.getMinimum());
    }

    @Test
    public void testProgressBarMaxValue() {
        assertEquals(100, progressGUI.progressBar.getMaximum());
    }

    @Test
    public void testUpdateProgressButtonEnabledInitially() {
        assertTrue(progressGUI.updateProgressButton.isEnabled());
    }

    @Test
    public void testUpdateProgressButtonEnabledAfterClick() {
        progressGUI.updateProgressButton.doClick();
        assertTrue(progressGUI.updateProgressButton.isEnabled());
    }

    @Test
    public void testProgressValueNotIncreasedWhenExperienceNotMaster() throws InterruptedException {
        acc.setExperience("Beginner");
        progressGUI.updateProgressButton.doClick();
        Thread.sleep(100); // Wait for timer to update progress bar
        assertEquals(0, progressGUI.progressBar.getValue());
    }
}
