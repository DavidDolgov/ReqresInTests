package api;

import org.aeonbits.owner.Config;

@Config.Sources("file:E:\\JAVA\\TESTS\\ReqresInTests\\src\\test\\java\\resources\\RegisterUsers.properties")
public interface RegisterUsers extends Config {
    @Key("baseUrl")
    String baseUrl();

    // for createdUserTest
    @Key("createdUserUrl")
    String createdUserUrl();
    @Key("createdUserName")
    String name();
    @Key("createdUserJob")
    String job();

    // for updateUserTest
    @Key("updateUserUrl")
    String updateUserUrl();
    @Key("updateUserName")
    String updateName();
    @Key("updateUserJob")
    String updateJob();

    // for registerUserTest
    @Key("registerUserUrl")
    String registerUserUrl();
    @Key("registerUserId")
    int id();
    @Key("registerUserToken")
    String token();
    @Key("registerUserEmail")
    String email();
    @Key("registerUserPassword")
    String password();

    // for registerUnsuccessfulTest
    @Key("registerUnsuccessfulError")
    String unsuccessfulError();
    @Key("registerUnsuccessfulEmail")
    String unsuccessfulEmail();

    // for loginUserTest
    @Key("loginUserToken")
    String loginToken();
    @Key("loginUserEmail")
    String loginEmail();
    @Key("loginUserPassword")
    String loginPassword();

    // for loginUnsuccessfulTest
    @Key("loginUserUrl")
    String loginUrl();
    @Key("loginUnsuccessfulError")
    String loginUnsuccessfulError();
    @Key("loginUnsuccessfulEmail")
    String loginUnsuccessfulEmail();
}
