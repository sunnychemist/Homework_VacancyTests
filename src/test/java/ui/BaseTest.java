package ui;

import com.codeborne.selenide.Configuration;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
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
            Configuration.remote = PROJECT_CONFIG.remoteDriverUrl();
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
        Configuration.baseUrl = PROJECT_CONFIG.baseUrl();
        Configuration.browserSize = PROJECT_CONFIG.browserSize();
    }

}
