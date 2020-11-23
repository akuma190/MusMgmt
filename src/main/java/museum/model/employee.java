package museum.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class employee {
    @Id
    @Column(name="staff_id")
    int staffid;
    @Column(name="staff_name")
    String staffname;
    @Column(name="creation_date")
    String creationdate;
    String role;

}
