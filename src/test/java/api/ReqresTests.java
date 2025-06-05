package api;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;

import static io.restassured.RestAssured.given;

public class ReqresTests {
    public static final RegisterUsers APP = ConfigFactory.create(RegisterUsers.class);
    public static final String URL = APP.baseUrl();


    @Test
    public void createdUserTest() {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(201));

        String name = APP.name();
        String job = APP.job();
        UserData user = new UserData(APP.name(), APP.job());

        ResponseUserData response = given()
                .body(user)
                .when()
                .post(APP.createdUserUrl())
                .then().log().all()
                .extract().as(ResponseUserData.class);

        Assertions.assertEquals(name, response.getName());
        Assertions.assertEquals(job, response.getJob());

        String currentTime = Clock.systemUTC().instant().toString().substring(0, 18);
        Assertions.assertEquals(currentTime,response.getCreatedAt().substring(0, 18));
    }

    @Test
    public void updateUserTest() {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(200));

        String name = APP.updateName();
        String job = APP.updateJob();
        UserData user = new UserData(APP.updateName(), APP.updateJob());

        ResponseUpdateUserData response = given()
                .body(user)
                .when()
                .put(APP.updateUserUrl())
                .then().log().all()
                .extract().as(ResponseUpdateUserData.class);

        Assertions.assertEquals(name, response.getName());
        Assertions.assertEquals(job, response.getJob());

        String currentTime = Clock.systemUTC().instant().toString().substring(0, 18);
        Assertions.assertEquals(currentTime,response.getUpdatedAt().substring(0, 18));
    }

    @Test
    public void registerUserTest() {
       Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(200));

        int id = APP.id();
        String token = APP.token();
        RegisterUser user = new RegisterUser(APP.email(), APP.password());

        ResponseRegisterUser response = given()
                .body(user)
                .when()
                .post(APP.registerUserUrl())
                .then().log().all()
                .extract().as(ResponseRegisterUser.class);


        Assertions.assertEquals(id,response.getId());
        Assertions.assertEquals(token,response.getToken());
    }

    @Test
    public void registerUnsuccessfulTest() {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(400));

        String error = APP.unsuccessfulError();
        RegisterUser user = new RegisterUser(APP.unsuccessfulEmail(), "");

        UnsuccessfulRegister response = given()
                .body(user)
                .when()
                .post(APP.registerUserUrl())
                .then().log().all()
                .extract().as(UnsuccessfulRegister.class);

        Assertions.assertEquals(error,response.getError());
    }

    @Test
    public void loginUserTest() {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(200));

        String token = APP.loginToken();
        RegisterUser user = new RegisterUser(APP.loginEmail(), APP.loginPassword());

        ResponseRegisterUser response = given()
                .body(user)
                .when()
                .post(APP.loginUrl())
                .then().log().all()
                .extract().as(ResponseRegisterUser.class);

        Assertions.assertEquals(token,response.getToken());
    }

    @Test
    public void loginUnsuccessfulTest() {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(400));

        String error = APP.loginUnsuccessfulError();
        RegisterUser user = new RegisterUser(APP.loginUnsuccessfulEmail(), "");

        UnsuccessfulRegister response = given()
                .body(user)
                .when()
                .post(APP.loginUrl())
                .then().log().all()
                .extract().as(UnsuccessfulRegister.class);

        Assertions.assertEquals(error,response.getError());
    }
}
