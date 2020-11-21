package museum.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class users {

    @Id
    String username;
    String password;
    String firstname;
    String lastname;
    boolean enabled;
}
