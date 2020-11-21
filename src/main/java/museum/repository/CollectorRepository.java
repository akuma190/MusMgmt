package museum.repository;

import museum.model.artist;
import museum.model.collector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectorRepository extends CrudRepository<collector,Integer> {

    @Query(value="select * from collector where collector_name =:colName",nativeQuery=true)
    collector findOne(@Param("colName") String colName);
}

