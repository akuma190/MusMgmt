package museum.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="store_status")
public class StoreStatus {
    @Id
    @Column(name="stat_id")
    int statId;
    String name;

}
