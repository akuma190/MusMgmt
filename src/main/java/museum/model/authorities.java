package museum.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class authorities {

    @Id
    String username;
    String authority;
}
