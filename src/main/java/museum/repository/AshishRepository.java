package museum.repository;

import museum.model.Ashish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AshishRepository extends CrudRepository<Ashish,Integer> {
}
