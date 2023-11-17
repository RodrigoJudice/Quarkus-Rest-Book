package com.git.judice;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
public class NativeBookResourceIT extends BookResourceTest {

    // Execute the same tests but in native mode.

    @Test
    public void shouldGetABook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1).when()
                .get("/api/books/{id}").then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("title", is("Understanding Quarkus"))
                .body("author", is("Antonio"))
                .body("yearOfPublication", is(2020))
                .body("genre", is("IT Production"));
    }
}