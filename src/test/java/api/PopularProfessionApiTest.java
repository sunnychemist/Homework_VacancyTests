package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.*;
import models.api.TopPopularProfessionsModel;
import models.api.TopPopularProfessionsRequestModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PopularProfessionApiTest extends BaseApiTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Test
    public void successfulViewTopProfessionPopularTest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(objectMapper.writeValueAsString(TopPopularProfessionsModel.newTopPopularProfessionsModel().build()))
                .log().all()
                .post("/api-web/v4/companies/top.json")
                .then()
                .extract().response();

        assertThat(response.statusCode()).isEqualTo(200);
    }

    @SneakyThrows
    @Test
    public void negativeViewTopProfessionPopularTest() {
        TopPopularProfessionsRequestModel model = TopPopularProfessionsRequestModel.newModel().region_id(0).build();
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(objectMapper.writeValueAsString(TopPopularProfessionsModel.newTopPopularProfessionsModel().request(model).build()))
                .log().all()
                .post("/api-web/v4/companies/top.json")
                .then()
                .extract().response();

        assertThat(response.statusCode()).isEqualTo(400);
    }
}
