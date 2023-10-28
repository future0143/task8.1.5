package config;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.$;

public interface ConfigSetup {

    String url = TestProperties.getValue("test.url");

    @BeforeAll
    static void setup() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        WebDriverManager.firefoxdriver().setup();

        Configuration.browserSize = "1150x850";
        Configuration.timeout = 15000;
    }

    @BeforeEach
    default void openBrowser() {
        Selenide.open(url);

        $(".main-page__content-wrapper").should(Condition.visible);
    }
}