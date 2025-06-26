import dto.*;
import dto.RegisterUsers;
import specifications.Specifications;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class ReqresTests {
    public static final RegisterUsers application = ConfigFactory.create(RegisterUsers.class);
    public static final String URL = application.baseUrl();

    @ParameterizedTest
    @CsvFileSource (resources = "/createdUserTest.csv")
    public void createdUserTest(String name, String job)  {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(application.statusCode201()));

        UserData user = new UserData(name, job);

        ResponseUserData response = given()
                .header(application.headerName(), application.headerValue())
                .body(user)
                .when()
                .post(application.createdUserUrl())
                .then().log().all()
                .extract().as(ResponseUserData.class);


        Assertions.assertEquals(name, response.getName());
        Assertions.assertEquals(job, response.getJob());

        LocalDateTime currentTime = LocalDateTime.now().minusHours(3);
        LocalDateTime updatedDate = LocalDateTime.parse(response.getCreatedAt(), DateTimeFormatter.ISO_DATE_TIME);


        Assertions.assertEquals(String.valueOf(currentTime).substring(0, 18),String.valueOf(updatedDate).substring(0, 18));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/createdUserTest.csv")
    public void updateUserTest(String name, String job) {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(application.statusCode200()));

        UserData user = new UserData(name, job);

        ResponseUpdateUserData response = given()
                .header(application.headerName(), application.headerValue())
                .body(user)
                .when()
                .put(application.updateUserUrl())
                .then().log().all()
                .extract().as(ResponseUpdateUserData.class);

        Assertions.assertEquals(name, response.getName());
        Assertions.assertEquals(job, response.getJob());

        LocalDateTime currentTime = LocalDateTime.now().minusHours(3);
        LocalDateTime updatedDate = LocalDateTime.parse(response.getUpdatedAt(), DateTimeFormatter.ISO_DATE_TIME);

        Assertions.assertEquals(String.valueOf(currentTime).substring(0, 18),String.valueOf(updatedDate).substring(0, 18));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registerUserTest.csv")
    public void registerUserTest(String email, String password, String token, int id) {
       Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(application.statusCode200()));

        RegisterUser user = new RegisterUser(email, password);

        ResponseRegisterUser response = given()
                .header(application.headerName(), application.headerValue())
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
    public void registerUnsuccessfulTest(String email,String password, String error) {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(application.statusCode400()));

        RegisterUser user = new RegisterUser(email, password);

        UnsuccessfulRegister response = given()
                .header(application.headerName(), application.headerValue())
                .body(user)
                .when()
                .post(application.registerUserUrl())
                .then().log().all()
                .extract().as(UnsuccessfulRegister.class);

        Assertions.assertEquals(error,response.getError());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registerUserTest.csv")
    public void loginUserTest(String email,String password, String token) {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(application.statusCode200()));

        RegisterUser user = new RegisterUser(email, password);

        ResponseRegisterUser response = given()
                .header(application.headerName(), application.headerValue())
                .body(user)
                .when()
                .post(application.loginUrl())
                .then().log().all()
                .extract().as(ResponseRegisterUser.class);

        Assertions.assertEquals(token,response.getToken());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registerUnsuccessfulTest.csv")
    public void loginUnsuccessfulTest(String email,String password, String error) {
        Specifications.installRequestSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUniq(application.statusCode400()));

        RegisterUser user = new RegisterUser(email, password);

        UnsuccessfulRegister response = given()
                .header(application.headerName(), application.headerValue())
                .body(user)
                .when()
                .post(application.loginUrl())
                .then().log().all()
                .extract().as(UnsuccessfulRegister.class);

        Assertions.assertEquals(error,response.getError());
    }
}
