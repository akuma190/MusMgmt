package museum.repository;

import museum.model.artwork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkRepository extends CrudRepository<artwork,Integer> {

}
