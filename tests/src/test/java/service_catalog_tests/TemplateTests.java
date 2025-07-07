package service_catalog_tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class TemplateTests {
    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void getTemplatesByCategory_shouldReturnTemplatesWithRequestedCategory() {
        String categoryName = "hosting";

        String payload = """
            {
              "name": "%s"
            }
            """.formatted(categoryName);

        RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .log().all()
                .when()
                .post("/templates")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("category", everyItem(equalToIgnoringCase(categoryName)));
    }
}
