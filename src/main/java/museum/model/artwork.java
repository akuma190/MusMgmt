package museum.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class artwork {
    @Id
    @Column(name="artwork_id")
    int artworkid;
    @Column(name="artwork_name")
    String artworkname;
    @Column(name="Art_col_id")
    int artcolid;
    @Column(name="creation_date")
    String creationdate;
    @Column(name="artist_type")
    String artist_type;
    int price;
    String status;
    int salesperson;
}
