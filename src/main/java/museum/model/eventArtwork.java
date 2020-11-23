package museum.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="event_artwork")
public class eventArtwork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="event_art_id")
    int eventartid;
    @Column(name="event_id")
    int eventid;
    @Column(name="artwork_id")
    int artworkid;
    @Column(name="salesperson")
    int salesperson;
}
