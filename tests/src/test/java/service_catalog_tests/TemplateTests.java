package service_catalog_tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class TemplateTests {
    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:12000";
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
                .when()
                .post("/templates")
                .then()
                .assertThat()
                .statusCode(200)
                .body("category", everyItem(equalToIgnoringCase(categoryName)));
    }

    @Test
    public void getTemplatesByCategoryThatDoesNotExists_shouldReturnError() {
        String categoryName = "not_existing";

        String payload = """
            {
              "name": "%s"
            }
            """.formatted(categoryName);

        RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post("/templates")
                .then()
                .assertThat()
                .statusCode(400);
    }

    @Test
    public void addTemplateToCategory_shouldAddTemplateToCategory() {
        String categoryName = "hosting";
        String templateName = "hosting_template_" + System.currentTimeMillis();

        String payload = """
            {
              "name": "%s",
              "category": "%s"
            }
            """.formatted(templateName, categoryName);

        RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post("/templates/add")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void addTemplateToCategoryThatDoesNotExists_shouldReturnError() {
        String categoryName = "not_existing";
        String templateName = "hosting_template_" + System.currentTimeMillis();

        String payload = """
            {
              "name": "%s",
              "category": "%s"
            }
            """.formatted(templateName, categoryName);

        RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post("/templates/add")
                .then()
                .assertThat()
                .statusCode(400);
    }
}
