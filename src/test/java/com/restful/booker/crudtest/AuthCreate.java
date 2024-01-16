package com.restful.booker.crudtest;

import com.restful.booker.model.AuthPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthCreate {

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/auth";
    }

    @Test
    public void generateAuthToken(){
        AuthPojo authorisationPojo = new AuthPojo();
        authorisationPojo.setUserName("admin");
        authorisationPojo.setPassword("password123");
        Response response = given()
                            .header("Content-Type","application/json")
                            .body(authorisationPojo)
                            .when()
                            .post();
                response.prettyPrint();
                response.then().statusCode(200);

    }
}
