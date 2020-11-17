package museum.repository;

import museum.model.Newtable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewtableRepository extends CrudRepository<Newtable,String> {

}
