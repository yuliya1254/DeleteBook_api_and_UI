package models;

import lombok.Data;

@Data
public class DeleteBookRequest {
    String isbn;
    String userId;
}
