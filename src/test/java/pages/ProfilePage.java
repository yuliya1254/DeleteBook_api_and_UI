package pages;

import models.AuthResponse;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProfilePage {
    public ProfilePage setCookie(AuthResponse authResponse) {

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", authResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", authResponse.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", authResponse.getExpires()));
        return this;
    }

    public ProfilePage openProfile() {
        open("/profile");
        return this;
    }

    public void checkExistenceOfBook(String isbn) {
        $("[href='profile?book=" + isbn + "']").shouldNot(exist);
    }
}
