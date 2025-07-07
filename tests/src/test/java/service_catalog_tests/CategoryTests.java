package service_catalog_tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

public class CategoryTests {

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:12000";
    }

    @Test
    public void addCategoryTest_shouldReturnOkRequest(){

        String uniqueName = "new_category_" + System.currentTimeMillis();

        String payload = """
            {
              "name": "%s"
            }
            """.formatted(uniqueName);

        RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .when().post("/categories/add")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void addCategoryWithoutName_shouldReturnBadRequest() {
        String payload = "{ \"name\": \"\" }";

        RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .when().post("/categories/add")
                .then().assertThat().statusCode(400);
    }

    @Test
    public void addCategoryWithoutPayload_shouldReturnBadRequest() {
        RestAssured.given()
                .contentType("application/json")
                .when().post("/categories/add")
                .then().assertThat().statusCode(400);
    }

    @Test
    public void getCategories_shouldReturnList() {
        RestAssured.given()
                .when().get("/categories")
                .then().statusCode(200)
                .and().body("$",not(empty()));
    }

}
