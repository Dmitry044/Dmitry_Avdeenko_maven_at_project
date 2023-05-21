package homework.day15.runners;


import homework.day15.tests.junit4.BookingTests;
import homework.day15.tests.junit4.DemoQATests;
import homework.day15.tests.junit4.W3SchoolsTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingTests.class, DemoQATests.class, W3SchoolsTests.class})

public class JunitRunner {
}
