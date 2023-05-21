package classwork.day19;

import org.junit.runner.JUnitCore;

public class JUnit4Runner {
    public static void main (String[] args) {
        JUnitCore runner = new JUnitCore();
        runner.addListener(new MyJUnit4Listener());
        runner.run(JUnitTestClass.class);
    }
}
