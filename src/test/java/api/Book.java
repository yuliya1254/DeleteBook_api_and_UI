package api;

import models.AuthResponse;
import models.DeleteBookRequest;
import models.PostBookRequest;
import models.PostBookResponse;
import tests.TestData;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static specs.TestSpecs.*;

public class Book {

    TestData data = new TestData();

    public void addBook(AuthResponse authResponse, PostBookRequest postBookRequest, String isbn1) {
        PostBookRequest.IsbnModel isbn = new PostBookRequest.IsbnModel(isbn1);
        List<PostBookRequest.IsbnModel> isbnList = new ArrayList<>();
        isbnList.add(isbn);

        postBookRequest.setUserId(authResponse.getUserId());
        postBookRequest.setCollectionOfIsbns(isbnList);


        given(bodyRequestSpec)
                .header("Authorization", "Bearer " + authResponse.getToken())
                .body(postBookRequest)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(responseSpec)
                .statusCode(201)
                .extract().as(PostBookResponse.class);
    }

    public void deleteBook(AuthResponse authResponse, String isbn1) {
        DeleteBookRequest request = new DeleteBookRequest();
        request.setUserId(authResponse.getUserId());
        request.setIsbn(isbn1);

        given(bodyRequestSpec)
                .header("Authorization", "Bearer " + authResponse.getToken())
                .body(request)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .spec(withoutResponseSpec)
                .statusCode(204);

    }


}
