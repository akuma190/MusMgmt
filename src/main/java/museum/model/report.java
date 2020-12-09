package museum.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class report {
    @Id
    @Column(name="report_id")
    int reportid;
    @Column(name="event_id")
    int eventid;
    @Column(name="artwork_id")
    int artworkid;
    @Column(name="customer_id")
    String customerid;
    @Column(name="employee_id")
    int employeeid;
    @Column(name="sold_amount")
    int soldamount;
    @Column(name="creation_date")
    String creationdate;
    @Column(name="Art_col_id")
    int artcolid;
    @Column(name="sold_date")
    String solddate;

}
