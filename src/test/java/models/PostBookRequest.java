package models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class PostBookRequest {
    String userId;
    List<IsbnModel> collectionOfIsbns;

    @Data
    @AllArgsConstructor
    public static class IsbnModel {
        String isbn;
    }
}
