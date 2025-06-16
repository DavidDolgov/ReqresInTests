package dto;

import org.aeonbits.owner.Config;

@Config.Sources("file:E:\\JAVA\\TESTS\\ReqresInTests\\src\\test\\resources\\RegisterUsers.properties")
public interface RegisterUsers extends Config {
    @Key("baseUrl")
    String baseUrl();
    @Key("headerName")
    String headerName();
    @Key("headerValue")
    String headerValue();

    // for createdUserTest
    @Key("createdUserUrl")
    String createdUserUrl();
    @Key("statusCode201")
    int statusCode201();

    // for updateUserTest
    @Key("updateUserUrl")
    String updateUserUrl();
    @Key("statusCode200")
    int statusCode200();

    // for registerUserTest
    @Key("registerUserUrl")
    String registerUserUrl();
    @Key("statusCode400")
    int statusCode400();

    // for loginUserTest
    @Key("loginUserUrl")
    String loginUrl();

}
