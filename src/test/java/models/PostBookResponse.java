package models;

import lombok.Data;

import java.util.List;

@Data
public class PostBookResponse {
    List<Books> books;

@Data
    public static class Books{
        String isbn;
    }
}
