package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import models.api.TopPopularProfessionsModel;
import models.api.TopPopularProfessionsRequestModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static config.ProjectConfig.PROJECT_CONFIG;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RabotaRUApiTest {
    @BeforeAll
    static void setUp() {
        RestAssured.baseURI =  PROJECT_CONFIG.baseUrl();
    }

    @Test
    public void getRegionsTest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .get("/api/v3/regions")
                .then()
                .extract().response();

        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    public void successfulViewTopProfessionPopularTest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(TopPopularProfessionsModel.newTopPopularProfessionsModel().build())
                .log().all()
                .post("/api-web/v4/companies/top.json")
                .then()
                .extract().response();

        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    public void negativeViewTopProfessionPopularTest() {
        TopPopularProfessionsRequestModel model = TopPopularProfessionsRequestModel.newModel().region_id(0).build();
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(TopPopularProfessionsModel.newTopPopularProfessionsModel().request(model).build())
                .log().all()
                .post("/api-web/v4/companies/top.json")
                .then()
                .extract().response();

        assertThat(response.statusCode()).isEqualTo(400);
    }
}
