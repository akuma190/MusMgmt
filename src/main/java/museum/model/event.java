package museum.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class event {
    @Id
    @Column(name="event_id")
    int eventid;
    @Column(name="event_name")
    String eventname;
    @Column(name="event_type")
    String eventtype;
    @Column(name="creation_date")
    String creationdate;
    @Column(name="artist_id")
    Integer artistid;

}
