package junit_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import CustomComponents.Question;

public class QuestionTest {

    private Question question;

    @Before
    public void setUp() {
        String prompt = "What is the best language of the three?";
        String[] options = {"Python", "Java", "PHP"};
        String[] answers = {"Python"};
        List<String> optionsList = Arrays.asList(options);
        List<String> answersList = Arrays.asList(answers);
        question = new Question(prompt, optionsList, answersList);
    }

    @Test
    public void testSetId() {
        question.setId(1);
        int expected = 1;
        int actual = question.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCurId() {
        int expected = 1;
        int actual = Question.getCurId();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetCurId() {
        Question.setCurId(10);
        int expected = 10;
        int actual = Question.getCurId();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNoAns() {
        int expected = 0;
        int actual = question.getNoAns();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetNoAns() {
        question.setNoAns(1);
        int expected = 1;
        int actual = question.getNoAns();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrompt() {
        String expected = "What is the best language of the three?";
        String actual = question.getPrompt();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetPrompt() {
        question.setPrompt("What is the best language?");
        String expected = "What is the best language?";
        String actual = question.getPrompt();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetOptions() {
        String[] newOptions = {"Python", "Java", "PHP"};
        question.setOptions(newOptions);
        List<String> expected = Arrays.asList("Python", "Java", "PHP");
        List<String> actual = question.getOptions();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAnswers() {
        List<String> expected = Arrays.asList("Python");
        List<String> actual = question.getAnswers();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetAnswers() {
        String[] newAnswers = {"Java"};
        question.setAnswers(newAnswers);
        List<String> expected = Arrays.asList("Java");
        List<String> actual = question.getAnswers();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsAnswerWithCorrectAnswer() {
        boolean actual = question.isAnswer("Python");
        assertTrue(actual);
    }

    @Test
    public void testIsAnswerWithWrongAnswer() {
        boolean actual = question.isAnswer("Java");
        assertFalse(actual);
    }
}