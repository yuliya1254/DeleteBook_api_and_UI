package tests;

import models.AuthRequest;

public class TestData {
    public static String isbn = "9781449331818";
    static String login = "Juli",
            password = "QWEqwe123!!";
    public static AuthRequest authRequest = new AuthRequest(login, password);
}
