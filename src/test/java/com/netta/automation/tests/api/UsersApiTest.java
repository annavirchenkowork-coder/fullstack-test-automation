package com.netta.automation.tests.api;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Users API")
public class UsersApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    @Description("GET /users should return 200")
    void getUsers() {
        Response res = given()
                .when()
                .get("/users")
                .then()
                .extract().response();

        assertEquals(200, res.getStatusCode());
        System.out.println("Response: " + res.getBody().asString());
    }

    @Test
    @Description("POST /users should return 201")
    void createUserTest() {
        String payload = """
                {
                  "name": "John",
                  "email": "john@example.com"
                }
                """;

        Response res = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/users")
                .then()
                .extract().response();

        assertEquals(201, res.getStatusCode());
        System.out.println(res.getBody().asString());
    }
}