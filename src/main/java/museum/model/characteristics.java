package museum.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class characteristics {

    @Id
    @Column(name="charect_id")
    Integer charectid;
    @Column(name="artwork_id")
    Integer artworkid;
    @Column(name="type")
    String type;
    @Column(name="style")
    String style;
    @Column(name="length")
    Integer length;
    @Column(name="width")
    Integer width;
    @Column(name="height")
    Integer height;
}
