package museum.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class artist {
    @Id@GeneratedValue(strategy= GenerationType.AUTO)
    int artist_id;
    String artist_name;
    String creation_date;
}
