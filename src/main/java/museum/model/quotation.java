package museum.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class quotation {
    @Id
    @Column(name="quotation_id")
    int quotationid;
    @Column(name="event_id")
    int eventid;
    @Column(name="user_name")
    String username;
    @Column(name="artwork_id")
    int artworkid;
    @Column(name="quoted_price")
    int quotedprice;
    @Column(name="creation_date")
    String creationdate;
    @Column(name="employee_id")
    int employeeid;
    @Column(name="status")
    String status;
    @Column(name="Art_col_id")
    int Artcolid;

}
