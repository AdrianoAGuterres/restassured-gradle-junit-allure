package in.reqres.testCases;


import in.reqres.paths.Paths;
import in.reqres.baseTestCase.BaseTest;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetTestCase extends BaseTest {

    @Test
    public void getListUsersTest() {
        int usersPage = 1;

        int user1Id = 1;
        String user1Email = "george.bluth@reqres.in";
        String user1FirstName = "George";
        String user1LastName = "Bluth";
        String user1Avatar = "https://reqres.in/img/faces/1-image.jpg";

        int user2Id = 2;
        String user2Email = "janet.weaver@reqres.in";
        String user2FirstName = "Janet";
        String user2LastName = "Weaver";
        String user2Avatar = "https://reqres.in/img/faces/2-image.jpg";

        int user3Id = 3;
        String user3Email = "emma.wong@reqres.in";
        String user3FirstName = "Emma";
        String user3LastName = "Wong";
        String user3Avatar = "https://reqres.in/img/faces/3-image.jpg";

        int user4Id = 4;
        String user4Email = "eve.holt@reqres.in";
        String user4FirstName = "Eve";
        String user4LastName = "Holt";
        String user4Avatar = "https://reqres.in/img/faces/4-image.jpg";

        int user5Id = 5;
        String user5Email = "charles.morris@reqres.in";
        String user5FirstName = "Charles";
        String user5LastName = "Morris";
        String user5Avatar = "https://reqres.in/img/faces/5-image.jpg";

        int user6Id = 6;
        String user6Email = "tracey.ramos@reqres.in";
        String user6FirstName = "Tracey";
        String user6LastName = "Ramos";
        String user6Avatar = "https://reqres.in/img/faces/6-image.jpg";

        given()
                .when()
                .get(Paths.USERS_PAGE_PATH + usersPage)
                .then()
                .log().ifValidationFails()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("page", is(usersPage))
                .body("per_page", is(6))

                .body("data[0].id", is(user1Id))
                .body("data[0].email", is(user1Email))
                .body("data[0].first_name", is(user1FirstName))
                .body("data[0].last_name", is(user1LastName))
                .body("data[0].avatar", is(user1Avatar))

                .body("data[1].id", is(user2Id))
                .body("data[1].email", is(user2Email))
                .body("data[1].first_name", is(user2FirstName))
                .body("data[1].last_name", is(user2LastName))
                .body("data[1].avatar", is(user2Avatar))

                .body("data[2].id", is(user3Id))
                .body("data[2].email", is(user3Email))
                .body("data[2].first_name", is(user3FirstName))
                .body("data[2].last_name", is(user3LastName))
                .body("data[2].avatar", is(user3Avatar))

                .body("data[3].id", is(user4Id))
                .body("data[3].email", is(user4Email))
                .body("data[3].first_name", is(user4FirstName))
                .body("data[3].last_name", is(user4LastName))
                .body("data[3].avatar", is(user4Avatar))

                .body("data[4].id", is(user5Id))
                .body("data[4].email", is(user5Email))
                .body("data[4].first_name", is(user5FirstName))
                .body("data[4].last_name", is(user5LastName))
                .body("data[4].avatar", is(user5Avatar))

                .body("data[5].id", is(user6Id))
                .body("data[5].email", is(user6Email))
                .body("data[5].first_name", is(user6FirstName))
                .body("data[5].last_name", is(user6LastName))
                .body("data[5].avatar", is(user6Avatar));
    }

    @Test
    public void getSingleUserTest() {
        int user1Id = 1;
        String user1Email = "george.bluth@reqres.in";
        String user1FirstName = "George";
        String user1LastName = "Bluth";
        String user1Avatar = "https://reqres.in/img/faces/1-image.jpg";

        given()
                .when()
                .get("/api/users/1")
                .then()
                .log().ifValidationFails()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("data.id", is(user1Id))
                .body("data.email", is(user1Email))
                .body("data.first_name", is(user1FirstName))
                .body("data.last_name", is(user1LastName))
                .body("data.avatar", is(user1Avatar));
    }
}
