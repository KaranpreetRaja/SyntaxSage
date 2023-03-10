package junit_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CustomComponents.Question;
import CustomComponents.Session;

class QuestionTest {
    String[] options1 = new String[]{"Milk", "Cheese", "Fruit"};
    String[] answers1 = new String[]{"Milk"};
    Question q1 = new Question("Testing1", options1, answers1);

    String[] options2 = new String[]{"Apple", "Pear", "Prune"};
    String[] answers2 = new String[]{"Prune"};
    Question q2 = new Question("Testing2", options2, answers2);

    Question[] questions = new Question[]{q1, q2};
    Session session = new Session("Test Session", 2, questions);

    @Test
    void isAnswerTest1() {
        Question qTest1 = session.getNextQuestion();
        assertTrue(qTest1.isAnswer("Prune"));
    }

    @Test
    void isAnswerTest2() {
        Question qTest1 = session.getNextQuestion();
        assertFalse(qTest1.isAnswer("Apple"));
    }

    @Test
    void isAnswerTest3() {
        Question qTest1 = session.getNextQuestion();
        assertFalse(qTest1.isAnswer("Milk"));
    }
}