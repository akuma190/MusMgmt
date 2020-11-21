package museum.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class artist {
    @Id
    int artist_id;
    String artist_name;
    String creation_date;
}
