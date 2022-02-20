package ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void before() {
        Configuration.baseUrl = "https://www.rabota.ru/";
        Configuration.browserSize = "1920x1080";
    }

}
