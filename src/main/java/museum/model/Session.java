package museum.model;

import lombok.Data;

@Data
public class Session {
    String username;
    String type;
    int userId;
}
