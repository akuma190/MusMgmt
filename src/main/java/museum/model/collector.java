package museum.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class collector {
    @Id
    int collector_id;
    String collector_name;
    String creation_date;
}
