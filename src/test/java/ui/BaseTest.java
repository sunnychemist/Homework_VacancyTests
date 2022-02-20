package ui;

import com.codeborne.selenide.Configuration;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.Map;

import static config.ProjectConfig.PROJECT_CONFIG;

public class BaseTest {

    @SneakyThrows
    @BeforeAll
    static void before() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (!PROJECT_CONFIG.localRun()) {
            Configuration.remote = PROJECT_CONFIG.removeUrl();
            capabilities.setCapability("browserName", PROJECT_CONFIG.browser());
            capabilities.setCapability("browserVersion", PROJECT_CONFIG.browserVersion());
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://selenoid:4444/wd/hub").toURL(),
                    capabilities
            );
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

}
