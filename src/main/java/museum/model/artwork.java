package museum.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class artwork {
    @Id
    int artwork_id;
    String artwork_name;
    int Art_col_id;
    String creation_date;
    String artist_type;
    int price;
    String status;
}
