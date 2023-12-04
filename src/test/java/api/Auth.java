package api;

import models.AuthRequest;
import models.AuthResponse;


import static io.restassured.RestAssured.given;
import static specs.TestSpecs.bodyRequestSpec;
import static specs.TestSpecs.responseSpec;


public class Auth {


    public  static AuthResponse authResponse(AuthRequest authRequest ){
        return given (bodyRequestSpec)
                .body (authRequest)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(AuthResponse.class);
    }
}
