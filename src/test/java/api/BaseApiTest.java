package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import ui.BaseTest;

import static config.ProjectConfig.PROJECT_CONFIG;

public class BaseApiTest extends BaseTest {
    @BeforeAll
    public static void before() {
        RestAssured.baseURI = PROJECT_CONFIG.baseUrl();
    }
}
