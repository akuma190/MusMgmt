package museum.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Newtable {

    @Id
    String name;
    String sirname;
}
