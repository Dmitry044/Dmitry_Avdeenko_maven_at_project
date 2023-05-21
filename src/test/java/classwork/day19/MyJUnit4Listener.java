package classwork.day19;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;


public class MyJUnit4Listener extends RunListener {

    boolean isFailed;

    public void testStarted(Description description) throws Exception {
        System.out.println("Executing test: " + description.getDisplayName());
        //description.getAnnotations().forEach(System.out::println);
        String id = description.getAnnotation(TestCaseId.class).id();
        System.out.println("Test ID is: " + id);
    }

    public void testFailure(Failure failure) throws Exception {
        //failure.getDescription().getAnnotations().forEach (System.out::println);
        isFailed = true;
        System.out.println("Failed test: " + failure.getDescription().getDisplayName());
        String id = failure.getDescription().getAnnotation(TestCaseId.class).id();

        TestRailReporter.reportResult("2206", id, new Result(5));
    }

    public void testFinished(Description description) throws Exception {
        //description.
        if (!isFailed) {
            String id = description.getAnnotation(TestCaseId.class).id();
            TestRailReporter.reportResult("2206", id, new Result(1));
        }

        System.out.println("Finishing test: " + description.getDisplayName());
        //description.getAnnotations().forEach(System.out::println);
        isFailed = false;
    }


}
