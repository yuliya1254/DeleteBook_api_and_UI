package tests;

import models.AuthRequest;

public class TestData {
    static String login = "Juli",
            password = "QWEqwe123!!";

    public static AuthRequest authRequest = new AuthRequest(login, password);

    public static String isbn = "9781449331818";
}
