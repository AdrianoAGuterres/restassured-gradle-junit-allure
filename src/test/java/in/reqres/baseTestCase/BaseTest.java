package in.reqres.baseTestCase;

import in.reqres.paths.Paths;
import org.junit.After;
import org.junit.Before;

import static io.restassured.RestAssured.baseURI;

public class BaseTest {
    @Before
    public void setup() {
        baseURI = Paths.BASE_URI;
    }

    @After
    public void teardown() {
        baseURI = "";
    }
}
