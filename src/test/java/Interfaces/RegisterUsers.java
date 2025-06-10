package Interfaces;

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
    @Key("registerUserEmail")
    String email();
    @Key("registerUserPassword")
    String password();

    // for registerUnsuccessfulTest
    @Key("registerUnsuccessfulEmail")
    String unsuccessfulEmail();

    // for loginUserTest
    @Key("loginUserEmail")
    String loginEmail();
    @Key("loginUserPassword")
    String loginPassword();

    // for loginUnsuccessfulTest
    @Key("loginUserUrl")
    String loginUrl();
    @Key("loginUnsuccessfulEmail")
    String loginUnsuccessfulEmail();
}
