package museum.repository;

import museum.model.StoreStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreStatusRepository extends CrudRepository<StoreStatus,Integer> {

}
