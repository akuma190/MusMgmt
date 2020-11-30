package museum.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class customer {

    @Id@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="customer_id")
    int customerid;
    @Column(name="customer_name")
    String customername;
    @Column(name="creation_date")
    String creationdate;
}
