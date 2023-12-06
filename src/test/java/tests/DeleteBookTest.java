package tests;

import api.Auth;
import io.qameta.allure.Step;
import models.AuthResponse;
import models.PostBookRequest;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.TestData.authRequest;
import static tests.TestData.isbn;

public class DeleteBookTest extends TestBase {
    @Test
    void DeleteBook() {


        AuthResponse authResponse = Auth.authResponse(authRequest);


        step("Добавить книгу в профиль", () ->
                book.addBook(authResponse, new PostBookRequest(), isbn));


        step("Удалить книгу из профиля", () ->
                book.deleteBook(authResponse, isbn));

        step("Открыть браузер и убедиться, что книга отсутствует", () -> {
            profile.setCookie(authResponse)
                    .openProfile()
                    .checkExistenceOfBook(isbn);
        });


    }
}
