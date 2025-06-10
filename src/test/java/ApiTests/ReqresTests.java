package ApiTests;

import DTO.*;
import Interfaces.RegisterUsers;
import Specifications.Specifications;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class ReqresTests {
    public static final RegisterUsers application = ConfigFactory.create(RegisterUsers.class);
    public static final String URL = application.baseUrl();


    @ParameterizedTest
    @CsvFileSource(resources = "/createdUserTest.csv")
    public void createdUserTest(int statusCode, String name, String job) {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(statusCode));

        UserData user = new UserData(application.name(), application.job());

        ResponseUserData response = given()
                .body(user)
                .when()
                .post(application.createdUserUrl())
                .then().log().all()
                .extract().as(ResponseUserData.class);

        Assertions.assertEquals(name, response.getName());
        Assertions.assertEquals(job, response.getJob());

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime updatedDate = LocalDateTime.parse(response.getCreatedAt(), DateTimeFormatter.ISO_DATE_TIME);

        Assertions.assertEquals(String.valueOf(currentTime).substring(0, 18),String.valueOf(updatedDate).substring(0, 18));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/updateUserTest.csv")
    public void updateUserTest(int statusCode, String name, String job) {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(statusCode));

        UserData user = new UserData(application.updateName(), application.updateJob());

        ResponseUpdateUserData response = given()
                .body(user)
                .when()
                .put(application.updateUserUrl())
                .then().log().all()
                .extract().as(ResponseUpdateUserData.class);

        Assertions.assertEquals(name, response.getName());
        Assertions.assertEquals(job, response.getJob());

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime updatedDate = LocalDateTime.parse(response.getUpdatedAt(), DateTimeFormatter.ISO_DATE_TIME);

        Assertions.assertEquals(String.valueOf(currentTime).substring(0, 18),String.valueOf(updatedDate).substring(0, 18));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registerUserTest.csv")
    public void registerUserTest(int statusCode, int id, String token) {
       Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(statusCode));

        RegisterUser user = new RegisterUser(application.email(), application.password());

        ResponseRegisterUser response = given()
                .body(user)
                .when()
                .post(application.registerUserUrl())
                .then().log().all()
                .extract().as(ResponseRegisterUser.class);


        Assertions.assertEquals(id,response.getId());
        Assertions.assertEquals(token,response.getToken());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registerUnsuccessfulTest.csv")
    public void registerUnsuccessfulTest(int statusCode, String error) {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(statusCode));

        RegisterUser user = new RegisterUser(application.unsuccessfulEmail(), "");

        UnsuccessfulRegister response = given()
                .body(user)
                .when()
                .post(application.registerUserUrl())
                .then().log().all()
                .extract().as(UnsuccessfulRegister.class);

        Assertions.assertEquals(error,response.getError());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/loginUserTest.csv")
    public void loginUserTest(int statusCode, String token) {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(statusCode));

        RegisterUser user = new RegisterUser(application.loginEmail(), application.loginPassword());

        ResponseRegisterUser response = given()
                .body(user)
                .when()
                .post(application.loginUrl())
                .then().log().all()
                .extract().as(ResponseRegisterUser.class);

        Assertions.assertEquals(token,response.getToken());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/loginUnsuccessfulTest.csv")
    public void loginUnsuccessfulTest(int statusCode, String error) {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(statusCode));

        RegisterUser user = new RegisterUser(application.loginUnsuccessfulEmail(), "");

        UnsuccessfulRegister response = given()
                .body(user)
                .when()
                .post(application.loginUrl())
                .then().log().all()
                .extract().as(UnsuccessfulRegister.class);

        Assertions.assertEquals(error,response.getError());
    }
}
