package museum.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class characteristics {

    @Id@GeneratedValue(strategy= GenerationType.AUTO)
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
    String medium;
}
