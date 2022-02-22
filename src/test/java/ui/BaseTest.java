package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.Attach;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.ProjectConfig.PROJECT_CONFIG;
import static io.qameta.allure.Allure.step;

public class BaseTest {

    @SneakyThrows
    @BeforeAll
    static void before() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.out.println("localRun = " + PROJECT_CONFIG.isLocalRun());
        if (!PROJECT_CONFIG.isLocalRun()) {
            Configuration.remote = PROJECT_CONFIG.removeUrl();
            capabilities.setCapability("browserName", PROJECT_CONFIG.browser());
            capabilities.setCapability("browserVersion", PROJECT_CONFIG.browserVersion());
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");
        Configuration.baseUrl = PROJECT_CONFIG.baseUrl();
        Configuration.browserSize = PROJECT_CONFIG.browserSize();
        Configuration.timeout = 30000;
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
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
