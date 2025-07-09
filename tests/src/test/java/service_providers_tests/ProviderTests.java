package service_providers_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class ProviderTests {
    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:12001";
    }

    @Test
    public void addProvider_shouldReturnOkRequest() {
        String name = "provider";
        String address = "Krakow ul. Skarzynskiego 2";
        String phone = String.format("%09d", System.currentTimeMillis() % 1_000_000_000);
        String email = "provider" + System.currentTimeMillis()%1000 + "@test.com";


        String payload = """
            {
              "name": "%s"
              ,"address": "%s"
              ,"phone": "%s"
              ,"email": "%s"
            }
            """.formatted(name, address, phone, email);


        Response response = RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .when().post("/providers/add")
                .then().statusCode(200)
                .extract().response();

        String id = response.jsonPath().getString("id");

        RestAssured.given()
                .when().get("/providers/" + id)
                .then().statusCode(200);
    }

    @Test
    public void addProviderWithDuplicatedPhone_shouldReturnBadRequest() {
        String name = "provider";
        String address = "Krakow ul. Skarzynskiego 2";

        String phone = String.format("%09d", System.currentTimeMillis() % 1_000_000_000);

        String email1 = "provider" + (System.currentTimeMillis() % 1000) + "@test.com";
        String email2 = "provider" + ((System.currentTimeMillis() + 1) % 1000) + "@test.com";

        String payload1 = """
            {
              "name": "%s",
              "address": "%s",
              "phone": "%s",
              "email": "%s"
            }
            """.formatted(name, address, phone, email1);

        RestAssured.given()
                .contentType("application/json")
                .body(payload1)
                .when().post("/providers/add")
                .then().statusCode(200);

        String payload2 = """
            {
              "name": "%s",
              "address": "%s",
              "phone": "%s",
              "email": "%s"
            }
            """.formatted(name, address, phone, email2);

        RestAssured.given()
                .contentType("application/json")
                .body(payload2)
                .when().post("/providers/add")
                .then().statusCode(400);
    }

    @Test
    public void addProviderWithDuplicatedEmail_shouldReturnBadRequest() {
        String name = "provider";
        String address = "Krakow ul. Skarzynskiego 2";

        String phone1 = String.format("%09d", System.currentTimeMillis() % 1_000_000_000);
        String phone2 = String.format("%09d", System.currentTimeMillis() % 1_000_000_000 + 1);

        String email = "provider" + (System.currentTimeMillis() % 1000) + "@test.com";

        String payload1 = """
            {
              "name": "%s",
              "address": "%s",
              "phone": "%s",
              "email": "%s"
            }
            """.formatted(name, address, phone1, email);

        RestAssured.given()
                .contentType("application/json")
                .body(payload1)
                .when().post("/providers/add")
                .then().statusCode(200);

        String payload2 = """
            {
              "name": "%s",
              "address": "%s",
              "phone": "%s",
              "email": "%s"
            }
            """.formatted(name, address, phone2, email);

        RestAssured.given()
                .contentType("application/json")
                .body(payload2)
                .when().post("/providers/add")
                .then().statusCode(400);
    }

    @Test
    public void addProviderWithWrongPhoneLength_shouldReturnBadRequest() {
        String name = "provider";
        String address = "Krakow ul. Skarzynskiego 2";
        String phone = String.format("%08d", System.currentTimeMillis() % 1_000_000_00);
        String email = "provider" + (System.currentTimeMillis() % 1000) + "@test.com";

        String payload = """
            {
              "name": "%s",
              "address": "%s",
              "phone": "%s",
              "email": "%s"
            }
            """.formatted(name, address, phone, email);


        RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .when().post("/providers/add")
                .then().statusCode(400);
    }

    @Test
    public void updateProviderAddress_shouldReturnOkRequest(){
        String name = "provider";

        String address1 = "Krakow ul. Skarzynskiego 2";
        String address2 = "Krakow ul. Bydgoska 19A";


        String phone = String.format("%09d", System.currentTimeMillis() % 1_000_000_000);
        String email = "provider" + System.currentTimeMillis()%1000 + "@test.com";


        String payload1 = """
            {
              "name": "%s"
              ,"address": "%s"
              ,"phone": "%s"
              ,"email": "%s"
            }
            """.formatted(name, address1, phone, email);


        Response response = RestAssured.given()
                .contentType("application/json")
                .body(payload1)
                .when().post("/providers/add")
                .then().statusCode(200)
                .extract().response();

        String id = response.jsonPath().getString("id");


        String payload2 = """
            {
              "address": "%s"
            }
            """.formatted(address2);

        RestAssured.given()
                .contentType("application/json")
                .body(payload2)
                .when().patch("/providers/update/" + id)
                .then().statusCode(200)
                .body("address", equalTo(address2));
    }

    @Test
    public void updateProviderPhoneNumberWithWrongLength_shouldReturnBadRequest(){
        String name = "provider";
        String address = "Krakow ul. Skarzynskiego 2";

        String phone1 = String.format("%09d", System.currentTimeMillis() % 1_000_000_000);
        String phone2 = String.format("%08d", System.currentTimeMillis() % 100_000_000);

        String email = "provider" + System.currentTimeMillis()%1000 + "@test.com";


        String payload1 = """
            {
              "name": "%s"
              ,"address": "%s"
              ,"phone": "%s"
              ,"email": "%s"
            }
            """.formatted(name, address, phone1, email);


        Response response = RestAssured.given()
                .contentType("application/json")
                .body(payload1)
                .when().post("/providers/add")
                .then().statusCode(200)
                .extract().response();

        String id = response.jsonPath().getString("id");


        String payload2 = """
            {
              "phone": "%s"
            }
            """.formatted(phone2);

        RestAssured.given()
                .contentType("application/json")
                .body(payload2)
                .when().patch("/providers/update/" + id)
                .then().statusCode(400);
    }

    @Test
    public void deleteProvider_shouldReturnOkAndNotFoundAfterward() {
        String name = "provider";
        String address = "Krakow ul. Skarzynskiego 2";
        String phone = String.format("%09d", System.currentTimeMillis() % 1_000_000_000);
        String email = "provider" + System.currentTimeMillis() % 1000 + "@test.com";

        String payload = """
        {
          "name": "%s",
          "address": "%s",
          "phone": "%s",
          "email": "%s"
        }
        """.formatted(name, address, phone, email);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .when().post("/providers/add")
                .then().statusCode(200)
                .extract().response();

        String id = response.jsonPath().getString("id");

        RestAssured.given()
                .when().delete("/providers/delete/" + id)
                .then().statusCode(200);

        RestAssured.given()
                .when().get("/providers/" + id)
                .then().statusCode(400);
    }
}
