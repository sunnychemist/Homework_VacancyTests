package api;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.Attach;
import io.restassured.RestAssured;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.BaseTest;

import static config.ProjectConfig.PROJECT_CONFIG;
import static io.qameta.allure.Allure.step;

public class BaseApiTest extends BaseTest {
    @SneakyThrows
    @BeforeAll
    static void before() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (!PROJECT_CONFIG.localRun()) {
            Configuration.remote = PROJECT_CONFIG.removeUrl();
            capabilities.setCapability("browserName", PROJECT_CONFIG.browser());
            capabilities.setCapability("browserVersion", PROJECT_CONFIG.browserVersion());
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }

        Configuration.browserSize = PROJECT_CONFIG.browserSize();
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        step("Закрыть браузер", Selenide::closeWebDriver);
    }

}
