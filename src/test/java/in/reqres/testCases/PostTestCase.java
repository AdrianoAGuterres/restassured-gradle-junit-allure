package in.reqres.testCases;


import in.reqres.paths.Paths;
import in.reqres.baseTestCase.BaseTest;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class PostTestCase extends BaseTest {

    @Test
    public void postCreateTest() {
        Fairy fairy = Fairy.create(Locale.FRANCE);
        Person person = fairy.person();

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("name", person.getFirstName());
        jsonBody.put("job", "QA Developer");

        given()
                .body(jsonBody.toJSONString())
                .when()
                .log().ifValidationFails()
                .post(Paths.USERS_PATH)
                .then()
                .log().ifValidationFails()
                .statusCode(201)
                .body(containsString("createdAt"));
    }

    @Test
    public void patchUpdateTest() {
        Fairy fairy = Fairy.create(Locale.CANADA);
        Person person = fairy.person();

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("name", person.getFirstName());
        jsonBody.put("job", "QA Developer");

        given()
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .patch(Paths.USERS_PATH+"/100")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .contentType("application/json")
                .body("name", is(person.getFirstName()))
                .body("job", is("QA Developer"))
                .body(containsString("updatedAt"));

    }
}
