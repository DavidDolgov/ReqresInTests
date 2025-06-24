package dto;

import org.aeonbits.owner.Config;

@Config.Sources("file:E:\\JAVA\\TESTS\\ReqresInTests\\src\\test\\resources\\ConfigPostgres.properties")
public interface ConfigPostgres extends Config{
    @Key("url")
    String url();
    @Key("user")
    String user();
    @Key("password")
    String password();
}
