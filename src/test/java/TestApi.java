import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class TestApi {


    @Test
    void getSingleResource(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("unknown/2")
                .then()
                .log().all()
                .statusCode(200);
    }
@Test
void createSingleUser(){
        String body = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";
        given()
         .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .body(body)
            .log().all()
            .when()
            .post("register")
            .then()
            .log().all()
            .statusCode(200)
                .body(not(emptyString()))
                .body("id", equalTo(4), "token", equalTo("QpwL5tke4Pnpja7X4"));

}
@Test
void unsuccessfulLogin(){
    String body = "{\n" +
            "    \"email\": \"peter@klaven\"\n" +
            "}";
    given()
            .baseUri("https://reqres.in/api")
            .contentType("application/json")
            .body(body)
            .log().all()
            .when()
            .post("login")
            .then()
            .log().all()
            .statusCode(400)
            .body(not(emptyString()))
            .body("error", equalTo("Missing password"));

}

@Test
    void updateUser(){
    String body = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"zion resident\"\n" +
            "}";
    given()
            .baseUri("https://reqres.in/api")
            .contentType("application/json")
            .body(body)
            .log().all()
            .when()
            .put("users/2")
            .then()
            .log().all()
            .statusCode(200)
            .body(not(emptyString()))
            .body("name", equalTo("morpheus"), "job", equalTo("zion resident"));
}


}
