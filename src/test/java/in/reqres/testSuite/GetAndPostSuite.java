package in.reqres.testSuite;


import in.reqres.testCases.GetTestCase;
import in.reqres.testCases.PostTestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GetTestCase.class,
        PostTestCase.class
})
public class GetAndPostSuite {
}

