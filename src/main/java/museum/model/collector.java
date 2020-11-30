package museum.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class collector {
    @Id@GeneratedValue(strategy= GenerationType.AUTO)
    int collector_id;
    String collector_name;
    String creation_date;
}
