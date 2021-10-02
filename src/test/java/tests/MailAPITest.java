package tests;

import config.Credential;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MailAPITest {

    @Test
    void loginAPIPositiveTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .header("Referer", "https://mail.ru/")
                .cookie("act", "c6374ffd451443fcbdb0a9437ca353da")
                .formParam("login", Credential.config.email())
                .formParam("password", Credential.config.password())
                .formParam("token", Credential.config.token())
                .formParam("project", "e.mail.ru")
                .when()
                .post("https://auth.mail.ru/jsapi/auth")
                .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo("ok"));
    }

    @Test
    void loginAPINegativeTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .header("Referer", "https://mail.ru/")
                .cookie("act", "c6374ffd451443fcbdb0a9437ca353da")
                .formParam("login", Credential.config.wrongEmail())
                .formParam("password", Credential.config.password())
                .formParam("token", Credential.config.token())
                .formParam("project", "e.mail.ru")
                .when()
                .post("https://auth.mail.ru/jsapi/auth")
                .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo("fail"))
                .body("code", equalTo("auth"));
    }
}
