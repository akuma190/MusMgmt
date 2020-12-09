package museum.repository;

import museum.model.artwork;
import museum.model.characteristics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CharacteristicsRepository  extends CrudRepository<characteristics,Integer> {

    @Query(value="select * from characteristics where artwork_id =:artId",nativeQuery=true)
    characteristics findOne(@Param("artId") int artId);
}
